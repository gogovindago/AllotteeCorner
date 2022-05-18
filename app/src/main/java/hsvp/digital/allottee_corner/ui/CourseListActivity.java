package hsvp.digital.allottee_corner.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import hsvp.digital.allottee_corner.R;
import hsvp.digital.allottee_corner.adapter.RvCourseListAdapter;
import hsvp.digital.allottee_corner.allinterface.GetCourseListData_interface;
import hsvp.digital.allottee_corner.apicall.WebAPiCall;
import hsvp.digital.allottee_corner.databinding.ActivityCourseListBinding;
import hsvp.digital.allottee_corner.model.CoursesListResponse;
import hsvp.digital.allottee_corner.utility.BaseActivity;
import hsvp.digital.allottee_corner.utility.GlobalClass;

public class CourseListActivity extends BaseActivity implements GetCourseListData_interface, RvCourseListAdapter.ItemListener {


    ActivityCourseListBinding binding;
    private List<CoursesListResponse.Datum> arrayList = new ArrayList<CoursesListResponse.Datum>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_course_list);


        binding.simpleSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override

            public void onRefresh() {
                if (GlobalClass.isNetworkConnected(CourseListActivity.this)) {
                    WebAPiCall aPiCall = new WebAPiCall();
                    aPiCall.GetCoursesListDataMethod(CourseListActivity.this, CourseListActivity.this, binding.simpleSwipeRefreshLayout, CourseListActivity.this);

                } else {
                    Toast.makeText(CourseListActivity.this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
                }

                binding.simpleSwipeRefreshLayout.setRefreshing(false);
            }
        });


        if (GlobalClass.isNetworkConnected(CourseListActivity.this)) {
            WebAPiCall aPiCall = new WebAPiCall();
            aPiCall.GetCoursesListDataMethod(CourseListActivity.this, CourseListActivity.this, binding.simpleSwipeRefreshLayout, CourseListActivity.this);

        } else {
            Toast.makeText(CourseListActivity.this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
        }


    }

    @Override
    public void initData() {
        binding.toolbar.tvToolbarTitle.setText("Course List");
    }

    @Override
    public void initListeners() {

        binding.toolbar.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    @Override
    public void GetCourseListData(List<CoursesListResponse.Datum> list) {


        arrayList.clear();
        arrayList = new ArrayList();
        arrayList.addAll(list);

        RvCourseListAdapter adapter = new RvCourseListAdapter(this, (ArrayList) arrayList, this);
        binding.rvcourse.setAdapter(adapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
        binding.rvcourse.setLayoutManager(gridLayoutManager);

    }

    @Override
    public void onItemClick(CoursesListResponse.Datum item, int currposition) {

    }
}