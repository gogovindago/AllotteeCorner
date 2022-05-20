package hsvp.digital.allottee_corner.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;

import java.util.List;

import hsvp.digital.allottee_corner.R;
import hsvp.digital.allottee_corner.allinterface.allottecurrentoutstandingData_interface;
import hsvp.digital.allottee_corner.apicall.WebAPiCall;
import hsvp.digital.allottee_corner.databinding.ActivityDashboardBinding;
import hsvp.digital.allottee_corner.model.AllotteCurrentOutStandingResponse;
import hsvp.digital.allottee_corner.model.LoginRequest;
import hsvp.digital.allottee_corner.model.PlotIdRequest;
import hsvp.digital.allottee_corner.utility.BaseActivity;
import hsvp.digital.allottee_corner.utility.CSPreferences;
import hsvp.digital.allottee_corner.utility.GlobalClass;

public class DashboardActivity extends BaseActivity implements allottecurrentoutstandingData_interface {
    ActivityDashboardBinding binding;

    String PlotID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard);


        try {
            PlotID = CSPreferences.readString(this, "User_Name");
        } catch (Exception e) {
            e.printStackTrace();
        }


        PlotIdRequest request = new PlotIdRequest();

        request.setPlotID(PlotID);


        if (GlobalClass.isNetworkConnected(DashboardActivity.this)) {

            WebAPiCall webapiCall = new WebAPiCall();
            webapiCall.allotteCurrentOutStandingMethod(this, this, DashboardActivity.this, request);


        } else {

            Toast.makeText(this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
        }


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
    public void allallottecurrentoutstandingdata(List<AllotteCurrentOutStandingResponse.Datum> data) {

        binding.edtcurrentoutstandingvalue.setText(String.valueOf(data.get(0).getAmount()));

    }
}