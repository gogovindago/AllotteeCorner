package hsvp.digital.allottee_corner.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import hsvp.digital.allottee_corner.R;
import hsvp.digital.allottee_corner.adapter.RvPaymentMadeDetailListAdapter;
import hsvp.digital.allottee_corner.adapter.RvPaymentMadeListAdapter;
import hsvp.digital.allottee_corner.allinterface.allottePaymentReceived2Data_interface;
import hsvp.digital.allottee_corner.allinterface.allottePaymentReceivedData_interface;
import hsvp.digital.allottee_corner.allinterface.allottePaymentReceivedDetailsData_interface;
import hsvp.digital.allottee_corner.apicall.WebAPiCall;
import hsvp.digital.allottee_corner.databinding.ActivityPaymentmadeBinding;
import hsvp.digital.allottee_corner.model.AllottePaymentReceived2Response;
import hsvp.digital.allottee_corner.model.AllottePaymentReceivedDetailsResponse;
import hsvp.digital.allottee_corner.model.AllottePaymentReceivedResponse;
import hsvp.digital.allottee_corner.model.PaymentReceivedDetailsRequest;
import hsvp.digital.allottee_corner.model.PlotIdRequest;
import hsvp.digital.allottee_corner.utility.BaseActivity;
import hsvp.digital.allottee_corner.utility.CSPreferences;
import hsvp.digital.allottee_corner.utility.GlobalClass;

public class PaymentMadeActivity extends BaseActivity implements allottePaymentReceivedData_interface, allottePaymentReceivedDetailsData_interface, allottePaymentReceived2Data_interface, RvPaymentMadeListAdapter.ItemListener, RvPaymentMadeDetailListAdapter.ItemListener {
    ActivityPaymentmadeBinding binding;


    private String PlotID;
    //   List<String> listDataHeader;
    private List<AllottePaymentReceived2Response.Payment> listDataHeader = new ArrayList<AllottePaymentReceived2Response.Payment>();

    List<AllottePaymentReceivedResponse.Datum> arrayList2 = new ArrayList<AllottePaymentReceivedResponse.Datum>();
    List<AllottePaymentReceivedDetailsResponse.Datum> arrayList3 = new ArrayList<AllottePaymentReceivedDetailsResponse.Datum>();

    List<AllottePaymentReceived2Response.PaymentDetail> arrayList = new ArrayList<AllottePaymentReceived2Response.PaymentDetail>();
    HashMap<List<AllottePaymentReceived2Response.Payment>, List<AllottePaymentReceived2Response.PaymentDetail>> listDataChild;
    private PopupWindow popupWindow;
    private LayoutInflater layoutInflater;
    private RecyclerView lst;
    private CustomListViewDialog customDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_paymentmade);

        try {
            PlotID = CSPreferences.readString(this, "User_Name");
        } catch (Exception e) {
            e.printStackTrace();
        }


        PlotIdRequest request = new PlotIdRequest();

        request.setPlotID(PlotID);


        if (GlobalClass.isNetworkConnected(PaymentMadeActivity.this)) {


            WebAPiCall webapiCall = new WebAPiCall();
            webapiCall.allottePaymentReceivedMethod(PaymentMadeActivity.this, PaymentMadeActivity.this, PaymentMadeActivity.this, request);
            //  webapiCall.AllottePaymentReceived2Method(PaymentMadeActivity.this, PaymentMadeActivity.this, PaymentMadeActivity.this, request);


        } else {

            Toast.makeText(PaymentMadeActivity.this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
        }


    }


    @Override
    public void initData() {
        binding.toolbar.tvToolbarTitle.setText("Payment Made");
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
    public void allottePaymentReceiveddata(List<AllottePaymentReceivedResponse.Datum> data) {


        arrayList2.clear();
        arrayList2.addAll(data);

        RvPaymentMadeListAdapter adaptermain = new RvPaymentMadeListAdapter(this, (ArrayList) arrayList2, this);
        binding.RvpaymentMade.setAdapter(adaptermain);
        GridLayoutManager manager = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
        binding.RvpaymentMade.setLayoutManager(manager);



/*
        listDataHeader.clear();

        listDataHeader.addAll(data);


        PaymentReceivedDetailsRequest detailsRequest = new PaymentReceivedDetailsRequest();

        detailsRequest.setPlotID(PlotID);
        detailsRequest.setPaymentID(String.valueOf(data.get(0).getPaymentId()));


        if (GlobalClass.isNetworkConnected(PaymentMadeActivity.this)) {


            WebAPiCall webapiCall = new WebAPiCall();
            webapiCall.allottePaymentReceivedDetailsMethod(PaymentMadeActivity.this, PaymentMadeActivity.this, PaymentMadeActivity.this, detailsRequest);


        } else {

            Toast.makeText(PaymentMadeActivity.this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
        }*/

    }

    @Override
    public void allottePaymentReceivedDetailsdata(List<AllottePaymentReceivedDetailsResponse.Datum> data) {


        arrayList3.clear();
        arrayList3.addAll(data);








        RvPaymentMadeDetailListAdapter dataAdapter = new RvPaymentMadeDetailListAdapter(PaymentMadeActivity.this, (ArrayList) arrayList3,PaymentMadeActivity.this);
        customDialog = new CustomListViewDialog(PaymentMadeActivity.this, dataAdapter);

        customDialog.show();
        customDialog.setCanceledOnTouchOutside(false);




      /*  container.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                popupWindow.dismiss();
                return false;
            }
        });*/


    }

    @Override
    public void allottePayment2data(List<AllottePaymentReceived2Response.Payment> data) {

        listDataHeader.clear();
        listDataHeader.addAll(data);


    }

    @Override
    public void allottePaymentDetail2data(List<AllottePaymentReceived2Response.PaymentDetail> data) {

//
//        listDataChild = new HashMap<List<AllottePaymentReceived2Response.Payment>, List<AllottePaymentReceived2Response.PaymentDetail>>();
//
//        listDataChild.put(listDataHeader, data);
//
//        //  prepareListData();
//        listAdapter = new ExpandableListAdapter(PaymentMadeActivity.this, listDataHeader, listDataChild);
//
//        // setting list adapter
//        binding.ExpdblListview.setAdapter(listAdapter);


    }

    @Override
    public void onItemClick(AllottePaymentReceivedResponse.Datum data, int currposition) {


        PaymentReceivedDetailsRequest detailsRequest = new PaymentReceivedDetailsRequest();

        detailsRequest.setPlotID(PlotID);
        detailsRequest.setPaymentID(String.valueOf(data.getPaymentId()));


        if (GlobalClass.isNetworkConnected(PaymentMadeActivity.this)) {


            WebAPiCall webapiCall = new WebAPiCall();
            webapiCall.allottePaymentReceivedDetailsMethod(PaymentMadeActivity.this, PaymentMadeActivity.this, PaymentMadeActivity.this, detailsRequest);


        } else {

            Toast.makeText(PaymentMadeActivity.this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
        }


    }

    @Override
    public void onItemClick(AllottePaymentReceivedDetailsResponse.Datum item, int currposition) {

    }
}