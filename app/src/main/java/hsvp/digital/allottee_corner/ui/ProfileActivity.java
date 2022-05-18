package hsvp.digital.allottee_corner.ui;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import hsvp.digital.allottee_corner.R;
import hsvp.digital.allottee_corner.databinding.ActivityProfileBinding;
import hsvp.digital.allottee_corner.utility.BaseActivity;
import hsvp.digital.allottee_corner.utility.CSPreferences;


public class ProfileActivity extends BaseActivity {
    ActivityProfileBinding binding;
    String User_PhoneNo, token, UserName, User_State, User_DisabiltiesName, UserEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile);


    }


    @Override
    public void initData() {

        try {
            User_PhoneNo = CSPreferences.readString(ProfileActivity.this, "PhoneNo");
            token = CSPreferences.readString(ProfileActivity.this, "token");
            UserName = CSPreferences.readString(ProfileActivity.this, "User_Name");
            User_State = CSPreferences.readString(ProfileActivity.this, "User_State");
            UserEmail = CSPreferences.readString(ProfileActivity.this, "Email");


            binding.name.setText(UserName);
            binding.edtmobile.setText(User_PhoneNo);
            binding.edtemail.setText(UserEmail);
            Glide.with(ProfileActivity.this)
                    .load(CSPreferences.readString(ProfileActivity.this, "User_Profile_Photo").trim()) // image url
                    .placeholder(R.mipmap.ic_launcher_round) // any placeholder to load at start
                    .error(R.mipmap.ic_launcher_round)  // any image in case of error
                    .override(140, 140) // resizing
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(binding.profileImage);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void initListeners() {


    }
}