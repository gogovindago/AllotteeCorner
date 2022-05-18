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
                loginRequest.setPassword(EdtUserPassword.getText().toString().trim());
                loginRequest.setAuthID(edtUserName.getText().toString().trim());


                if (GlobalClass.isNetworkConnected(LoginActivity.this)) {

                    WebAPiCall webapiCall = new WebAPiCall();

                    Intent intentlogin = new Intent(LoginActivity.this, MainActivity.class);
                    intentlogin.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intentlogin.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intentlogin);
                    finish();


                    // webapiCall.loginPostDataMethod(this, this, LoginActivity.this, loginRequest);


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
    public void alluserdata(LoginResponse.Data data) {
        try {
            /*{"response":200,"sys_message":"Login Data Returned","data":{"name":"Super Admin","collegeId":"","college":"",
            "collegeCode":"","studentId":"","memberId":"","token":"459839a022111372c00df629305430df","userType":"SuperAdmin","mobileNo":"","email":""}}
             */
            CSPreferences.putString(this, "MemberId", String.valueOf(data.getMemberId()));
            CSPreferences.putString(this, "userid", String.valueOf(data.getStudentId()));
            CSPreferences.putString(this, "User_Name", data.getName());
            CSPreferences.putString(this, "User_Profile_Photo", data.getFile_Student_Image());
            CSPreferences.putString(this, "PhoneNo", data.getMobileNo());
            CSPreferences.putString(this, "Email", data.getEmail());
            CSPreferences.putString(this, "token", data.getToken());
            CSPreferences.putBolean(this, "firstTimelogin", firstTimelogin);
            CSPreferences.putString(this, "UserType", data.getUserType());

            CSPreferences.putString(this, "AadhaarNo", data.getAadhaarNo());
            CSPreferences.putString(this, "CasteCategoryName", data.getCasteCategoryName());
            CSPreferences.putString(this, "FamilyIncome", data.getFamilyIncome());
            CSPreferences.putString(this, "FatherFullName", data.getFatherFullName());
            CSPreferences.putString(this, "FamilyID", data.getFamilyID());
            CSPreferences.putString(this, "department_Id", String.valueOf(data.getDepartment_Id()));
            CSPreferences.putString(this, "collegeId", data.getCollegeId());
            CSPreferences.putString(this, "nodalBody_Id", data.getNodalBody_Id());
            CSPreferences.putBolean(this, "Is_CurrentSession_Active", Is_CurrentSession_Active);
            CSPreferences.putBolean(this, "Is_Already_Apply_In_Current_Session", Is_Already_Apply_In_Current_Session);
            CSPreferences.putBolean(this, "Is_Already_Apply_Other_Scholarship_scheme_In_Current_Session", Is_Already_Apply_Other_Scholarship_scheme_In_Current_Session);

            CSPreferences.putBolean(this, "skiplogin", false);


//            if (data.getPic() == null) {
//                data.setPic(imageurl);
//            }
//
//            CSPreferences.putString(this, "pic", data.getPic());
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