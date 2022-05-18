package hsvp.digital.allottee_corner.ui;

import android.os.Build;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.databinding.DataBindingUtil;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import hsvp.digital.allottee_corner.R;
import hsvp.digital.allottee_corner.adapter.SpinnerAcademicSessionAdapter;
import hsvp.digital.allottee_corner.adapter.SpinnerScholarshipSchemesAdapter;
import hsvp.digital.allottee_corner.allinterface.GetAcademicSessionData_interface;
import hsvp.digital.allottee_corner.allinterface.GetApplicationStatusData_interface;
import hsvp.digital.allottee_corner.allinterface.GetScholarshipschemeData_interface;
import hsvp.digital.allottee_corner.apicall.WebAPiCall;
import hsvp.digital.allottee_corner.databinding.ActivityCheckApplicatioStatusBinding;
import hsvp.digital.allottee_corner.model.AcademicSessionResponse;
import hsvp.digital.allottee_corner.model.GetApplicationStatusByAadharResponse;
import hsvp.digital.allottee_corner.model.ScholarshipSchemesResponse;
import hsvp.digital.allottee_corner.utility.BaseActivity;
import hsvp.digital.allottee_corner.utility.CSPreferences;
import hsvp.digital.allottee_corner.utility.GlobalClass;
import hsvp.digital.allottee_corner.utility.MyLoaders;

public class CheckApplicatioStatusActivity extends BaseActivity implements GetAcademicSessionData_interface, AdapterView.OnItemSelectedListener, GetScholarshipschemeData_interface, GetApplicationStatusData_interface {

