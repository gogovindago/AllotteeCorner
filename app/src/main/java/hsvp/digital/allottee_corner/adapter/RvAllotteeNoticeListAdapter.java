package hsvp.digital.allottee_corner.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import hsvp.digital.allottee_corner.R;
import hsvp.digital.allottee_corner.model.AllotteNoticesResponse;


public class RvAllotteeNoticeListAdapter extends RecyclerView.Adapter<RvAllotteeNoticeListAdapter.ViewHolder> {

    ArrayList<AllotteNoticesResponse.Datum> mValues = new ArrayList<AllotteNoticesResponse.Datum>();


    Context mContext;
    protected ItemListener mListener;
    public int currposition;


    public RvAllotteeNoticeListAdapter(Context context, ArrayList values, ItemListener itemListener) {

        mValues = values;
        mContext = context;
        mListener = itemListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public int currposition;
        public TextView PlotId, NoticeSectioNumber, NoticeDate, SurveyDate, ActionStatus, NoticeMemoNumber, PenaltyAmount;
        AllotteNoticesResponse.Datum item;

        public ViewHolder(View v) {

            super(v);

            v.setOnClickListener(this);

/*
#	Plot Id	Notice Section Number	Notice Date	Survey Date	Action Status	Notice Memo Number	Penalty Amount

*/
            PlotId = v.findViewById(R.id.txtownerName);
            NoticeSectioNumber = v.findViewById(R.id.txtownertypevalue);
            NoticeDate = v.findViewById(R.id.txtFathernameValue);
            SurveyDate = v.findViewById(R.id.txtMobilevalue);
            ActionStatus = v.findViewById(R.id.txtEmailvalue);
            NoticeMemoNumber = v.findViewById(R.id.txtPanvalue);
            PenaltyAmount = v.findViewById(R.id.txtAadharvalue);

        }

        public void setData(AllotteNoticesResponse.Datum item, int currposition) {
            this.item = item;
            this.currposition = currposition;


            try {
                PlotId.setText(String.valueOf(++currposition) + ". plot Id - " + item.getPlotId());
                NoticeSectioNumber.setText(String.valueOf(item.getNoticeSectionNumber()));
                NoticeDate.setText(String.valueOf(item.getNoticeDate()));
                SurveyDate.setText(String.valueOf(item.getNoticeDate()));
                ActionStatus.setText(String.valueOf(item.getActionStatus()));
                NoticeMemoNumber.setText(String.valueOf(item.getNoticeMemoNumber()));
                PenaltyAmount.setText(String.valueOf(item.getPenaltyAmount()));

            } catch (Exception e) {
                e.printStackTrace();
            }
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

        View view = LayoutInflater.from(mContext).inflate(R.layout.allotteenotice_list_row, parent, false);

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
        void onItemClick(AllotteNoticesResponse.Datum item, int currposition);
    }
}