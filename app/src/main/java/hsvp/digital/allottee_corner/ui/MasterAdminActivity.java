package hsvp.digital.allottee_corner.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import java.util.ArrayList;
import java.util.List;

import hsvp.digital.allottee_corner.R;
import hsvp.digital.allottee_corner.adapter.RvAdmindashboardListAdapter;
import hsvp.digital.allottee_corner.adapter.SpinnerAcademicSessionAdapter;
import hsvp.digital.allottee_corner.adapter.SpinnerCastAdapter;
import hsvp.digital.allottee_corner.adapter.SpinnerScholarshipSchemesAdapter;
import hsvp.digital.allottee_corner.allinterface.GetAcademicSessionData_interface;
import hsvp.digital.allottee_corner.allinterface.GetAdminDashboardDataListData_interface;
import hsvp.digital.allottee_corner.allinterface.GetScholarshipschemeData_interface;
import hsvp.digital.allottee_corner.apicall.WebAPiCall;
import hsvp.digital.allottee_corner.databinding.ActivityMasterAdminBinding;
import hsvp.digital.allottee_corner.model.AcademicSessionResponse;
import hsvp.digital.allottee_corner.model.AdminDashboardResponse;
import hsvp.digital.allottee_corner.model.Masteradminmodel;
import hsvp.digital.allottee_corner.model.ScholarshipSchemesResponse;
import hsvp.digital.allottee_corner.utility.BaseActivity;
import hsvp.digital.allottee_corner.utility.GlobalClass;

public class MasterAdminActivity extends BaseActivity implements GetAcademicSessionData_interface, AdapterView.OnItemSelectedListener, GetScholarshipschemeData_interface, GetAdminDashboardDataListData_interface, RvAdmindashboardListAdapter.ItemListener {
    ActivityMasterAdminBinding binding;
    private int spnAcademicSessionCurrentPosition, spnScholarshipschemeCurrentPosition, spnCastCurrentPosition;


    private List<AcademicSessionResponse.Datum> AcademicSessionlist = new ArrayList<AcademicSessionResponse.Datum>();
    private List<ScholarshipSchemesResponse.Datum> ScholarshipSchemeslist = new ArrayList<ScholarshipSchemesResponse.Datum>();
    ArrayList<Masteradminmodel> castArraylist = new ArrayList<Masteradminmodel>();
    ArrayList<AdminDashboardResponse.Datum> admindashboardarrayList = new ArrayList<AdminDashboardResponse.Datum>();


    SpinnerAcademicSessionAdapter academicSessionAdapter;
    SpinnerScholarshipSchemesAdapter scholarshipSchemesAdapter;
    SpinnerCastAdapter SpinnerCastAdapter;

