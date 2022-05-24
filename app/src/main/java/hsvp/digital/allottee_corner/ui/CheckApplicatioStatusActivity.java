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
import hsvp.digital.allottee_corner.adapter.ApplicationStatusTypeAdapter;
import hsvp.digital.allottee_corner.adapter.RvAllotteeHistoryListAdapter;
import hsvp.digital.allottee_corner.adapter.RvAppStatusTypeListAdapter;
import hsvp.digital.allottee_corner.allinterface.allotteeAppStatusData_interface;
import hsvp.digital.allottee_corner.apicall.WebAPiCall;
import hsvp.digital.allottee_corner.databinding.ActivityCheckApplicatioStatusBinding;
import hsvp.digital.allottee_corner.model.AllotteApplicationStatusResponse;
import hsvp.digital.allottee_corner.model.AppStatusRequest;
import hsvp.digital.allottee_corner.model.ApplicationStatusType;
import hsvp.digital.allottee_corner.model.PlotIdRequest;
import hsvp.digital.allottee_corner.utility.BaseActivity;
import hsvp.digital.allottee_corner.utility.CSPreferences;
import hsvp.digital.allottee_corner.utility.GlobalClass;

public class CheckApplicatioStatusActivity extends BaseActivity implements AdapterView.OnItemSelectedListener, allotteeAppStatusData_interface, RvAppStatusTypeListAdapter.ItemListener {

    ActivityCheckApplicatioStatusBinding binding;
    private List<ApplicationStatusType> ApplicationStatusTypelist = new ArrayList<ApplicationStatusType>();
    ApplicationStatusTypeAdapter adapter;
    private int spnApplicationStatusTypeCurrentPosition;
    private List<AllotteApplicationStatusResponse.Datum> arrayList = new ArrayList<AllotteApplicationStatusResponse.Datum>();
    String userApplicationStatusType, PlotID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_check_applicatio_status);


        try {
            PlotID = CSPreferences.readString(this, "User_Name");
        } catch (Exception e) {
            e.printStackTrace();
        }


        ApplicationStatusTypelist.add(new ApplicationStatusType(0, "Select Application Type"));
        ApplicationStatusTypelist.add(new ApplicationStatusType(1, "All"));
        ApplicationStatusTypelist.add(new ApplicationStatusType(2, "In Process"));
        ApplicationStatusTypelist.add(new ApplicationStatusType(3, "Approved"));
        ApplicationStatusTypelist.add(new ApplicationStatusType(4, "Rejected"));

        adapter = new ApplicationStatusTypeAdapter(getApplicationContext(), ApplicationStatusTypelist);
        binding.spnsApplicationStatusType.setAdapter(adapter);

        binding.spnsApplicationStatusType.setOnItemSelectedListener(this);





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


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {


        int id = parent.getId();
        if (id == R.id.spnsApplicationStatusType) {




            /*{
"plotID": "16298",
"option": "ALL"
Or
"plotID": "16298",
"option": "INPROC"
Or
"plotID": "16298",
"option": "APPRO"
Or
"plotID": "16298",
"option": "REJEC"



}

*/


            if (position != 0) {

                spnApplicationStatusTypeCurrentPosition = position;


                if (spnApplicationStatusTypeCurrentPosition == 1) {

                    userApplicationStatusType = "ALL";

                } else if (spnApplicationStatusTypeCurrentPosition == 2) {
                    userApplicationStatusType = "INPROC";
                } else if (spnApplicationStatusTypeCurrentPosition == 3) {
                    userApplicationStatusType = "APPRO";
                } else if (spnApplicationStatusTypeCurrentPosition == 4) {
                    userApplicationStatusType = "REJEC";
                } else {

                }

                AppStatusRequest request = new AppStatusRequest();

                request.setPlotID(PlotID);
                  request.setOption(userApplicationStatusType);


                if (GlobalClass.isNetworkConnected(CheckApplicatioStatusActivity.this)) {

                    WebAPiCall webapiCall = new WebAPiCall();
                    webapiCall.allotteAppStatusMethod(this, this, CheckApplicatioStatusActivity.this, request);


                } else {

                    Toast.makeText(this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
                }


                //  userApplicationStatusType = ApplicationStatusTypelist.get(position).getappStatusType();


            } else {
                spnApplicationStatusTypeCurrentPosition = position;
            }


        } else {
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void allotteeAppStatusdata(List<AllotteApplicationStatusResponse.Datum> data) {


        if (data == null || data.isEmpty()) {

            binding.nodata.setVisibility(View.VISIBLE);
            binding.RvApplicationStatusType.setVisibility(View.GONE);
        } else {

            binding.nodata.setVisibility(View.GONE);

            binding.RvApplicationStatusType.setVisibility(View.VISIBLE);


            arrayList.clear();
            arrayList.addAll(data);

            RvAppStatusTypeListAdapter adaptermain = new RvAppStatusTypeListAdapter(this, (ArrayList) arrayList, this);
            binding.RvApplicationStatusType.setAdapter(adaptermain);
            GridLayoutManager manager = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
            binding.RvApplicationStatusType.setLayoutManager(manager);
        }


    }

    @Override
    public void onItemClick(AllotteApplicationStatusResponse.Datum item, int currposition) {

    }
}