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
import hsvp.digital.allottee_corner.model.AllotteCurrentOutStandingResponse;


public class RvcurrentoutstandingdetailListAdapter extends RecyclerView.Adapter<RvcurrentoutstandingdetailListAdapter.ViewHolder> {

    ArrayList<AllotteCurrentOutStandingResponse.Datum> mValues = new ArrayList<AllotteCurrentOutStandingResponse.Datum>();


    Context mContext;
    protected ItemListener mListener;
    public int currposition;


    public RvcurrentoutstandingdetailListAdapter(Context context, ArrayList values, ItemListener itemListener) {

        mValues = values;
        mContext = context;
        mListener = itemListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public int currposition;
        public TextView txtsrlno, txtParicularvalue, txtDueDateValue, txtAmountValue, txtTotalAmountvalue;
        AllotteCurrentOutStandingResponse.Datum item;

        public ViewHolder(View v) {

            super(v);

            v.setOnClickListener(this);


            txtParicularvalue = v.findViewById(R.id.txtParicularvalue);
            txtsrlno = v.findViewById(R.id.txtsrlno);
            txtDueDateValue = v.findViewById(R.id.txtDueDateValue);
            txtAmountValue = v.findViewById(R.id.txtAmountValue);
            txtTotalAmountvalue = v.findViewById(R.id.txtTotalAmountvalue);


        }

        public void setData(AllotteCurrentOutStandingResponse.Datum item, int currposition) {
            this.item = item;
            this.currposition = currposition;


            try {
                txtsrlno.setText(String.valueOf(++currposition) + ". ");
                txtParicularvalue.setText(String.valueOf(item.getParicular()));
                txtAmountValue.setText(String.valueOf(item.getAmount()));
                txtTotalAmountvalue.setText(String.valueOf(item.getAmount()));


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

        View view = LayoutInflater.from(mContext).inflate(R.layout.currentoutdetail_list_row, parent, false);

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
        void onItemClick(AllotteCurrentOutStandingResponse.Datum item, int currposition);
    }
}