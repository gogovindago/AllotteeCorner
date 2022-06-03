package hsvp.digital.allottee_corner.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import hsvp.digital.allottee_corner.R;
import hsvp.digital.allottee_corner.model.AllottePaymentReceivedDetailsResponse;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.FruitViewHolder>  {
   // private String[] mDataset;

    List<AllottePaymentReceivedDetailsResponse.Datum> mDataset = new ArrayList<AllottePaymentReceivedDetailsResponse.Datum>();


    RecyclerViewItemClickListener recyclerViewItemClickListener;

    public DataAdapter(List<AllottePaymentReceivedDetailsResponse.Datum>  myDataset, RecyclerViewItemClickListener listener) {
        mDataset = myDataset;
        this.recyclerViewItemClickListener = listener;
    }

    @NonNull
    @Override
    public FruitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_group, parent, false);

        FruitViewHolder vh = new FruitViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(@NonNull FruitViewHolder fruitViewHolder, int i) {
        fruitViewHolder.mTextView.setText(String.valueOf(mDataset.get(i).getPlotId()));
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }



    public  class FruitViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView mTextView;

        public FruitViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.textView);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            recyclerViewItemClickListener.clickOnItem(String.valueOf(mDataset.get(this.getAdapterPosition())));

        }
    }

    public interface RecyclerViewItemClickListener {
        void clickOnItem(String data);
    }
}
