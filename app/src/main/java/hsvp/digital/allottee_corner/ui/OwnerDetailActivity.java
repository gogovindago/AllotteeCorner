package hsvp.digital.allottee_corner.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;

import java.util.List;

import hsvp.digital.allottee_corner.R;
import hsvp.digital.allottee_corner.allinterface.allotteedetailData_interface;
import hsvp.digital.allottee_corner.allinterface.allotteeplotedetailData_interface;
import hsvp.digital.allottee_corner.apicall.WebAPiCall;
import hsvp.digital.allottee_corner.databinding.ActivityOwnerDetailBinding;
import hsvp.digital.allottee_corner.model.AllotteplotdetailsResponse;
import hsvp.digital.allottee_corner.model.FetchAllottedetailsResponse;
import hsvp.digital.allottee_corner.model.PlotIdRequest;
import hsvp.digital.allottee_corner.utility.BaseActivity;
import hsvp.digital.allottee_corner.utility.CSPreferences;
import hsvp.digital.allottee_corner.utility.GlobalClass;

public class OwnerDetailActivity extends BaseActivity implements allotteedetailData_interface {
    ActivityOwnerDetailBinding binding;
    private String PlotID;


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
            webapiCall.FetchAllottedetailsMethod(this, this, OwnerDetailActivity.this, request);


        } else {

            Toast.makeText(this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
        }


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
}