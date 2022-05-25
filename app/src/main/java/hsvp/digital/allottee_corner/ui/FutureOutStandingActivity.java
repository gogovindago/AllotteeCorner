package hsvp.digital.allottee_corner.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import hsvp.digital.allottee_corner.R;
import hsvp.digital.allottee_corner.adapter.RvfutureoutstandingdetailListAdapter;
import hsvp.digital.allottee_corner.allinterface.allotteefutureoustandingdetaildetailData_interface;
import hsvp.digital.allottee_corner.apicall.WebAPiCall;
import hsvp.digital.allottee_corner.databinding.ActivityFutureoutstandingBinding;
import hsvp.digital.allottee_corner.model.AllottefutureOutStandingDetailsResponse;
import hsvp.digital.allottee_corner.model.PlotIdRequest;
import hsvp.digital.allottee_corner.utility.BaseActivity;
import hsvp.digital.allottee_corner.utility.CSPreferences;
import hsvp.digital.allottee_corner.utility.GlobalClass;

public class FutureOutStandingActivity extends BaseActivity implements allotteefutureoustandingdetaildetailData_interface, RvfutureoutstandingdetailListAdapter.ItemListener {
    ActivityFutureoutstandingBinding binding;
    private String PlotID;

    private List<AllottefutureOutStandingDetailsResponse.Datum> arrayList = new ArrayList<AllottefutureOutStandingDetailsResponse.Datum>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_futureoutstanding);


        try {
            PlotID = CSPreferences.readString(this, "User_Name");
        } catch (Exception e) {
            e.printStackTrace();
        }





        binding.mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override

            public void onRefresh() {

                binding.mSwipeRefreshLayout.setRefreshing(true);
                binding.llmain.setVisibility(View.GONE);

                PlotIdRequest request = new PlotIdRequest();

                request.setPlotID(PlotID);


                if (GlobalClass.isNetworkConnected(FutureOutStandingActivity.this)) {


                    WebAPiCall webapiCall = new WebAPiCall();
                    webapiCall.allottefutureOutStandingDetailsMethod(FutureOutStandingActivity.this, FutureOutStandingActivity.this, FutureOutStandingActivity.this, request,binding.llmain);


                } else {

                    Toast.makeText(FutureOutStandingActivity.this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
                }

                binding.mSwipeRefreshLayout.setRefreshing(false);

            }
        });
























        PlotIdRequest request = new PlotIdRequest();

        request.setPlotID(PlotID);


        if (GlobalClass.isNetworkConnected(FutureOutStandingActivity.this)) {

            WebAPiCall webapiCall = new WebAPiCall();
            webapiCall.allottefutureOutStandingDetailsMethod(this, this, FutureOutStandingActivity.this, request, binding.llmain);


        } else {

            Toast.makeText(this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void initData() {
        binding.toolbar.tvToolbarTitle.setText("Future OutStanding");
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
    public void allottefutureOutStandingdata(List<AllottefutureOutStandingDetailsResponse.Datum> data) {



        if (data == null || data.isEmpty()) {

            binding.nofutureschedule.setVisibility(View.VISIBLE);
            binding.Rvfutureschedule.setVisibility(View.GONE);
        } else {

            binding.nofutureschedule.setVisibility(View.GONE);

            binding.Rvfutureschedule.setVisibility(View.VISIBLE);


            arrayList.clear();
            arrayList.addAll(data);

            RvfutureoutstandingdetailListAdapter adaptermain = new RvfutureoutstandingdetailListAdapter(this, (ArrayList) arrayList, this);
            binding.Rvfutureschedule.setAdapter(adaptermain);
            GridLayoutManager manager = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
            binding.Rvfutureschedule.setLayoutManager(manager);
        }

    }

    @Override
    public void onItemClick(AllottefutureOutStandingDetailsResponse.Datum item, int currposition) {

    }
}