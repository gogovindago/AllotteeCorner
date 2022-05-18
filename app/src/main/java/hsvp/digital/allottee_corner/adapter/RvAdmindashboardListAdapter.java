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
import hsvp.digital.allottee_corner.model.AdminDashboardResponse;


public class RvAdmindashboardListAdapter extends RecyclerView.Adapter<RvAdmindashboardListAdapter.ViewHolder> {

    ArrayList<AdminDashboardResponse.Datum> mValues = new ArrayList<AdminDashboardResponse.Datum>();


    String Department, AcademicSession;
    Context mContext;
    protected ItemListener mListener;
    public int currposition;
    int totalApplications = 0, ApprovedbyColleges = 0, approvedbyuniversity = 0, approvedbyHQ = 0,
            DisbursementDone = 0, Pendingatcollege = 0,
            PendingatUniversities = 0, PendingatHQ = 0, Rejected = 0, SentBack = 0, moSJENSpApistatus = 0;


    public RvAdmindashboardListAdapter(Context context, ArrayList values, ItemListener itemListener) {

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
        AdminDashboardResponse.Datum item;

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

        public void setData(AdminDashboardResponse.Datum item, int currposition) {
            this.item = item;
            this.currposition = currposition;


         /*  // totalApplications = totalApplications + item.getTotalApplications();
            ApprovedbyColleges = ApprovedbyColleges + item.getApprovedByColleges();
            approvedbyuniversity = approvedbyuniversity + item.getApprovedByNB();
            approvedbyHQ = approvedbyHQ + item.getApprovedByHQ();
            DisbursementDone = DisbursementDone + item.getDisbursement();
            Pendingatcollege = Pendingatcollege + item.getPendingAtCollege();
            PendingatUniversities = PendingatUniversities + item.getPendingAtNB();
            PendingatHQ = PendingatHQ + item.getPendingAtHQ();
            Rejected = Rejected + item.getRejected();
            SentBack = SentBack + item.getSentBack();
            moSJENSpApistatus = moSJENSpApistatus + item.getMoSJEAPIStatus();

             Department = item.getDepartment();
             AcademicSession = item.getAcademicSession();

*/

//
//            if (item.getSchemeId() == 6) {
//                txtschemeName.setText(item.getDepartment());
//                txtsessionvalue.setText(item.getAcademicSession());
//                txxcastValue.setText(item.getCaste());
//                txttotalApplicationsvalue.setText(String.valueOf(item.getTotalApplications()));
//                txtApprovedbyCollegesvalue.setText(String.valueOf(item.getApprovedByColleges()));
//                txtapprovedbyuniversityvalue.setText(String.valueOf(item.getApprovedByNB()));
//                txtapprovedbyHQvalue.setText(String.valueOf(item.getApprovedByHQ()));
//                txtDisbursementDonevalue.setText(String.valueOf(item.getDisbursement()));
//                txtPendingatcollegevalue.setText(String.valueOf(item.getPendingAtCollege()));
//                textPendingatUniversitiesvalue.setText(String.valueOf(item.getPendingAtNB()));
//                textPendingatHQvalue.setText(String.valueOf(item.getPendingAtHQ()));
//                txtRejectedvalue.setText(String.valueOf(item.getRejected()));
//                textSentBackValue.setText(String.valueOf(item.getSentBack()));
//                textmoSJENSpApistatusValue.setText(String.valueOf(item.getMoSJEAPIStatus()));
//
//                // txtRejectedvalue.setTextColor(mContext.getResources().getColor(R.color.red_btn_bg_color));
////                llrejected.setBackgroundColor(mContext.getResources().getColor(R.color.red));
////                lldisbursmentdone.setBackgroundColor(mContext.getResources().getColor(R.color.green));
//
//
//            }else {

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
            txtRejectedvalue.setText(String.valueOf(item.getRejected()));
            textSentBackValue.setText(String.valueOf(item.getSentBack()));
            textmoSJENSpApistatusValue.setText(String.valueOf(item.getMoSJEAPIStatus()));

            //  }

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

        View view = LayoutInflater.from(mContext).inflate(R.layout.lib_admindashboard_list_row, parent, false);

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
        void onItemClick(AdminDashboardResponse.Datum item, int currposition);
    }
}