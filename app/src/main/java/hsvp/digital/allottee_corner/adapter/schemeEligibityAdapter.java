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
import hsvp.digital.allottee_corner.model.EligibilityModel;


public class schemeEligibityAdapter extends RecyclerView.Adapter<schemeEligibityAdapter.ViewHolder> {

    ArrayList<EligibilityModel> mValues = new ArrayList<EligibilityModel>();
    Context mContext;
    protected ItemListener mListener;
    int currposition;

    public schemeEligibityAdapter(Context context, ArrayList values, ItemListener itemListener) {

        mValues = values;
        mContext = context;
        mListener = itemListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView txtscheme, txtInstituteType, txtCategory, txtFamilyIncome, txtDomicile, txtAttendance;
        EligibilityModel item;
        Button btnSchemeDocument;
        public int currposition;

        public ViewHolder(View v) {

            super(v);

            //  v.setOnClickListener(this);

            txtscheme = (TextView) v.findViewById(R.id.txtscheme);
            txtInstituteType = (TextView) v.findViewById(R.id.txtInstituteType);
            txtCategory = (TextView) v.findViewById(R.id.txtCategory);
            txtFamilyIncome = (TextView) v.findViewById(R.id.txtFamilyIncome);
            txtDomicile = (TextView) v.findViewById(R.id.txtDomicile);
            txtAttendance = (TextView) v.findViewById(R.id.txtAttendance);
            btnSchemeDocument = v.findViewById(R.id.btnSchemeDocument);
            btnSchemeDocument.setOnClickListener(this);
        }


        public void setData(EligibilityModel item, int currposition) {

            this.currposition = currposition;
            this.item = item;


            txtscheme.setText(item.Scheme);
            txtInstituteType.setText(item.InstituteType);
            txtCategory.setText(item.Category);
            txtFamilyIncome.setText(item.FamilyIncome);
            txtDomicile.setText(item.Domicile);
            txtAttendance.setText(item.Attendance);
            btnSchemeDocument.setText(item.SchemeDocument);

        }


        @Override
        public void onClick(View view) {

            switch (view.getId()) {

                case R.id.btnSchemeDocument:

                    if (mListener != null) {

                        mListener.onItemClick(item, currposition);


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

        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_view_item_eligibility_data, parent, false);

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
        void onItemClick(EligibilityModel item, int currposition);
    }
}