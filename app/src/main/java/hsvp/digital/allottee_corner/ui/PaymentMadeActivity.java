package hsvp.digital.allottee_corner.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import hsvp.digital.allottee_corner.R;
import hsvp.digital.allottee_corner.adapter.ExpandableListAdapter;
import hsvp.digital.allottee_corner.allinterface.allottePaymentReceived2Data_interface;
import hsvp.digital.allottee_corner.allinterface.allottePaymentReceivedData_interface;
import hsvp.digital.allottee_corner.allinterface.allottePaymentReceivedDetailsData_interface;
import hsvp.digital.allottee_corner.apicall.WebAPiCall;
import hsvp.digital.allottee_corner.databinding.ActivityPaymentmadeBinding;
import hsvp.digital.allottee_corner.model.AllottePaymentReceived2Response;
import hsvp.digital.allottee_corner.model.AllottePaymentReceivedDetailsResponse;
import hsvp.digital.allottee_corner.model.AllottePaymentReceivedResponse;
import hsvp.digital.allottee_corner.model.PlotIdRequest;
import hsvp.digital.allottee_corner.utility.BaseActivity;
import hsvp.digital.allottee_corner.utility.CSPreferences;
import hsvp.digital.allottee_corner.utility.GlobalClass;

public class PaymentMadeActivity extends BaseActivity implements allottePaymentReceivedData_interface, allottePaymentReceivedDetailsData_interface, allottePaymentReceived2Data_interface {
    ActivityPaymentmadeBinding binding;

    ExpandableListAdapter listAdapter;
    //  ExpandableListView ExpdblListview;

    private String PlotID;
    //   List<String> listDataHeader;
    private List<AllottePaymentReceived2Response.Payment> listDataHeader = new ArrayList<AllottePaymentReceived2Response.Payment>();

    List<AllottePaymentReceived2Response.PaymentDetail> arrayList = new ArrayList<AllottePaymentReceived2Response.PaymentDetail>();
    HashMap<List<AllottePaymentReceived2Response.Payment>, List<AllottePaymentReceived2Response.PaymentDetail>> listDataChild;


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
            // webapiCall.allottePaymentReceivedMethod(PaymentMadeActivity.this, PaymentMadeActivity.this, PaymentMadeActivity.this, request);
            webapiCall.AllottePaymentReceived2Method(PaymentMadeActivity.this, PaymentMadeActivity.this, PaymentMadeActivity.this, request);


        } else {

            Toast.makeText(PaymentMadeActivity.this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
        }


        //   setContentView(R.layout.activity_paymentmade);

        // get the listview
        //   binding.ExpdblListview = (ExpandableListView) findViewById(R.id.ExpdblListview);

        // preparing list data
        //   prepareListData();

//        listAdapter = new ExpandableListAdapter(PaymentMadeActivity.this, listDataHeader, listDataChild);
//
//        // setting list adapter
//        binding.ExpdblListview.setAdapter(listAdapter);

        // Listview Group click listener
        binding.ExpdblListview.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {


//
//                Toast.makeText(getApplicationContext(),
//                        "Group Clicked " + listDataHeader.get(groupPosition).getPaymentDate(),
//                        Toast.LENGTH_SHORT).show();


                return false;
            }
        });

        // Listview Group expanded listener
        binding.ExpdblListview.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {

//
//                Toast.makeText(getApplicationContext(),
//                        listDataHeader.get(groupPosition).getPaymentDate() + " Expanded",
//                        Toast.LENGTH_SHORT).show();
//

            }
        });

        // Listview Group collasped listener
        binding.ExpdblListview.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
//                Toast.makeText(getApplicationContext(),
//                        listDataHeader.get(groupPosition) + " Collapsed",
//                        Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on child click listener
        binding.ExpdblListview.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
//                Toast.makeText(
//                                getApplicationContext(),
//                                listDataHeader.get(groupPosition)
//                                        + " : "
//                                        + listDataChild.get(
//                                        listDataHeader.get(groupPosition)).get(
//                                        childPosition), Toast.LENGTH_SHORT)
//                        .show();
                return false;
            }
        });
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {


//       // Adding child data
//        listDataHeader.add("Top 250");
//        listDataHeader.add("Now Showing");
//        listDataHeader.add("Coming Soon..");

     /*   // Adding child data
        List<AllottePaymentReceivedDetailsResponse.Datum> top250 = new ArrayList<AllottePaymentReceivedDetailsResponse.Datum>();
        top250.add("The Shawshank Redemption");
        top250.add("The Godfather");
        top250.add("The Godfather: Part II");
        top250.add("Pulp Fiction");
        top250.add("The Good, the Bad and the Ugly");
        top250.add("The Dark Knight");
        top250.add("12 Angry Men");

        List<AllottePaymentReceivedDetailsResponse.Datum> nowShowing = new ArrayList<AllottePaymentReceivedDetailsResponse.Datum>();
        nowShowing.add("The Conjuring");
        nowShowing.add("Despicable Me 2");
        nowShowing.add("Turbo");
        nowShowing.add("Grown Ups 2");
        nowShowing.add("Red 2");
        nowShowing.add("The Wolverine");

        List<AllottePaymentReceivedDetailsResponse.Datum> comingSoon = new ArrayList<AllottePaymentReceivedDetailsResponse.Datum>();
        comingSoon.add("2 Guns");
        comingSoon.add("The Smurfs 2");
        comingSoon.add("The Spectacular Now");
        comingSoon.add("The Canyons");
        comingSoon.add("Europa Report");
*/
//        listDataChild = new HashMap<List<AllottePaymentReceivedResponse.Datum>, List<AllottePaymentReceivedDetailsResponse.Datum>>();
//        listDataChild.put(listDataHeader, (List<AllottePaymentReceivedDetailsResponse.Datum>) listDataChild); // Header, Child data
//        listDataChild.put(listDataHeader.get(1), "nowShowing");
//        listDataChild.put(listDataHeader.get(2), "comingSoon");
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


    }

    @Override
    public void allottePayment2data(List<AllottePaymentReceived2Response.Payment> data) {

        listDataHeader.clear();
        listDataHeader.addAll(data);
    }

    @Override
    public void allottePaymentDetail2data(List<AllottePaymentReceived2Response.PaymentDetail> data) {



        listDataChild = new HashMap<List<AllottePaymentReceived2Response.Payment>, List<AllottePaymentReceived2Response.PaymentDetail>>();

        listDataChild.put(listDataHeader, data);

        //  prepareListData();
        listAdapter = new ExpandableListAdapter(PaymentMadeActivity.this, listDataHeader, listDataChild);

        // setting list adapter
        binding.ExpdblListview.setAdapter(listAdapter);


    }
}