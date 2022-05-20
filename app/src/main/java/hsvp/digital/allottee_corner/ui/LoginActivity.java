package hsvp.digital.allottee_corner.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.messaging.FirebaseMessaging;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.regex.Pattern;

import hsvp.digital.allottee_corner.R;
import hsvp.digital.allottee_corner.allinterface.LoginData_interface;
import hsvp.digital.allottee_corner.apicall.WebAPiCall;
import hsvp.digital.allottee_corner.model.LoginRequest;
import hsvp.digital.allottee_corner.model.LoginResponse;
import hsvp.digital.allottee_corner.utility.CSPreferences;
import hsvp.digital.allottee_corner.utility.GlobalClass;
import hsvp.digital.allottee_corner.utility.MyLoaders;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, LoginData_interface {

    private MyLoaders myLoaders;
    String refreshedToken;
    TextView login, TxtRegisterUser, txtforget, btnskip;
    private TextInputEditText edtUserName;
    private TextInputEditText EdtUserPassword;
    Boolean firstTimelogin = true, Is_CurrentSession_Active = true, Is_Already_Apply_In_Current_Session = false, Is_Already_Apply_Other_Scholarship_scheme_In_Current_Session = false;

    RadioGroup btnRadiogroup;
    RadioButton checkedRadioButton;
    Boolean Is_Studying_Outside_the_Haryana_State;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        myLoaders = new MyLoaders(getApplicationContext());
        findViews();

        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            //  Log.w(TAG, "Fetching FCM registration token failed", task.getException());
                            return;
                        }

                        // Get new FCM registration token
                        refreshedToken = task.getResult();
                        // Log.d("fcm",refreshedToken);

                    }
                });


        txtforget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, ForgetPasswordActivity.class);
                startActivity(i);


            }
        });


        btnskip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    CSPreferences.putString(LoginActivity.this, "User_Name", "Har Chhatravratti");
                    CSPreferences.putBolean(LoginActivity.this, "skiplogin", true);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                CSPreferences.putBolean(LoginActivity.this, "skiplogin", true);
                startActivity(intent);
                finish();

            }
        });


    }

    private void findViews() {
        login = (TextView) findViewById(R.id.BtnLogin);
        txtforget = (TextView) findViewById(R.id.txtforget);
        btnskip = (TextView) findViewById(R.id.btnskip);
        TxtRegisterUser = (TextView) findViewById(R.id.TxtRegisterUser);
        edtUserName = (TextInputEditText) findViewById(R.id.edtUserName);
        EdtUserPassword = (TextInputEditText) findViewById(R.id.EdtUserPassword);
        login.setOnClickListener(this);
        TxtRegisterUser.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v == login) {
            if (Check_Data(v)) {


                LoginRequest loginRequest = new LoginRequest();
                loginRequest.setFCMToken(refreshedToken);

                String firsttimeconvertion = md5(EdtUserPassword.getText().toString().trim());
                String secondtimeconvertion = md5(firsttimeconvertion);


                loginRequest.setPassword(secondtimeconvertion);
                loginRequest.setUserid(edtUserName.getText().toString().trim());


                if (GlobalClass.isNetworkConnected(LoginActivity.this)) {

                    WebAPiCall webapiCall = new WebAPiCall();
                    webapiCall.loginPostDataMethod(this, this, LoginActivity.this, loginRequest);


                } else {

                    Toast.makeText(this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
                }

            }


        } else if (v == TxtRegisterUser) {

            Intent intentsignup = new Intent(LoginActivity.this, RegistrationActivity.class);
            startActivity(intentsignup);
            finish();

        }

    }


    public static String md5(String string) {
        byte[] hash;

        try {
            hash = MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Huh, MD5 should be supported?", e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Huh, UTF-8 should be supported?", e);
        }

        StringBuilder hex = new StringBuilder(hash.length * 2);

        for (byte b : hash) {
            int i = (b & 0xFF);
            if (i < 0x10) hex.append('0');
            hex.append(Integer.toHexString(i));
        }
        System.out.println(hex.toString());
        return hex.toString();

    }


    private boolean isValidMobile(String phone) {
        if (!Pattern.matches("[a-zA-Z]+", phone)) {
            return phone.length() >= 10 && phone.length() < 11;
            //return phone.length()==10;
        }
        return false;
    }

    public boolean Check_Data(View view) {

        if (TextUtils.isEmpty(edtUserName.getText().toString().trim())) {
            myLoaders.showSnackBar(view, "Please Enter Registered User Name");
            return false;
        } else if (TextUtils.isEmpty(EdtUserPassword.getText().toString().trim())) {
            myLoaders.showSnackBar(view, "Please Enter Password");
            return false;
        }
        return true;
    }

    @Override
    public void alluserdata(List<LoginResponse.Datum> data) {
        try {

            CSPreferences.putString(this, "userid", String.valueOf(data.get(0).getUserId()));
            CSPreferences.putString(this, "User_Name", data.get(0).getUserName());
            CSPreferences.putString(this, "Email", data.get(0).getEmail());

            Intent intentlogin = new Intent(LoginActivity.this, MainActivity.class);
            intentlogin.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intentlogin.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intentlogin);
            finish();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}