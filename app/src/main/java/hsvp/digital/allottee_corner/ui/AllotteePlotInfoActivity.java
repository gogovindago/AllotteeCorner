package hsvp.digital.allottee_corner.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.List;

import hsvp.digital.allottee_corner.R;
import hsvp.digital.allottee_corner.allinterface.allotteePlotInfoData_interface;
import hsvp.digital.allottee_corner.apicall.WebAPiCall;
import hsvp.digital.allottee_corner.databinding.ActivityAllotteeplotinfoBinding;
import hsvp.digital.allottee_corner.model.AllottePlotInfoResponse;
import hsvp.digital.allottee_corner.model.PlotIdRequest;
import hsvp.digital.allottee_corner.utility.BaseActivity;
import hsvp.digital.allottee_corner.utility.CSPreferences;
import hsvp.digital.allottee_corner.utility.GlobalClass;

public class AllotteePlotInfoActivity extends BaseActivity implements allotteePlotInfoData_interface {
    ActivityAllotteeplotinfoBinding binding;
    private String PlotID, U_Name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_allotteeplotinfo);


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


                if (GlobalClass.isNetworkConnected(AllotteePlotInfoActivity.this)) {


                    WebAPiCall webapiCall = new WebAPiCall();
                    webapiCall.allottePlotInfoMethod(AllotteePlotInfoActivity.this, AllotteePlotInfoActivity.this, AllotteePlotInfoActivity.this, request, binding.llmain);


                } else {

                    Toast.makeText(AllotteePlotInfoActivity.this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
                }

                binding.mSwipeRefreshLayout.setRefreshing(false);

            }
        });


        if (GlobalClass.isNetworkConnected(AllotteePlotInfoActivity.this)) {

            WebAPiCall webapiCall = new WebAPiCall();
            webapiCall.allottePlotInfoMethod(this, this, AllotteePlotInfoActivity.this, request, binding.llmain);


        } else {

            Toast.makeText(this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void initData() {


        try {
            PlotID = CSPreferences.readString(this, "User_Name");
            U_Name = CSPreferences.readString(this, "U_Name");


        } catch (Exception e) {
            e.printStackTrace();
        }
        binding.toolbar.tvToolbarTitle.setText(U_Name + " Plot - " + PlotID + "  Detail");
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
    public void AllottePlotInfodata(List<AllottePlotInfoResponse.Datum> data) {

        if (data == null || data.isEmpty()) {

            binding.noAllotteeNotice.setVisibility(View.VISIBLE);
            binding.llmain.setVisibility(View.GONE);

        } else {

            binding.noAllotteeNotice.setVisibility(View.GONE);
            binding.llmain.setVisibility(View.VISIBLE);

            binding.edtUrbanEstateName.setText(String.valueOf(data.get(0).getUrbanEstateName()));
            binding.edtSector.setText(String.valueOf(data.get(0).getSectorId()));
            binding.edtPlotNo.setText(String.valueOf(data.get(0).getPlotNumber()));
            binding.edtCategory.setText(String.valueOf(data.get(0).getCategoryName()));
            binding.edtSubCategory.setText(String.valueOf(data.get(0).getSubCategoryName()));
            binding.edtTypeofProperty.setText(String.valueOf(data.get(0).getTypeOfProperty()));
            binding.edtTotalCostofProperty.setText(String.valueOf(data.get(0).getTotalCost()));
            binding.edtEnhancementCost.setText(String.valueOf(data.get(0).getEnhancementCost()));
            binding.edtstatus.setText(String.valueOf(data.get(0).getPlotStatus()));


            binding.edtTypeofInstalment.setText(String.valueOf(data.get(0).getTypeOfInstalment()));
            binding.edtNoofInstalment.setText(String.valueOf(data.get(0).getNumberOfInstalment()));
            binding.edtModeofAllotment.setText(String.valueOf(data.get(0).getModeOfAllotmentDesc()));
            binding.edtCourtCaseStatus.setText(String.valueOf(data.get(0).getCourtCaseStatus()));
            binding.edtUnderMortgageStatus.setText(String.valueOf(data.get(0).getUnderMortgageStatus()));
            binding.edtUnderMisuseStatus.setText(String.valueOf(data.get(0).getUnderMisuseStatus()));
            binding.edtDateofAllotment.setText(String.valueOf(data.get(0).getAllotmentDate()));
            binding.edtOfferofPossessionDate.setText(String.valueOf(data.get(0).getOfferOfPossessionDate()));
            binding.edtPossessionDate.setText(String.valueOf(data.get(0).getPossessionDate()));
            binding.edtBuildingPlanSanctionDate.setText(String.valueOf(data.get(0).getBuildingPlanSanctionDate()));

        }

    }
}