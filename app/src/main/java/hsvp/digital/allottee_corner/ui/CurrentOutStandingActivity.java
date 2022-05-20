package hsvp.digital.allottee_corner.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import java.util.ArrayList;
import java.util.List;

import hsvp.digital.allottee_corner.R;
import hsvp.digital.allottee_corner.adapter.RvcurrentoutstandingdetailListAdapter;
import hsvp.digital.allottee_corner.adapter.RvfutureoutstandingdetailListAdapter;
import hsvp.digital.allottee_corner.allinterface.allottecurrentoutstandingData_interface;
import hsvp.digital.allottee_corner.apicall.WebAPiCall;
import hsvp.digital.allottee_corner.databinding.ActivityCurrentoutstandingBinding;
import hsvp.digital.allottee_corner.model.AllotteCurrentOutStandingResponse;
import hsvp.digital.allottee_corner.model.AllottefutureOutStandingDetailsResponse;
import hsvp.digital.allottee_corner.model.PlotIdRequest;
import hsvp.digital.allottee_corner.utility.BaseActivity;
import hsvp.digital.allottee_corner.utility.CSPreferences;
import hsvp.digital.allottee_corner.utility.GlobalClass;

public class CurrentOutStandingActivity extends BaseActivity implements RvcurrentoutstandingdetailListAdapter.ItemListener, allottecurrentoutstandingData_interface {
    ActivityCurrentoutstandingBinding binding;
    private String PlotID;
    private List<AllotteCurrentOutStandingResponse.Datum> arrayList = new ArrayList<AllotteCurrentOutStandingResponse.Datum>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_currentoutstanding);


        try {
            PlotID = CSPreferences.readString(this, "User_Name");
        } catch (Exception e) {
            e.printStackTrace();
        }


        PlotIdRequest request = new PlotIdRequest();

        request.setPlotID(PlotID);


        if (GlobalClass.isNetworkConnected(CurrentOutStandingActivity.this)) {

            WebAPiCall webapiCall = new WebAPiCall();
            webapiCall.allotteCurrentOutStandingDetailsApiMethod(this, this, CurrentOutStandingActivity.this, request);


        } else {

            Toast.makeText(this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void initData() {
        binding.toolbar.tvToolbarTitle.setText("Current Outstanding");
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
    public void allallottecurrentoutstandingdata(List<AllotteCurrentOutStandingResponse.Datum> data) {


        arrayList.clear();
        arrayList.addAll(data);

        RvcurrentoutstandingdetailListAdapter adaptermain = new RvcurrentoutstandingdetailListAdapter(this, (ArrayList) arrayList, this);
        binding.RvCurrentoutstand.setAdapter(adaptermain);
        GridLayoutManager manager = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
        binding.RvCurrentoutstand.setLayoutManager(manager);


    }

    @Override
    public void onItemClick(AllotteCurrentOutStandingResponse.Datum item, int currposition) {

    }
}