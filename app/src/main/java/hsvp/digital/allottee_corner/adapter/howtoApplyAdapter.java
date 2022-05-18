package hsvp.digital.allottee_corner.adapter;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import hsvp.digital.allottee_corner.R;
import hsvp.digital.allottee_corner.model.HowToApplyModel;


public class howtoApplyAdapter extends RecyclerView.Adapter<howtoApplyAdapter.ViewHolder> {

    ArrayList<HowToApplyModel> mValues = new ArrayList<HowToApplyModel>();
    Context mContext;
    protected ItemListener mListener;
    int currposition;

    public howtoApplyAdapter(Context context, ArrayList values, ItemListener itemListener) {

        mValues = values;
        mContext = context;
        mListener = itemListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView txtdescription, txtstepName;
        HowToApplyModel item;
        Button btnSchemeDocument;
        public int currposition;

        public ViewHolder(View v) {

            super(v);

            //  v.setOnClickListener(this);

            txtdescription = (TextView) v.findViewById(R.id.txtdescription);
            txtstepName = (TextView) v.findViewById(R.id.txtstepName);
            // btnSchemeDocument.setOnClickListener(this);
        }


        public void setData(HowToApplyModel item, int currposition) {

            this.currposition = currposition;
            this.item = item;


            txtstepName.setText(item.StepName);
            txtdescription.setText(item.StepDescription);

        }


        @Override
        public void onClick(View view) {

            switch (view.getId()) {

                case R.id.btnSchemeDocument:

                    if (mListener != null) {

                        //   mListener.onItemClick(item, currposition);


                    }
                    break;

            }
/*
            if (mListener != null) {
                mListener.onItemClick(item, currposition);


            }*/
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_view_item_how_to_apply_data, parent, false);

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
        void onItemClick(HowToApplyModel item, int currposition);
    }
}