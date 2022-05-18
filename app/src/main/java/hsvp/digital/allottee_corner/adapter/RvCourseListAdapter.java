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
import hsvp.digital.allottee_corner.model.CoursesListResponse;


public class RvCourseListAdapter extends RecyclerView.Adapter<RvCourseListAdapter.ViewHolder> {

    ArrayList<CoursesListResponse.Datum> mValues = new ArrayList<CoursesListResponse.Datum>();

    Context mContext;
    protected ItemListener mListener;
    public int currposition;

    public RvCourseListAdapter(Context context, ArrayList values, ItemListener itemListener) {

        mValues = values;
        mContext = context;
        mListener = itemListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public int currposition;
        public TextView txtsrno, txtdeptName, txtCourseName;
        CoursesListResponse.Datum item;

        public ViewHolder(View v) {

            super(v);

            v.setOnClickListener(this);
            txtsrno = v.findViewById(R.id.txtsrno);
            txtdeptName = v.findViewById(R.id.txtdeptName);
            txtCourseName = v.findViewById(R.id.txtCourseName);

        }

        public void setData(CoursesListResponse.Datum item, int currposition) {
            this.item = item;
            this.currposition = currposition;

            txtsrno.setText((String.valueOf(++currposition) + " "));
            txtdeptName.setText(item.getDepartment());
            txtCourseName.setText(item.getCourseName());

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

        View view = LayoutInflater.from(mContext).inflate(R.layout.lib_course_list_row, parent, false);

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
        void onItemClick(CoursesListResponse.Datum item, int currposition);
    }
}