package hsvp.digital.allottee_corner.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import hsvp.digital.allottee_corner.R;
import hsvp.digital.allottee_corner.model.CollegeListResponse;


public class CollegeInstituteAdapter extends BaseAdapter {
    Context context;
    private List<CollegeListResponse.Datum> coursetypelist = new ArrayList<CollegeListResponse.Datum>();

    LayoutInflater inflter;

    public CollegeInstituteAdapter(Context applicationContext, List<CollegeListResponse.Datum> coursetypelist) {
        this.context = applicationContext;
        this.coursetypelist = coursetypelist;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return coursetypelist.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.custom_spinner_items, null);
        ImageView icon = (ImageView) view.findViewById(R.id.imageView);
        TextView names = (TextView) view.findViewById(R.id.textView);
        icon.setImageResource(R.drawable.ic_baseline_business_24);
        names.setText(coursetypelist.get(i).getCollege());
        return view;
    }
}