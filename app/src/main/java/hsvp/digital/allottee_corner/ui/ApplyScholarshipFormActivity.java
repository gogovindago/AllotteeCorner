package hsvp.digital.allottee_corner.ui;

import static android.Manifest.permission.INTERNET;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

import hsvp.digital.allottee_corner.R;
import hsvp.digital.allottee_corner.adapter.AreaTypeAdapter;
import hsvp.digital.allottee_corner.adapter.BoardingTypeAdapter;
import hsvp.digital.allottee_corner.adapter.CollegeInstituteAdapter;
import hsvp.digital.allottee_corner.adapter.CourseTypeAdapter;
import hsvp.digital.allottee_corner.adapter.CourseYearAdapter;
import hsvp.digital.allottee_corner.adapter.SpinnerAcademicSessionAdapter;
import hsvp.digital.allottee_corner.adapter.SpinnerAllCourseForApplyAdapter;
import hsvp.digital.allottee_corner.adapter.SpinnerAllDistrictAdapter;
import hsvp.digital.allottee_corner.adapter.SpinnerlDepartmentByCourseIdAdapter;
import hsvp.digital.allottee_corner.adapter.StudentQuotaAdapter;
import hsvp.digital.allottee_corner.adapter.lateralEntryAdapter;
import hsvp.digital.allottee_corner.allinterface.GetAcademicSessionData_interface;
import hsvp.digital.allottee_corner.allinterface.GetAllCourseForApplyListData_interface;
import hsvp.digital.allottee_corner.allinterface.GetAllCourseTypeListData_interface;
import hsvp.digital.allottee_corner.allinterface.GetCheckApplicationExistData_interface;
import hsvp.digital.allottee_corner.allinterface.GetCollegeListData_interface;
import hsvp.digital.allottee_corner.allinterface.GetCourseYearData_interface;
import hsvp.digital.allottee_corner.allinterface.GetDeptByCourseIdListData_interface;
import hsvp.digital.allottee_corner.allinterface.GetDistrictListData_interface;
import hsvp.digital.allottee_corner.allinterface.OtpForMEMIDData_interface;
import hsvp.digital.allottee_corner.allinterface.verifyOtpForMEMIDData_interface;
import hsvp.digital.allottee_corner.apicall.WebAPiCall;
import hsvp.digital.allottee_corner.databinding.ActivityApplyScholarshipFormBinding;
import hsvp.digital.allottee_corner.model.AcademicSessionResponse;
import hsvp.digital.allottee_corner.model.AllDistrictsResponse;
import hsvp.digital.allottee_corner.model.AreaType;
import hsvp.digital.allottee_corner.model.BoardingType;
import hsvp.digital.allottee_corner.model.CheckApplicationExistResponse;
import hsvp.digital.allottee_corner.model.CollegeListResponse;
import hsvp.digital.allottee_corner.model.CourseYearResponse;
import hsvp.digital.allottee_corner.model.CoursesTypeResponse;
import hsvp.digital.allottee_corner.model.DepartmentByCourseIdForApplyResponse;
import hsvp.digital.allottee_corner.model.GetAllCoursesResponse;
import hsvp.digital.allottee_corner.model.LateralEntry;
import hsvp.digital.allottee_corner.model.OTPRequestforMEMIDRequest;
import hsvp.digital.allottee_corner.model.OTPRequestforMEMIDResponse;
import hsvp.digital.allottee_corner.model.StudentQuota;
import hsvp.digital.allottee_corner.model.VerifyOTPRequestforMEMIDRequest;
import hsvp.digital.allottee_corner.model.VerifyOTPRequestforMEMIDResponse;
import hsvp.digital.allottee_corner.utility.BaseActivity;
import hsvp.digital.allottee_corner.utility.CSPreferences;
import hsvp.digital.allottee_corner.utility.FileUtils;
import hsvp.digital.allottee_corner.utility.GlobalClass;
import hsvp.digital.allottee_corner.utility.ImagePickerActivity;

public class ApplyScholarshipFormActivity extends BaseActivity implements GetAcademicSessionData_interface, GetDistrictListData_interface, AdapterView.OnItemSelectedListener, View.OnClickListener, OtpForMEMIDData_interface, verifyOtpForMEMIDData_interface, GetAllCourseForApplyListData_interface, GetDeptByCourseIdListData_interface, GetAllCourseTypeListData_interface, GetCourseYearData_interface, GetCollegeListData_interface, GetCheckApplicationExistData_interface {
    ActivityApplyScholarshipFormBinding binding;

    Boolean IsTermConditionCheked = false;
    private static final String TAG = MainActivity.class.getSimpleName();
    public static final int REQUEST_IMAGE = 100;
    public static final int REQUEST_IMAGE_FOR_SIGNATURE = 101;
    File imagefile, signaturefile;
    private int REQUEST_CODE = 123;
    private int REQUEST_CODE_FOR_dOMICILE = 124;
    private int REQUEST_CODE_FOR_AADHAR = 125;
    private int REQUEST_CODE_FOR_INCOMECERTIFICATE = 126;
    private int REQUEST_CODE_FOR_CASTCERTIFICATE = 127;
    private int REQUEST_CODE_FOR_HOSTELCERTIFICATE = 128;
    private int REQUEST_CODE_FOR_10thDMCCERTIFICATE = 129;
    private int REQUEST_CODE_FOR_12thDMCCERTIFICATE = 130;
    private int REQUEST_CODE_FOR_LastExamPassedDMCDMCCERTIFICATE = 131;
    private int REQUEST_CODE_FOR_FEERECEIPTCOPTY = 132;
    private int REQUEST_CODE_FOR_FATHERDEATHCERTIFICATE = 133;
    private int REQUEST_CODE_FOR_BPLCERTIFICATE = 134;
    private int REQUEST_CODE_FOR_AadhaarSeededdocuments = 135;
    private int REQUEST_CODE_FOR_AttendanceCertificate = 136;
    private int REQUEST_CODE_FOR_FeeStructureCopy = 137;
    private int REQUEST_CODE_FOR_UniversityCertificate = 138;
    private int REQUEST_CODE_FOR_NSPCertificate = 139;
    private int REQUEST_CODE_FOR_CollegeInstitutionAffiliationCertificate = 140;
    File scorecardfile, dOmicilefile, aADHARfile, INCOMECERTIFICATEFILE, casteCertificate, hostelCertificate,
            tenth_dmcCertificate, inter_dmcCertificate, LastExamPassedDMCCertificate, fatherdeathCertificate,
            BPLCertificate, FeeReceiptCopy, AadhaarSeededdocuments,
            AttendanceCertificate, feeStructureCopy,
            universityCertificate, nSPCertificate, collegeInstitutionAffiliationCertificate;


    private List<AcademicSessionResponse.Datum> AcademicSessionlist = new ArrayList<AcademicSessionResponse.Datum>();
    private List<AllDistrictsResponse.Datum> DistrictarrayList = new ArrayList<AllDistrictsResponse.Datum>();
    private List<DepartmentByCourseIdForApplyResponse.Datum> DepartmentarrayList = new ArrayList<DepartmentByCourseIdForApplyResponse.Datum>();
    private List<GetAllCoursesResponse.Datum> allCourseForApplyarrayList = new ArrayList<GetAllCoursesResponse.Datum>();

    private List<CollegeListResponse.Datum> CollegearrayList = new ArrayList<CollegeListResponse.Datum>();
    private List<CoursesTypeResponse.Datum> CoursesTypearrayList = new ArrayList<CoursesTypeResponse.Datum>();
    private List<CourseYearResponse.Datum> CoursesYaerarrayList = new ArrayList<CourseYearResponse.Datum>();


    private List<AreaType> AreaTypelist = new ArrayList<AreaType>();
    private List<BoardingType> BoardingTypelist = new ArrayList<BoardingType>();
    private List<StudentQuota> StudentQuotaTypelist = new ArrayList<StudentQuota>();
    private List<LateralEntry> lateralEntrylist = new ArrayList<LateralEntry>();


    private int UserstudentCollegeId, spnstudentCollegeCurrentPosition, spnCourseYearCurrentPosition, spnCourseTypeCurrentPosition, UserCourseTypeId, UseLateralEntryId, spnLateralEntryaCurrentPosition, spnAreaTypeCurrentPosition, spnBoardingTypeCurrentPosition, spnStudentQuotaCurrentPosition, spndistrictCurrentPosition, UseBoardingTypeId,
            UseStudentQuotaId, UserAreaTypeId, spncourseCurrentPosition, spndepartmentCurrentPosition, UserDistrictId, UserDepartmentID, spnAcademicSessionCurrentPosition;


    private SpinnerAllDistrictAdapter Adapter;
    private SpinnerlDepartmentByCourseIdAdapter departmentAdapter;
    SpinnerAcademicSessionAdapter academicSessionAdapter;
    SpinnerAllCourseForApplyAdapter spinnerAllCourseForApplyAdapter;
    AreaTypeAdapter areaTypeAdapter;
    BoardingTypeAdapter boardingTypeAdapter;

    StudentQuotaAdapter studentQuotaAdapter;
    lateralEntryAdapter entryAdapter;
    CourseTypeAdapter courseTypeAdapter;
    CourseYearAdapter courseYearAdapter;
    CollegeInstituteAdapter collegeInstituteAdapter;
    RadioGroup btnRadiogroup;
    RadioButton checkedRadioButton;
    Boolean Is_Studying_Outside_the_Haryana_State;

