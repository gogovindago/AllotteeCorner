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
import hsvp.digital.allottee_corner.model.CollegeListResponse;


public class ListOfCollegeAdapter extends RecyclerView.Adapter<ListOfCollegeAdapter.ViewHolder> {

    ArrayList<CollegeListResponse.Datum> mValues = new ArrayList<CollegeListResponse.Datum>();
    Context mContext;
    protected ItemListener mListener;
    int currposition;

    public ListOfCollegeAdapter(Context context, ArrayList values, ItemListener itemListener) {

        mValues = values;
        mContext = context;
        mListener = itemListener;
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        private TextView txtcollegeSrNo, txtcollegeName,
                txtcollegeCode,
                txtcollegeAisheCode,
                txtcollegeType,
                txtcollegeCategory,
                txtcollegeAffilliatonbody1,
                txtcollegeAffilliatonbody2,
                txtcollege20_21Status,
                txtcollege21_22Status;

        CollegeListResponse.Datum item;
        public int currposition;

        public ViewHolder(View v) {

            super(v);

            v.setOnClickListener(this);


            txtcollegeSrNo = (TextView) v.findViewById(R.id.txtcollegeSrNo);
            txtcollegeName = (TextView) v.findViewById(R.id.txtcollegeName);
            txtcollegeCode = (TextView) v.findViewById(R.id.txtcollegeCode);
            txtcollegeAisheCode = (TextView) v.findViewById(R.id.txtcollegeAisheCode);
            txtcollegeType = (TextView) v.findViewById(R.id.txtcollegeType);
            txtcollegeCategory = (TextView) v.findViewById(R.id.txtcollegeCategory);
            txtcollegeAffilliatonbody1 = (TextView) v.findViewById(R.id.txtcollegeAffilliatonbody1);
            txtcollegeAffilliatonbody2 = (TextView) v.findViewById(R.id.txtcollegeAffilliatonbody2);
            txtcollege20_21Status = (TextView) v.findViewById(R.id.txtcollege20_21Status);
            txtcollege21_22Status = (TextView) v.findViewById(R.id.txtcollege21_22Status);


        }


        public void setData(CollegeListResponse.Datum item, int currposition) {

            this.currposition = currposition;
            this.item = item;
            txtcollegeSrNo.setText((String.valueOf(++currposition) + " "));
            txtcollegeName.setText(item.getCollege());
            txtcollegeCode.setText(String.valueOf(item.getCollegeCode()));
          //  txtcollegeAisheCode.setText(String.valueOf(item.getCollegeCode()));
            txtcollegeType.setText(item.getType());
            txtcollegeCategory.setText(item.getCategory());
            txtcollegeAffilliatonbody1.setText(item.getAffiliationBody());
            txtcollegeAffilliatonbody2.setText(item.getAffiliationBody2());
            txtcollege20_21Status.setText(item.getStatus());
            txtcollege21_22Status.setText(item.getCollegeStatus());


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

        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_view_item_college_listdata, parent, false);

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
        void onItemClick(CollegeListResponse.Datum item, int currposition);
    }
}