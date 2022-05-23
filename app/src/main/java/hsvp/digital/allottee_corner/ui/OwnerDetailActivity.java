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
import hsvp.digital.allottee_corner.adapter.RvGpaDirectorsListAdapter;
import hsvp.digital.allottee_corner.adapter.RvfetchjointholderListAdapter;
import hsvp.digital.allottee_corner.allinterface.allotteedetailData_interface;
import hsvp.digital.allottee_corner.allinterface.fetchjointdetaildetailData_interface;
import hsvp.digital.allottee_corner.apicall.WebAPiCall;
import hsvp.digital.allottee_corner.databinding.ActivityOwnerDetailBinding;
import hsvp.digital.allottee_corner.model.FetchAllottedetailsResponse;
import hsvp.digital.allottee_corner.model.FetchJointHolderDetailsResponse;
import hsvp.digital.allottee_corner.model.PlotIdRequest;
import hsvp.digital.allottee_corner.utility.BaseActivity;
import hsvp.digital.allottee_corner.utility.CSPreferences;
import hsvp.digital.allottee_corner.utility.GlobalClass;

public class OwnerDetailActivity extends BaseActivity implements allotteedetailData_interface, fetchjointdetaildetailData_interface, RvfetchjointholderListAdapter.ItemListener, RvGpaDirectorsListAdapter.ItemListener {
    ActivityOwnerDetailBinding binding;
    private String PlotID;


