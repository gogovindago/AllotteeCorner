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
import hsvp.digital.allottee_corner.adapter.RvAllotteeHistoryListAdapter;
import hsvp.digital.allottee_corner.allinterface.allotteeHistoryData_interface;
import hsvp.digital.allottee_corner.apicall.WebAPiCall;
import hsvp.digital.allottee_corner.databinding.ActivityAllotteehistoryBinding;
import hsvp.digital.allottee_corner.model.AlloteeHistoryResponse;
import hsvp.digital.allottee_corner.model.PlotIdRequest;
import hsvp.digital.allottee_corner.utility.BaseActivity;
import hsvp.digital.allottee_corner.utility.CSPreferences;
import hsvp.digital.allottee_corner.utility.GlobalClass;

public class AllotteeHistoryActivity extends BaseActivity implements allotteeHistoryData_interface, RvAllotteeHistoryListAdapter.ItemListener {
    ActivityAllotteehistoryBinding binding;
    private String PlotID;

    private List<AlloteeHistoryResponse.Datum> arrayList = new ArrayList<AlloteeHistoryResponse.Datum>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_allotteehistory);


        try {
            PlotID = CSPreferences.readString(this, "User_Name");
        } catch (Exception e) {
            e.printStackTrace();
        }

        PlotIdRequest request = new PlotIdRequest();

        request.setPlotID(PlotID);


        binding.mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override

            public void onRefresh() {

                binding.mSwipeRefreshLayout.setRefreshing(true);
                binding.llmain.setVisibility(View.GONE);


                request.setPlotID(PlotID);


                if (GlobalClass.isNetworkConnected(AllotteeHistoryActivity.this)) {


                    WebAPiCall webapiCall = new WebAPiCall();
                    webapiCall.allotteHistoryMethod(AllotteeHistoryActivity.this, AllotteeHistoryActivity.this, AllotteeHistoryActivity.this, request,binding.llmain);


                } else {

                    Toast.makeText(AllotteeHistoryActivity.this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
                }

                binding.mSwipeRefreshLayout.setRefreshing(false);

            }
        });


        if (GlobalClass.isNetworkConnected(AllotteeHistoryActivity.this)) {

            WebAPiCall webapiCall = new WebAPiCall();
            webapiCall.allotteHistoryMethod(this, this, AllotteeHistoryActivity.this, request, binding.llmain);


        } else {

            Toast.makeText(this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void initData() {
        binding.toolbar.tvToolbarTitle.setText("Allotee History");
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
    public void onItemClick(AlloteeHistoryResponse.Datum item, int currposition) {

    }

    @Override
    public void AllotteHistorydata(List<AlloteeHistoryResponse.Datum> data) {


        if (data == null || data.isEmpty()) {

            binding.noAllotteeNotice.setVisibility(View.VISIBLE);
            binding.RvAllotteeNotice.setVisibility(View.GONE);
        } else {

            binding.noAllotteeNotice.setVisibility(View.GONE);

            binding.RvAllotteeNotice.setVisibility(View.VISIBLE);


            arrayList.clear();
            arrayList.addAll(data);

            RvAllotteeHistoryListAdapter adaptermain = new RvAllotteeHistoryListAdapter(this, (ArrayList) arrayList, this);
            binding.RvAllotteeNotice.setAdapter(adaptermain);
            GridLayoutManager manager = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
            binding.RvAllotteeNotice.setLayoutManager(manager);
        }




    }


}