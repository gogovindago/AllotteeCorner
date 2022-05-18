package hsvp.digital.allottee_corner.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import hsvp.digital.allottee_corner.R;
import hsvp.digital.allottee_corner.model.DepartmentDashboardResponse;


public class RvDepartmentdashboardListAdapter extends RecyclerView.Adapter<RvDepartmentdashboardListAdapter.ViewHolder> {

    ArrayList<DepartmentDashboardResponse.Datum> mValues = new ArrayList<DepartmentDashboardResponse.Datum>();


    Context mContext;
    protected ItemListener mListener;
    public int currposition;


    public RvDepartmentdashboardListAdapter(Context context, ArrayList values, ItemListener itemListener) {

        mValues = values;
        mContext = context;
        mListener = itemListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public int currposition;
        LinearLayout llrejected, lldisbursmentdone;
        public TextView txtschemeName, txtsessionvalue, txxcastValue,
                txttotalApplicationsvalue, txtApprovedbyCollegesvalue, txtapprovedbyuniversityvalue,
                txtapprovedbyHQvalue, txtDisbursementDonevalue,
                txtPendingatcollegevalue, textPendingatUniversitiesvalue,
                textPendingatHQvalue, txtRejectedvalue, textSentBackValue, textmoSJENSpApistatusValue;
        DepartmentDashboardResponse.Datum item;

        public ViewHolder(View v) {

            super(v);

            v.setOnClickListener(this);

            lldisbursmentdone = v.findViewById(R.id.lldisbursmentdone);
            llrejected = v.findViewById(R.id.llrejected);
            txttotalApplicationsvalue = v.findViewById(R.id.txttotalApplicationsvalue);
            txtschemeName = v.findViewById(R.id.txtschemeName);
            txtsessionvalue = v.findViewById(R.id.txtsessionvalue);
            txxcastValue = v.findViewById(R.id.txxcastValue);
            txtApprovedbyCollegesvalue = v.findViewById(R.id.txtApprovedbyCollegesvalue);
            txtapprovedbyuniversityvalue = v.findViewById(R.id.txtapprovedbyuniversityvalue);
            txtapprovedbyHQvalue = v.findViewById(R.id.txtapprovedbyHQvalue);
            txtDisbursementDonevalue = v.findViewById(R.id.txtDisbursementDonevalue);
            txtPendingatcollegevalue = v.findViewById(R.id.txtPendingatcollegevalue);
            textPendingatUniversitiesvalue = v.findViewById(R.id.textPendingatUniversitiesvalue);
            textPendingatHQvalue = v.findViewById(R.id.textPendingatHQvalue);
            txtRejectedvalue = v.findViewById(R.id.txtRejectedvalue);
            textSentBackValue = v.findViewById(R.id.textSentBackValue);
            textmoSJENSpApistatusValue = v.findViewById(R.id.textmoSJENSpApistatusValue);

        }

        public void setData(DepartmentDashboardResponse.Datum item, int currposition) {
            this.item = item;
            this.currposition = currposition;



            txtschemeName.setText(item.getDepartment());
            txtsessionvalue.setText(item.getAcademicSession());
            txxcastValue.setText(item.getCaste());
            txttotalApplicationsvalue.setText(String.valueOf(item.getTotalApplications()));
            txtApprovedbyCollegesvalue.setText(String.valueOf(item.getApprovedByColleges()));
            txtapprovedbyuniversityvalue.setText(String.valueOf(item.getApprovedByNB()));
            txtapprovedbyHQvalue.setText(String.valueOf(item.getApprovedByHQ()));
            txtDisbursementDonevalue.setText(String.valueOf(item.getDisbursement()));
            txtPendingatcollegevalue.setText(String.valueOf(item.getPendingAtCollege()));
            textPendingatUniversitiesvalue.setText(String.valueOf(item.getPendingAtNB()));
            textPendingatHQvalue.setText(String.valueOf(item.getPendingAtHQ()));
            txtRejectedvalue.setText(String.valueOf(item.getRejectedAtNB() + item.getRejectedAtHQ() + item.getRejectedAtColleges()));
            textSentBackValue.setText(String.valueOf(item.getSentBackAtColleges()));
            textmoSJENSpApistatusValue.setText(String.valueOf(item.getMoSJEAPIStatus()));


        }


        @Override
        public void onClick(View view) {
            if (mListener != null) {
                mListener.onItemClick(item, currposition);
            }
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.lib_department_dashboard_list_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        currposition = position;
        holder.setData(mValues.get(position), currposition);

    }


    @Override
    public int getItemCount() {

        return mValues.size();
    }

    public interface ItemListener {
        void onItemClick(DepartmentDashboardResponse.Datum item, int currposition);
    }
}