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
import hsvp.digital.allottee_corner.model.KeyDocumentsRequired;


public class keydocumentsreqAdapter extends RecyclerView.Adapter<keydocumentsreqAdapter.ViewHolder> {

    ArrayList<KeyDocumentsRequired> mValues = new ArrayList<KeyDocumentsRequired>();
    Context mContext;
    protected ItemListener mListener;
    int currposition;

    public keydocumentsreqAdapter(Context context, ArrayList values, ItemListener itemListener) {

        mValues = values;
        mContext = context;
        mListener = itemListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView txtdescription, txtstepName;
        KeyDocumentsRequired item;
        Button btnSchemeDocument;
        public int currposition;

        public ViewHolder(View v) {

            super(v);

            //  v.setOnClickListener(this);

            txtdescription = (TextView) v.findViewById(R.id.txtdescription);
            txtstepName = (TextView) v.findViewById(R.id.txtstepName);
            // btnSchemeDocument.setOnClickListener(this);
        }


        public void setData(KeyDocumentsRequired item, int currposition) {

            this.currposition = currposition;
            this.item = item;


            txtstepName.setText(String.valueOf(item.Id) + ".");
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

        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_view_item_req_doc_data, parent, false);

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
        void onItemClick(KeyDocumentsRequired item, int currposition);
    }
}