package hsvp.digital.allottee_corner.ui;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.util.InetAddressUtils;
import com.google.firebase.messaging.FirebaseMessaging;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.pedant.SweetAlert.SweetAlertDialog;
import hsvp.digital.allottee_corner.R;
import hsvp.digital.allottee_corner.adapter.SpinnerMemberBasicDetailAdapter;
import hsvp.digital.allottee_corner.adapter.SpinnerReligionAdapter;
import hsvp.digital.allottee_corner.adapter.SpinnerYesNoAdapter;
import hsvp.digital.allottee_corner.allinterface.AadharFromMemIdData_interface;
import hsvp.digital.allottee_corner.allinterface.GetCheckStudentExistData_interface;
import hsvp.digital.allottee_corner.allinterface.GetMemberBasicDetailData_interface;
import hsvp.digital.allottee_corner.allinterface.OtpForMEMIDData_interface;
import hsvp.digital.allottee_corner.allinterface.RegistrationData_interface;
import hsvp.digital.allottee_corner.allinterface.verifyOtpForMEMIDData_interface;
import hsvp.digital.allottee_corner.apicall.WebAPiCall;
import hsvp.digital.allottee_corner.databinding.ActivityRegistrationBinding;
import hsvp.digital.allottee_corner.model.CheckStudentAlreadyExistResponse;
import hsvp.digital.allottee_corner.model.GetMemberbasicdetailsfromFIDUIDRequest;
import hsvp.digital.allottee_corner.model.GetMemberbasicdetailsfromFIDUIDResponse;
import hsvp.digital.allottee_corner.model.OTPRequestforMEMIDRequest;
import hsvp.digital.allottee_corner.model.OTPRequestforMEMIDResponse;
import hsvp.digital.allottee_corner.model.Religion;
import hsvp.digital.allottee_corner.model.StudentRegistrationResponse;
import hsvp.digital.allottee_corner.model.VerifyOTPRequestforMEMIDRequest;
import hsvp.digital.allottee_corner.model.VerifyOTPRequestforMEMIDResponse;
import hsvp.digital.allottee_corner.model.YesNo;
import hsvp.digital.allottee_corner.utility.BaseActivity;
import hsvp.digital.allottee_corner.utility.CSPreferences;
import hsvp.digital.allottee_corner.utility.GlobalClass;

public class RegistrationActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener, GetMemberBasicDetailData_interface, OtpForMEMIDData_interface, verifyOtpForMEMIDData_interface, GetCheckStudentExistData_interface, RegistrationData_interface, AadharFromMemIdData_interface {

    private static final int REQUEST_READ_PHONE_STATE = 121;
    ActivityRegistrationBinding binding;
    private List<Religion> Religionlist = new ArrayList<Religion>();
    private List<YesNo> yesnolist = new ArrayList<YesNo>();

    private List<GetMemberbasicdetailsfromFIDUIDResponse.Dropdown> UserBasicDetailArraylist = new ArrayList<GetMemberbasicdetailsfromFIDUIDResponse.Dropdown>();

    SpinnerReligionAdapter SpinnerReligionAdapter;
    SpinnerMemberBasicDetailAdapter basicDetailAdapter;
    Boolean IsTermConditionCheked = false;
    int spnstudentNameCurrentPosition, spnReligionCurrentPosition, spnBPlCurrentPosition;

    Boolean firstTimelogin = true, Is_CurrentSession_Active = false, Is_Already_Apply_In_Current_Session = false, Is_Already_Apply_Other_Scholarship_scheme_In_Current_Session = false;
    String spnstudentMemberId, txn, spnstudentReligion, pinCode, dCode, btCode, btCodeLGD, wvCode, districtName, btName, wvName, dCodeLGD, wvCodeLGD, divyangPercentage, isDOBVerified, isCasteVerified, isIncomeVerified,
            isBPLVerified,
            isDivyangVerified,
            subCaste_code,
            subCaste_name,
            casteDescription,
            divyangCategory,
            deprived, refreshedToken, bpl;
    private SpinnerYesNoAdapter spinnerYesNoAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_registration);


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


        String text = "I agree with Terms & Conditions";
        SpannableString spannableString = new SpannableString(text);

        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(RegistrationActivity.this, "THIS", Toast.LENGTH_SHORT).show();
            }
        };

        ClickableSpan clickableSpan2 = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(RegistrationActivity.this, "THIS", Toast.LENGTH_SHORT).show();
            }
        };

        ClickableSpan clickableSpan3 = new ClickableSpan() {
            @Override
            public void onClick(View v) {
                //  Toast.makeText(RegistrationActivity.this, "CLICKED", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(RegistrationActivity.this);
                ViewGroup viewGroup = findViewById(android.R.id.content);
                View dialogView = LayoutInflater.from(v.getContext()).inflate(R.layout.customdailogview, viewGroup, false);
                builder.setView(dialogView);


                AlertDialog alertDialog = builder.create();

                Button btnOk = dialogView.findViewById(R.id.buttonOk);

                btnOk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });
                alertDialog.show();
            }
        };


        // spannableString.setSpan(clickableSpan1, 7, 11, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //  spannableString.setSpan(clickableSpan2, 16, 20, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(clickableSpan3, 12, 31, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        binding.chktermcondition.setText(spannableString);
        binding.chktermcondition.setMovementMethod(LinkMovementMethod.getInstance());

        binding.chktermcondition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.chktermcondition.isChecked()) {
                    IsTermConditionCheked = true;

                } else {

                    IsTermConditionCheked = false;
                }
                GlobalClass.showtost(RegistrationActivity.this, String.valueOf(IsTermConditionCheked));

            }
        });


