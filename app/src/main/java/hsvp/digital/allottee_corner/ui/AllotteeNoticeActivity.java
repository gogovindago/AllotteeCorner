package hsvp.digital.allottee_corner.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import java.util.ArrayList;
import java.util.List;

import hsvp.digital.allottee_corner.R;
import hsvp.digital.allottee_corner.adapter.RvAllotteeNoticeListAdapter;
import hsvp.digital.allottee_corner.allinterface.allotteeNoticesData_interface;
import hsvp.digital.allottee_corner.apicall.WebAPiCall;
import hsvp.digital.allottee_corner.databinding.ActivityAllotteenoticeBinding;
import hsvp.digital.allottee_corner.model.AllotteNoticesResponse;
import hsvp.digital.allottee_corner.model.PlotIdRequest;
import hsvp.digital.allottee_corner.utility.BaseActivity;
import hsvp.digital.allottee_corner.utility.CSPreferences;
import hsvp.digital.allottee_corner.utility.GlobalClass;

public class AllotteeNoticeActivity extends BaseActivity implements RvAllotteeNoticeListAdapter.ItemListener, allotteeNoticesData_interface {
    ActivityAllotteenoticeBinding binding;
    private String PlotID;

    private List<AllotteNoticesResponse.Datum> arrayList = new ArrayList<AllotteNoticesResponse.Datum>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_allotteenotice);


        try {
            PlotID = CSPreferences.readString(this, "User_Name");
        } catch (Exception e) {
            e.printStackTrace();
        }

        PlotIdRequest request = new PlotIdRequest();

        request.setPlotID(PlotID);


        if (GlobalClass.isNetworkConnected(AllotteeNoticeActivity.this)) {

            WebAPiCall webapiCall = new WebAPiCall();
            webapiCall.allotteNoticesMethod(this, this, AllotteeNoticeActivity.this, request);


        } else {

            Toast.makeText(this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void initData() {
        binding.toolbar.tvToolbarTitle.setText("Allotee Future Schedule");
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
    public void AllotteNoticesdata(List<AllotteNoticesResponse.Datum> data) {

        if (data == null || data.isEmpty()) {

            binding.noAllotteeNotice.setVisibility(View.VISIBLE);
            binding.RvAllotteeNotice.setVisibility(View.GONE);
        } else {

            binding.noAllotteeNotice.setVisibility(View.GONE);

            binding.RvAllotteeNotice.setVisibility(View.VISIBLE);


            arrayList.clear();
            arrayList.addAll(data);

            RvAllotteeNoticeListAdapter adaptermain = new RvAllotteeNoticeListAdapter(this, (ArrayList) arrayList, this);
            binding.RvAllotteeNotice.setAdapter(adaptermain);
            GridLayoutManager manager = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
            binding.RvAllotteeNotice.setLayoutManager(manager);
        }

    }

    @Override
    public void onItemClick(AllotteNoticesResponse.Datum item, int currposition) {

    }
}