package hsvp.digital.allottee_corner.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import hsvp.digital.allottee_corner.R;
import hsvp.digital.allottee_corner.model.GetScholarshipSchemesResponse;
import hsvp.digital.allottee_corner.ui.ApplyScholarshipFormActivity;

public class RvSchemeTypeFromApiAdapter extends
        RecyclerView.Adapter<RvSchemeTypeFromApiAdapter.ViewHolder> {

    private List<GetScholarshipSchemesResponse.Datum> offersList;
    private Context context;

    private int lastSelectedPosition = -1;

    public RvSchemeTypeFromApiAdapter(List<GetScholarshipSchemesResponse.Datum> offersListIn
            , Context ctx) {
        offersList = offersListIn;
        context = ctx;
    }

    @Override
    public RvSchemeTypeFromApiAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                    int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_radiobtn, parent, false);

        RvSchemeTypeFromApiAdapter.ViewHolder viewHolder =
                new RvSchemeTypeFromApiAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RvSchemeTypeFromApiAdapter.ViewHolder holder,
                                 int position) {
        GetScholarshipSchemesResponse.Datum offersModel = offersList.get(position);
        //  holder.txtscholarshipName.setText(offersModel.getSchemeName());

        //since only one radio button is allowed to be selected,
        // this condition un-checks previous selections
        holder.selectionState.setChecked(lastSelectedPosition == position);
        holder.selectionState.setText(offersModel.getSchemeName());
    }

    @Override
    public int getItemCount() {
        return offersList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtscholarshipName;

        public RadioButton selectionState;

        public ViewHolder(View view) {
            super(view);
            txtscholarshipName = (TextView) view.findViewById(R.id.txtscholarshipName);
            selectionState = (RadioButton) view.findViewById(R.id.rdbt);

            selectionState.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                        lastSelectedPosition = getAdapterPosition();
                    notifyDataSetChanged();

                        Intent intent = new Intent(context, ApplyScholarshipFormActivity.class);
                        intent.putExtra("ItemID", String.valueOf(offersList.get(lastSelectedPosition).getSchemeId()));
                        intent.putExtra("ItemName", String.valueOf(offersList.get(lastSelectedPosition).getSchemeName()));
                        context.startActivity(intent);




                   /* Toast.makeText(RvSchemeTypeFromApiAdapter.this.context,
                            "selected offer is " + selectionState.getText(),
                            Toast.LENGTH_LONG).show();*/
                }
            });
        }
    }
}
