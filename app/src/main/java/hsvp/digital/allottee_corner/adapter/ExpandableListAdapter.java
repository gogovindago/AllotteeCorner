package hsvp.digital.allottee_corner.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import hsvp.digital.allottee_corner.R;
import hsvp.digital.allottee_corner.model.AllottePaymentReceivedDetailsResponse;
import hsvp.digital.allottee_corner.model.AllottePaymentReceivedResponse;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context _context;
    private List<AllottePaymentReceivedResponse.Datum> _listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<List<AllottePaymentReceivedResponse.Datum>, List<AllottePaymentReceivedDetailsResponse.Datum>> _listDataChild;

    public ExpandableListAdapter(Context context, List<AllottePaymentReceivedResponse.Datum> listDataHeader,
                                 HashMap<List<AllottePaymentReceivedResponse.Datum>, List<AllottePaymentReceivedDetailsResponse.Datum>> listChildData) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

      final AllottePaymentReceivedDetailsResponse.Datum childText = (AllottePaymentReceivedDetailsResponse.Datum) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_item, null);
        }

        TextView txtListChild = (TextView) convertView
                .findViewById(R.id.lblListItem);

        txtListChild.setText(_listDataChild.get(groupPosition).get(childPosition).getPlotId());
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return _listDataChild.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        // AllottePaymentReceivedDetailsResponse.Datum headerTitle =  getGroup(groupPosition);

        // AllottePaymentReceivedDetailsResponse.Datum headerTitle = AllottePaymentReceivedDetailsResponse.Datum.valueOf(_listDataHeader.get(groupPosition).getPaydate());

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group, null);
        }
        TextView lblListHeader, lblListHeader2, lblListHeader3, lblListHeader4;

        lblListHeader = (TextView) convertView
                .findViewById(R.id.lblListHeader);

        lblListHeader2 = (TextView) convertView
                .findViewById(R.id.lblListHeader2);
        lblListHeader3 = (TextView) convertView
                .findViewById(R.id.lblListHeader3);
        lblListHeader4 = (TextView) convertView
                .findViewById(R.id.lblListHeader4);


        lblListHeader.setTypeface(null, Typeface.BOLD);


        lblListHeader.setText(_listDataHeader.get(groupPosition).getPaydate());

        lblListHeader2.setText(String.valueOf(_listDataHeader.get(groupPosition).getPaymentAmount()));
        lblListHeader3.setText(String.valueOf(_listDataHeader.get(groupPosition).getPaymentFlag()));
        lblListHeader4.setText(_listDataHeader.get(groupPosition).getPaymentReceiptMemoNumber());

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}