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
import hsvp.digital.allottee_corner.model.ListOfScholarshipDataModel;


public class schemedetailAdapter extends RecyclerView.Adapter<schemedetailAdapter.ViewHolder> {

    ArrayList<ListOfScholarshipDataModel> mValues = new ArrayList<ListOfScholarshipDataModel>();
    Context mContext;
    protected ItemListener mListener;
    int currposition;

    public schemedetailAdapter(Context context, ArrayList values, ItemListener itemListener) {

        mValues = values;
        mContext = context;
        mListener = itemListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView txtscheme;
        ImageView Imgdept1, Imgdept2, Imgdept3, Imgdept4, Imgdept5;
        ListOfScholarshipDataModel item;
        public int currposition;

        public ViewHolder(View v) {

            super(v);

            v.setOnClickListener(this);
            Imgdept1 = (ImageView) v.findViewById(R.id.Imgdept1);
            Imgdept2 = (ImageView) v.findViewById(R.id.Imgdept2);
            Imgdept3 = (ImageView) v.findViewById(R.id.Imgdept3);
            Imgdept4 = (ImageView) v.findViewById(R.id.Imgdept4);
            Imgdept5 = (ImageView) v.findViewById(R.id.Imgdept5);
            txtscheme = (TextView) v.findViewById(R.id.txtscheme);

        }


        public void setData(ListOfScholarshipDataModel item, int currposition) {

            this.currposition = currposition;
            this.item = item;


            if (item.IsschemeActive1) {
                Imgdept1.setImageResource(R.drawable.right);

            } else {
                Imgdept1.setImageResource(R.drawable.cross);

            }

            if (item.IsschemeActive2) {
                Imgdept2.setImageResource(R.drawable.right);
            } else {
                Imgdept2.setImageResource(R.drawable.cross);
            }
            if (item.IsschemeActive3) {
                Imgdept3.setImageResource(R.drawable.right);
            } else {
                Imgdept3.setImageResource(R.drawable.cross);
            }
            if (item.IsschemeActive4) {
                Imgdept4.setImageResource(R.drawable.right);
            } else {
                Imgdept4.setImageResource(R.drawable.cross);
            }
            if (item.IsschemeActive5) {
                Imgdept5.setImageResource(R.drawable.right);
            } else {
                Imgdept5.setImageResource(R.drawable.cross);
            }


            txtscheme.setText(item.SchemeName);

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

        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_view_itemschemedata, parent, false);

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
        void onItemClick(ListOfScholarshipDataModel item, int currposition);
    }
}