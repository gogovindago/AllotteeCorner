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
import hsvp.digital.allottee_corner.model.AllotteApplicationStatusResponse;


public class RvAppStatusTypeListAdapter extends RecyclerView.Adapter<RvAppStatusTypeListAdapter.ViewHolder> {

    ArrayList<AllotteApplicationStatusResponse.Datum> mValues = new ArrayList<AllotteApplicationStatusResponse.Datum>();


    Context mContext;
    protected ItemListener mListener;
    public int currposition;


    public RvAppStatusTypeListAdapter(Context context, ArrayList values, ItemListener itemListener) {

        mValues = values;
        mContext = context;
        mListener = itemListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public int currposition;
        public TextView txtApplicationNumber, txtCategoryNameValue,
                txtSubCategoryNamevalue, txtSectorIdvalue, txtPlotNumbervalue,
                txtProcessNamevalue, txtApplicationStatusvalue, txtProcessingOfficialDesignationvalue, textProcessingDatevalue;

        AllotteApplicationStatusResponse.Datum item;

        public ViewHolder(View v) {

            super(v);

            v.setOnClickListener(this);


            txtApplicationNumber = v.findViewById(R.id.txtApplicationNumber);
            txtCategoryNameValue = v.findViewById(R.id.txtCategoryNameValue);
            txtSubCategoryNamevalue = v.findViewById(R.id.txtSubCategoryNamevalue);
            txtSectorIdvalue = v.findViewById(R.id.txtSectorIdvalue);
            txtPlotNumbervalue = v.findViewById(R.id.txtPlotNumbervalue);
            txtProcessNamevalue = v.findViewById(R.id.txtProcessNamevalue);
            txtApplicationStatusvalue = v.findViewById(R.id.txtApplicationStatusvalue);
            txtProcessingOfficialDesignationvalue = v.findViewById(R.id.txtProcessingOfficialDesignationvalue);
            textProcessingDatevalue = v.findViewById(R.id.textProcessingDatevalue);

        }

        public void setData(AllotteApplicationStatusResponse.Datum item, int currposition) {
            this.item = item;
            this.currposition = currposition;


            try {
                txtApplicationNumber.setText(String.valueOf(++currposition) + ".  " + item.getApplicationNumber());
                txtCategoryNameValue.setText(String.valueOf(item.getCategoryName()));


                txtSubCategoryNamevalue.setText(String.valueOf(item.getSubCategoryName()));
                txtSectorIdvalue.setText(String.valueOf(item.getSectorId()));
                txtPlotNumbervalue.setText(String.valueOf(item.getPlotNumber()));
                txtProcessNamevalue.setText(String.valueOf(item.getProcessName()));
                txtApplicationStatusvalue.setText(String.valueOf(item.getApplicationStatus()));
                txtProcessingOfficialDesignationvalue.setText(String.valueOf(item.getProcessingOfficialDesignation()));
                textProcessingDatevalue.setText(String.valueOf(item.getProcessingDate()));


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

        View view = LayoutInflater.from(mContext).inflate(R.layout.appstatustype_list_row, parent, false);

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
        void onItemClick(AllotteApplicationStatusResponse.Datum item, int currposition);
    }
}