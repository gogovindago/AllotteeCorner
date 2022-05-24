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
import hsvp.digital.allottee_corner.model.AlloteeHistoryResponse;


public class RvAllotteeHistoryListAdapter extends RecyclerView.Adapter<RvAllotteeHistoryListAdapter.ViewHolder> {

    ArrayList<AlloteeHistoryResponse.Datum> mValues = new ArrayList<AlloteeHistoryResponse.Datum>();


    Context mContext;
    protected ItemListener mListener;
    public int currposition;


    public RvAllotteeHistoryListAdapter(Context context, ArrayList values, ItemListener itemListener) {

        mValues = values;
        mContext = context;
        mListener = itemListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public int currposition;
        public TextView PlotId, txtFathernameValue, txtownertypevalue, txtPermanentAddress1value, textCorrespondenceAddress1Value,
                txtGendervalue, txtMaritalStatusvalue, txtPreviousAllotmentDatevalue,
                textPreviousRReasonChangeDescvalue, txtPreviousReasonChangevalue, txtPreviousChangeDatevalue, textPreviousTransferModeValue, textPreviousTransferModeDescValue;
        AlloteeHistoryResponse.Datum item;

        public ViewHolder(View v) {

            super(v);

            v.setOnClickListener(this);

/*
#	PreviousOwnerName	Father Name	Gender	Marital Status

Permanent Address

	Correspondence Address


	Previous Allotment Date	Previous Reason Change

	PreviousR Reason Change Desc


Previous Change Date	Previous Transfer Mode

	PreviousTransferModeDesc

*/
            textPreviousTransferModeDescValue = v.findViewById(R.id.textPreviousTransferModeDescValue);
            txtPreviousChangeDatevalue = v.findViewById(R.id.txtPreviousChangeDatevalue);
            textPreviousRReasonChangeDescvalue = v.findViewById(R.id.textPreviousRReasonChangeDescvalue);
            txtPreviousReasonChangevalue = v.findViewById(R.id.txtPreviousReasonChangevalue);
            txtPreviousAllotmentDatevalue = v.findViewById(R.id.txtPreviousAllotmentDatevalue);
            txtMaritalStatusvalue = v.findViewById(R.id.txtMaritalStatusvalue);
            txtGendervalue = v.findViewById(R.id.txtGendervalue);
            PlotId = v.findViewById(R.id.txtownerName);
            txtFathernameValue = v.findViewById(R.id.txtFathernameValue);
            txtownertypevalue = v.findViewById(R.id.txtownertypevalue);
            txtPermanentAddress1value = v.findViewById(R.id.txtPermanentAddress1value);
            textCorrespondenceAddress1Value = v.findViewById(R.id.textCorrespondenceAddress1Value);
            textPreviousTransferModeValue = v.findViewById(R.id.textPreviousTransferModeValue);

        }

        public void setData(AlloteeHistoryResponse.Datum item, int currposition) {
            this.item = item;
            this.currposition = currposition;


            try {
                PlotId.setText(String.valueOf(++currposition) + ".");
                txtownertypevalue.setText(String.valueOf(item.getName()));
                txtFathernameValue.setText(String.valueOf(item.getFatherFullName()));
                txtPermanentAddress1value.setText(String.valueOf(item.getPermanentAddress()));
                textCorrespondenceAddress1Value.setText(String.valueOf(item.getCorrespondenceAddress()));
                txtGendervalue.setText(String.valueOf(item.getGender()));
                txtMaritalStatusvalue.setText(String.valueOf(item.getMaritalStatus()));
                txtPreviousAllotmentDatevalue.setText(String.valueOf(item.getPreviousAllotmentDate()));
                txtPreviousReasonChangevalue.setText(String.valueOf(item.getPreviousReasonChange()));
                textPreviousRReasonChangeDescvalue.setText(String.valueOf(item.getPreviousReasonChangeDesc()));
                txtPreviousChangeDatevalue.setText(String.valueOf(item.getPreviousChangeDate()));
                textPreviousTransferModeValue.setText(String.valueOf(item.getPreviousTransferMode()));
                textPreviousTransferModeDescValue.setText(String.valueOf(item.getPreviousTransferModeDesc()));

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

        View view = LayoutInflater.from(mContext).inflate(R.layout.allotteehistory_list_row, parent, false);

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
        void onItemClick(AlloteeHistoryResponse.Datum item, int currposition);
    }
}