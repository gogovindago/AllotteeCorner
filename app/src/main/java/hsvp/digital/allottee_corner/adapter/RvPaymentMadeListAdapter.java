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
import hsvp.digital.allottee_corner.model.AllottePaymentReceivedResponse;


public class RvPaymentMadeListAdapter extends RecyclerView.Adapter<RvPaymentMadeListAdapter.ViewHolder> {

    ArrayList<AllottePaymentReceivedResponse.Datum> mValues = new ArrayList<AllottePaymentReceivedResponse.Datum>();


    Context mContext;
    protected ItemListener mListener;
    public int currposition;


    public RvPaymentMadeListAdapter(Context context, ArrayList values, ItemListener itemListener) {

        mValues = values;
        mContext = context;
        mListener = itemListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public int currposition;
        public TextView lblListHeader, lblListHeader2, lblListHeader3, lblListHeader4;
        AllottePaymentReceivedResponse.Datum item;

        public ViewHolder(View v) {

            super(v);

            v.setOnClickListener(this);

            lblListHeader = v.findViewById(R.id.lblListHeader);
            lblListHeader2 = v.findViewById(R.id.lblListHeader2);
            lblListHeader3 = v.findViewById(R.id.lblListHeader3);
            lblListHeader4 = v.findViewById(R.id.lblListHeader4);

        }

        public void setData(AllottePaymentReceivedResponse.Datum item, int currposition) {
            this.item = item;
            this.currposition = currposition;


            try {
             //   lblListHeader.setText(String.valueOf(++currposition) + ".  " + String.valueOf(item.getPaymentDate()));
                lblListHeader.setText(String.valueOf(item.getPaymentDate()));
                lblListHeader3.setText(String.valueOf(item.getPaymentFlag()));
                lblListHeader2.setText(String.valueOf(item.getPaymentAmount()));
                lblListHeader4.setText(String.valueOf(item.getPaymentReceiptMemoNumber()));

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

        View view = LayoutInflater.from(mContext).inflate(R.layout.list_group, parent, false);

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
        void onItemClick(AllottePaymentReceivedResponse.Datum item, int currposition);
    }
}