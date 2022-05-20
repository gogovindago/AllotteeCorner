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
import hsvp.digital.allottee_corner.model.FetchJointHolderDetailsResponse;


public class RvfetchjointholderListAdapter extends RecyclerView.Adapter<RvfetchjointholderListAdapter.ViewHolder> {

    ArrayList<FetchJointHolderDetailsResponse.Datum> mValues = new ArrayList<FetchJointHolderDetailsResponse.Datum>();


    Context mContext;
    protected ItemListener mListener;
    public int currposition;


    public RvfetchjointholderListAdapter(Context context, ArrayList values, ItemListener itemListener) {

        mValues = values;
        mContext = context;
        mListener = itemListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public int currposition;
        public TextView txtownerName, txtownertypevalue, txtFathernameValue, txtMobilevalue, txtEmailvalue,
                txtPanvalue, txtAadharvalue, txtPermanentAddress1value, v, txtPermanentAddress2value, textPermanentAddress3value, textPermanentStatevalue, txtPermanentPINvalue,
                textCorrespondenceAddress1Value, textCorrespondenceAddress2Value, textCorrespondenceAddress3Value, textCorrespondenceStateValue, textCorrespondencePINValue;
        FetchJointHolderDetailsResponse.Datum item;

        public ViewHolder(View v) {

            super(v);

            v.setOnClickListener(this);


            txtownerName = v.findViewById(R.id.txtownerName);
            txtownertypevalue = v.findViewById(R.id.txtownertypevalue);
            txtFathernameValue = v.findViewById(R.id.txtFathernameValue);
            txtMobilevalue = v.findViewById(R.id.txtMobilevalue);
            txtEmailvalue = v.findViewById(R.id.txtEmailvalue);
            txtPanvalue = v.findViewById(R.id.txtPanvalue);
            txtAadharvalue = v.findViewById(R.id.txtAadharvalue);
            txtPermanentAddress1value = v.findViewById(R.id.txtPermanentAddress1value);
            txtPermanentAddress2value = v.findViewById(R.id.txtPermanentAddress2value);
            textPermanentAddress3value = v.findViewById(R.id.textPermanentAddress3value);
            textPermanentStatevalue = v.findViewById(R.id.textPermanentStatevalue);
            txtPermanentPINvalue = v.findViewById(R.id.txtPermanentPINvalue);
            textCorrespondenceAddress1Value = v.findViewById(R.id.textCorrespondenceAddress1Value);
            textCorrespondenceAddress2Value = v.findViewById(R.id.textCorrespondenceAddress2Value);
            textCorrespondenceAddress3Value = v.findViewById(R.id.textCorrespondenceAddress3Value);
            textCorrespondenceStateValue = v.findViewById(R.id.textCorrespondenceStateValue);
            textCorrespondencePINValue = v.findViewById(R.id.textCorrespondencePINValue);

        }

        public void setData(FetchJointHolderDetailsResponse.Datum item, int currposition) {
            this.item = item;
            this.currposition = currposition;


            try {
                txtownerName.setText(String.valueOf(++currposition)+". "+item.getName());
                txtownertypevalue.setText(item.getOwnerType());


                txtFathernameValue.setText(item.getFatherName() + " " + item.getFatherSurname());

                txtMobilevalue.setText(item.getMobileNumber());
                txtEmailvalue.setText(item.getEmailID());
                txtPanvalue.setText(item.getPANNo());
                txtAadharvalue.setText(item.getOCIAadharNumber());
                txtPermanentAddress1value.setText(item.getPermanentAddress1());
                txtPermanentAddress2value.setText(item.getPermanentAddress2());
                textPermanentAddress3value.setText(item.getPermanentAddress3());
                textPermanentStatevalue.setText(item.getPermanentState());
                txtPermanentPINvalue.setText(item.getPermanentPIN());
                textCorrespondenceAddress1Value.setText(item.getCorrespondenceAddress1());
                textCorrespondenceAddress2Value.setText(item.getCorrespondenceAddress2());
                textCorrespondenceAddress3Value.setText(item.getCorrespondenceAddress3());
                textCorrespondenceStateValue.setText(item.getCorrespondenceState());
                textCorrespondencePINValue.setText(item.getCorrespondencePIN());

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

        View view = LayoutInflater.from(mContext).inflate(R.layout.currentjointholder_list_row, parent, false);

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
        void onItemClick(FetchJointHolderDetailsResponse.Datum item, int currposition);
    }
}