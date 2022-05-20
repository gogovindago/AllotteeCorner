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
import hsvp.digital.allottee_corner.model.AllottefutureOutStandingDetailsResponse;


public class RvfutureoutstandingdetailListAdapter extends RecyclerView.Adapter<RvfutureoutstandingdetailListAdapter.ViewHolder> {

    ArrayList<AllottefutureOutStandingDetailsResponse.Datum> mValues = new ArrayList<AllottefutureOutStandingDetailsResponse.Datum>();


    Context mContext;
    protected ItemListener mListener;
    public int currposition;


    public RvfutureoutstandingdetailListAdapter(Context context, ArrayList values, ItemListener itemListener) {

        mValues = values;
        mContext = context;
        mListener = itemListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public int currposition;
        public TextView txtpaymentcategory, txtInstallmentNumbervalue, txtDueDateValue, txtPrincipalDueAmountvalue, txtPossessionOrEnhancementInterestAmountvalue, txtTotalAmountvalue;
        AllottefutureOutStandingDetailsResponse.Datum item;

        public ViewHolder(View v) {

            super(v);

            v.setOnClickListener(this);


            txtInstallmentNumbervalue = v.findViewById(R.id.txtInstallmentNumbervalue);
            txtpaymentcategory = v.findViewById(R.id.txtpaymentcategory);
            txtDueDateValue = v.findViewById(R.id.txtDueDateValue);
            txtPrincipalDueAmountvalue = v.findViewById(R.id.txtPrincipalDueAmountvalue);
            txtPossessionOrEnhancementInterestAmountvalue = v.findViewById(R.id.txtPossessionOrEnhancementInterestAmountvalue);
            txtTotalAmountvalue = v.findViewById(R.id.txtTotalAmountvalue);


        }

        public void setData(AllottefutureOutStandingDetailsResponse.Datum item, int currposition) {
            this.item = item;
            this.currposition = currposition;


            try {
                txtpaymentcategory.setText(String.valueOf(++currposition) + ". ");
                txtInstallmentNumbervalue.setText(String.valueOf(item.getInstallmentNumber()));
                txtDueDateValue.setText(String.valueOf(item.getDueDate()));
                txtPrincipalDueAmountvalue.setText(String.valueOf(item.getPrincipalDueAmount()));
                txtPossessionOrEnhancementInterestAmountvalue.setText(String.valueOf(item.getPossessionOrEnhancementInterestAmount()));
                txtTotalAmountvalue.setText(String.valueOf(item.getTotalAmount()));


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

        View view = LayoutInflater.from(mContext).inflate(R.layout.futureoutdetail_list_row, parent, false);

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
        void onItemClick(AllottefutureOutStandingDetailsResponse.Datum item, int currposition);
    }
}