    private List<FetchJointHolderDetailsResponse.JHolder> arrayList = new ArrayList<FetchJointHolderDetailsResponse.JHolder>();
    private List<FetchJointHolderDetailsResponse.Gpa> arrayListGpa = new ArrayList<FetchJointHolderDetailsResponse.Gpa>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_owner_detail);


        try {
            PlotID = CSPreferences.readString(this, "User_Name");
        } catch (Exception e) {
            e.printStackTrace();
        }


        PlotIdRequest request = new PlotIdRequest();

        request.setPlotID(PlotID);


        if (GlobalClass.isNetworkConnected(OwnerDetailActivity.this)) {

            WebAPiCall webapiCall = new WebAPiCall();
            webapiCall.FetchAllottedetailsMethod(this, this, OwnerDetailActivity.this, request, binding.llmain);


        } else {

            Toast.makeText(this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
        }


        binding.mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override

            public void onRefresh() {

                binding.mSwipeRefreshLayout.setRefreshing(true);
                binding.llmain.setVisibility(View.GONE);


                request.setPlotID(PlotID);


                if (GlobalClass.isNetworkConnected(OwnerDetailActivity.this)) {


                    WebAPiCall webapiCall = new WebAPiCall();
                    webapiCall.FetchAllottedetailsMethod(OwnerDetailActivity.this, OwnerDetailActivity.this, OwnerDetailActivity.this, request,binding.llmain);


                } else {

                    Toast.makeText(OwnerDetailActivity.this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
                }

                binding.mSwipeRefreshLayout.setRefreshing(false);

            }
        });


    }

    @Override
    public void initData() {
        binding.toolbar.tvToolbarTitle.setText("Owner Detail");
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
    public void allotteedetaildata(List<FetchAllottedetailsResponse.Datum> data) {


        PlotIdRequest request = new PlotIdRequest();

        request.setPlotID(PlotID);


        if (GlobalClass.isNetworkConnected(OwnerDetailActivity.this)) {

            WebAPiCall webapiCall = new WebAPiCall();
            webapiCall.FetchJointHolderMethod(this, this, OwnerDetailActivity.this, request);


        } else {

            Toast.makeText(this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
        }


        try {


            binding.edtOwnerfullName.setText(String.valueOf(data.get(0).getOriginalAllotteeName() + " " + data.get(0).getOriginalAllotteeSurname()));
            binding.edtFatherHusbandName.setText(String.valueOf(data.get(0).getOriginalAllotteeFatherName() + " " + data.get(0).getOriginalAllotteeFatherSurname()));

            binding.edtPermanentAddress1.setText(String.valueOf(data.get(0).getOriginalAllotteePermanentAddress1()));
            binding.edtPermanentAddress2.setText(String.valueOf(data.get(0).getOriginalAllotteePermanentAddress2()));
            binding.edtPermanentAddress3.setText(String.valueOf(data.get(0).getOriginalAllotteePermanentAddress3()));
            binding.edtPermanentState.setText(String.valueOf(data.get(0).getOriginalAllotteePermanentState()));
            binding.edtPermanentPinCode.setText(String.valueOf(data.get(0).getOriginalAllotteePermanentPIN()));

            binding.edtMobile.setText(String.valueOf(data.get(0).getOriginalAllotteeMobileNumber()));
            binding.edtEmailID.setText(String.valueOf(data.get(0).getOriginalAllotteeEmail()));
            binding.edtPanNo.setText(String.valueOf(data.get(0).getOriginalAllotteePancard()));
            binding.edtAadharNo.setText(String.valueOf(data.get(0).getOriginalAllotteeAadharNumber()));


            /*---present allottee detail---*/

            binding.edtPresentAllotteefullName.setText(String.valueOf(data.get(0).getPresentOwnerName() + " " + data.get(0).getPresentOwnerSurname()));
            binding.edtPresentFatherHusbandName.setText(String.valueOf(data.get(0).getPresentOwnerFatherName() + " " + data.get(0).getPresentOwnerFatherSurname()));


            binding.edtPresentAllotteePermanentAddress1.setText(String.valueOf(data.get(0).getPermanentAddress1()));
            binding.edtPresentAllotteePermanentAddress2.setText(String.valueOf(data.get(0).getPermanentAddress2()));
            binding.edtPresentAllotteePermanentAddress3.setText(String.valueOf(data.get(0).getPermanentAddress3()));
            binding.edtPresentAllotteePermanentState.setText(String.valueOf(data.get(0).getPermanentState()));
            binding.edtPresentAllotteePermanentPinCode.setText(String.valueOf(data.get(0).getPermanentPIN()));


            binding.edtCorrespondenceAddress1.setText(String.valueOf(data.get(0).getCorrespondenceAddress1()));
            binding.edtCorrespondenceAddress2.setText(String.valueOf(data.get(0).getCorrespondenceAddress2()));
            binding.edtCorrespondenceAddress3.setText(String.valueOf(data.get(0).getCorrespondenceAddress3()));
            binding.edtCorrespondenceState.setText(String.valueOf(data.get(0).getCorrespondenceState()));
            binding.edtCorrespondencePinCode.setText(String.valueOf(data.get(0).getCorrespondencePIN()));


            binding.edtPresentAllotteeMobile.setText(String.valueOf(data.get(0).getMobileNumber()));
            binding.edtPresentAllotteeEmailID.setText(String.valueOf(data.get(0).getEmail()));
            binding.edtPresentAllotteePanNo.setText(String.valueOf(data.get(0).getPancard()));
            binding.edtPresentAllotteeAadharNo.setText(String.valueOf(data.get(0).getAadharNumber()));


        } catch (Exception e) {

            e.printStackTrace();
        }


    }

    @Override
    public void allFetchJointHolderDetailsdata(List<FetchJointHolderDetailsResponse.JHolder> data) {

        if (data == null || data.isEmpty()) {

            binding.noJointHolder.setVisibility(View.VISIBLE);
            binding.RVCurrentJointHoldeDetails.setVisibility(View.GONE);
        } else {


            binding.noJointHolder.setVisibility(View.GONE);

            binding.RVCurrentJointHoldeDetails.setVisibility(View.VISIBLE);

            arrayList.clear();
            arrayList.addAll(data);

            RvfetchjointholderListAdapter adaptermain = new RvfetchjointholderListAdapter(this, (ArrayList) arrayList, this);
            binding.RVCurrentJointHoldeDetails.setAdapter(adaptermain);
            GridLayoutManager manager = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
            binding.RVCurrentJointHoldeDetails.setLayoutManager(manager);
        }

    }

    @Override
    public void allFetchdirecterdata(List<FetchJointHolderDetailsResponse.Gpa> data) {

        if (data == null || data.isEmpty()) {

            binding.noGpA.setVisibility(View.VISIBLE);
            binding.CurrentGPADirectorsPartners.setVisibility(View.GONE);
        } else {

            binding.noGpA.setVisibility(View.GONE);

            binding.CurrentGPADirectorsPartners.setVisibility(View.VISIBLE);


            arrayListGpa.clear();
            arrayListGpa.addAll(data);

            RvGpaDirectorsListAdapter adaptermain = new RvGpaDirectorsListAdapter(this, (ArrayList) arrayListGpa, this);
            binding.CurrentGPADirectorsPartners.setAdapter(adaptermain);
            GridLayoutManager manager = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
            binding.CurrentGPADirectorsPartners.setLayoutManager(manager);


        }


    }

    @Override
    public void onItemClick(FetchJointHolderDetailsResponse.JHolder item, int currposition) {


    }

    @Override
    public void onItemClick(FetchJointHolderDetailsResponse.Gpa item, int currposition) {

    }
}