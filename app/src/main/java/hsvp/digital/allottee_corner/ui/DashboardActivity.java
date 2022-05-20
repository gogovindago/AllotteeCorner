package hsvp.digital.allottee_corner.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;

import java.util.List;

import hsvp.digital.allottee_corner.R;
import hsvp.digital.allottee_corner.allinterface.allottecurrentoutstandingData_interface;
import hsvp.digital.allottee_corner.allinterface.allotteefutureoustandingData_interface;
import hsvp.digital.allottee_corner.allinterface.allotteeplotedetailData_interface;
import hsvp.digital.allottee_corner.apicall.WebAPiCall;
import hsvp.digital.allottee_corner.databinding.ActivityDashboardBinding;
import hsvp.digital.allottee_corner.model.AllotteCurrentOutStandingResponse;
import hsvp.digital.allottee_corner.model.AllottefutureOutStandingResponse;
import hsvp.digital.allottee_corner.model.AllotteplotdetailsResponse;
import hsvp.digital.allottee_corner.model.PlotIdRequest;
import hsvp.digital.allottee_corner.utility.BaseActivity;
import hsvp.digital.allottee_corner.utility.CSPreferences;
import hsvp.digital.allottee_corner.utility.GlobalClass;

public class DashboardActivity extends BaseActivity implements allottecurrentoutstandingData_interface, allotteefutureoustandingData_interface, allotteeplotedetailData_interface {
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

        PlotIdRequest request = new PlotIdRequest();

        request.setPlotID(PlotID);


        if (GlobalClass.isNetworkConnected(DashboardActivity.this)) {

            WebAPiCall webapiCall = new WebAPiCall();
            webapiCall.allottefutureOutStandingAPiMethod(this, this, DashboardActivity.this, request);


        } else {

            Toast.makeText(this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
        }


    }


    @Override
    public void allotteefutureoustandingdata(List<AllottefutureOutStandingResponse.Datum> data) {


        binding.edtFutureOutstanding.setText(String.valueOf(data.get(0).getAmount()));


        PlotIdRequest request = new PlotIdRequest();

        request.setPlotID(PlotID);


        if (GlobalClass.isNetworkConnected(DashboardActivity.this)) {

            WebAPiCall webapiCall = new WebAPiCall();
            webapiCall.allotteplotdetailsMethod(this, this, DashboardActivity.this, request);


        } else {

            Toast.makeText(this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
        }


    }


    @Override
    public void allotteeplotedetaildata(List<AllotteplotdetailsResponse.Datum> data) {


        try {

            binding.edtOwnerfullName.setText(data.get(0).getPresentOwnerName() + "  " + data.get(0).getPresentOwnerSurname());
            binding.edtFatherHusbandName.setText(data.get(0).getPresentOwnerFatherName() + "  " + data.get(0).getPresentOwnerFatherSurname());
            binding.edtUrbanEstateName.setText(data.get(0).getUrbanEstateName());
            binding.edtAllotted.setText(data.get(0).getPlotStatus());
            binding.edtSector.setText(data.get(0).getSectorId());
            binding.edtCategory.setText(data.get(0).getCategoryName());
            binding.edtSubCategory.setText(data.get(0).getSubCategoryName());
            binding.edtPlotNo.setText(data.get(0).getPlotNumber());
            binding.edtArea.setText(String.valueOf(data.get(0).getPlotArea()));
            binding.edtstatus.setText(String.valueOf(data.get(0).getPlotStatus()));
            binding.edtMobile.setText(String.valueOf(data.get(0).getMobileNumber()));

            CSPreferences.putString(this, "PhoneNo", String.valueOf(data.get(0).getMobileNumber()));

            binding.edtEmailID.setText(String.valueOf(data.get(0).getEmail()));
            binding.edtPanNo.setText(String.valueOf(data.get(0).getPancard()));
            binding.edtAadharNo.setText(String.valueOf(data.get(0).getAadharNumber()));


            binding.edtPermanentAddress1.setText(String.valueOf(data.get(0).getPermanentAddress1()));
            binding.edtPermanentAddress2.setText(String.valueOf(data.get(0).getPermanentAddress2()));
            binding.edtPermanentAddress3.setText(String.valueOf(data.get(0).getPermanentAddress3()));
            binding.edtPermanentState.setText(String.valueOf(data.get(0).getPermanentState()));
            binding.edtPermanentPinCode.setText(String.valueOf(data.get(0).getPermanentPIN()));


            binding.edtCorrespondenceAddress1.setText(String.valueOf(data.get(0).getCorrespondenceAddress1()));
            binding.edtCorrespondenceAddress2.setText(String.valueOf(data.get(0).getCorrespondenceAddress2()));
            binding.edtCorrespondenceAddress3.setText(String.valueOf(data.get(0).getCorrespondenceAddress3()));
            binding.edtCorrespondenceState.setText(String.valueOf(data.get(0).getCorrespondenceState()));
            binding.edtCorrespondencePinCode.setText(String.valueOf(data.get(0).getCorrespondencePIN()));


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}