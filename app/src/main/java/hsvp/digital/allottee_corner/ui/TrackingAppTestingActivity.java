package hsvp.digital.allottee_corner.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import hsvp.digital.allottee_corner.R;

public class TrackingAppTestingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking_app_testing);

    }

    public void OrderPlaced(View view) {
        //startActivity(new Intent(TrackingAppTestingActivity.this,TrackActivity.class));
        String orderStatus = "0";
        Intent intent = new Intent(TrackingAppTestingActivity.this, TrackActivity.class);
        intent.putExtra("orderStatus", orderStatus);
        startActivity(intent);
    }

    public void OrderConfirmed(View view) {
        String orderStatus = "1";
        Intent intent = new Intent(TrackingAppTestingActivity.this, TrackActivity.class);
        intent.putExtra("orderStatus", orderStatus);
        startActivity(intent);
    }

    public void OrderProcessed(View view) {
        String orderStatus = "2";
        Intent intent = new Intent(TrackingAppTestingActivity.this, TrackActivity.class);
        intent.putExtra("orderStatus", orderStatus);
        startActivity(intent);
    }

    public void OrderPickup(View view) {
        String orderStatus = "3";
        Intent intent = new Intent(TrackingAppTestingActivity.this, TrackActivity.class);
        intent.putExtra("orderStatus", orderStatus);
        startActivity(intent);
    }


}