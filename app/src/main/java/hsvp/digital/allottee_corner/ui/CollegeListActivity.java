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
import hsvp.digital.allottee_corner.adapter.ListOfCollegeAdapter;
import hsvp.digital.allottee_corner.adapter.SpinnerAllDepartmentAdapter;
import hsvp.digital.allottee_corner.adapter.SpinnerAllDistrictAdapter;
import hsvp.digital.allottee_corner.allinterface.GetCollegeListData_interface;
import hsvp.digital.allottee_corner.allinterface.GetDepartmentListData_interface;
import hsvp.digital.allottee_corner.allinterface.GetDistrictListData_interface;
import hsvp.digital.allottee_corner.apicall.WebAPiCall;
import hsvp.digital.allottee_corner.databinding.ActivityCollegeListBinding;
import hsvp.digital.allottee_corner.model.AllDepartmentResponse;
import hsvp.digital.allottee_corner.model.AllDistrictsResponse;
import hsvp.digital.allottee_corner.model.CollegeListResponse;
import hsvp.digital.allottee_corner.utility.BaseActivity;
import hsvp.digital.allottee_corner.utility.GlobalClass;

public class CollegeListActivity extends BaseActivity implements GetDistrictListData_interface, AdapterView.OnItemSelectedListener, GetDepartmentListData_interface, GetCollegeListData_interface, ListOfCollegeAdapter.ItemListener {


    ActivityCollegeListBinding binding;

    private List<AllDistrictsResponse.Datum> DistrictarrayList = new ArrayList<AllDistrictsResponse.Datum>();
    private List<AllDepartmentResponse.Datum> DepartmentarrayList = new ArrayList<AllDepartmentResponse.Datum>();
    private List<CollegeListResponse.Datum> CollegearrayList = new ArrayList<CollegeListResponse.Datum>();


    private int spndistrictCurrentPosition, spndepartmentCurrentPosition, UserDistrictId, UserDepartmentID;
    String userDistrictName, userdepartmentName;
    private SpinnerAllDistrictAdapter Adapter;
    private SpinnerAllDepartmentAdapter departmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_college_list);


        binding.simpleSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override

            public void onRefresh() {
                if (GlobalClass.isNetworkConnected(CollegeListActivity.this)) {
                    WebAPiCall aPiCall = new WebAPiCall();
                    aPiCall.GetDistrictListDataMethod(CollegeListActivity.this, CollegeListActivity.this, binding.simpleSwipeRefreshLayout, CollegeListActivity.this);

                } else {
                    Toast.makeText(CollegeListActivity.this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
                }

                binding.simpleSwipeRefreshLayout.setRefreshing(false);
            }
        });


        if (GlobalClass.isNetworkConnected(CollegeListActivity.this)) {
            WebAPiCall aPiCall = new WebAPiCall();
            aPiCall.GetDistrictListDataMethod(CollegeListActivity.this, CollegeListActivity.this, binding.simpleSwipeRefreshLayout, CollegeListActivity.this);

        } else {
            Toast.makeText(CollegeListActivity.this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
        }
        binding.spnstudentdistrict.setOnItemSelectedListener(this);
        binding.spnstudentdepartment.setOnItemSelectedListener(this);


    }

    @Override
    public void initData() {
        binding.toolbar.tvToolbarTitle.setText("College List");
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
    public void GetDistrictListData(List<AllDistrictsResponse.Datum> list) {

        DistrictarrayList.clear();
        DistrictarrayList.addAll(list);


        AllDistrictsResponse.Datum datum = new AllDistrictsResponse.Datum();
        datum.setDistrict("Select your district");
        datum.setDistrictId(0);
        DistrictarrayList.add(0, datum);

        Adapter = new SpinnerAllDistrictAdapter(getApplicationContext(), DistrictarrayList);
        binding.spnstudentdistrict.setAdapter(Adapter);

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

        int id = adapterView.getId();
        if (id == R.id.spnstudentdistrict) {

            if (position != 0) {

                spndistrictCurrentPosition = position;

                userDistrictName = DistrictarrayList.get(position).getDistrict();
                UserDistrictId = DistrictarrayList.get(position).getDistrictId();

                if (GlobalClass.isNetworkConnected(CollegeListActivity.this)) {

                    WebAPiCall aPiCall = new WebAPiCall();
                    aPiCall.GetDepartmentListDataMethod(CollegeListActivity.this, CollegeListActivity.this, binding.simpleSwipeRefreshLayout, CollegeListActivity.this);

                } else {

                    Toast.makeText(CollegeListActivity.this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
                }


                //Toast.makeText(getApplicationContext(), courseYear.get(position).getName(), Toast.LENGTH_LONG).show();

            } else {
                spndistrictCurrentPosition = position;

            }


        } else if (id == R.id.spnstudentdepartment) {

            if (position != 0) {

                spndepartmentCurrentPosition = position;

                userdepartmentName = DepartmentarrayList.get(position).getDepartment();
                UserDepartmentID = DepartmentarrayList.get(position).getDepartmentId();

                if (GlobalClass.isNetworkConnected(CollegeListActivity.this)) {

                    WebAPiCall aPiCall = new WebAPiCall();
                    aPiCall.getCollegesListDataAPiMethod(CollegeListActivity.this, CollegeListActivity.this,
                            CollegeListActivity.this, String.valueOf(UserDistrictId),
                            String.valueOf(UserDepartmentID));

                } else {

                    Toast.makeText(CollegeListActivity.this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
                }


            } else {
                spndepartmentCurrentPosition = position;

            }
        } else {

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void GetDepartmentListData(List<AllDepartmentResponse.Datum> list) {

        DepartmentarrayList.clear();
        DepartmentarrayList.addAll(list);


        AllDepartmentResponse.Datum datum = new AllDepartmentResponse.Datum();
        datum.setDepartment("Select your department");
        datum.setDepartmentId(0);
        DepartmentarrayList.add(0, datum);

        departmentAdapter = new SpinnerAllDepartmentAdapter(getApplicationContext(), DepartmentarrayList);
        binding.spnstudentdepartment.setAdapter(departmentAdapter);

    }

    @Override
    public void GetCollegeData(List<CollegeListResponse.Datum> list) {


        CollegearrayList.clear();
        CollegearrayList.addAll(list);

        ListOfCollegeAdapter adaptermain = new ListOfCollegeAdapter(this, (ArrayList)CollegearrayList, this);
        binding.rvcollege.setAdapter(adaptermain);
        GridLayoutManager manager = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
        binding.rvcollege.setLayoutManager(manager);


    }

    @Override
    public void onItemClick(CollegeListResponse.Datum item, int currposition) {

    }
}