    private String userAcademicSession, userScholarshipSchemeName, userScholarshipSchemeID, userCastName, userCastId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_admin);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_master_admin);


        castArraylist.add(new Masteradminmodel(1, "Select cast"));
        castArraylist.add(new Masteradminmodel(2, "All"));
        castArraylist.add(new Masteradminmodel(3, "SC"));
        castArraylist.add(new Masteradminmodel(4, "BC"));

        SpinnerCastAdapter = new SpinnerCastAdapter(getApplicationContext(), castArraylist);
        binding.spnstudentcastCategory.setAdapter(SpinnerCastAdapter);

        binding.spnstudentcastCategory.setOnItemSelectedListener(this);


        if (GlobalClass.isNetworkConnected(MasterAdminActivity.this)) {
            WebAPiCall aPiCall = new WebAPiCall();
            aPiCall.GetAllAcademicSessionDataMethod(MasterAdminActivity.this, MasterAdminActivity.this, MasterAdminActivity.this);

        } else {
            Toast.makeText(MasterAdminActivity.this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
        }

        binding.spnstudentAcademicSession.setOnItemSelectedListener(this);
        binding.spnstudentScholarshipscheme.setOnItemSelectedListener(this);
        binding.spnstudentcastCategory.setOnItemSelectedListener(this);

    }

    @Override
    public void initData() {
        binding.toolbar.tvToolbarTitle.setText("Master Admin Dashboard");
    }

    @Override
    public void initListeners() {

        binding.toolbar.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

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

                if (GlobalClass.isNetworkConnected(MasterAdminActivity.this)) {

                    WebAPiCall aPiCall = new WebAPiCall();
                    aPiCall.GetAllScholarshipSchemesDataMethod(MasterAdminActivity.this, MasterAdminActivity.this, MasterAdminActivity.this);

                } else {

                    Toast.makeText(MasterAdminActivity.this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
                }


                //Toast.makeText(getApplicationContext(), courseYear.get(position).getName(), Toast.LENGTH_LONG).show();

            } else {
                spnAcademicSessionCurrentPosition = position;

            }


        } else if (id == R.id.spnstudentScholarshipscheme) {
            if (position != 0) {
                spnScholarshipschemeCurrentPosition = position;

                userScholarshipSchemeName = ScholarshipSchemeslist.get(position).getSchemeName();
                userScholarshipSchemeID = String.valueOf(ScholarshipSchemeslist.get(position).getSchemeId());


                SpinnerCastAdapter = new SpinnerCastAdapter(getApplicationContext(), castArraylist);
                binding.spnstudentcastCategory.setAdapter(SpinnerCastAdapter);


            } else {
                spnScholarshipschemeCurrentPosition = position;
            }

        } else if (id == R.id.spnstudentcastCategory) {


            if (position != 0) {
                spnCastCurrentPosition = position;

                userCastName = castArraylist.get(position).getItemname();
                userCastId = String.valueOf(castArraylist.get(position).getItemId());


                if (GlobalClass.isNetworkConnected(MasterAdminActivity.this)) {

                    if (userCastId.equalsIgnoreCase("2")) {

                        userCastName = "All";
                    }

                    WebAPiCall aPiCall = new WebAPiCall();
                    aPiCall.getPMSDashboardAdminAPiMethod(MasterAdminActivity.this, MasterAdminActivity.this,
                            MasterAdminActivity.this, userCastName, userAcademicSession, userScholarshipSchemeID);

                } else {

                    Toast.makeText(MasterAdminActivity.this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
                }

            } else {
                spnCastCurrentPosition = position;
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

    @Override
    public void GetAdminDashboardData(List<AdminDashboardResponse.Datum> list) {


        admindashboardarrayList.clear();
        admindashboardarrayList.addAll(list);
        if (userScholarshipSchemeID.equalsIgnoreCase("1")) {
            int totalApplications = 0, ApprovedbyColleges = 0, approvedbyuniversity = 0, approvedbyHQ = 0,
                    DisbursementDone = 0, Pendingatcollege = 0,
                    PendingatUniversities = 0, PendingatHQ = 0, Rejected = 0, SentBack = 0, moSJENSpApistatus = 0;

            for (int i = 0; i < list.size(); i++) {
                totalApplications = totalApplications + list.get(i).getTotalApplications();
                ApprovedbyColleges = ApprovedbyColleges + list.get(i).getApprovedByColleges();
                approvedbyuniversity = approvedbyuniversity + list.get(i).getApprovedByNB();
                approvedbyHQ = approvedbyHQ + list.get(i).getApprovedByHQ();
                DisbursementDone = DisbursementDone + list.get(i).getDisbursement();
                Pendingatcollege = Pendingatcollege + list.get(i).getPendingAtCollege();
                PendingatUniversities = PendingatUniversities + list.get(i).getPendingAtNB();
                PendingatHQ = PendingatHQ + list.get(i).getPendingAtHQ();
                Rejected = Rejected + list.get(i).getRejected();
                SentBack = SentBack + list.get(i).getSentBack();
                moSJENSpApistatus = moSJENSpApistatus + list.get(i).getMoSJEAPIStatus();


            }


            AdminDashboardResponse.Datum datum = new AdminDashboardResponse.Datum();
            datum.setDepartment("Grand Total");
            datum.setCaste(userCastName);
            datum.setAcademicSession(userAcademicSession);
            datum.setTotalApplications(totalApplications);
            datum.setApprovedByColleges(ApprovedbyColleges);
            datum.setApprovedByNB(approvedbyuniversity);
            datum.setApprovedByHQ(approvedbyHQ);
            datum.setDisbursement(DisbursementDone);
            datum.setPendingAtCollege(Pendingatcollege);
            datum.setPendingAtNB(PendingatUniversities);
            datum.setPendingAtHQ(PendingatHQ);
            datum.setRejected(Rejected);
            datum.setSentBack(SentBack);
            datum.setMoSJEAPIStatus(moSJENSpApistatus);

            datum.setSchemeId(6);
            admindashboardarrayList.add(5, datum);

        }
        binding.admintxtlastUpdated.setText("Last Updated on- " + admindashboardarrayList.get(0).getLastUpdated());
        RvAdmindashboardListAdapter adaptermain = new RvAdmindashboardListAdapter(this, admindashboardarrayList, this);
        binding.rvdashboard.setAdapter(adaptermain);
        GridLayoutManager manager = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
        binding.rvdashboard.setLayoutManager(manager);


    }

    @Override
    public void onItemClick(AdminDashboardResponse.Datum item, int currposition) {

    }
}