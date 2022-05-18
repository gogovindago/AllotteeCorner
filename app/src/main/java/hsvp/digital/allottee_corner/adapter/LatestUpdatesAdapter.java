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
import hsvp.digital.allottee_corner.model.LatestUpdatesmodel;


public class LatestUpdatesAdapter extends RecyclerView.Adapter<LatestUpdatesAdapter.ViewHolder> {

    ArrayList<LatestUpdatesmodel> mValues = new ArrayList<LatestUpdatesmodel>();
    Context mContext;
    protected ItemListener mListener;
    int currposition;

    public LatestUpdatesAdapter(Context context, ArrayList values, ItemListener itemListener) {

        mValues = values;
        mContext = context;
        mListener = itemListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView txtdata,txtnewscount;
        LatestUpdatesmodel item;
        public int currposition;

        public ViewHolder(View v) {

            super(v);

            v.setOnClickListener(this);
            txtdata =  v.findViewById(R.id.txtdata);
            txtnewscount =  v.findViewById(R.id.txtnewscount);

        }


        public void setData(LatestUpdatesmodel item, int currposition) {

            this.currposition = currposition;
            this.item = item;


            txtdata.setText(item.itemName);
            txtnewscount.setText(String.valueOf(++currposition));

            if (currposition ==1) {
                txtdata.setTextColor(mContext.getResources().getColor(R.color.blue));


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

        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_view_latest_updatesdata, parent, false);

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
        void onItemClick(LatestUpdatesmodel item, int currposition);
    }
}