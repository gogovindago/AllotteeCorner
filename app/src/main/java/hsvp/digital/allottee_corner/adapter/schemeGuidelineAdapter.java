package hsvp.digital.allottee_corner.adapter;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import hsvp.digital.allottee_corner.R;
import hsvp.digital.allottee_corner.model.SchemeGuideLinemodel;


public class schemeGuidelineAdapter extends RecyclerView.Adapter<schemeGuidelineAdapter.ViewHolder> {

    ArrayList<SchemeGuideLinemodel> mValues = new ArrayList<SchemeGuideLinemodel>();
    Context mContext;
    protected ItemListener mListener;
    int currposition;

    public schemeGuidelineAdapter(Context context, ArrayList values, ItemListener itemListener) {

        mValues = values;
        mContext = context;
        mListener = itemListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView txtdata;
        SchemeGuideLinemodel item;
        ImageView Imggo;
        public int currposition;

        public ViewHolder(View v) {

            super(v);

            v.setOnClickListener(this);
            txtdata =  v.findViewById(R.id.txtdata);
            Imggo =  v.findViewById(R.id.Imggo);

        }


        public void setData(SchemeGuideLinemodel item, int currposition) {

            this.currposition = currposition;
            this.item = item;
            Imggo.setVisibility(View.VISIBLE);

            txtdata.setText(item.salientfeatureName);

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

        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_view_schemeguidelineitemdata, parent, false);

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
        void onItemClick(SchemeGuideLinemodel item, int currposition);
    }
}