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
import hsvp.digital.allottee_corner.adapter.SpinnerAcademicSessionAdapter;
import hsvp.digital.allottee_corner.adapter.SpinnerScholarshipSchemesAdapter;
import hsvp.digital.allottee_corner.allinterface.GetAcademicSessionData_interface;
import hsvp.digital.allottee_corner.allinterface.GetNodalBodyDHEDashboardDataListData_interface;
import hsvp.digital.allottee_corner.allinterface.GetScholarshipschemeData_interface;
import hsvp.digital.allottee_corner.apicall.WebAPiCall;
import hsvp.digital.allottee_corner.databinding.ActivityNodalBodyDheactivityBinding;
import hsvp.digital.allottee_corner.model.AcademicSessionResponse;
import hsvp.digital.allottee_corner.model.NodalBodyDHEDashboardResponse;
import hsvp.digital.allottee_corner.model.ScholarshipSchemesResponse;
import hsvp.digital.allottee_corner.utility.BaseActivity;
import hsvp.digital.allottee_corner.utility.CSPreferences;
import hsvp.digital.allottee_corner.utility.GlobalClass;

public class NodalBodyDHEActivity extends BaseActivity implements GetAcademicSessionData_interface, AdapterView.OnItemSelectedListener, GetNodalBodyDHEDashboardDataListData_interface, GetScholarshipschemeData_interface {
    ActivityNodalBodyDheactivityBinding binding;
    private int spnAcademicSessionCurrentPosition, spnScholarshipschemeCurrentPosition;
    SpinnerAcademicSessionAdapter academicSessionAdapter;
    SpinnerScholarshipSchemesAdapter scholarshipSchemesAdapter;
    private String userAcademicSession, userScholarshipSchemeName, userScholarshipSchemeID, DepartmentID;
    private List<AcademicSessionResponse.Datum> AcademicSessionlist = new ArrayList<AcademicSessionResponse.Datum>();
    private List<ScholarshipSchemesResponse.Datum> ScholarshipSchemeslist = new ArrayList<ScholarshipSchemesResponse.Datum>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_nodal_body_dheactivity);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_nodal_body_dheactivity);
        DepartmentID = CSPreferences.readString(this, "nodalBody_Id");

        if (GlobalClass.isNetworkConnected(NodalBodyDHEActivity.this)) {
            WebAPiCall aPiCall = new WebAPiCall();
            aPiCall.GetAllAcademicSessionDataMethod(NodalBodyDHEActivity.this, NodalBodyDHEActivity.this, NodalBodyDHEActivity.this);

        } else {
            Toast.makeText(NodalBodyDHEActivity.this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
        }

        binding.spnstudentAcademicSession.setOnItemSelectedListener(this);
        binding.spnstudentScholarshipscheme.setOnItemSelectedListener(this);


        binding.simpleSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {


                if (Check_Data(binding.simpleSwipeRefreshLayout)) {

                    if (GlobalClass.isNetworkConnected(NodalBodyDHEActivity.this)) {

                        //https://cmapi.highereduhry.ac.in/api/commonapi/Get_DashboardNodalBodyDHE/1/2020-21/1

                        WebAPiCall aPiCall = new WebAPiCall();
                        aPiCall.getNodalBodyDHEDashboardAPiMethod(NodalBodyDHEActivity.this, NodalBodyDHEActivity.this,
                                NodalBodyDHEActivity.this, DepartmentID, userAcademicSession, userScholarshipSchemeID);

                    } else {

                        Toast.makeText(NodalBodyDHEActivity.this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
                    }

                    binding.simpleSwipeRefreshLayout.setRefreshing(false);

                } else {

                    binding.simpleSwipeRefreshLayout.setRefreshing(false);

                }

            }
        });


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


    public boolean Check_Data(View view) {
        if (spnAcademicSessionCurrentPosition == 0) {
            GlobalClass.dailogError(NodalBodyDHEActivity.this, "Missing Academic Session", "Please Select Academic Session from List. ");
            return false;
        } else if (spnScholarshipschemeCurrentPosition == 0) {

            GlobalClass.dailogError(NodalBodyDHEActivity.this, "Missing Scholarship Scheme", "Please Select Scholarship Scheme from List. ");
            return false;
        }

        return true;

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {


        int id = adapterView.getId();
        if (id == R.id.spnstudentAcademicSession) {

            if (position != 0) {

                spnAcademicSessionCurrentPosition = position;

                userAcademicSession = AcademicSessionlist.get(position).getAcademicSession();

                if (GlobalClass.isNetworkConnected(NodalBodyDHEActivity.this)) {

                    WebAPiCall aPiCall = new WebAPiCall();
                    aPiCall.GetAllScholarshipSchemesDataMethod(NodalBodyDHEActivity.this, NodalBodyDHEActivity.this, NodalBodyDHEActivity.this);

                } else {

                    Toast.makeText(NodalBodyDHEActivity.this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
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

                if (GlobalClass.isNetworkConnected(NodalBodyDHEActivity.this)) {

//https://cmapi.highereduhry.ac.in/api/commonapi/Get_DashboardNodalBodyDHE/1/2020-21/1

                    WebAPiCall aPiCall = new WebAPiCall();
                    aPiCall.getNodalBodyDHEDashboardAPiMethod(NodalBodyDHEActivity.this, NodalBodyDHEActivity.this,
                            NodalBodyDHEActivity.this, DepartmentID, userAcademicSession, userScholarshipSchemeID);

                } else {

                    Toast.makeText(NodalBodyDHEActivity.this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
                }
            } else {
                spnScholarshipschemeCurrentPosition = position;
            }


        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void GetNodalBodyDHEDashboardData(List<NodalBodyDHEDashboardResponse.Datum> list) {
        binding.edttotalRecievedApplication.setText(String.valueOf(list.get(0).getTotalRegistration()));
        binding.edttotalapproved.setText(String.valueOf(list.get(0).getApprove()));
        binding.edttotalpendingApplication.setText(String.valueOf(list.get(0).getPending()));
        binding.edttotalRejected.setText(String.valueOf(list.get(0).getReject()));
        binding.edttotalSentBack.setText(String.valueOf(list.get(0).getSendBack()));
        binding.edttotalDisbursement.setText(String.valueOf(list.get(0).getDisbursement()));


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
}