    ActivityCheckApplicatioStatusBinding binding;
    private String refreshedToken, userAcademicSession, userScholarshipSchemeName;
    private List<AcademicSessionResponse.Datum> AcademicSessionlist = new ArrayList<AcademicSessionResponse.Datum>();
    private List<ScholarshipSchemesResponse.Datum> ScholarshipSchemeslist = new ArrayList<ScholarshipSchemesResponse.Datum>();
    SpinnerAcademicSessionAdapter academicSessionAdapter;
    SpinnerScholarshipSchemesAdapter scholarshipSchemesAdapter;
    private int spnAcademicSessionCurrentPosition;
    private int spnScholarshipschemeCurrentPosition;
    private int userScholarshipSchemeId;
    private String AadharNo;
    private MyLoaders myLoaders;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_check_applicatio_status);
        myLoaders = new MyLoaders(getApplicationContext());

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
        String auth_key = CSPreferences.readString(CheckApplicatioStatusActivity.this, "userid");

        if (!auth_key.isEmpty()) {

            if (CSPreferences.readString(CheckApplicatioStatusActivity.this, "UserType").equalsIgnoreCase("Student")) {

                binding.edtuserAdharNO.setText(CSPreferences.readString(this, "AadhaarNo"));
            }
        }

        if (GlobalClass.isNetworkConnected(CheckApplicatioStatusActivity.this)) {
            WebAPiCall aPiCall = new WebAPiCall();
            aPiCall.GetAllAcademicSessionDataMethod(CheckApplicatioStatusActivity.this, CheckApplicatioStatusActivity.this, CheckApplicatioStatusActivity.this);

        } else {
            Toast.makeText(CheckApplicatioStatusActivity.this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
        }


        binding.spnstudentAcademicSession.setOnItemSelectedListener(this);
        binding.spnstudentScholarshipscheme.setOnItemSelectedListener(this);


    }

    @Override
    public void initData() {
        binding.toolbar.tvToolbarTitle.setText("Application Status");
    }

    @Override
    public void initListeners() {

        binding.toolbar.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        binding.btnStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Check_Data(v)) {
                    AadharNo = binding.edtuserAdharNO.getText().toString().trim();

                    if (GlobalClass.isNetworkConnected(CheckApplicatioStatusActivity.this)) {

                        WebAPiCall aPiCall = new WebAPiCall();
                        aPiCall.getApplicationStatusByAadharDataMethod(CheckApplicatioStatusActivity.this, CheckApplicatioStatusActivity.this,
                                CheckApplicatioStatusActivity.this, AadharNo,
                                String.valueOf(userScholarshipSchemeId),
                                userAcademicSession, binding.consapptracking, binding.lldetail, binding.txtlabel);

                    } else {

                        Toast.makeText(CheckApplicatioStatusActivity.this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
                    }

                }

            }
        });

    }

    private boolean isValidAdhar(String phone) {
        if (!Pattern.matches("[a-zA-Z]+", phone)) {
            return phone.length() > 11 && phone.length() <= 12;

        }
        return false;
    }

    public boolean Check_Data(View view) {

        if (binding.edtuserAdharNO.getText().toString().trim().isEmpty()) {
            GlobalClass.dailogError(CheckApplicatioStatusActivity.this, "Missing Aadhar Number.", "Please Enter Your  12 digits Aadhar Number.");
            return false;
        } else if (!isValidAdhar(binding.edtuserAdharNO.getText().toString().trim())) {
            GlobalClass.dailogError(CheckApplicatioStatusActivity.this, "Missing 12 digits Aadhar Number.", "Please Enter Your  12 digits Aadhar Number.");
            return false;

        } else if (spnAcademicSessionCurrentPosition == 0) {
            GlobalClass.dailogError(CheckApplicatioStatusActivity.this, "Missing Academic Session.", "Please Select Your Academic Session.");
            return false;
        } else if (spnScholarshipschemeCurrentPosition == 0) {
            GlobalClass.dailogError(CheckApplicatioStatusActivity.this, "Missing Scholarship scheme.", "Please Select Your Scholarship scheme.");
            return false;
        }
        return true;

    }

    @Override
    public void GetAcademicSessionData(List<AcademicSessionResponse.Datum> list) {

        AcademicSessionlist.clear();
        AcademicSessionlist.addAll(list);

        AcademicSessionResponse.Datum datum = new AcademicSessionResponse.Datum();
        datum.setAcademicSession("academic session.");
        datum.setAcademicSessionid(0);
        AcademicSessionlist.add(0, datum);

        academicSessionAdapter = new SpinnerAcademicSessionAdapter(getApplicationContext(), AcademicSessionlist);
        binding.spnstudentAcademicSession.setAdapter(academicSessionAdapter);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

        int id = adapterView.getId();
        if (id == R.id.spnstudentAcademicSession) {

            if (position != 0) {

                spnAcademicSessionCurrentPosition = position;

                userAcademicSession = AcademicSessionlist.get(position).getAcademicSession();

                if (GlobalClass.isNetworkConnected(CheckApplicatioStatusActivity.this)) {

                    WebAPiCall aPiCall = new WebAPiCall();
                    aPiCall.GetAllScholarshipSchemesDataMethod(CheckApplicatioStatusActivity.this, CheckApplicatioStatusActivity.this, CheckApplicatioStatusActivity.this);

                } else {

                    Toast.makeText(CheckApplicatioStatusActivity.this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
                }


                //Toast.makeText(getApplicationContext(), courseYear.get(position).getName(), Toast.LENGTH_LONG).show();

            } else {
                spnAcademicSessionCurrentPosition = position;

            }


        } else if (id == R.id.spnstudentScholarshipscheme) {

            if (position != 0) {

                spnScholarshipschemeCurrentPosition = position;

                userScholarshipSchemeName = ScholarshipSchemeslist.get(position).getSchemeName();
                userScholarshipSchemeId = ScholarshipSchemeslist.get(position).getSchemeId();


            } else {
                spnScholarshipschemeCurrentPosition = position;

            }


        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void GetScholarshipschemeData(List<ScholarshipSchemesResponse.Datum> list) {

        ScholarshipSchemeslist.clear();
        ScholarshipSchemeslist.addAll(list);

        ScholarshipSchemesResponse.Datum datum = new ScholarshipSchemesResponse.Datum();
        datum.setSchemeName("Select your scholarship scheme.");
        datum.setSchemeId(0);
        ScholarshipSchemeslist.add(0, datum);

        scholarshipSchemesAdapter = new SpinnerScholarshipSchemesAdapter(getApplicationContext(), ScholarshipSchemeslist);
        binding.spnstudentScholarshipscheme.setAdapter(scholarshipSchemesAdapter);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void GetApplicationStatusData(List<GetApplicationStatusByAadharResponse.Datum> list) {


        if (list != null) {

            binding.consapptracking.setVisibility(View.VISIBLE);
            binding.lldetail.setVisibility(View.VISIBLE);
            binding.txtlabel.setVisibility(View.VISIBLE);

            /*{"response":200,"sys_message":"Data Returned","data":[{"fullName":"MUKESH VERMA","fatherFullName":"OM PARKASH",
            "familyID":"8OXH8657","memberID":"JHSZ2393","aadhaarNo":"483817819463","casteCategoryName":"BC (A)","college":"Guru Dronacharya College of Education, Bhuna, Fatehabad","courseName":"D.EL.Ed.","year":"I  ",
            "application_Id":1000,"academicSession":"2020-21","appliedOn":"2021-03-11T17:03:15.49","rR_No":"","attendance":0,
            "collegeStatus":"Rejected","collegeStatusDate":"2021-07-05T10:54:01.97",
            "collegeRemarks":"NAME STRUCK OFF ","nodalBody_Status":"Pending","nodalBody_StatusDate":null,
            "nodalBody_Remarks":null,"hQ_Status":"Pending","hQ_StatusDate":null,"hQ_Remarks":null,
            "isScholarshipDisbursed":"N","transactionNo":null,"amountDisbursed":null,"transactionDate":null}]}*/

            try {


                binding.edtFullName.setText(list.get(0).getFullName());
                binding.edtMemberId.setText(String.valueOf(list.get(0).getMemberID()));
                binding.edtFatherName.setText(list.get(0).getFatherFullName());
                binding.edtCastCategoryName.setText(list.get(0).getCasteCategoryName());
                binding.edtApplicationNo.setText(String.valueOf(list.get(0).getApplicationId()));
                binding.edtInstituteName.setText(list.get(0).getCollege());
                binding.edtCourseName.setText(list.get(0).getCourseName());
                binding.edtYear.setText(String.valueOf(list.get(0).getYear()));
                binding.edtSession.setText(list.get(0).getAcademicSession());

                binding.edtAppliedOn.setText(list.get(0).getAppliedOn());
                binding.txtAppAppliedDate.setText(list.get(0).getAppliedOn());
                binding.edtRRNo.setText(String.valueOf(list.get(0).getrRNo()));
                binding.edtAttendance.setText(String.valueOf(list.get(0).getAttendance()));

                /*********************            Application Verified by College/Institute         *************************/

                binding.txtStatusCollegeInstituteLabel.setText("Status:- " + list.get(0).getCollegeStatus());
                binding.txtcollegeStatusdate.setText("Status Date:- " + list.get(0).getCollegeStatusDate());
                binding.txtcollegeStatusRemark.setText("Remark:- " + list.get(0).getCollegeRemarks());


                if (list.get(0).getCollegeStatus().equalsIgnoreCase("Rejected")) {

                    binding.imgCollegeoRInstituteLavel.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_cancel_24));

                } else if (list.get(0).getCollegeStatus().equalsIgnoreCase("Pending")) {
                    binding.imgCollegeoRInstituteLavel.setImageDrawable(getResources().getDrawable(R.drawable.pending));


                } else if (list.get(0).getCollegeStatus().equalsIgnoreCase("Sent Back for Correction")) {
                    binding.imgCollegeoRInstituteLavel.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_undo_24));

                } else if (list.get(0).getCollegeStatus().equalsIgnoreCase("Approved")) {
                    binding.imgCollegeoRInstituteLavel.setImageDrawable(getResources().getDrawable(R.drawable.right));
                }


                /********************   Application Verified by Nodal Body  "nodalBody_Status":"Pending","nodalBody_StatusDate":null,
                 "nodalBody_Remarks":null,   *************************/

                binding.TxtNodalBodyLabelStatus.setText("Status:- " + list.get(0).getNodalBodyStatus());
                binding.TxtNodalBodyLabelStatusdate.setText("Status Date:- " + list.get(0).getNodalBodyStatusDate());
                binding.TxtNodalBodyLabelRemark.setText("Remark:- " + list.get(0).getNodalBodyRemarks());

                if (list.get(0).getNodalBodyStatus().equalsIgnoreCase("Rejected")) {

                    binding.imgNodalBodyLevel.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_cancel_24));

                } else if (list.get(0).getNodalBodyStatus().equalsIgnoreCase("Pending")) {
                    binding.imgNodalBodyLevel.setImageDrawable(getResources().getDrawable(R.drawable.pending));


                } else if (list.get(0).getNodalBodyStatus().equalsIgnoreCase("Sent Back for Correction")) {
                    binding.imgNodalBodyLevel.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_undo_24));

                } else if (list.get(0).getNodalBodyStatus().equalsIgnoreCase("Approved")) {
                    binding.imgNodalBodyLevel.setImageDrawable(getResources().getDrawable(R.drawable.right));
                } else {
                }


                /********************   Application Verified by Department/Head Office "hQ_Status":"Pending","hQ_StatusDate":null,"hQ_Remarks":null,   *************************/

                binding.txtDeptHeadOfficeLabelStatus.setText("Status:- " + list.get(0).gethQStatus());
                binding.txtDeptHeadOfficeLabelStatusdate.setText("Status Date:- " + list.get(0).gethQStatusDate());
                binding.txtDeptHeadOfficeLabelStatusRemark.setText("Remark:- " + list.get(0).gethQRemarks());

                if (list.get(0).gethQStatus().equalsIgnoreCase("Rejected")) {

                    binding.imgDepartmentOrHeadLevel.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_cancel_24));

                } else if (list.get(0).gethQStatus().equalsIgnoreCase("Pending")) {
                    binding.imgDepartmentOrHeadLevel.setImageDrawable(getResources().getDrawable(R.drawable.pending));


                } else if (list.get(0).gethQStatus().equalsIgnoreCase("Sent Back for Correction")) {
                    binding.imgDepartmentOrHeadLevel.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_undo_24));

                } else if (list.get(0).gethQStatus().equalsIgnoreCase("Approved")) {
                    binding.imgDepartmentOrHeadLevel.setImageDrawable(getResources().getDrawable(R.drawable.right));
                } else {
                }


                /********************   Application Scholarship Disbursed    "isScholarshipDisbursed":"N","transactionNo":null,"amountDisbursed":null,"transactionDate":null
                 *  Status: No
                 Disbursement Date:
                 Transaction No:
                 Amount Disbursed:  *************************/

                SpannableStringBuilder str = new SpannableStringBuilder("Status:- " + list.get(0).getIsScholarshipDisbursed());
                str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 8, 10, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);


                // binding.TxtScholarshipDisbursedStatus.setText("Status:- "+list.get(0).getIsScholarshipDisbursed());
                binding.TxtScholarshipDisbursedStatus.setText(str);
                binding.TxtScholarshipDisbursedStatusdate.setText("Disbursement Date:- " + list.get(0).getTransactionDate());
                binding.txtScholarshipTransactionNo.setText("Transaction No:- " + list.get(0).getTransactionNo());
                binding.txtScholarshipDisbursedAmount.setText("Amount Disbursed:- " + list.get(0).getAmountDisbursed());

                if (list.get(0).getIsScholarshipDisbursed().equalsIgnoreCase("N")) {
                    binding.imgScholarshipDisbursedLevel.setImageDrawable(getResources().getDrawable(R.drawable.pending));


                } else if (list.get(0).getIsScholarshipDisbursed().equalsIgnoreCase("Y")) {
                    binding.imgScholarshipDisbursedLevel.setImageDrawable(getResources().getDrawable(R.drawable.right));
                } else {
                }


            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {

            binding.consapptracking.setVisibility(View.GONE);
            binding.lldetail.setVisibility(View.GONE);
        }


    }
}