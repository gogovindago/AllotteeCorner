package hsvp.digital.allottee_corner.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;

import java.util.regex.Pattern;

import hsvp.digital.allottee_corner.R;
import hsvp.digital.allottee_corner.allinterface.ForgotPasswordData_interface;
import hsvp.digital.allottee_corner.apicall.WebAPiCall;
import hsvp.digital.allottee_corner.databinding.ActivityForgetPasswordBinding;
import hsvp.digital.allottee_corner.model.ForgotPasswordRequest;
import hsvp.digital.allottee_corner.model.ForgotPasswordResponse;
import hsvp.digital.allottee_corner.utility.BaseActivity;
import hsvp.digital.allottee_corner.utility.GlobalClass;

public class ForgetPasswordActivity extends BaseActivity implements ForgotPasswordData_interface {
    ActivityForgetPasswordBinding binding;
    private int otptoMatch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_forget_password);


    }

    public boolean CheckOTPSENT_Data(View view) {

        if (TextUtils.isEmpty(binding.edtUserMno.getText().toString().trim())) {
            GlobalClass.dailogError(ForgetPasswordActivity.this, "Missing Mobile Number", "Please Enter Your Mobile Number");
            return false;
        } else if (!isValidMobile(binding.edtUserMno.getText().toString().trim())) {

            GlobalClass.dailogError(ForgetPasswordActivity.this, "Missing 10 digits", "Please Enter 10 digits Registered Mobile Number");

            return false;

        } else if (TextUtils.isEmpty(binding.edtUserMemberId.getText().toString().trim())) {
            GlobalClass.dailogError(ForgetPasswordActivity.this, "Missing  PPP Member Id", "Please Enter Your PPP Member Id");
            return false;
        }
        return true;
    }

    public boolean CheckForgotPassword_Data(View view) {

        if (TextUtils.isEmpty(binding.edtUserMno.getText().toString().trim())) {
            GlobalClass.dailogError(ForgetPasswordActivity.this, "Missing Mobile Number", "Please Enter Your Mobile Number");
            return false;
        } else if (TextUtils.isEmpty(binding.edtUserMemberId.getText().toString().trim())) {
            GlobalClass.dailogError(ForgetPasswordActivity.this, "Missing  PPP Member Id", "Please Enter Your PPP Member Id");
            return false;
        } else if (TextUtils.isEmpty(binding.edtOtp.getText().toString().trim())) {
            GlobalClass.dailogError(ForgetPasswordActivity.this, "Missing OTP", "Please Enter OTP.");
            return false;
        } else if (!binding.edtOtp.getText().toString().trim().equalsIgnoreCase(String.valueOf(otptoMatch))) {
            GlobalClass.dailogError(ForgetPasswordActivity.this, "Mismatched OTP", "Please Enter correct  OTP.");
            return false;
        } else if (TextUtils.isEmpty(binding.edtUserForgotPassword.getText().toString().trim())) {
            GlobalClass.dailogError(ForgetPasswordActivity.this, "Missing Password", "Please Enter Your  new Password.");
            return false;
        } else if (TextUtils.isEmpty(binding.edtUserConfirmForgotPassword.getText().toString().trim())) {
            GlobalClass.dailogError(ForgetPasswordActivity.this, "Missing Confirm Password", "Please Enter Your new Confirm-Password");
            return false;
        } else if (!binding.edtUserForgotPassword.getText().toString().trim().equals(binding.edtUserConfirmForgotPassword.getText().toString().trim())) {
            GlobalClass.dailogError(ForgetPasswordActivity.this, "Mismatched password", "Please Enter Same password");
            return false;
        } else {
        }
        return true;
    }


    private boolean isValidMobile(String phone) {
        if (!Pattern.matches("[a-zA-Z]+", phone)) {
            return phone.length() >= 10 && phone.length() < 11;
            //return phone.length()==10;
        }
        return false;
    }


    @Override
    public void initData() {

    }

    @Override
    public void initListeners() {

        binding.toolbar.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        binding.btnSendOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CheckOTPSENT_Data(v)) {


                }
            }
        });
        binding.btnForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CheckForgotPassword_Data(v)) {


                    if (GlobalClass.isNetworkConnected(ForgetPasswordActivity.this)) {

                        ForgotPasswordRequest request = new ForgotPasswordRequest();
                        request.setPassword(binding.edtUserForgotPassword.getText().toString().trim());
                        request.setMemberID(binding.edtUserMemberId.getText().toString().trim());
                        request.setMobileNo(binding.edtUserMno.getText().toString().trim());

                        WebAPiCall webapiCall = new WebAPiCall();
                        webapiCall.forgotPostDataMethod(ForgetPasswordActivity.this, ForgetPasswordActivity.this, ForgetPasswordActivity.this, request);

                    } else {

                        Toast.makeText(ForgetPasswordActivity.this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }



    @Override
    public void forgotPasswordMethod(ForgotPasswordResponse data) {
        GlobalClass.showtost(ForgetPasswordActivity.this, data.getSysMessage());

        Intent intent = new Intent(ForgetPasswordActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
}