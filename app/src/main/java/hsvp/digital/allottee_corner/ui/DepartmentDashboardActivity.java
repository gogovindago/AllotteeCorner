package hsvp.digital.allottee_corner.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import hsvp.digital.allottee_corner.R;
import hsvp.digital.allottee_corner.adapter.RvDepartmentdashboardListAdapter;
import hsvp.digital.allottee_corner.adapter.SpinnerAcademicSessionAdapter;
import hsvp.digital.allottee_corner.allinterface.GetAcademicSessionData_interface;
import hsvp.digital.allottee_corner.allinterface.GetDepartmrntDashboardDataListData_interface;
import hsvp.digital.allottee_corner.apicall.WebAPiCall;
import hsvp.digital.allottee_corner.databinding.ActivityDepartmentDashboardBinding;
import hsvp.digital.allottee_corner.model.AcademicSessionResponse;
import hsvp.digital.allottee_corner.model.DepartmentDashboardResponse;
import hsvp.digital.allottee_corner.utility.BaseActivity;
import hsvp.digital.allottee_corner.utility.CSPreferences;
import hsvp.digital.allottee_corner.utility.GlobalClass;

public class DepartmentDashboardActivity extends BaseActivity implements GetAcademicSessionData_interface, AdapterView.OnItemSelectedListener, RvDepartmentdashboardListAdapter.ItemListener, GetDepartmrntDashboardDataListData_interface {
    ActivityDepartmentDashboardBinding binding;
    private int spnAcademicSessionCurrentPosition;


    private List<AcademicSessionResponse.Datum> AcademicSessionlist = new ArrayList<AcademicSessionResponse.Datum>();

    ArrayList<DepartmentDashboardResponse.Datum> DepartmentashboardarrayList = new ArrayList<DepartmentDashboardResponse.Datum>();


    SpinnerAcademicSessionAdapter academicSessionAdapter;

    private String userAcademicSession, DepartmentID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department_dashboard);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_department_dashboard);


        binding.simpleSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override

            public void onRefresh() {

                if (GlobalClass.isNetworkConnected(DepartmentDashboardActivity.this)) {
                    WebAPiCall aPiCall = new WebAPiCall();
                    aPiCall.GetAllAcademicSessionDataMethod(DepartmentDashboardActivity.this, DepartmentDashboardActivity.this, DepartmentDashboardActivity.this);


                } else {

                    Toast.makeText(DepartmentDashboardActivity.this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
                }
                binding.simpleSwipeRefreshLayout.setRefreshing(false);
            }
        });


        DepartmentID = CSPreferences.readString(this, "department_Id");
        if (GlobalClass.isNetworkConnected(DepartmentDashboardActivity.this)) {
            WebAPiCall aPiCall = new WebAPiCall();
            aPiCall.GetAllAcademicSessionDataMethod(DepartmentDashboardActivity.this, DepartmentDashboardActivity.this, DepartmentDashboardActivity.this);

        } else {
            Toast.makeText(DepartmentDashboardActivity.this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
        }

        binding.spnstudentAcademicSession.setOnItemSelectedListener(this);


    }

    @Override
    public void initData() {
        binding.toolbar.tvToolbarTitle.setText("Department Dashboard");
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

                if (GlobalClass.isNetworkConnected(DepartmentDashboardActivity.this)) {

                    WebAPiCall aPiCall = new WebAPiCall();
                    aPiCall.getPMSDashboardDepartmentAPiMethod(DepartmentDashboardActivity.this, DepartmentDashboardActivity.this,
                            DepartmentDashboardActivity.this, "All", userAcademicSession, DepartmentID);

                } else {

                    Toast.makeText(DepartmentDashboardActivity.this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
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
    public void GetDepartmentDashboardData(List<DepartmentDashboardResponse.Datum> list) {

        DepartmentashboardarrayList.clear();
        DepartmentashboardarrayList.addAll(list);

        binding.txtlastUpdated.setText("Last Updated on- " + DepartmentashboardarrayList.get(0).getLastUpdated());
        RvDepartmentdashboardListAdapter adaptermain = new RvDepartmentdashboardListAdapter(this, DepartmentashboardarrayList, this);
        binding.rvdashboard.setAdapter(adaptermain);
        GridLayoutManager manager = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
        binding.rvdashboard.setLayoutManager(manager);


    }
}