    String userstudentCollegeName, userCourseYearName, userCourseTypeName, userLateralEntryName, userAreaTypeName, userBoardingTypeName, userStudentQuotaName, Session, studentMemberId, SchemeID, studentuserid, courseId, courseName, userDistrictName, userAcademicSession,
            userdepartmentName, txn, pinCode, dCode, btCode, btCodeLGD, wvCode, districtName, btName, wvName, dCodeLGD, wvCodeLGD, divyangPercentage, isDOBVerified, isCasteVerified, isIncomeVerified,
            isBPLVerified,
            isDivyangVerified,
            subCaste_code,
            subCaste_name,
            casteDescription,
            divyangCategory,
            deprived, refreshedToken, bpl;
    private String AccountType;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_scholarship_form);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_apply_scholarship_form);
        loadProfileDefault(REQUEST_IMAGE);
        // Clearing older images from cache directory
        // don't call this line if you want to choose multiple images in the same activity
        // call this once the bitmap(s) usage is over
        ImagePickerActivity.clearCache(this);


        binding.chktermconditionApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.chktermconditionApply.isChecked()) {
                    IsTermConditionCheked = true;

                } else {

                    IsTermConditionCheked = false;
                }
                GlobalClass.showtost(ApplyScholarshipFormActivity.this, String.valueOf(IsTermConditionCheked));

            }
        });


        binding.simpleSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override

            public void onRefresh() {

                if (GlobalClass.isNetworkConnected(ApplyScholarshipFormActivity.this)) {
                    WebAPiCall aPiCall = new WebAPiCall();


                } else {

                    Toast.makeText(ApplyScholarshipFormActivity.this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
                }
                binding.simpleSwipeRefreshLayout.setRefreshing(false);
            }
        });


        try {

            studentMemberId = CSPreferences.readString(this, "MemberId");
            studentuserid = CSPreferences.readString(this, "userid");


            Bundle extras = getIntent().getExtras();

            if (extras != null) {

                SchemeID = extras.getString("ItemID");
                String ItemName = extras.getString("ItemName");


                binding.toolbar.tvToolbarTitle.setText(ItemName);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        lateralEntrylist.add(new LateralEntry(0, " Is Lateral-Entry ?"));
        lateralEntrylist.add(new LateralEntry(1, "No"));
        lateralEntrylist.add(new LateralEntry(2, "Yes"));

        entryAdapter = new lateralEntryAdapter(getApplicationContext(), lateralEntrylist);
        binding.spnLateralEntry.setAdapter(entryAdapter);

        binding.spnLateralEntry.setOnItemSelectedListener(this);


        StudentQuotaTypelist.add(new StudentQuota(0, "Select Quota Type"));
        StudentQuotaTypelist.add(new StudentQuota(1, "Management Quota"));
        StudentQuotaTypelist.add(new StudentQuota(2, "State Quota"));

        studentQuotaAdapter = new StudentQuotaAdapter(getApplicationContext(), StudentQuotaTypelist);
        binding.spnStudentQuota.setAdapter(studentQuotaAdapter);

        binding.spnStudentQuota.setOnItemSelectedListener(this);


        BoardingTypelist.add(new BoardingType(0, "Select Boarding Type"));
        BoardingTypelist.add(new BoardingType(1, "DayScholar"));
        BoardingTypelist.add(new BoardingType(2, "Hosteller"));

        boardingTypeAdapter = new BoardingTypeAdapter(getApplicationContext(), BoardingTypelist);
        binding.spnBoardingType.setAdapter(boardingTypeAdapter);

        binding.spnBoardingType.setOnItemSelectedListener(this);


        AreaTypelist.add(new AreaType(0, "Select Area Type"));
        AreaTypelist.add(new AreaType(1, "Rural"));
        AreaTypelist.add(new AreaType(2, "Urban"));

        areaTypeAdapter = new AreaTypeAdapter(getApplicationContext(), AreaTypelist);
        binding.spnAreaType.setAdapter(areaTypeAdapter);

        binding.spnAreaType.setOnItemSelectedListener(this);


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
        String auth_key = CSPreferences.readString(ApplyScholarshipFormActivity.this, "userid");

        if (!auth_key.isEmpty()) {

            if (CSPreferences.readString(ApplyScholarshipFormActivity.this, "UserType").equalsIgnoreCase("Student")) {

                // binding.edtuserAdharNO.setText(CSPreferences.readString(this, "AadhaarNo"));
            }
        }


        if (GlobalClass.isNetworkConnected(ApplyScholarshipFormActivity.this)) {
            WebAPiCall aPiCall = new WebAPiCall();
            aPiCall.GetAllAcademicSessionDataMethod(ApplyScholarshipFormActivity.this, ApplyScholarshipFormActivity.this, ApplyScholarshipFormActivity.this);

        } else {
            Toast.makeText(ApplyScholarshipFormActivity.this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
        }

        binding.btnVerifyOtp.setOnClickListener(this);
        binding.spnYear.setOnItemSelectedListener(this);
        binding.spnstudentCollegeInstitute.setOnItemSelectedListener(this);
        binding.spnstudentdistrict.setOnItemSelectedListener(this);
        binding.spnstudentCourseType.setOnItemSelectedListener(this);
        binding.spnstudentdepartment.setOnItemSelectedListener(this);
        binding.spnstudentAcademicSession.setOnItemSelectedListener(this);
        binding.spnstudentCourse.setOnItemSelectedListener(this);
        binding.BtnApply.setOnClickListener(this);


        binding.myImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dexter.withActivity(ApplyScholarshipFormActivity.this)
                        .withPermissions(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        .withListener(new MultiplePermissionsListener() {
                            @Override
                            public void onPermissionsChecked(MultiplePermissionsReport report) {
                                if (report.areAllPermissionsGranted()) {
                                    showImagePickerOptions(REQUEST_IMAGE);
                                }

                                if (report.isAnyPermissionPermanentlyDenied()) {
                                    showSettingsDialog();
                                }
                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                                token.continuePermissionRequest();
                            }
                        }).check();

            }
        });


        binding.myImageViewStudentSignature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dexter.withActivity(ApplyScholarshipFormActivity.this)
                        .withPermissions(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        .withListener(new MultiplePermissionsListener() {
                            @Override
                            public void onPermissionsChecked(MultiplePermissionsReport report) {
                                if (report.areAllPermissionsGranted()) {
                                    showImagePickerOptions(REQUEST_IMAGE_FOR_SIGNATURE);
                                }

                                if (report.isAnyPermissionPermanentlyDenied()) {
                                    showSettingsDialog();
                                }
                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                                token.continuePermissionRequest();
                            }
                        }).check();

            }
        });


        binding.llParivarPehchaanPatra.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {

                checkpermissions(ApplyScholarshipFormActivity.this);

                showFileChooser(REQUEST_CODE);
            }
        });


        binding.llDomicileCertificate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {

                checkpermissions(ApplyScholarshipFormActivity.this);

                showFileChooser(REQUEST_CODE_FOR_dOMICILE);
            }
        });


        binding.llAadhaarCopy.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {

                checkpermissions(ApplyScholarshipFormActivity.this);

                showFileChooser(REQUEST_CODE_FOR_AADHAR);
            }
        });


        binding.llIncomeCertificate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {

                checkpermissions(ApplyScholarshipFormActivity.this);

                showFileChooser(REQUEST_CODE_FOR_INCOMECERTIFICATE);
            }
        });

        binding.llCasteCertificate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {

                checkpermissions(ApplyScholarshipFormActivity.this);

                showFileChooser(REQUEST_CODE_FOR_CASTCERTIFICATE);
            }
        });


        binding.llHostelCertificate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {

                checkpermissions(ApplyScholarshipFormActivity.this);

                showFileChooser(REQUEST_CODE_FOR_HOSTELCERTIFICATE);
            }
        });

        binding.llMatriculationDMC.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {

                checkpermissions(ApplyScholarshipFormActivity.this);

                showFileChooser(REQUEST_CODE_FOR_10thDMCCERTIFICATE);
            }
        });

        binding.ll12thDMC.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {

                checkpermissions(ApplyScholarshipFormActivity.this);

                showFileChooser(REQUEST_CODE_FOR_12thDMCCERTIFICATE);
            }
        });


        binding.llLastExamPassedDMC.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {

                checkpermissions(ApplyScholarshipFormActivity.this);

                showFileChooser(REQUEST_CODE_FOR_LastExamPassedDMCDMCCERTIFICATE);
            }
        });

        binding.llFeeReceiptCopy.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {

                checkpermissions(ApplyScholarshipFormActivity.this);

                showFileChooser(REQUEST_CODE_FOR_FEERECEIPTCOPTY);
            }
        });


        binding.llFatheDeathCertificate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {

                checkpermissions(ApplyScholarshipFormActivity.this);

                showFileChooser(REQUEST_CODE_FOR_FATHERDEATHCERTIFICATE);
            }
        });


        binding.llBPLCertificate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {

                checkpermissions(ApplyScholarshipFormActivity.this);

                showFileChooser(REQUEST_CODE_FOR_BPLCERTIFICATE);
            }
        });

        binding.llAadhaarSeededdocuments.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {

                checkpermissions(ApplyScholarshipFormActivity.this);

                showFileChooser(REQUEST_CODE_FOR_AadhaarSeededdocuments);
            }
        });
        binding.llAttendanceCertificate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {

                checkpermissions(ApplyScholarshipFormActivity.this);

                showFileChooser(REQUEST_CODE_FOR_AttendanceCertificate);
            }
        });

        binding.llFeeStructureCopy.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {

                checkpermissions(ApplyScholarshipFormActivity.this);

                showFileChooser(REQUEST_CODE_FOR_FeeStructureCopy);
            }
        });


        binding.llUniversityCertificate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {

                checkpermissions(ApplyScholarshipFormActivity.this);

                showFileChooser(REQUEST_CODE_FOR_UniversityCertificate);
            }
        });
        binding.llNSPCertificate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {

                checkpermissions(ApplyScholarshipFormActivity.this);

                showFileChooser(REQUEST_CODE_FOR_NSPCertificate);
            }
        });
        binding.llCollegeInstitutionAffiliationCertificate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {

                checkpermissions(ApplyScholarshipFormActivity.this);

                showFileChooser(REQUEST_CODE_FOR_CollegeInstitutionAffiliationCertificate);
            }
        });


        binding.txtAadhaarlinkwebsite.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
                Intent othersApps = new Intent(ApplyScholarshipFormActivity.this, OpenBooksActivity.class);
                othersApps.putExtra("title", "Check Aadhaar-Bank Status");
                othersApps.putExtra("bookurl", GlobalClass.aadhaarLink);
                startActivity(othersApps);

            }
        });

        binding.btnSumit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (spnAcademicSessionCurrentPosition != 0) {
                    if (GlobalClass.isNetworkConnected(ApplyScholarshipFormActivity.this)) {

                        WebAPiCall aPiCall = new WebAPiCall();
                        aPiCall.CheckApplicationExistMethod(ApplyScholarshipFormActivity.this, ApplyScholarshipFormActivity.this, ApplyScholarshipFormActivity.this, studentuserid,
                                userAcademicSession, SchemeID);

                    } else {

                        Toast.makeText(ApplyScholarshipFormActivity.this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
                    }
                } else {

                    GlobalClass.dailogError(ApplyScholarshipFormActivity.this, "Missing Academic session", "Please Select your Academic session from List. ");

                }

            }
        });


        binding.btnDataFromPPP.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                //   if (spnAcademicSessionCurrentPosition != 0) {


                OTPRequestforMEMIDRequest otpRequestforMEMIDRequest = new OTPRequestforMEMIDRequest();

                // test keys
                // otpRequestforMEMIDRequest.setDeptKey("o2etc739ut");
                // otpRequestforMEMIDRequest.setDeptCode("NIC");
                // otpRequestforMEMIDRequest.setServiceCode("TestCred");

                otpRequestforMEMIDRequest.setDeptKey(GlobalClass.DeptKey);
                otpRequestforMEMIDRequest.setDeptCode(GlobalClass.DeptCode);
                otpRequestforMEMIDRequest.setServiceCode(GlobalClass.ServiceCode);


                otpRequestforMEMIDRequest.setMemberID(studentMemberId);

                if (GlobalClass.isNetworkConnected(ApplyScholarshipFormActivity.this)) {

                    WebAPiCall webapiCall = new WebAPiCall();
                    webapiCall.GetOTPRequestforMEMIDDataMethod(ApplyScholarshipFormActivity.this, ApplyScholarshipFormActivity.this, ApplyScholarshipFormActivity.this, otpRequestforMEMIDRequest);

                } else {

                    Toast.makeText(ApplyScholarshipFormActivity.this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
                }

//                }else {
//
//                    GlobalClass.dailogError(ApplyScholarshipFormActivity.this, "Missing Academic session", "Please Select your Academic session from List. ");
//
//                }

            }
        });


        binding.edtAdmissionDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get Current Date

                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(ApplyScholarshipFormActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                                //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());


                                Calendar calendar = Calendar.getInstance();
                                calendar.set(year, monthOfYear, dayOfMonth);

                                String selectedDate = dateFormat.format(calendar.getTime());


                                binding.edtAdmissionDate.setText(selectedDate);


                            }
                        }, mYear, mMonth, mDay);

                datePickerDialog.show();

            }
        });


        btnRadiogroup = (RadioGroup) findViewById(R.id.btnRadiogroup);
        btnRadiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {

                RadioButton checkedRadioButton = (RadioButton) btnRadiogroup.findViewById(checkedId);
                boolean isChecked = checkedRadioButton.isChecked();


                if (isChecked) {
                    switch (checkedId) {

                        case R.id.rdyes:

                            Is_Studying_Outside_the_Haryana_State = true;
                            //  Toast.makeText(ApplyScholarshipFormActivity.this, "YES--Studying_Outside_the_Haryana_State", Toast.LENGTH_SHORT).show();
                            binding.lloutSideHRy.setVisibility(View.VISIBLE);


                            DistrictarrayList.clear();


                            AllDistrictsResponse.Datum datum2 = new AllDistrictsResponse.Datum();
                            datum2.setDistrict("Please select");
                            datum2.setDistrictId(24);
                            DistrictarrayList.add(0, datum2);


                            AllDistrictsResponse.Datum datum = new AllDistrictsResponse.Datum();
                            datum.setDistrict("Outside Haryana");
                            datum.setDistrictId(23);
                            DistrictarrayList.add(1, datum);


                            UserDistrictId = DistrictarrayList.get(0).getDistrictId();
                            Adapter = new SpinnerAllDistrictAdapter(getApplicationContext(), DistrictarrayList);
                            binding.spnstudentdistrict.setAdapter(Adapter);

                            break;

                        case R.id.rdno:

                            Is_Studying_Outside_the_Haryana_State = false;
                            // Toast.makeText(ApplyScholarshipFormActivity.this, checkedRadioButton.getText(), Toast.LENGTH_SHORT).show();
                            binding.lloutSideHRy.setVisibility(View.GONE);
                            DistrictarrayList.clear();

                            if (GlobalClass.isNetworkConnected(ApplyScholarshipFormActivity.this)) {
                                WebAPiCall aPiCall = new WebAPiCall();
                                aPiCall.GetDistrictListDataMethod(ApplyScholarshipFormActivity.this, ApplyScholarshipFormActivity.this, binding.simpleSwipeRefreshLayout, ApplyScholarshipFormActivity.this);

                            } else {
                                Toast.makeText(ApplyScholarshipFormActivity.this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
                            }


                            break;

                    }

                }
                Toast.makeText(ApplyScholarshipFormActivity.this, checkedRadioButton.getText(), Toast.LENGTH_SHORT).show();

            }
        });


    }

    private void loadProfile(String url, int requestcode) {

        if (requestcode == REQUEST_IMAGE) {

            Log.d(TAG, "Image cache path: " + url);

            Glide.with(this).load(url)
                    .into(binding.myImageView);
            binding.myImageView.setColorFilter(ContextCompat.getColor(this, android.R.color.transparent));

        } else if (requestcode == REQUEST_IMAGE_FOR_SIGNATURE) {


            Log.d(TAG, "Image cache path Signature: " + url);

            Glide.with(this).load(url)
                    .into(binding.myImageViewStudentSignature);
            binding.myImageViewStudentSignature.setColorFilter(ContextCompat.getColor(this, android.R.color.transparent));

        }

    }

    private void loadProfileDefault(int requestcode) {
        if (requestcode == REQUEST_IMAGE) {

            Glide.with(this).load(R.mipmap.ic_launcher_round)
                    .into(binding.myImageView);
            binding.myImageView.setColorFilter(ContextCompat.getColor(this, R.color.bglight));

        } else if (requestcode == REQUEST_IMAGE_FOR_SIGNATURE) {

            Glide.with(this).load(R.mipmap.ic_launcher_round)
                    .into(binding.myImageViewStudentSignature);
            binding.myImageViewStudentSignature.setColorFilter(ContextCompat.getColor(this, R.color.bglight));


        }
    }

    public void checkpermissions(Activity context) {
        if (Build.VERSION.SDK_INT >= 23) {
            new TedPermission(context)
                    .setPermissionListener(permissionListener)
                    //.setDeniedMessage("If you reject permission,you can not use this service\n\nPlease turn on permissions at [Setting] > [Permission]")
                    .setPermissions(
                            INTERNET,
                            READ_EXTERNAL_STORAGE,
                            WRITE_EXTERNAL_STORAGE

                    )
                    .check();
        }


    }

    PermissionListener permissionListener = new PermissionListener() {
        @Override
        public void onPermissionGranted() {



        }

        @Override
        public void onPermissionDenied(ArrayList<String> deniedPermissions) {
            checkpermissions(ApplyScholarshipFormActivity.this);
        }

    };


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void showFileChooser(int REQUEST_CODE) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);

        // Update with mime types
        intent.setType("*/*");

        String[] mimeTypes = {"application/pdf"};

        // Update with additional mime types here using a String[].
        intent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes);

        // Only pick openable and local files. Theoretically we could pull files from google drive
        // or other applications that have networked files, but that's unnecessary for this example.
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.putExtra(Intent.EXTRA_LOCAL_ONLY, true);

        // REQUEST_CODE = <some-integer>
        startActivityForResult(intent, REQUEST_CODE);
    }


    private void showImagePickerOptions(int requestImage) {
        ImagePickerActivity.showImagePickerOptions(this, new ImagePickerActivity.PickerOptionListener() {
            @Override
            public void onTakeCameraSelected() {
                launchCameraIntent(requestImage);
            }

            @Override
            public void onChooseGallerySelected() {
                launchGalleryIntent(requestImage);
            }
        });
    }

    private void launchCameraIntent(int requestvalue) {
        Intent intent = new Intent(ApplyScholarshipFormActivity.this, ImagePickerActivity.class);
        intent.putExtra(ImagePickerActivity.INTENT_IMAGE_PICKER_OPTION, ImagePickerActivity.REQUEST_IMAGE_CAPTURE);

        // setting aspect ratio
        intent.putExtra(ImagePickerActivity.INTENT_LOCK_ASPECT_RATIO, true);
        intent.putExtra(ImagePickerActivity.INTENT_ASPECT_RATIO_X, 1); // 16x9, 1x1, 3:4, 3:2
        intent.putExtra(ImagePickerActivity.INTENT_ASPECT_RATIO_Y, 1);

        // setting maximum bitmap width and height
        intent.putExtra(ImagePickerActivity.INTENT_SET_BITMAP_MAX_WIDTH_HEIGHT, true);
        intent.putExtra(ImagePickerActivity.INTENT_BITMAP_MAX_WIDTH, 1000);
        intent.putExtra(ImagePickerActivity.INTENT_BITMAP_MAX_HEIGHT, 1000);

        startActivityForResult(intent, requestvalue);
    }

    private void launchGalleryIntent(int requestvalue) {
        Intent intent = new Intent(ApplyScholarshipFormActivity.this, ImagePickerActivity.class);
        intent.putExtra(ImagePickerActivity.INTENT_IMAGE_PICKER_OPTION, ImagePickerActivity.REQUEST_GALLERY_IMAGE);

        // setting aspect ratio
        intent.putExtra(ImagePickerActivity.INTENT_LOCK_ASPECT_RATIO, true);
        intent.putExtra(ImagePickerActivity.INTENT_ASPECT_RATIO_X, 1); // 16x9, 1x1, 3:4, 3:2
        intent.putExtra(ImagePickerActivity.INTENT_ASPECT_RATIO_Y, 1);
        startActivityForResult(intent, requestvalue);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE) {
            if (resultCode == Activity.RESULT_OK) {

                Uri uri = data.getParcelableExtra("path");
                String path = "";


                try {
                    // You can update this bitmap to your server
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
                    // loading profile image from local cache
                    loadProfile(uri.toString(), REQUEST_IMAGE);
                    imagefile = new File(uri.getPath());

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        } else if (requestCode == REQUEST_IMAGE_FOR_SIGNATURE) {
            if (resultCode == Activity.RESULT_OK) {

                Uri uri = data.getParcelableExtra("path");
                String path = "";

                try {
                    // You can update this bitmap to your server
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
                    // loading profile image from local cache
                    loadProfile(uri.toString(), REQUEST_IMAGE_FOR_SIGNATURE);
                    signaturefile = new File(uri.getPath());

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        } else if (requestCode == 123) {

            if (resultCode == RESULT_OK) {
                Uri uri = data.getData();
                String path = "";
                int currentVersion = android.os.Build.VERSION.SDK_INT;
                if (currentVersion >= android.os.Build.VERSION_CODES.N) {
                    // Do something for lollipop and above versions
                    path = FileUtils.getFilePathForN(uri, this);
                } else {
                    // do something for phones running an SDK before lollipop
                    path = FileUtils.getPath(this, uri);
                }
                // "file:///mnt/sdcard/FileName.mp3"
                Log.d("PATHS : ", path);
                File file = null;
                try {
                    file = new File(path);
                    scorecardfile = file;
                    // binding.txtupload.setText(imagefile.toString());

                    binding.txtParivarPehchaanPatra.setText(scorecardfile.getName());
                    binding.txtParivarPehchaanPatra.setTextColor(getResources().getColor(R.color.drkgreeen));

                    binding.attachedpdfParivarPehchaanPatra.setVisibility(View.VISIBLE);
                    binding.llParivarPehchaanPatra.setBackgroundResource(R.drawable.spinner_bordergreen);

                    Log.d("PDF", file.getAbsolutePath());
                    Log.d("PDF", "" + file.getTotalSpace());

                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {

            }


        } else if (requestCode == 124) {

            if (resultCode == RESULT_OK) {
                Uri uri = data.getData();
                String path = "";
                int currentVersion = android.os.Build.VERSION.SDK_INT;
                if (currentVersion >= android.os.Build.VERSION_CODES.N) {
                    // Do something for lollipop and above versions
                    path = FileUtils.getFilePathForN(uri, this);
                } else {
                    // do something for phones running an SDK before lollipop
                    path = FileUtils.getPath(this, uri);
                }
                // "file:///mnt/sdcard/FileName.mp3"
                Log.d("PATHS : ", path);
                File file = null;
                try {
                    file = new File(path);
                    dOmicilefile = file;
                    // binding.txtupload.setText(imagefile.toString());

                    binding.txtDomicileCertificate.setText(dOmicilefile.getName());
                    binding.txtDomicileCertificate.setTextColor(getResources().getColor(R.color.drkgreeen));

                    binding.attachedpdfDomicileCertificate.setVisibility(View.VISIBLE);
                    binding.llDomicileCertificate.setBackgroundResource(R.drawable.spinner_bordergreen);

                    Log.d("PDF", file.getAbsolutePath());
                    Log.d("PDF", "" + file.getTotalSpace());

                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {

            }


        } else if (requestCode == 125) {

            if (resultCode == RESULT_OK) {
                Uri uri = data.getData();
                String path = "";
                int currentVersion = android.os.Build.VERSION.SDK_INT;
                if (currentVersion >= android.os.Build.VERSION_CODES.N) {
                    // Do something for lollipop and above versions
                    path = FileUtils.getFilePathForN(uri, this);
                } else {
                    // do something for phones running an SDK before lollipop
                    path = FileUtils.getPath(this, uri);
                }
                // "file:///mnt/sdcard/FileName.mp3"
                Log.d("PATHS : ", path);
                File file = null;
                try {
                    file = new File(path);
                    aADHARfile = file;
                    // binding.txtupload.setText(imagefile.toString());

                    binding.txtAadhaarCopy.setText(aADHARfile.getName());
                    binding.txtAadhaarCopy.setTextColor(getResources().getColor(R.color.drkgreeen));

                    binding.attachedpdfAadhaarCopy.setVisibility(View.VISIBLE);
                    binding.llAadhaarCopy.setBackgroundResource(R.drawable.spinner_bordergreen);

                    Log.d("PDF", file.getAbsolutePath());
                    Log.d("PDF", "" + file.getTotalSpace());

                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {

            }


        } else if (requestCode == 126) {

            if (resultCode == RESULT_OK) {
                Uri uri = data.getData();
                String path = "";
                int currentVersion = android.os.Build.VERSION.SDK_INT;
                if (currentVersion >= android.os.Build.VERSION_CODES.N) {
                    // Do something for lollipop and above versions
                    path = FileUtils.getFilePathForN(uri, this);
                } else {
                    // do something for phones running an SDK before lollipop
                    path = FileUtils.getPath(this, uri);
                }
                // "file:///mnt/sdcard/FileName.mp3"
                Log.d("PATHS : ", path);
                File file = null;
                try {
                    file = new File(path);
                    INCOMECERTIFICATEFILE = file;
                    // binding.txtupload.setText(imagefile.toString());

                    binding.txtIncomeCertificate.setText(INCOMECERTIFICATEFILE.getName());
                    binding.txtIncomeCertificate.setTextColor(getResources().getColor(R.color.drkgreeen));

                    binding.attachedpdfIncomeCertificate.setVisibility(View.VISIBLE);
                    binding.llIncomeCertificate.setBackgroundResource(R.drawable.spinner_bordergreen);

                    Log.d("PDF", file.getAbsolutePath());
                    Log.d("PDF", "" + file.getTotalSpace());

                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {

            }


        } else if (requestCode == 127) {

            if (resultCode == RESULT_OK) {
                Uri uri = data.getData();
                String path = "";
                int currentVersion = android.os.Build.VERSION.SDK_INT;
                if (currentVersion >= android.os.Build.VERSION_CODES.N) {
                    // Do something for lollipop and above versions
                    path = FileUtils.getFilePathForN(uri, this);
                } else {
                    // do something for phones running an SDK before lollipop
                    path = FileUtils.getPath(this, uri);
                }
                // "file:///mnt/sdcard/FileName.mp3"
                Log.d("PATHS : ", path);
                File file = null;
                try {
                    file = new File(path);
                    casteCertificate = file;
                    // binding.txtupload.setText(imagefile.toString());

                    binding.txtCasteCertificate.setText(casteCertificate.getName());
                    binding.txtCasteCertificate.setTextColor(getResources().getColor(R.color.drkgreeen));

                    binding.attachedpdfCasteCertificate.setVisibility(View.VISIBLE);
                    binding.llCasteCertificate.setBackgroundResource(R.drawable.spinner_bordergreen);

                    Log.d("PDF", file.getAbsolutePath());
                    Log.d("PDF", "" + file.getTotalSpace());

                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {

            }


        } else if (requestCode == 128) {

            if (resultCode == RESULT_OK) {
                Uri uri = data.getData();
                String path = "";
                int currentVersion = android.os.Build.VERSION.SDK_INT;
                if (currentVersion >= android.os.Build.VERSION_CODES.N) {
                    // Do something for lollipop and above versions
                    path = FileUtils.getFilePathForN(uri, this);
                } else {
                    // do something for phones running an SDK before lollipop
                    path = FileUtils.getPath(this, uri);
                }
                // "file:///mnt/sdcard/FileName.mp3"
                Log.d("PATHS : ", path);
                File file = null;
                try {
                    file = new File(path);
                    hostelCertificate = file;
                    // binding.txtupload.setText(imagefile.toString());

                    binding.txtHostelCertificate.setText(hostelCertificate.getName());
                    binding.txtHostelCertificate.setTextColor(getResources().getColor(R.color.drkgreeen));

                    binding.attachedpdfHostelCertificate.setVisibility(View.VISIBLE);
                    binding.llHostelCertificate.setBackgroundResource(R.drawable.spinner_bordergreen);

                    Log.d("PDF", file.getAbsolutePath());
                    Log.d("PDF", "" + file.getTotalSpace());

                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {

            }


        } else if (requestCode == 129) {

            if (resultCode == RESULT_OK) {
                Uri uri = data.getData();
                String path = "";
                int currentVersion = android.os.Build.VERSION.SDK_INT;
                if (currentVersion >= android.os.Build.VERSION_CODES.N) {
                    // Do something for lollipop and above versions
                    path = FileUtils.getFilePathForN(uri, this);
                } else {
                    // do something for phones running an SDK before lollipop
                    path = FileUtils.getPath(this, uri);
                }
                // "file:///mnt/sdcard/FileName.mp3"
                Log.d("PATHS : ", path);
                File file = null;
                try {
                    file = new File(path);
                    tenth_dmcCertificate = file;
                    // binding.txtupload.setText(imagefile.toString());

                    binding.txtMatriculationDMC.setText(tenth_dmcCertificate.getName());
                    binding.txtMatriculationDMC.setTextColor(getResources().getColor(R.color.drkgreeen));

                    binding.attachedpdfMatriculationDMC.setVisibility(View.VISIBLE);
                    binding.llMatriculationDMC.setBackgroundResource(R.drawable.spinner_bordergreen);

                    Log.d("PDF", file.getAbsolutePath());
                    Log.d("PDF", "" + file.getTotalSpace());

                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {

            }

        } else if (requestCode == 130) {

            if (resultCode == RESULT_OK) {
                Uri uri = data.getData();
                String path = "";
                int currentVersion = android.os.Build.VERSION.SDK_INT;
                if (currentVersion >= android.os.Build.VERSION_CODES.N) {
                    // Do something for lollipop and above versions
                    path = FileUtils.getFilePathForN(uri, this);
                } else {
                    // do something for phones running an SDK before lollipop
                    path = FileUtils.getPath(this, uri);
                }
                // "file:///mnt/sdcard/FileName.mp3"
                Log.d("PATHS : ", path);
                File file = null;
                try {
                    file = new File(path);
                    inter_dmcCertificate = file;
                    // binding.txtupload.setText(imagefile.toString());

                    binding.txt12thDMC.setText(inter_dmcCertificate.getName());
                    binding.txt12thDMC.setTextColor(getResources().getColor(R.color.drkgreeen));

                    binding.attachedpdf12thDMC.setVisibility(View.VISIBLE);
                    binding.ll12thDMC.setBackgroundResource(R.drawable.spinner_bordergreen);

                    Log.d("PDF", file.getAbsolutePath());
                    Log.d("PDF", "" + file.getTotalSpace());

                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {

            }
        } else if (requestCode == 131) {

            if (resultCode == RESULT_OK) {
                Uri uri = data.getData();
                String path = "";
                int currentVersion = android.os.Build.VERSION.SDK_INT;
                if (currentVersion >= android.os.Build.VERSION_CODES.N) {
                    // Do something for lollipop and above versions
                    path = FileUtils.getFilePathForN(uri, this);
                } else {
                    // do something for phones running an SDK before lollipop
                    path = FileUtils.getPath(this, uri);
                }
                // "file:///mnt/sdcard/FileName.mp3"
                Log.d("PATHS : ", path);
                File file = null;
                try {
                    file = new File(path);
                    LastExamPassedDMCCertificate = file;
                    // binding.txtupload.setText(imagefile.toString());

                    binding.txtLastExamPassedDMC.setText(LastExamPassedDMCCertificate.getName());
                    binding.txtLastExamPassedDMC.setTextColor(getResources().getColor(R.color.drkgreeen));

                    binding.attachedpdfLastExamPassedDMC.setVisibility(View.VISIBLE);
                    binding.llLastExamPassedDMC.setBackgroundResource(R.drawable.spinner_bordergreen);

                    Log.d("PDF", file.getAbsolutePath());
                    Log.d("PDF", "" + file.getTotalSpace());

                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {

            }
        } else if (requestCode == 132) {

            if (resultCode == RESULT_OK) {
                Uri uri = data.getData();
                String path = "";
                int currentVersion = android.os.Build.VERSION.SDK_INT;
                if (currentVersion >= android.os.Build.VERSION_CODES.N) {
                    // Do something for lollipop and above versions
                    path = FileUtils.getFilePathForN(uri, this);
                } else {
                    // do something for phones running an SDK before lollipop
                    path = FileUtils.getPath(this, uri);
                }
                // "file:///mnt/sdcard/FileName.mp3"
                Log.d("PATHS : ", path);
                File file = null;
                try {
                    file = new File(path);
                    FeeReceiptCopy = file;
                    // binding.txtupload.setText(imagefile.toString());

                    binding.txtFeeReceiptCopy.setText(FeeReceiptCopy.getName());
                    binding.txtFeeReceiptCopy.setTextColor(getResources().getColor(R.color.drkgreeen));

                    binding.attachedpdfFeeReceiptCopy.setVisibility(View.VISIBLE);
                    binding.llFeeReceiptCopy.setBackgroundResource(R.drawable.spinner_bordergreen);

                    Log.d("PDF", file.getAbsolutePath());
                    Log.d("PDF", "" + file.getTotalSpace());

                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {

            }
        } else if (requestCode == 133) {

            if (resultCode == RESULT_OK) {
                Uri uri = data.getData();
                String path = "";
                int currentVersion = android.os.Build.VERSION.SDK_INT;
                if (currentVersion >= android.os.Build.VERSION_CODES.N) {
                    // Do something for lollipop and above versions
                    path = FileUtils.getFilePathForN(uri, this);
                } else {
                    // do something for phones running an SDK before lollipop
                    path = FileUtils.getPath(this, uri);
                }
                // "file:///mnt/sdcard/FileName.mp3"
                Log.d("PATHS : ", path);
                File file = null;
                try {
                    file = new File(path);
                    fatherdeathCertificate = file;
                    // binding.txtupload.setText(imagefile.toString());

                    binding.txtFatheDeathCertificate.setText(fatherdeathCertificate.getName());
                    binding.txtFatheDeathCertificate.setTextColor(getResources().getColor(R.color.drkgreeen));

                    binding.attachedpdfFatheDeathCertificate.setVisibility(View.VISIBLE);
                    binding.llFatheDeathCertificate.setBackgroundResource(R.drawable.spinner_bordergreen);

                    Log.d("PDF", file.getAbsolutePath());
                    Log.d("PDF", "" + file.getTotalSpace());

                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {

            }
        } else if (requestCode == 134) {

            if (resultCode == RESULT_OK) {
                Uri uri = data.getData();
                String path = "";
                int currentVersion = android.os.Build.VERSION.SDK_INT;
                if (currentVersion >= android.os.Build.VERSION_CODES.N) {
                    // Do something for lollipop and above versions
                    path = FileUtils.getFilePathForN(uri, this);
                } else {
                    // do something for phones running an SDK before lollipop
                    path = FileUtils.getPath(this, uri);
                }
                // "file:///mnt/sdcard/FileName.mp3"
                Log.d("PATHS : ", path);
                File file = null;
                try {
                    file = new File(path);
                    BPLCertificate = file;
                    // binding.txtupload.setText(imagefile.toString());

                    binding.txtBPLCertificate.setText(BPLCertificate.getName());
                    binding.txtBPLCertificate.setTextColor(getResources().getColor(R.color.drkgreeen));

                    binding.attachedpdfBPLCertificate.setVisibility(View.VISIBLE);
                    binding.llBPLCertificate.setBackgroundResource(R.drawable.spinner_bordergreen);

                    Log.d("PDF", file.getAbsolutePath());
                    Log.d("PDF", "" + file.getTotalSpace());

                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {

            }

        } else if (requestCode == 135) {

            if (resultCode == RESULT_OK) {
                Uri uri = data.getData();
                String path = "";
                int currentVersion = android.os.Build.VERSION.SDK_INT;
                if (currentVersion >= android.os.Build.VERSION_CODES.N) {
                    // Do something for lollipop and above versions
                    path = FileUtils.getFilePathForN(uri, this);
                } else {
                    // do something for phones running an SDK before lollipop
                    path = FileUtils.getPath(this, uri);
                }
                // "file:///mnt/sdcard/FileName.mp3"
                Log.d("PATHS : ", path);
                File file = null;
                try {
                    file = new File(path);
                    AadhaarSeededdocuments = file;
                    // binding.txtupload.setText(imagefile.toString());

                    binding.txtAadhaarSeededdocuments.setText(AadhaarSeededdocuments.getName());
                    binding.txtAadhaarSeededdocuments.setTextColor(getResources().getColor(R.color.drkgreeen));

                    binding.attachedpdfAadhaarSeededdocuments.setVisibility(View.VISIBLE);
                    binding.llAadhaarSeededdocuments.setBackgroundResource(R.drawable.spinner_bordergreen);

                    Log.d("PDF", file.getAbsolutePath());
                    Log.d("PDF", "" + file.getTotalSpace());

                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {

            }
        } else if (requestCode == 136) {

            if (resultCode == RESULT_OK) {
                Uri uri = data.getData();
                String path = "";
                int currentVersion = android.os.Build.VERSION.SDK_INT;
                if (currentVersion >= android.os.Build.VERSION_CODES.N) {
                    // Do something for lollipop and above versions
                    path = FileUtils.getFilePathForN(uri, this);
                } else {
                    // do something for phones running an SDK before lollipop
                    path = FileUtils.getPath(this, uri);
                }
                // "file:///mnt/sdcard/FileName.mp3"
                Log.d("PATHS : ", path);
                File file = null;
                try {
                    file = new File(path);
                    AttendanceCertificate = file;
                    // binding.txtupload.setText(imagefile.toString());

                    binding.txtAttendanceCertificate.setText(AttendanceCertificate.getName());
                    binding.txtAttendanceCertificate.setTextColor(getResources().getColor(R.color.drkgreeen));

                    binding.attachedpdfAttendanceCertificate.setVisibility(View.VISIBLE);
                    binding.llAttendanceCertificate.setBackgroundResource(R.drawable.spinner_bordergreen);

                    Log.d("PDF", file.getAbsolutePath());
                    Log.d("PDF", "" + file.getTotalSpace());

                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {

            }
        } else if (requestCode == 137) {

            if (resultCode == RESULT_OK) {
                Uri uri = data.getData();
                String path = "";
                int currentVersion = android.os.Build.VERSION.SDK_INT;
                if (currentVersion >= android.os.Build.VERSION_CODES.N) {
                    // Do something for lollipop and above versions
                    path = FileUtils.getFilePathForN(uri, this);
                } else {
                    // do something for phones running an SDK before lollipop
                    path = FileUtils.getPath(this, uri);
                }
                // "file:///mnt/sdcard/FileName.mp3"
                Log.d("PATHS : ", path);
                File file = null;
                try {
                    file = new File(path);
                    feeStructureCopy = file;
                    // binding.txtupload.setText(imagefile.toString());

                    binding.txtFeeStructureCopy.setText(feeStructureCopy.getName());
                    binding.txtFeeStructureCopy.setTextColor(getResources().getColor(R.color.drkgreeen));

                    binding.attachedpdfFeeStructureCopy.setVisibility(View.VISIBLE);
                    binding.llFeeStructureCopy.setBackgroundResource(R.drawable.spinner_bordergreen);

                    Log.d("PDF", file.getAbsolutePath());
                    Log.d("PDF", "" + file.getTotalSpace());

                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {

            }
        } else if (requestCode == 138) {

            if (resultCode == RESULT_OK) {
                Uri uri = data.getData();
                String path = "";
                int currentVersion = android.os.Build.VERSION.SDK_INT;
                if (currentVersion >= android.os.Build.VERSION_CODES.N) {
                    // Do something for lollipop and above versions
                    path = FileUtils.getFilePathForN(uri, this);
                } else {
                    // do something for phones running an SDK before lollipop
                    path = FileUtils.getPath(this, uri);
                }
                // "file:///mnt/sdcard/FileName.mp3"
                Log.d("PATHS : ", path);
                File file = null;
                try {
                    file = new File(path);
                    universityCertificate = file;
                    // binding.txtupload.setText(imagefile.toString());

                    binding.txtUniversityCertificate.setText(universityCertificate.getName());
                    binding.txtUniversityCertificate.setTextColor(getResources().getColor(R.color.drkgreeen));

                    binding.attachedpdfUniversityCertificate.setVisibility(View.VISIBLE);
                    binding.llUniversityCertificate.setBackgroundResource(R.drawable.spinner_bordergreen);

                    Log.d("PDF", file.getAbsolutePath());
                    Log.d("PDF", "" + file.getTotalSpace());

                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {

            }
        } else if (requestCode == 139) {

            if (resultCode == RESULT_OK) {
                Uri uri = data.getData();
                String path = "";
                int currentVersion = android.os.Build.VERSION.SDK_INT;
                if (currentVersion >= android.os.Build.VERSION_CODES.N) {
                    // Do something for lollipop and above versions
                    path = FileUtils.getFilePathForN(uri, this);
                } else {
                    // do something for phones running an SDK before lollipop
                    path = FileUtils.getPath(this, uri);
                }
                // "file:///mnt/sdcard/FileName.mp3"
                Log.d("PATHS : ", path);
                File file = null;
                try {
                    file = new File(path);
                    nSPCertificate = file;
                    // binding.txtupload.setText(imagefile.toString());

                    binding.txtNSPCertificate.setText(nSPCertificate.getName());
                    binding.txtNSPCertificate.setTextColor(getResources().getColor(R.color.drkgreeen));

                    binding.attachedpdfNSPCertificate.setVisibility(View.VISIBLE);
                    binding.llNSPCertificate.setBackgroundResource(R.drawable.spinner_bordergreen);

                    Log.d("PDF", file.getAbsolutePath());
                    Log.d("PDF", "" + file.getTotalSpace());

                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {

            }
        } else if (requestCode == 140) {

            if (resultCode == RESULT_OK) {
                Uri uri = data.getData();
                String path = "";
                int currentVersion = android.os.Build.VERSION.SDK_INT;
                if (currentVersion >= android.os.Build.VERSION_CODES.N) {
                    // Do something for lollipop and above versions
                    path = FileUtils.getFilePathForN(uri, this);
                } else {
                    // do something for phones running an SDK before lollipop
                    path = FileUtils.getPath(this, uri);
                }
                // "file:///mnt/sdcard/FileName.mp3"
                Log.d("PATHS : ", path);
                File file = null;
                try {
                    file = new File(path);
                    collegeInstitutionAffiliationCertificate = file;
                    // binding.txtupload.setText(imagefile.toString());

                    binding.txtCollegeInstitutionAffiliationCertificate.setText(collegeInstitutionAffiliationCertificate.getName());
                    binding.txtCollegeInstitutionAffiliationCertificate.setTextColor(getResources().getColor(R.color.drkgreeen));

                    binding.attachedpdfCollegeInstitutionAffiliationCertificate.setVisibility(View.VISIBLE);
                    binding.llCollegeInstitutionAffiliationCertificate.setBackgroundResource(R.drawable.spinner_bordergreen);

                    Log.d("PDF", file.getAbsolutePath());
                    Log.d("PDF", "" + file.getTotalSpace());

                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {

            }
        }


    }


    private void showSettingsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ApplyScholarshipFormActivity.this);
        builder.setTitle(getString(R.string.dialog_permission_title));
        builder.setMessage(getString(R.string.dialog_permission_message));
        builder.setPositiveButton(getString(R.string.go_to_settings), (dialog, which) -> {
            dialog.cancel();
            openSettings();
        });
        builder.setNegativeButton(getString(android.R.string.cancel), (dialog, which) -> dialog.cancel());
        builder.show();

    }

    // navigating user to app settings
    private void openSettings() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", getPackageName(), null);
        intent.setData(uri);
        startActivityForResult(intent, 101);
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


        binding.BtnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (CheckRegistrationRequestAll_Data(v)) {

                    if (!(AccountType == null)) {

                    } else {

                    }


                }
            }
        });


    }


    public boolean CheckRegistrationRequestAll_Data(View view) {

        if (spnAcademicSessionCurrentPosition == 0) {
            GlobalClass.dailogError(ApplyScholarshipFormActivity.this, "Missing Academic session", "Please Select your Academic session from List. ");
            return false;
        } else if (TextUtils.isEmpty(binding.edtOtp.getText().toString().trim())) {
            GlobalClass.dailogError(ApplyScholarshipFormActivity.this, "Missing OTP", "Please Enter Valid OTP. ");
            return false;
        } else if (Is_Studying_Outside_the_Haryana_State == null) {
            GlobalClass.dailogError(ApplyScholarshipFormActivity.this, "Studying Outside Or Not", "Studying Outside the Haryana State being the domicile of Haryana");
            return false;
        } else if (TextUtils.isEmpty(binding.edtFamilyId.getText().toString().trim())) {
            GlobalClass.dailogError(ApplyScholarshipFormActivity.this, "Missing Family Id ", " Error while fetching FamilyId  data from  PPP.");
            return false;
        } else if (TextUtils.isEmpty(binding.edtMemberId.getText().toString().trim())) {
            GlobalClass.dailogError(ApplyScholarshipFormActivity.this, "Missing Member Id ", " Error while fetching MemberId  data from  PPP.");
            return false;
        } else if (TextUtils.isEmpty(binding.edtFirstName.getText().toString().trim())) {
            GlobalClass.dailogError(ApplyScholarshipFormActivity.this, "Missing First Name ", " Error while fetching First Name  data from  PPP.");
            return false;
        } else if (TextUtils.isEmpty(binding.edtFullName.getText().toString().trim())) {
            GlobalClass.dailogError(ApplyScholarshipFormActivity.this, "Missing Full Name ", " Error while fetching Full Name  data from  PPP.");
            return false;
        } else if (TextUtils.isEmpty(binding.edtFatherName.getText().toString().trim())) {
            GlobalClass.dailogError(ApplyScholarshipFormActivity.this, "Missing Father Name ", " Error while fetching Father Name  data from  PPP.");
            return false;
        } else if (TextUtils.isEmpty(binding.edtFatherName.getText().toString().trim())) {
            GlobalClass.dailogError(ApplyScholarshipFormActivity.this, "Missing Father Name ", " Error while fetching Father Name  data from  PPP.");
            return false;
        } else if (TextUtils.isEmpty(binding.edtMotherName.getText().toString().trim())) {
            GlobalClass.dailogError(ApplyScholarshipFormActivity.this, "Missing Mother Name ", " Error while fetching Mother Name  data from  PPP.");
            return false;
        } else if (TextUtils.isEmpty(binding.edtGender.getText().toString().trim())) {
            GlobalClass.dailogError(ApplyScholarshipFormActivity.this, "Missing Gender ", " Error while fetching Gender data from  PPP.");
            return false;
        } else if (TextUtils.isEmpty(binding.edtGender.getText().toString().trim())) {
            GlobalClass.dailogError(ApplyScholarshipFormActivity.this, "Missing Gender ", " Error while fetching Gender data from  PPP.");
            return false;
        } else if (TextUtils.isEmpty(binding.edtHouseNo.getText().toString().trim())) {
            GlobalClass.dailogError(ApplyScholarshipFormActivity.this, "Missing House Number ", " Error while fetching House Number data from  PPP.");
            return false;
        } else if (TextUtils.isEmpty(binding.edtStreetNo.getText().toString().trim())) {
            GlobalClass.dailogError(ApplyScholarshipFormActivity.this, "Missing Street Number ", " Error while fetching Street Number data from  PPP.");
            return false;
        } else if (TextUtils.isEmpty(binding.edtAddress.getText().toString().trim())) {
            GlobalClass.dailogError(ApplyScholarshipFormActivity.this, "Missing Address ", " Error while fetching Address data from  PPP.");
            return false;
       /* } else if (TextUtils.isEmpty(binding.edtAAdhar.getText().toString().trim())) {
            GlobalClass.dailogError(ApplyScholarshipFormActivity.this, "Missing Aadhar Number ", " Error while fetching Aadhar Number data from  PPP.");
            return false;
        } else if (!isValidAdhar(binding.edtAAdhar.getText().toString().trim())) {
            GlobalClass.dailogError(ApplyScholarshipFormActivity.this, "Missing 12 digits Aadhar Number.", "Please Enter Your  12 digits Aadhar Number.");
            return false;
*/
        } else if (TextUtils.isEmpty(binding.edtDOb.getText().toString().trim())) {
            GlobalClass.dailogError(ApplyScholarshipFormActivity.this, "Missing DOb ", " Error while fetching Date of Birthday data from  PPP.");
            return false;
        } else if (TextUtils.isEmpty(binding.edtMobileNo.getText().toString().trim())) {
            GlobalClass.dailogError(ApplyScholarshipFormActivity.this, "Missing Mobile Number ", " Error while fetching Mobile Number data from  PPP.");
            return false;
        } else if (TextUtils.isEmpty(binding.edtCastCategoryName.getText().toString().trim())) {
            GlobalClass.dailogError(ApplyScholarshipFormActivity.this, "Missing Cast-Category Name ", " Error while fetching Cast-Category Name data from  PPP.");
            return false;
        } else if (TextUtils.isEmpty(binding.edtEmailId.getText().toString().trim())) {
            GlobalClass.dailogError(ApplyScholarshipFormActivity.this, "Missing Email-Id ", " Error while fetching Email-Id data from  PPP.");
            return false;
        }/* else if (TextUtils.isEmpty(binding.edtIsDenotifiedTribecategory.getText().toString().trim())) {
            GlobalClass.dailogError(ApplyScholarshipFormActivity.this, "Missing Is Denotified Tribe category ", " Error while fetching IsDenotified Tribe-category data from  PPP.");
            return false;
        }*/ else if (TextUtils.isEmpty(binding.edtFamilyIncome.getText().toString().trim())) {
            GlobalClass.dailogError(ApplyScholarshipFormActivity.this, "Missing Family-Income ", " Error while fetching Family-Income data from  PPP.");
            return false;
        }/* else if (TextUtils.isEmpty(binding.edtIsDivyang.getText().toString().trim())) {
            GlobalClass.dailogError(ApplyScholarshipFormActivity.this, "Missing IsDivyang ", " Error while fetching IsDivyang data from  PPP.");
            return false;
        }*/ else if (!IsTermConditionCheked) {
            GlobalClass.dailogError(ApplyScholarshipFormActivity.this, "Missing Term & Condition", "Please check Term & Condition. ");
            return false;
        }
        return true;


    }

    private boolean isValidAdhar(String AadharNo) {

        if (!Pattern.matches("[a-zA-Z]+", AadharNo)) {
            return AadharNo.length() == 12;

        }
        return false;
    }


    @Override
    public void GetDistrictListData(List<AllDistrictsResponse.Datum> list) {

        DistrictarrayList.clear();
        DistrictarrayList.addAll(list);


        AllDistrictsResponse.Datum datum = new AllDistrictsResponse.Datum();
        datum.setDistrict("Select your district");
        datum.setDistrictId(0);
        DistrictarrayList.add(0, datum);


        Adapter = new SpinnerAllDistrictAdapter(getApplicationContext(), DistrictarrayList);
        binding.spnstudentdistrict.setAdapter(Adapter);
        Adapter.notifyDataSetChanged();


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
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {


        int id = parent.getId();
        if (id == R.id.spnstudentAcademicSession) {


            if (position != 0) {

                spnAcademicSessionCurrentPosition = position;

                userAcademicSession = AcademicSessionlist.get(position).getAcademicSession();


            } else {
                spnAcademicSessionCurrentPosition = position;
            }


        } else if (id == R.id.spnstudentCourse) {

            if (position != 0) {


                binding.spnstudentdepartment.setVisibility(View.VISIBLE);
                binding.spnstudentdistrict.setVisibility(View.VISIBLE);
                binding.spnstudentCollegeInstitute.setVisibility(View.VISIBLE);

                spncourseCurrentPosition = position;


                courseName = allCourseForApplyarrayList.get(position).getCourseName();
                courseId = String.valueOf(allCourseForApplyarrayList.get(position).getCourseId());

                if (GlobalClass.isNetworkConnected(ApplyScholarshipFormActivity.this)) {


                    WebAPiCall aPiCall = new WebAPiCall();
                    aPiCall.getDepartmentByCourseIdAPiMethod(ApplyScholarshipFormActivity.this, ApplyScholarshipFormActivity.this, ApplyScholarshipFormActivity.this, courseId);


                } else {

                    Toast.makeText(ApplyScholarshipFormActivity.this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
                }


            } else {
                spndepartmentCurrentPosition = position;

                binding.spnstudentdepartment.setVisibility(View.GONE);
                binding.spnstudentdistrict.setVisibility(View.GONE);
                binding.spnstudentCollegeInstitute.setVisibility(View.GONE);


            }


        } else if (id == R.id.spnstudentdepartment) {

            if (position != 0) {

                spndepartmentCurrentPosition = position;

                userdepartmentName = DepartmentarrayList.get(position).getDepartment();
                UserDepartmentID = DepartmentarrayList.get(position).getDepartmentId();


                if (Is_Studying_Outside_the_Haryana_State != null) {


                    if (!Is_Studying_Outside_the_Haryana_State) {


                        if (GlobalClass.isNetworkConnected(ApplyScholarshipFormActivity.this)) {
                            WebAPiCall aPiCall = new WebAPiCall();
                            aPiCall.GetDistrictListDataMethod(ApplyScholarshipFormActivity.this, ApplyScholarshipFormActivity.this, binding.simpleSwipeRefreshLayout, ApplyScholarshipFormActivity.this);

                        } else {
                            Toast.makeText(ApplyScholarshipFormActivity.this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
                        }
                    } else {


                        DistrictarrayList.clear();


                        AllDistrictsResponse.Datum datum2 = new AllDistrictsResponse.Datum();
                        datum2.setDistrict("Please select");
                        datum2.setDistrictId(24);
                        DistrictarrayList.add(0, datum2);


                        AllDistrictsResponse.Datum datum = new AllDistrictsResponse.Datum();
                        datum.setDistrict("Outside Haryana");
                        datum.setDistrictId(23);
                        DistrictarrayList.add(1, datum);


                        UserDistrictId = DistrictarrayList.get(0).getDistrictId();
                        Adapter = new SpinnerAllDistrictAdapter(getApplicationContext(), DistrictarrayList);
                        binding.spnstudentdistrict.setAdapter(Adapter);
                    }

                } else {


                    GlobalClass.dailogError(ApplyScholarshipFormActivity.this, "Studying Outside Or Not", "Studying Outside the Haryana State being the domicile of Haryana");
                }

/*

                    if (GlobalClass.isNetworkConnected(ApplyScholarshipFormActivity.this)) {
                        WebAPiCall aPiCall = new WebAPiCall();
                        aPiCall.GetDistrictListDataMethod(ApplyScholarshipFormActivity.this, ApplyScholarshipFormActivity.this, binding.simpleSwipeRefreshLayout, ApplyScholarshipFormActivity.this);

                    } else {
                        Toast.makeText(ApplyScholarshipFormActivity.this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
                    }

*/

            } else {
                spndepartmentCurrentPosition = position;

            }


        } else if (id == R.id.spnstudentdistrict) {

            if (position != 0) {

                spndistrictCurrentPosition = position;

                userDistrictName = DistrictarrayList.get(position).getDistrict();
                UserDistrictId = DistrictarrayList.get(position).getDistrictId();


                if (GlobalClass.isNetworkConnected(ApplyScholarshipFormActivity.this)) {

                    WebAPiCall aPiCall = new WebAPiCall();
                    aPiCall.getCollegesListPMSDataAPiMethod(ApplyScholarshipFormActivity.this, ApplyScholarshipFormActivity.this,
                            ApplyScholarshipFormActivity.this, String.valueOf(UserDistrictId),
                            String.valueOf(UserDepartmentID), String.valueOf(userAcademicSession));

                } else {

                    Toast.makeText(ApplyScholarshipFormActivity.this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
                }

            } else {
                spndistrictCurrentPosition = position;

            }


        } else if (id == R.id.spnstudentCollegeInstitute) {

            if (position != 0) {

                spnstudentCollegeCurrentPosition = position;

                userstudentCollegeName = CollegearrayList.get(position).getCollege();
                UserstudentCollegeId = (int) CollegearrayList.get(position).getCollegeId();

                if (GlobalClass.isNetworkConnected(ApplyScholarshipFormActivity.this)) {

                    WebAPiCall aPiCall = new WebAPiCall();
                    aPiCall.GetCoursesTypeMethod(ApplyScholarshipFormActivity.this, ApplyScholarshipFormActivity.this, ApplyScholarshipFormActivity.this);

                } else {

                    Toast.makeText(ApplyScholarshipFormActivity.this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
                }


            } else {
                spnstudentCollegeCurrentPosition = position;

            }


        } else if (id == R.id.spnstudentCourseType) {

            if (position != 0) {

                spnCourseTypeCurrentPosition = position;

                userCourseTypeName = CoursesTypearrayList.get(position).getCourseName();
                UserCourseTypeId = CoursesTypearrayList.get(position).getCourseId();


                if (GlobalClass.isNetworkConnected(ApplyScholarshipFormActivity.this)) {

                    WebAPiCall aPiCall = new WebAPiCall();
                    aPiCall.getCourse_YearMethod(ApplyScholarshipFormActivity.this, ApplyScholarshipFormActivity.this, ApplyScholarshipFormActivity.this, studentuserid,
                            userAcademicSession, courseId, "1");

                } else {

                    Toast.makeText(ApplyScholarshipFormActivity.this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
                }


            } else {
                spnCourseTypeCurrentPosition = position;

            }


        } else if (id == R.id.spnYear) {

            if (position != 0) {

                spnCourseYearCurrentPosition = position;

                userCourseYearName = CoursesYaerarrayList.get(position).getYear();


            } else {
                spnCourseYearCurrentPosition = position;

            }


        } else if (id == R.id.spnAreaType) {

            if (position != 0) {

                spnAreaTypeCurrentPosition = position;

                userAreaTypeName = AreaTypelist.get(position).getAreaName();
                UserAreaTypeId = AreaTypelist.get(position).getId();


                //Toast.makeText(getApplicationContext(), courseYear.get(position).getName(), Toast.LENGTH_LONG).show();

            } else {
                spnAreaTypeCurrentPosition = position;

            }


        } else if (id == R.id.spnBoardingType) {

            if (position != 0) {

                spnBoardingTypeCurrentPosition = position;

                userBoardingTypeName = BoardingTypelist.get(position).getBoardingType();
                UseBoardingTypeId = BoardingTypelist.get(position).getId();


                //Toast.makeText(getApplicationContext(), courseYear.get(position).getName(), Toast.LENGTH_LONG).show();

            } else {
                spnBoardingTypeCurrentPosition = position;

            }
        } else if (id == R.id.spnStudentQuota) {

            if (position != 0) {

                spnStudentQuotaCurrentPosition = position;

                userStudentQuotaName = StudentQuotaTypelist.get(position).getStudentQuota();
                UseStudentQuotaId = StudentQuotaTypelist.get(position).getId();


                //Toast.makeText(getApplicationContext(), courseYear.get(position).getName(), Toast.LENGTH_LONG).show();

            } else {
                spnStudentQuotaCurrentPosition = position;

            }
        } else if (id == R.id.spnLateralEntry) {

            if (position != 0) {

                spnLateralEntryaCurrentPosition = position;

                userLateralEntryName = lateralEntrylist.get(position).getLateralEntry();
                UseLateralEntryId = lateralEntrylist.get(position).getId();


                //Toast.makeText(getApplicationContext(), courseYear.get(position).getName(), Toast.LENGTH_LONG).show();

            } else {
                spnLateralEntryaCurrentPosition = position;

            }
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public boolean CheckVerifyOtpRequest_Data(View view) {

        if (spnAcademicSessionCurrentPosition == 0) {
            GlobalClass.dailogError(ApplyScholarshipFormActivity.this, "Missing Academic Session", "Please Select your Academic Session List. ");
            return false;
        } else if (TextUtils.isEmpty(binding.edtOtp.getText().toString().trim())) {
            GlobalClass.dailogError(ApplyScholarshipFormActivity.this, "Missing OTP", "Please Enter Valid OTP. ");
            return false;
        }
        return true;


    }

    @Override
    public void onClick(View v) {


        if (v == binding.btnVerifyOtp) {
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


                verifyOTPRequestforMEMIDRequest.setMemberID(studentMemberId);
                verifyOTPRequestforMEMIDRequest.setOtp(binding.edtOtp.getText().toString().trim());
                verifyOTPRequestforMEMIDRequest.setTxn(txn);

                if (GlobalClass.isNetworkConnected(ApplyScholarshipFormActivity.this)) {

                    WebAPiCall webapiCall = new WebAPiCall();
                    webapiCall.GetVerifyOTPRequestforMEMIDDataMethod(this, this, ApplyScholarshipFormActivity.this, verifyOTPRequestforMEMIDRequest);

                } else {

                    Toast.makeText(this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
                }
            }
        } else if (v == binding.cardview) {
        }
    }

    @Override
    public void OtpForMEMIDDdata(OTPRequestforMEMIDResponse.Result data) {

        GlobalClass.dailogsuccess(ApplyScholarshipFormActivity.this, data.getStatus(), data.getMessage());

        txn = data.getTxn();

    }

    @Override
    public void verifyOtpForMEMIDDdata(VerifyOTPRequestforMEMIDResponse.Result data) {


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


        if (data.getCasteCategory() == 6) {
//                                        hdnCasteCode.Value = "2";
//                                        txtCaste.Text = "SC";
            binding.edtCastCategoryName.setText("SC");
            //  txtDenotifiedTribe.Text = "Y";
            //   binding.edtIsDenotifiedTribecategory.setText("Y");
        } else {
//                                        hdnCasteCode.Value = Convert.ToString(objjson.result.casteCategory);
//                                        txtCaste.Text = objjson.result.casteCategoryName;
            binding.edtCastCategoryName.setText(data.getCasteCategoryName());
            //   binding.edtIsDenotifiedTribecategory.setText("N");
            //   txtDenotifiedTribe.Text = "N";
        }


        //  binding.edtCastCategoryName.setText((data.getCasteCategoryName()));

//        binding.edtDisabilityType.setText(String.valueOf(data.getDisabiltyType()));
//        binding.edtIsDivyang.setText(String.valueOf(data.getIsDivyang()));


        if (GlobalClass.isNetworkConnected(ApplyScholarshipFormActivity.this)) {

            WebAPiCall aPiCall = new WebAPiCall();
            aPiCall.GetAllCoursesForApplyMethod(ApplyScholarshipFormActivity.this, ApplyScholarshipFormActivity.this, ApplyScholarshipFormActivity.this);

        } else {

            Toast.makeText(ApplyScholarshipFormActivity.this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void GetCourseForApplyData(List<GetAllCoursesResponse.Datum> list) {


        allCourseForApplyarrayList.clear();
        allCourseForApplyarrayList.addAll(list);


        GetAllCoursesResponse.Datum datum = new GetAllCoursesResponse.Datum();
        datum.setCourseName("Select your Course");
        datum.setCourseId(0);
        allCourseForApplyarrayList.add(0, datum);

        spinnerAllCourseForApplyAdapter = new SpinnerAllCourseForApplyAdapter(getApplicationContext(), allCourseForApplyarrayList);
        binding.spnstudentCourse.setAdapter(spinnerAllCourseForApplyAdapter);

    }

    @Override
    public void GetDeptByCourseIdData(List<DepartmentByCourseIdForApplyResponse.Datum> list) {

        DepartmentarrayList.clear();
        DepartmentarrayList.addAll(list);


        DepartmentByCourseIdForApplyResponse.Datum datum = new DepartmentByCourseIdForApplyResponse.Datum();
        datum.setDepartment("Select your department");
        datum.setDepartmentId(0);
        DepartmentarrayList.add(0, datum);

        departmentAdapter = new SpinnerlDepartmentByCourseIdAdapter(getApplicationContext(), DepartmentarrayList);
        binding.spnstudentdepartment.setAdapter(departmentAdapter);
    }

    @Override
    public void GetCoursesTypeData(List<CoursesTypeResponse.Datum> list) {
        CoursesTypearrayList.clear();
        CoursesTypearrayList.addAll(list);


        CoursesTypeResponse.Datum datum = new CoursesTypeResponse.Datum();
        datum.setCourseName("Select your Course-Type");
        datum.setCourseId(0);
        CoursesTypearrayList.add(0, datum);

        courseTypeAdapter = new CourseTypeAdapter(getApplicationContext(), CoursesTypearrayList);
        binding.spnstudentCourseType.setAdapter(courseTypeAdapter);
    }

    @Override
    public void GetCourseYearData(List<CourseYearResponse.Datum> list) {

        CoursesYaerarrayList.clear();
        CoursesYaerarrayList.addAll(list);


        courseYearAdapter = new CourseYearAdapter(getApplicationContext(), CoursesYaerarrayList);
        binding.spnYear.setAdapter(courseYearAdapter);


    }

    @Override
    public void GetCollegeData(List<CollegeListResponse.Datum> list) {
        CollegearrayList.clear();
        CollegearrayList.addAll(list);


        CollegeListResponse.Datum datum = new CollegeListResponse.Datum();
        datum.setCollege("Select your College/Institute");
        datum.setCollegeId(0);
        CollegearrayList.add(0, datum);

        collegeInstituteAdapter = new CollegeInstituteAdapter(getApplicationContext(), CollegearrayList);
        binding.spnstudentCollegeInstitute.setAdapter(collegeInstituteAdapter);
    }

    @Override
    public void GetCheckApplicationExist(List<CheckApplicationExistResponse.Datum> list) {

        binding.btnDataFromPPP.setVisibility(View.GONE);


        if (list.get(0).getOutput() == 1) {


            OTPRequestforMEMIDRequest otpRequestforMEMIDRequest = new OTPRequestforMEMIDRequest();

            // test keys
            // otpRequestforMEMIDRequest.setDeptKey("o2etc739ut");
            // otpRequestforMEMIDRequest.setDeptCode("NIC");
            // otpRequestforMEMIDRequest.setServiceCode("TestCred");

            otpRequestforMEMIDRequest.setDeptKey(GlobalClass.DeptKey);
            otpRequestforMEMIDRequest.setDeptCode(GlobalClass.DeptCode);
            otpRequestforMEMIDRequest.setServiceCode(GlobalClass.ServiceCode);


            otpRequestforMEMIDRequest.setMemberID(studentMemberId);

            if (GlobalClass.isNetworkConnected(ApplyScholarshipFormActivity.this)) {

                WebAPiCall webapiCall = new WebAPiCall();
                webapiCall.GetOTPRequestforMEMIDDataMethod(ApplyScholarshipFormActivity.this, ApplyScholarshipFormActivity.this, ApplyScholarshipFormActivity.this, otpRequestforMEMIDRequest);

            } else {

                Toast.makeText(ApplyScholarshipFormActivity.this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
            }


        } else if (list.get(0).getOutput() == 2) {

/// need api for sent back....."collegeStatus":"Send Back for Correction"

            if (list.get(0).getCollegeStatus().equalsIgnoreCase("Send Back for Correction")) {

                binding.btnDataFromPPP.setVisibility(View.VISIBLE);


                pinCode = (list.get(0).getEdit().get(0).getPinCode());
//                dCode = (list.get(0).getEdit().get(0).getdCode());
//                btCode = (list.get(0).getEdit().get(0).getBtCode());
//                btCodeLGD = (list.get(0).getEdit().get(0).getBtCodeLGD());
//                wvCode = (list.get(0).getEdit().get(0).getWvCode());
                districtName = (list.get(0).getEdit().get(0).getDistrictName());
//                btName = (list.get(0).getEdit().get(0).getBtName());
//                wvName = (list.get(0).getEdit().get(0).getWvName());
//                dCodeLGD = (list.get(0).getEdit().get(0).getdCodeLGD());
//                wvCodeLGD = (list.get(0).getEdit().get(0).getWvCodeLGD());
//                divyangPercentage = String.valueOf((list.get(0).getEdit().get(0).getDivyangPercentage()));
//
//                isDOBVerified = (list.get(0).getEdit().get(0).getIsDOBVerified());
//                isCasteVerified = (list.get(0).getEdit().get(0).getIsCasteVerified());
//                isIncomeVerified = (list.get(0).getEdit().get(0).getIsIncomeVerified());
//                isBPLVerified = (list.get(0).getEdit().get(0).getIsBPLVerified());
//                isDivyangVerified = (list.get(0).getEdit().get(0).getIsDivyangVerified());
//                subCaste_code = (list.get(0).getEdit().get(0).getSubCasteCode());
//                subCaste_name = (list.get(0).getEdit().get(0).getSubCasteName());
//                casteDescription = (list.get(0).getEdit().get(0).getCasteDescription());
//                divyangCategory = (list.get(0).getEdit().get(0).getDivyangCategory());
//                deprived = (list.get(0).getEdit().get(0).getDeprived());
                binding.llregistrationAll.setVisibility(View.VISIBLE);

                binding.edtCastCategoryName.setText((list.get(0).getEdit().get(0).getCasteCategoryName()));
                binding.edtFamilyId.setText((list.get(0).getEdit().get(0).getFamilyID()));
                binding.edtMemberId.setText((list.get(0).getEdit().get(0).getMemberID()));
                binding.edtFirstName.setText((list.get(0).getEdit().get(0).getFirstName()));
                binding.edtLastName.setText((list.get(0).getEdit().get(0).getLastName()));
                binding.edtFullName.setText((list.get(0).getEdit().get(0).getFullName()));
                binding.edtFatherName.setText((list.get(0).getEdit().get(0).getFatherFullName()));
                binding.edtMotherName.setText((list.get(0).getEdit().get(0).getMotherFullName()));
                binding.edtGender.setText((list.get(0).getEdit().get(0).getGender()));
                binding.edtHouseNo.setText((list.get(0).getEdit().get(0).getHouseNo()));
                binding.edtStreetNo.setText((list.get(0).getEdit().get(0).getStreetNo()));
                binding.edtAddress.setText((list.get(0).getEdit().get(0).getAddressLandMark()));
                binding.edtAAdhar.setText((list.get(0).getEdit().get(0).getAadhaarNo()));
                binding.edtDOb.setText((list.get(0).getEdit().get(0).getDob()));
                binding.edtMobileNo.setText((list.get(0).getEdit().get(0).getMobileNo()));

                binding.edtEmailId.setText((list.get(0).getEdit().get(0).getEmail()));
                binding.edtFamilyIncome.setText(String.valueOf((list.get(0).getEdit().get(0).getFamilyIncome())));


//                binding.edtDisabilityType.setText(String.valueOf((list.get(0).getEdit().get(0).getDisabiltyType())));
//                binding.edtIsDivyang.setText(String.valueOf((list.get(0).getEdit().get(0).getIsDivyang())));


            } else {

                GlobalClass.dailogError(ApplyScholarshipFormActivity.this, "Already applied !!", "You have already applied for this Scholarship.!! ");
            }

        } else if (list.get(0).getOutput() == 3) {


            GlobalClass.dailogError(ApplyScholarshipFormActivity.this, "Last date expired !!", "Last date has been expired, So you cannot apply for this session !! ");


        } else {
            GlobalClass.dailogError(ApplyScholarshipFormActivity.this, "Already applied in Others Scheme!!", "You have already applied in some other Scholarship scheme in current Academic Year, therefore now you cannot apply in this scheme. !! ");

        }


    }
}