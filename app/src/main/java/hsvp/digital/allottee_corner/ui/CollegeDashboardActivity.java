package hsvp.digital.allottee_corner.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import hsvp.digital.allottee_corner.R;
import hsvp.digital.allottee_corner.adapter.RvDepartmentdashboardListAdapter;
import hsvp.digital.allottee_corner.adapter.SpinnerAcademicSessionAdapter;
import hsvp.digital.allottee_corner.allinterface.GetAcademicSessionData_interface;
import hsvp.digital.allottee_corner.allinterface.GetCollegeDashboardDataListData_interface;
import hsvp.digital.allottee_corner.apicall.WebAPiCall;
import hsvp.digital.allottee_corner.databinding.ActivityCollegeDashboardBinding;
import hsvp.digital.allottee_corner.model.AcademicSessionResponse;
import hsvp.digital.allottee_corner.model.CollegeDashboardResponse;
import hsvp.digital.allottee_corner.model.DepartmentDashboardResponse;
import hsvp.digital.allottee_corner.utility.BaseActivity;
import hsvp.digital.allottee_corner.utility.CSPreferences;
import hsvp.digital.allottee_corner.utility.GlobalClass;

public class CollegeDashboardActivity extends BaseActivity implements GetAcademicSessionData_interface, AdapterView.OnItemSelectedListener, RvDepartmentdashboardListAdapter.ItemListener, GetCollegeDashboardDataListData_interface {
    ActivityCollegeDashboardBinding binding;
    private int spnAcademicSessionCurrentPosition;


    private List<AcademicSessionResponse.Datum> AcademicSessionlist = new ArrayList<AcademicSessionResponse.Datum>();

    ArrayList<CollegeDashboardResponse.Datum> CollegeDashboardarrayList = new ArrayList<CollegeDashboardResponse.Datum>();


    SpinnerAcademicSessionAdapter academicSessionAdapter;

    private String userAcademicSession, DepartmentID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  setContentView(R.layout.activity_department_dashboard);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_college_dashboard);

        // DepartmentID = CSPreferences.readString(this, "department_Id");
        DepartmentID = CSPreferences.readString(this, "collegeId");

        binding.simpleSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override

            public void onRefresh() {

                if (Check_Data(binding.simpleSwipeRefreshLayout)) {
                    if (GlobalClass.isNetworkConnected(CollegeDashboardActivity.this)) {

                        WebAPiCall aPiCall = new WebAPiCall();
                        aPiCall.getCollegeDashboardAPiMethod(CollegeDashboardActivity.this, CollegeDashboardActivity.this,
                                CollegeDashboardActivity.this, userAcademicSession, DepartmentID);

                    } else {

                        Toast.makeText(CollegeDashboardActivity.this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
                    }

                    binding.simpleSwipeRefreshLayout.setRefreshing(false);
                } else {
                    binding.simpleSwipeRefreshLayout.setRefreshing(false);
                }
            }
        });


        if (GlobalClass.isNetworkConnected(CollegeDashboardActivity.this)) {
            WebAPiCall aPiCall = new WebAPiCall();
            aPiCall.GetAllAcademicSessionDataMethod(CollegeDashboardActivity.this, CollegeDashboardActivity.this, CollegeDashboardActivity.this);

        } else {
            Toast.makeText(CollegeDashboardActivity.this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
        }

        binding.spnstudentAcademicSession.setOnItemSelectedListener(this);


    }


    public boolean Check_Data(View view) {
        if (spnAcademicSessionCurrentPosition == 0) {
            GlobalClass.dailogError(CollegeDashboardActivity.this, "Missing Academic Session", "Please Select Academic Session from List. ");
            return false;
        }

        return true;

    }

    @Override
    public void initData() {
        binding.toolbar.tvToolbarTitle.setText("Dashboard");
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
        binding.spnstudentAcademicSession.setSelected(true);
        binding.spnstudentAcademicSession.setSelection(1);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

        int id = adapterView.getId();
        if (id == R.id.spnstudentAcademicSession) {

            if (position != 0) {

                spnAcademicSessionCurrentPosition = position;

                userAcademicSession = AcademicSessionlist.get(position).getAcademicSession();

                if (GlobalClass.isNetworkConnected(CollegeDashboardActivity.this)) {

                    WebAPiCall aPiCall = new WebAPiCall();
                    aPiCall.getCollegeDashboardAPiMethod(CollegeDashboardActivity.this, CollegeDashboardActivity.this,
                            CollegeDashboardActivity.this, userAcademicSession, DepartmentID);

                } else {

                    Toast.makeText(CollegeDashboardActivity.this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
                }

                //Toast.makeText(getApplicationContext(), courseYear.get(position).getName(), Toast.LENGTH_LONG).show();

            } else {
                spnAcademicSessionCurrentPosition = position;

            }


        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    @Override
    public void onItemClick(DepartmentDashboardResponse.Datum item, int currposition) {

    }

    @Override
    public void GetCollegeDashboardData(List<CollegeDashboardResponse.Datum> list) {


        binding.edttotalRecievedApplication.setText(String.valueOf(list.get(0).getTotalRegistration()));
        binding.edttotalapproved.setText(String.valueOf(list.get(0).getApprove()));
        binding.edttotalpendingApplication.setText(String.valueOf(list.get(0).getPending()));
        binding.edttotalRejected.setText(String.valueOf(list.get(0).getReject()));
        binding.edttotalSentBack.setText(String.valueOf(list.get(0).getSendBack()));
        binding.edttotaldisbursement.setText(String.valueOf(list.get(0).getDisbursement()));


    }
}