/*/*Select
Hindu
Muslim
Christian
Sikh
Buddhist
Jain
Parsi*/


        Religionlist.add(new Religion(0, "Religion"));
        Religionlist.add(new Religion(1, "Hindu"));
        Religionlist.add(new Religion(2, "Muslim"));
        Religionlist.add(new Religion(3, "Christian"));
        Religionlist.add(new Religion(4, "Sikh"));
        Religionlist.add(new Religion(5, "Buddhist"));
        Religionlist.add(new Religion(6, "Jain"));
        Religionlist.add(new Religion(7, "Parsi"));
        SpinnerReligionAdapter = new SpinnerReligionAdapter(getApplicationContext(), Religionlist);
        binding.spnReligion.setAdapter(SpinnerReligionAdapter);

        binding.spnReligion.setOnItemSelectedListener(this);
        binding.spnstudentName.setOnItemSelectedListener(this);

        binding.btnSearch.setOnClickListener(this);
        binding.btnGenerateOtp.setOnClickListener(this);
        binding.btnVerifyOtp.setOnClickListener(this);
        binding.BtnRegistration.setOnClickListener(this);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_READ_PHONE_STATE:
                if ((grantResults.length > 0) && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    //TODO

                    getDeviceIpAddress();
                }
                break;

            default:
                break;
        }
    }
    public static String getIPAddress(boolean useIPv4) {
        try {
            List<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface intf : interfaces) {
                List<InetAddress> addrs = Collections.list(intf.getInetAddresses());
                for (InetAddress addr : addrs) {
                    if (!addr.isLoopbackAddress()) {
                        String sAddr = addr.getHostAddress().toUpperCase();
                        boolean isIPv4 = InetAddressUtils.isIPv4Address(sAddr);
                        if (useIPv4) {
                            if (isIPv4)
                                return sAddr;
                        } else {
                            if (!isIPv4) {
                                int delim = sAddr.indexOf('%'); // drop ip6 port suffix
                                return delim<0 ? sAddr : sAddr.substring(0, delim);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @NonNull
    private String getDeviceIpAddress() {


        String actualConnectedToNetwork = null;
        ConnectivityManager connManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connManager != null) {
            NetworkInfo mWifi = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            if (mWifi.isConnected()) {
                actualConnectedToNetwork = getWifiIp();
            }
        }
        if (TextUtils.isEmpty(actualConnectedToNetwork)) {
            actualConnectedToNetwork = getNetworkInterfaceIpAddress();
        }
        if (TextUtils.isEmpty(actualConnectedToNetwork)) {
            actualConnectedToNetwork = "127.0.0.1";
        }
        return actualConnectedToNetwork;
    }

    @Nullable
    private String getWifiIp() {
        final WifiManager mWifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        if (mWifiManager != null && mWifiManager.isWifiEnabled()) {
            int ip = mWifiManager.getConnectionInfo().getIpAddress();
            return (ip & 0xFF) + "." + ((ip >> 8) & 0xFF) + "." + ((ip >> 16) & 0xFF) + "."
                    + ((ip >> 24) & 0xFF);
        }
        return null;
    }


    @Nullable
    public String getNetworkInterfaceIpAddress() {
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
                NetworkInterface networkInterface = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = networkInterface.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
                        String host = inetAddress.getHostAddress();
                        if (!TextUtils.isEmpty(host)) {
                            return host;
                        }
                    }
                }

            }
        } catch (Exception ex) {
            Log.e("IP Address", "getLocalIpAddress", ex);
        }
        return null;
    }


    @Override
    public void initData() {
        binding.toolbar.btnskip.setVisibility(View.VISIBLE);
        binding.toolbar.tvToolbarTitle.setText("Registration");
        //   getDeviceIpAddress();

//        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
//        String ipAddress = Formatter.formatIpAddress(wifiManager.getConnectionInfo().getIpAddress());
        //   GlobalClass.dailogsuccess(RegistrationActivity.this, getDeviceIpAddress(), getDeviceIpAddress());
        // Log.d("ipaddress", getDeviceIpAddress());

        //  textView.setText("Your Device IP Address: " + ipAddress);


    }

    @Override
    public void initListeners() {

        binding.toolbar.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        binding.toolbar.btnskip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    CSPreferences.putString(RegistrationActivity.this, "User_Name", "Har Chhatravratti");
                    CSPreferences.putBolean(RegistrationActivity.this, "skiplogin", true);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
                CSPreferences.putBolean(RegistrationActivity.this, "skiplogin", true);
                startActivity(intent);
                finish();

            }
        });

    }

    @Override
    public void onClick(View v) {

        if (v == binding.btnSearch) {

            binding.btnSearch.setCursorVisible(false);

            if (CheckFamilyId_Data(v)) {
/*{
    "DeptCode":"NIC",
    "ServiceCode":"TestCred",
    "DeptKey":"o2etc739ut",
    "UIDFID":"1KQP3440"
}*/
                GetMemberbasicdetailsfromFIDUIDRequest request = new GetMemberbasicdetailsfromFIDUIDRequest();
//test key
              /*  request.setDeptKey("o2etc739ut");
                request.setDeptCode("NIC");
                request.setServiceCode("TestCred");

*/
                //live key
                /*DeptCode	ServiceCode	DeptKey
                   DOHE	SCH	er41w944rr*/


                request.setDeptKey(GlobalClass.DeptKey);
                request.setDeptCode(GlobalClass.DeptCode);
                request.setServiceCode(GlobalClass.ServiceCode);


                request.setUidfid(binding.edtStudentFamilyId.getText().toString().trim());

                if (GlobalClass.isNetworkConnected(RegistrationActivity.this)) {

                    WebAPiCall webapiCall = new WebAPiCall();
                    webapiCall.GetMemberbasicdetailsfromFIDUIDtDataMethod(this, this, RegistrationActivity.this, request);

                } else {

                    Toast.makeText(this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
                }

                // GlobalClass.showtost(RegistrationActivity.this, "Search");
            }
        } else if (v == binding.btnGenerateOtp) {


            if (CheckOtpRequest_Data(v)) {


                if (GlobalClass.isNetworkConnected(RegistrationActivity.this)) {

                    WebAPiCall webapiCall = new WebAPiCall();
                    webapiCall.getCheckStudentAlreadyExistMethod(this, this, RegistrationActivity.this, spnstudentMemberId);

                } else {

                    Toast.makeText(this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
                }
            }
/*{

    "DeptCode":"NIC",
    "ServiceCode":"TestCred",
    "DeptKey":"o2etc739ut",
    "MemberID":"NPBY1904"
}*/


            // GlobalClass.showtost(RegistrationActivity.this, "Generate OTP");


        } else if (v == binding.btnVerifyOtp) {
            if (CheckVerifyOtpRequest_Data(v)) {

/*{
    "DeptCode":"NIC",
    "ServiceCode":"TestCred",
    "DeptKey":"o2etc739ut",
    "MemberID":"NPBY1904"
}*/

                VerifyOTPRequestforMEMIDRequest verifyOTPRequestforMEMIDRequest = new VerifyOTPRequestforMEMIDRequest();
                //test keys
                // verifyOTPRequestforMEMIDRequest.setDeptKey("o2etc739ut");
                // verifyOTPRequestforMEMIDRequest.setDeptCode("NIC");
                //  verifyOTPRequestforMEMIDRequest.setServiceCode("TestCred");

                //live keys


                verifyOTPRequestforMEMIDRequest.setDeptKey(GlobalClass.DeptKey);
                verifyOTPRequestforMEMIDRequest.setDeptCode(GlobalClass.DeptCode);
                verifyOTPRequestforMEMIDRequest.setServiceCode(GlobalClass.ServiceCode);


                verifyOTPRequestforMEMIDRequest.setMemberID(spnstudentMemberId);
                verifyOTPRequestforMEMIDRequest.setOtp(binding.edtOtp.getText().toString().trim());
                verifyOTPRequestforMEMIDRequest.setTxn(txn);

                if (GlobalClass.isNetworkConnected(RegistrationActivity.this)) {

                    WebAPiCall webapiCall = new WebAPiCall();
                    webapiCall.GetVerifyOTPRequestforMEMIDDataMethod(this, this, RegistrationActivity.this, verifyOTPRequestforMEMIDRequest);

                } else {

                    Toast.makeText(this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
                }
            }


            // GlobalClass.showtost(RegistrationActivity.this, "Verify Otp");

        } else if (v == binding.BtnRegistration) {


            int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE);

            if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, REQUEST_READ_PHONE_STATE);
            } else {
               // getDeviceIpAddress();
            }


            String FamilyID = binding.edtFamilyId.getText().toString().trim();
            String memberID = binding.edtMemberId.getText().toString().trim();
            String firstName = binding.edtFirstName.getText().toString().trim();
            String lastName = binding.edtLastName.getText().toString().trim();
            String fullName = binding.edtFullName.getText().toString().trim();
            String fatherFullName = binding.edtFatherName.getText().toString().trim();
            String motherFullName = binding.edtMotherName.getText().toString().trim();
            String gender = binding.edtGender.getText().toString().trim();
            String houseNo = binding.edtHouseNo.getText().toString().trim();
            String streetNo = binding.edtStreetNo.getText().toString().trim();
            String address_LandMark = binding.edtAddress.getText().toString().trim();
            String aadhaarNo = binding.edtAAdhar.getText().toString().trim();
            String dob = binding.edtDOb.getText().toString().trim();
            String mobileNo = binding.edtMobileNo.getText().toString().trim();
            String casteCategory = binding.edtCastCategoryName.getText().toString().trim();
            String casteCategoryName = binding.edtCastCategoryName.getText().toString().trim();
            String email = binding.edtEmailId.getText().toString().trim();
            String IsDenotifiedTribe = binding.edtIsDenotifiedTribecategory.getText().toString().trim();
            String familyIncome = binding.edtFamilyIncome.getText().toString().trim();
            //  String bpl = binding.edtBPL.getText().toString().trim();
            String bplCardNO = " ";
            String disabilityType = binding.edtDisabilityType.getText().toString();
            String isDivyang = binding.edtIsDivyang.getText().toString().trim();
            String Religion = spnstudentReligion;
            String AuthPwd = binding.edtConfirmPassword.getText().toString().trim();



            /*public string FamilyID { get; set; }
        public string memberID { get; set; }
        public string firstName { get; set; }
        public string lastName { get; set; }
        public string fullName { get; set; }
        public string fatherFullName { get; set; }
        public string motherFullName { get; set; }
        public string gender { get; set; }
        public string houseNo { get; set; }
        public string streetNo { get; set; }
        public string address_LandMark { get; set; }
        public string pinCode { get; set; }
        public string dCode { get; set; }
        public string btCode { get; set; }
        public string wvCode { get; set; }
        public string districtName { get; set; }
        public string btName { get; set; }
        public string wvName { get; set; }
        public string aadhaarNo { get; set; }
        public string dob { get; set; }
        public string mobileNo { get; set; }
        public string casteCategory { get; set; }
        public string familyIncome { get; set; }
        public string email { get; set; }
        public string bpl { get; set; }
        public string bplCardNO { get; set; }
        public string dCodeLGD { get; set; }
        public string btCodeLGD { get; set; }
        public string wvCodeLGD { get; set; }
        public string casteCategoryName { get; set; }
        public string disabilityType { get; set; }
        public string isDivyang { get; set; }
        public string divyangPercentage { get; set; }
        public string IsDenotifiedTribe { get; set; }
        public string isDOBVerified { get; set; }
        public string isCasteVerified { get; set; }
        public string isIncomeVerified { get; set; }
        public string isBPLVerified { get; set; }
        public string isDivyangVerified { get; set; }
        public string subCaste_code { get; set; }
        public string subCaste_name { get; set; }
        public string casteDescription { get; set; }
        public string divyangCategory { get; set; }
        public string deprived { get; set; }
        public string Religion { get; set; }
        public string AuthPwd { get; set; }*/
           /*

            String pinCode,
            String dCode,
            String btCode,
            String wvCode,
            String districtName,
            String btName,
            String wvName,
            String dCodeLGD,
            String wvCodeLGD,
            String divyangPercentage,
            String isDOBVerified,
                    String isCasteVerified,
                    String isIncomeVerified,
                    String isBPLVerified,
                    String isDivyangVerified,
                    String subCaste_code,
                    String subCaste_name,
                    String casteDescription,
                    String divyangCategory,
                    String deprived,

*/


            if (CheckRegistrationRequestAll_Data(v)) {

                GlobalClass.showtost(RegistrationActivity.this, "All set to registration call api");




                /*


                                   String ,
                                   String ,
                                   String ,
                                   String ,
                                   String ,
                                   String ,
                                   String ,
                                   String ,
                                   String ,
                                   String ,
                                   String ,
                                   String ,
                                   String ,
                                   String ,
                                   String ,
                                   String ,
                                   String ,
                                   String ,
                                   String ,
                                   String ,
                                   String ,
                                   String ,
                                   String ,
                                   String ,
                                   String ,
                                   String , String ,
                                   String ,
                                   String ,
                                   String ,
                                   String ,
                                   String ,
                                   String ,
                                   String ,
                                   String ,
                                   String ,
                                   String ,
                                   String   */


                if (GlobalClass.isNetworkConnected(RegistrationActivity.this)) {
//getIPAddress
                    WebAPiCall webapiCall = new WebAPiCall();
                    webapiCall.RegistrationMethod(this, this, RegistrationActivity.this, getIPAddress(true), refreshedToken, FamilyID, memberID, firstName,
                            lastName,
                            fullName, fatherFullName,
                            motherFullName, gender,
                            houseNo,
                            streetNo,
                            address_LandMark,
                            pinCode,
                            dCode,
                            btCode,
                            btCodeLGD,
                            wvCode,
                            districtName,
                            btName,
                            wvName,
                            aadhaarNo,
                            dob,
                            mobileNo,
                            casteCategory,
                            familyIncome,
                            email,
                            bpl,
                            bplCardNO,
                            dCodeLGD,
                            wvCodeLGD,
                            casteCategoryName,
                            disabilityType,
                            isDivyang,
                            divyangPercentage,
                            IsDenotifiedTribe,
                            isDOBVerified,
                            isCasteVerified,
                            isIncomeVerified,
                            isBPLVerified,
                            isDivyangVerified,
                            subCaste_code,
                            subCaste_name,
                            casteDescription,
                            divyangCategory,
                            deprived,
                            Religion,
                            AuthPwd);

                } else {

                    Toast.makeText(this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
                }


            }

        } else {
            GlobalClass.showtost(RegistrationActivity.this, "Default");
        }

    }


    public boolean CheckFamilyId_Data(View view) {

        if (TextUtils.isEmpty(binding.edtStudentFamilyId.getText().toString().trim())) {
            GlobalClass.dailogError(RegistrationActivity.this, "Missing PPP Family Id", "Please Enter your Valid PPP FamilyID. ");
            return false;
        }
        return true;
    }

    public boolean CheckOtpRequest_Data(View view) {

        if (TextUtils.isEmpty(binding.edtStudentFamilyId.getText().toString().trim())) {
            GlobalClass.dailogError(RegistrationActivity.this, "Missing PPP Family Id", "Please Enter your Valid PPP FamilyID. ");
            return false;
        } else if (spnstudentNameCurrentPosition == 0) {
            GlobalClass.dailogError(RegistrationActivity.this, "Missing PPP Family Name", "Please Select your Name from PPP Family List. ");
            return false;
        } else {
        }
        return true;


    }

    public boolean CheckVerifyOtpRequest_Data(View view) {

        if (TextUtils.isEmpty(binding.edtStudentFamilyId.getText().toString().trim())) {
            GlobalClass.dailogError(RegistrationActivity.this, "Missing PPP Family Id", "Please Enter your Valid PPP FamilyID. ");
            return false;
        } else if (spnstudentNameCurrentPosition == 0) {
            GlobalClass.dailogError(RegistrationActivity.this, "Missing PPP Family Name", "Please Select your Name from PPP Family List. ");
            return false;
        } else if (TextUtils.isEmpty(binding.edtOtp.getText().toString().trim())) {
            GlobalClass.dailogError(RegistrationActivity.this, "Missing OTP", "Please Enter Valid OTP. ");
            return false;
        }
        return true;


    }

    public boolean CheckRegistrationRequest_Data(View view) {
        if (TextUtils.isEmpty(binding.edtStudentFamilyId.getText().toString().trim())) {
            GlobalClass.dailogError(RegistrationActivity.this, "Missing PPP Family Id", "Please Enter your Valid PPP FamilyID. ");
            return false;
        } else if (spnstudentNameCurrentPosition == 0) {
            GlobalClass.dailogError(RegistrationActivity.this, "Missing PPP Family Name", "Please Select your Name from PPP Family List. ");
            return false;
        } else if (TextUtils.isEmpty(binding.edtOtp.getText().toString().trim())) {
            GlobalClass.dailogError(RegistrationActivity.this, "Missing OTP", "Please Enter Valid OTP. ");
            return false;
        } else if (TextUtils.isEmpty(binding.edtAAdhar.getText().toString().trim())) {
            GlobalClass.dailogError(RegistrationActivity.this, "Missing Aadhar Number ", " Error while fetching Aadhar Number data from  PPP.");
            return false;
        } else if (TextUtils.isEmpty(binding.edtEmailId.getText().toString().trim())) {
            GlobalClass.dailogError(RegistrationActivity.this, "Missing Email-Id ", " Error while fetching Email-Id data from  PPP.");
            return false;
        } /*else if (TextUtils.isEmpty(binding.edtBPL.getText().toString().trim())) {
            GlobalClass.dailogError(RegistrationActivity.this, "Missing BPL ", " Error while fetching BPL data from  PPP.");
            return false;
        }*/ else if (spnReligionCurrentPosition == 0) {
            GlobalClass.dailogError(RegistrationActivity.this, "Missing Religion", "Please Select your Religion from List. ");
            return false;
        } else if (TextUtils.isEmpty(binding.edtPassword.getText().toString().trim())) {
            GlobalClass.dailogError(RegistrationActivity.this, "Missing Password", "Please Enter Password");
            return false;
        } else if (TextUtils.isEmpty(binding.edtConfirmPassword.getText().toString().trim())) {

            GlobalClass.dailogError(RegistrationActivity.this, "Missing Confirm Password", "Please Enter Confirm Password");

            return false;
        } else if (!binding.edtPassword.getText().toString().trim().equalsIgnoreCase(binding.edtConfirmPassword.getText().toString().trim())) {

            GlobalClass.dailogError(RegistrationActivity.this, "Mismatched password & Confirm Password", "Please Enter same password");

            return false;
        } else if (!IsTermConditionCheked) {
            GlobalClass.dailogError(RegistrationActivity.this, "Missing Term & Condition", "Please check Term & Condition. ");
            return false;
        }
        return true;
    }


    public boolean CheckRegistrationRequestAll_Data(View view) {

        if (TextUtils.isEmpty(binding.edtStudentFamilyId.getText().toString().trim())) {
            GlobalClass.dailogError(RegistrationActivity.this, "Missing PPP Family Id", "Please Enter your Valid PPP FamilyID. ");
            return false;
        } else if (spnstudentNameCurrentPosition == 0) {
            GlobalClass.dailogError(RegistrationActivity.this, "Missing PPP Family Name", "Please Select your Name from PPP Family List. ");
            return false;
        } else if (TextUtils.isEmpty(binding.edtOtp.getText().toString().trim())) {
            GlobalClass.dailogError(RegistrationActivity.this, "Missing OTP", "Please Enter Valid OTP. ");
            return false;
        } else if (TextUtils.isEmpty(binding.edtFamilyId.getText().toString().trim())) {
            GlobalClass.dailogError(RegistrationActivity.this, "Missing Family Id ", " Error while fetching FamilyId  data from  PPP.");
            return false;
        } else if (TextUtils.isEmpty(binding.edtMemberId.getText().toString().trim())) {
            GlobalClass.dailogError(RegistrationActivity.this, "Missing Member Id ", " Error while fetching MemberId  data from  PPP.");
            return false;
        } else if (TextUtils.isEmpty(binding.edtFirstName.getText().toString().trim())) {
            GlobalClass.dailogError(RegistrationActivity.this, "Missing First Name ", " Error while fetching First Name  data from  PPP.");
            return false;
        } else if (TextUtils.isEmpty(binding.edtFullName.getText().toString().trim())) {
            GlobalClass.dailogError(RegistrationActivity.this, "Missing Full Name ", " Error while fetching Full Name  data from  PPP.");
            return false;
        } else if (TextUtils.isEmpty(binding.edtFatherName.getText().toString().trim())) {
            GlobalClass.dailogError(RegistrationActivity.this, "Missing Father Name ", " Error while fetching Father Name  data from  PPP.");
            return false;
        } else if (TextUtils.isEmpty(binding.edtFatherName.getText().toString().trim())) {
            GlobalClass.dailogError(RegistrationActivity.this, "Missing Father Name ", " Error while fetching Father Name  data from  PPP.");
            return false;
        } else if (TextUtils.isEmpty(binding.edtMotherName.getText().toString().trim())) {
            GlobalClass.dailogError(RegistrationActivity.this, "Missing Mother Name ", " Error while fetching Mother Name  data from  PPP.");
            return false;
        } else if (TextUtils.isEmpty(binding.edtGender.getText().toString().trim())) {
            GlobalClass.dailogError(RegistrationActivity.this, "Missing Gender ", " Error while fetching Gender data from  PPP.");
            return false;
        } else if (TextUtils.isEmpty(binding.edtGender.getText().toString().trim())) {
            GlobalClass.dailogError(RegistrationActivity.this, "Missing Gender ", " Error while fetching Gender data from  PPP.");
            return false;
        } else if (TextUtils.isEmpty(binding.edtHouseNo.getText().toString().trim())) {
            GlobalClass.dailogError(RegistrationActivity.this, "Missing House Number ", " Error while fetching House Number data from  PPP.");
            return false;
        } else if (TextUtils.isEmpty(binding.edtStreetNo.getText().toString().trim())) {
            GlobalClass.dailogError(RegistrationActivity.this, "Missing Street Number ", " Error while fetching Street Number data from  PPP.");
            return false;
        } else if (TextUtils.isEmpty(binding.edtAddress.getText().toString().trim())) {
            GlobalClass.dailogError(RegistrationActivity.this, "Missing Address ", " Error while fetching Address data from  PPP.");
            return false;
        } else if (TextUtils.isEmpty(binding.edtAAdhar.getText().toString().trim())) {
            GlobalClass.dailogError(RegistrationActivity.this, "Missing Aadhar Number ", " Error while fetching Aadhar Number data from  PPP.");
            return false;
        } else if (!isValidAdhar(binding.edtAAdhar.getText().toString().trim())) {
            GlobalClass.dailogError(RegistrationActivity.this, "Missing 12 digits Aadhar Number.", "Please Enter Your  12 digits Aadhar Number.");
            return false;

        } else if (TextUtils.isEmpty(binding.edtDOb.getText().toString().trim())) {
            GlobalClass.dailogError(RegistrationActivity.this, "Missing DOb ", " Error while fetching Date of Birthday data from  PPP.");
            return false;
        } else if (TextUtils.isEmpty(binding.edtMobileNo.getText().toString().trim())) {
            GlobalClass.dailogError(RegistrationActivity.this, "Missing Mobile Number ", " Error while fetching Mobile Number data from  PPP.");
            return false;
        } else if (TextUtils.isEmpty(binding.edtCastCategoryName.getText().toString().trim())) {
            GlobalClass.dailogError(RegistrationActivity.this, "Missing Cast-Category Name ", " Error while fetching Cast-Category Name data from  PPP.");
            return false;
        } else if (TextUtils.isEmpty(binding.edtEmailId.getText().toString().trim())) {
            GlobalClass.dailogError(RegistrationActivity.this, "Missing Email-Id ", " Error while fetching Email-Id data from  PPP.");
            return false;
        } else if (TextUtils.isEmpty(binding.edtIsDenotifiedTribecategory.getText().toString().trim())) {
            GlobalClass.dailogError(RegistrationActivity.this, "Missing Is Denotified Tribe category ", " Error while fetching IsDenotified Tribe-category data from  PPP.");
            return false;
        } else if (TextUtils.isEmpty(binding.edtFamilyIncome.getText().toString().trim())) {
            GlobalClass.dailogError(RegistrationActivity.this, "Missing Family-Income ", " Error while fetching Family-Income data from  PPP.");
            return false;
        } else if (TextUtils.isEmpty(binding.edtIsDivyang.getText().toString().trim())) {
            GlobalClass.dailogError(RegistrationActivity.this, "Missing IsDivyang ", " Error while fetching IsDivyang data from  PPP.");
            return false;
        } else if (spnReligionCurrentPosition == 0) {
            GlobalClass.dailogError(RegistrationActivity.this, "Missing Religion", "Please Select your Religion from List. ");
            return false;
        } else if (TextUtils.isEmpty(binding.edtPassword.getText().toString().trim())) {
            GlobalClass.dailogError(RegistrationActivity.this, "Missing Password", "Please Enter Password");
            return false;
        } else if (binding.edtPassword.getText().toString().trim().length() < 8) {
            GlobalClass.dailogError(RegistrationActivity.this, "Invalid Password", "Please Enter minimum 8 character  Password");
            return false;
        } else if (TextUtils.isEmpty(binding.edtConfirmPassword.getText().toString().trim())) {

            GlobalClass.dailogError(RegistrationActivity.this, "Missing Confirm Password", "Please Enter Confirm Password");

            return false;
        } else if (binding.edtConfirmPassword.getText().toString().trim().length() < 8) {

            GlobalClass.dailogError(RegistrationActivity.this, "Invalid Confirm Password", "Please Enter minimum 8 character  Confirm Password");

            return false;
        } else if (!binding.edtPassword.getText().toString().trim().equalsIgnoreCase(binding.edtConfirmPassword.getText().toString().trim())) {

            GlobalClass.dailogError(RegistrationActivity.this, "Mismatched password & Confirm Password", "Please Enter same password");

            return false;
        } else if (!IsTermConditionCheked) {
            GlobalClass.dailogError(RegistrationActivity.this, "Missing Term & Condition", "Please check Term & Condition. ");
            return false;
        }
        return true;


    }

    public static boolean isValidPassword(final String password) {

        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();

    }

    private boolean isValidAdhar(String AadharNo) {
        if (!Pattern.matches("[a-zA-Z]+", AadharNo)) {
            return AadharNo.length() > 11 && AadharNo.length() <= 12;

        }
        return false;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        int id = adapterView.getId();
        if (id == R.id.spnstudentName) {

            if (position != 0) {

                spnstudentNameCurrentPosition = position;
                spnstudentMemberId = UserBasicDetailArraylist.get(position).getValue();


//                // getting selected item
//                String item = adapterView.getItemAtPosition(position).toString();
//
//                // Showing selected spinner item in toast
//                Toast.makeText(adapterView.getContext(), "Selected : " + item, Toast.LENGTH_LONG).show();
//
//                //  GlobalClass.showtost(RegistrationActivity.this, "Selected  " + UserBasicDetailArraylist.get(position).getValue());


            } else {
                spnstudentNameCurrentPosition = position;
            }

        } else if (id == R.id.spnReligion) {

            if (position != 0) {
                spnReligionCurrentPosition = position;


                spnstudentReligion = Religionlist.get(position).getReligionName();
                //  GlobalClass.showtost(RegistrationActivity.this, "Selected " + Religionlist.get(position).ReligionName);

            } else {
                spnReligionCurrentPosition = position;
            }

        } else {
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void alluserBasicDetaildata(List<GetMemberbasicdetailsfromFIDUIDResponse.Dropdown> data) {


        UserBasicDetailArraylist.clear();
        UserBasicDetailArraylist.addAll(data);


        GetMemberbasicdetailsfromFIDUIDResponse.Dropdown datum = new GetMemberbasicdetailsfromFIDUIDResponse.Dropdown();
        datum.setText("Select your name.");
        datum.setValue("0");
        UserBasicDetailArraylist.add(0, datum);

//        // Creating array adapter for spinner
//        ArrayAdapter<GetMemberbasicdetailsfromFIDUIDResponse.Dropdown> dataAdapter = new ArrayAdapter<GetMemberbasicdetailsfromFIDUIDResponse.Dropdown>(this, android.R.layout.simple_spinner_item, UserBasicDetailArraylist);
//
//        // Drop down style will be listview with radio button
//        dataAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
//
//        // attaching data adapter to spinner
//        binding.spnstudentName.setAdapter(dataAdapter);


        basicDetailAdapter = new SpinnerMemberBasicDetailAdapter(getApplicationContext(), UserBasicDetailArraylist);
        binding.spnstudentName.setAdapter(basicDetailAdapter);


    }

    @Override
    public void OtpForMEMIDDdata(OTPRequestforMEMIDResponse.Result data) {

      /*  if (data.getStatus().equalsIgnoreCase("Successfull")) {
            
        }*/

        GlobalClass.dailogsuccess(RegistrationActivity.this, data.getStatus(), data.getMessage());

        txn = data.getTxn();

    }


    @Override
    public void verifyOtpForMEMIDDdata(VerifyOTPRequestforMEMIDResponse.Result data) {


        binding.llmain.setVisibility(View.GONE);

        pinCode = data.getPinCode();
        dCode = data.getdCode();
        btCode = data.getBtCode();
        btCodeLGD = data.getBtCodeLGD();
        wvCode = data.getWvCode();
        districtName = data.getDistrictName();
        btName = data.getBtName();
        wvName = data.getWvName();
        dCodeLGD = data.getdCodeLGD();
        wvCodeLGD = data.getWvCodeLGD();
        divyangPercentage = String.valueOf(data.getDivyangPercentage());

        isDOBVerified = data.getIsDOBVerified();
        isCasteVerified = data.getIsCasteVerified();
        isIncomeVerified = data.getIsIncomeVerified();
        isBPLVerified = data.getIsBPLVerified();
        isDivyangVerified = data.getIsDivyangVerified();
        subCaste_code = data.getSubCasteCode();
        subCaste_name = data.getSubCasteName();
        casteDescription = data.getCasteDescription();
        divyangCategory = data.getDivyangCategory();
        deprived = data.getDeprived();


        binding.llregistrationAll.setVisibility(View.VISIBLE);

        binding.edtFamilyId.setText(data.getFamilyID());
        binding.edtMemberId.setText(data.getMemberID());
        binding.edtFirstName.setText(data.getFirstName());
        binding.edtLastName.setText(data.getLastName());
        binding.edtFullName.setText(data.getFullName());
        binding.edtFatherName.setText(data.getFatherFullName());
        binding.edtMotherName.setText(data.getMotherFullName());
        binding.edtGender.setText(data.getGender());
        binding.edtHouseNo.setText(data.getHouseNo());
        binding.edtStreetNo.setText(data.getStreetNo());
        binding.edtAddress.setText(data.getAddressLandMark());
        binding.edtAAdhar.setText(data.getAadhaarNo());
        binding.edtDOb.setText(data.getDob());
        binding.edtMobileNo.setText(data.getMobileNo());

        binding.edtEmailId.setText(data.getEmail());
        binding.edtFamilyIncome.setText(String.valueOf(data.getFamilyIncome()));


        binding.edtDisabilityType.setText(String.valueOf(data.getDisabiltyType()));
        binding.edtIsDivyang.setText(String.valueOf(data.getIsDivyang()));


        if (data.getCasteCategory() == 6) {
//                                        hdnCasteCode.Value = "2";
//                                        txtCaste.Text = "SC";
            binding.edtCastCategoryName.setText("SC");
            //  txtDenotifiedTribe.Text = "Y";
            binding.edtIsDenotifiedTribecategory.setText("Y");
        } else {
//                                        hdnCasteCode.Value = Convert.ToString(objjson.result.casteCategory);
//                                        txtCaste.Text = objjson.result.casteCategoryName;
            binding.edtCastCategoryName.setText(data.getCasteCategoryName());
            binding.edtIsDenotifiedTribecategory.setText("N");
            //   txtDenotifiedTribe.Text = "N";
        }


        // if (isIncomeVerified.equalsIgnoreCase("Y")) {

        if (data.getAadhaarNo() == null || data.getAadhaarNo().isEmpty()) {


            if (GlobalClass.isNetworkConnected(RegistrationActivity.this)) {

                WebAPiCall webapiCall = new WebAPiCall();
                webapiCall.getAadharnoFromMemIDAPiMethod(this, this, RegistrationActivity.this, spnstudentMemberId);

            } else {

                Toast.makeText(this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
            }

        }


//        } else {
//
//
//            SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(RegistrationActivity.this);
//            sweetAlertDialog.setTitle("Family Income certificate not Verified !");
//            sweetAlertDialog.setContentText("Family Income is not Verified in your PPP Data, Kindly get your family income details Verified in your Parivar Pehchan Patra to avail Scholarship benefits");
//            sweetAlertDialog.setVolumeControlStream(2);
//            sweetAlertDialog.getAlerType();
//            sweetAlertDialog.changeAlertType(1);
//            sweetAlertDialog.setCancelable(false);
//            sweetAlertDialog.setCanceledOnTouchOutside(false);
//            sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
//                @Override
//                public void onClick(SweetAlertDialog sweetAlertDialog) {
//
//                    sweetAlertDialog.dismissWithAnimation();
//                    finish();
//
//                }
//            });
//
//            sweetAlertDialog.show();
//
//
//        }


    }


    @Override
    public void GetCheckStudentExistData(List<CheckStudentAlreadyExistResponse.Datum> list, int responseCode) {

        // if (list.get(0).getResponse().equalsIgnoreCase("1")) {
        if (responseCode == 200) {

            GlobalClass.dailogError(RegistrationActivity.this, "Already Exist", "Student with the Same Name and Member ID already exist, please check the details again.");

        } else {


            OTPRequestforMEMIDRequest otpRequestforMEMIDRequest = new OTPRequestforMEMIDRequest();

            // test keys
            // otpRequestforMEMIDRequest.setDeptKey("o2etc739ut");
            // otpRequestforMEMIDRequest.setDeptCode("NIC");
            // otpRequestforMEMIDRequest.setServiceCode("TestCred");

            otpRequestforMEMIDRequest.setDeptKey(GlobalClass.DeptKey);
            otpRequestforMEMIDRequest.setDeptCode(GlobalClass.DeptCode);
            otpRequestforMEMIDRequest.setServiceCode(GlobalClass.ServiceCode);


            otpRequestforMEMIDRequest.setMemberID(spnstudentMemberId);

            if (GlobalClass.isNetworkConnected(RegistrationActivity.this)) {

                WebAPiCall webapiCall = new WebAPiCall();
                webapiCall.GetOTPRequestforMEMIDDataMethod(this, this, RegistrationActivity.this, otpRequestforMEMIDRequest);

            } else {

                Toast.makeText(this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
            }

        }

    }

    @Override
    public void registrationuserdata(StudentRegistrationResponse.Data data) {


        SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(RegistrationActivity.this);
        sweetAlertDialog.setTitle("Congratulation\n!Registration successfull" + "!");
        sweetAlertDialog.setContentText("Student Registered Successfully. Your Username is: " + String.valueOf(data.getMemberId() + "\n Please go to URL - harchhatravratti.highereduhry.ac.in/UserLogin for filling of application form."));
        sweetAlertDialog.setVolumeControlStream(2);
        sweetAlertDialog.getAlerType();
        sweetAlertDialog.changeAlertType(2);
        sweetAlertDialog.setCancelable(false);
        sweetAlertDialog.setCanceledOnTouchOutside(false);
        sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sweetAlertDialog) {

                sweetAlertDialog.dismissWithAnimation();

                try {
            /*{"response":200,"sys_message":"Login Data Returned","data":{"name":"Super Admin","collegeId":"","college":"",
            "collegeCode":"","studentId":"","memberId":"","token":"459839a022111372c00df629305430df","userType":"SuperAdmin","mobileNo":"","email":""}}
             */
                    CSPreferences.putString(RegistrationActivity.this, "MemberId", String.valueOf(data.getMemberId()));
                    CSPreferences.putString(RegistrationActivity.this, "userid", String.valueOf(data.getStudentId()));
                    CSPreferences.putString(RegistrationActivity.this, "User_Name", data.getName());
                    CSPreferences.putString(RegistrationActivity.this, "User_Profile_Photo", data.getFileStudentImage());
                    CSPreferences.putString(RegistrationActivity.this, "PhoneNo", data.getMobileNo());
                    CSPreferences.putString(RegistrationActivity.this, "Email", data.getEmail());
                    CSPreferences.putString(RegistrationActivity.this, "token", data.getToken());
                    CSPreferences.putBolean(RegistrationActivity.this, "firstTimelogin", firstTimelogin);
                    CSPreferences.putString(RegistrationActivity.this, "UserType", data.getUserType());

                    CSPreferences.putString(RegistrationActivity.this, "AadhaarNo", data.getAadhaarNo());
                    CSPreferences.putString(RegistrationActivity.this, "CasteCategoryName", data.getCasteCategoryName());
                    CSPreferences.putString(RegistrationActivity.this, "FamilyIncome", data.getFamilyIncome());
                    CSPreferences.putString(RegistrationActivity.this, "FatherFullName", data.getFatherFullName());
                    CSPreferences.putString(RegistrationActivity.this, "FamilyID", data.getFamilyID());
                    //  CSPreferences.putString(RegistrationActivity.this, "department_Id", String.valueOf(data.getDepartment_Id()));
                    CSPreferences.putString(RegistrationActivity.this, "collegeId", data.getCollegeId());
                    //  CSPreferences.putString(RegistrationActivity.this, "nodalBody_Id", data.getNodalBody_Id());
                    CSPreferences.putBolean(RegistrationActivity.this, "skiplogin", false);
                    CSPreferences.putBolean(RegistrationActivity.this, "Is_CurrentSession_Active", Is_CurrentSession_Active);
                    CSPreferences.putBolean(RegistrationActivity.this, "Is_Already_Apply_In_Current_Session", Is_Already_Apply_In_Current_Session);
                    CSPreferences.putBolean(RegistrationActivity.this, "Is_Already_Apply_Other_Scholarship_scheme_In_Current_Session", Is_Already_Apply_Other_Scholarship_scheme_In_Current_Session);


                    Intent intentlogin = new Intent(RegistrationActivity.this, MainActivity.class);
                    intentlogin.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intentlogin.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intentlogin);
                    finish();


                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        sweetAlertDialog.show();


    }

    @Override
    public void AadharFromMemIddata(String data) {

        if (!data.isEmpty()) {

            binding.edtAAdhar.setText(data);


        }
    }
}