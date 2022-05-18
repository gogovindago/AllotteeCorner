package hsvp.digital.allottee_corner.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import hsvp.digital.allottee_corner.R;

public class TrackActivity extends AppCompatActivity {
    View viewAppSubmittedLavel,viewCollegeoRInstituteLavel,view_NodalBodyLevel,view_DepartmentOrHeadLevel,dividerNodalBody,dividerDepartmentOrHeadLevel,dividerCollegeInstitute;
    ImageView imgCollegeoRInstituteLavel,imgNodalBodyLevel,imgDepartmentOrHeadLevel;
    TextView txtDeptHeadOfficeLabel,txtCollege_InstituteLabel,txtNodalBodyLabel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track);


        viewAppSubmittedLavel=findViewById(R.id.viewAppSubmittedLavel);
        viewCollegeoRInstituteLavel=findViewById(R.id.viewCollegeoRInstituteLavel);
        view_NodalBodyLevel=findViewById(R.id.view_NodalBodyLevel);
        view_DepartmentOrHeadLevel=findViewById(R.id.view_DepartmentOrHeadLevel);
        dividerCollegeInstitute=findViewById(R.id.dividerCollegeInstitute);
        dividerNodalBody=findViewById(R.id.dividerNodalBody);
        dividerDepartmentOrHeadLevel=findViewById(R.id.dividerDepartmentOrHeadLevel);

        txtDeptHeadOfficeLabel=findViewById(R.id.txtDeptHeadOfficeLabel);
        txtCollege_InstituteLabel=findViewById(R.id.txtCollege_InstituteLabel);
        txtNodalBodyLabel=findViewById(R.id.txtNodalBodyLabel);

        imgCollegeoRInstituteLavel=findViewById(R.id.imgCollegeoRInstituteLavel);
        imgNodalBodyLevel=findViewById(R.id.imgNodalBodyLevel);
        imgDepartmentOrHeadLevel=findViewById(R.id.imgDepartmentOrHeadLevel);

        Intent intent=getIntent();
        String orderStatus=intent.getStringExtra("orderStatus");

        getOrderStatus(orderStatus);




    }

    private void getOrderStatus(String orderStatus) {
        if (orderStatus.equals("0")){
            float alfa= (float) 0.5;
            setStatus(alfa);

        }else if (orderStatus.equals("1")){
            float alfa= (float) 5;
            setStatus1(alfa);



        }else if (orderStatus.equals("2")){
            float alfa= (float) 4;
            setStatus2(alfa);


        }else if (orderStatus.equals("3")){
            float alfa= (float) 1;
            setStatus3(alfa);
        }
    }


    private void setStatus(float alfa) {
        float myf= (float) 0.5;
        viewAppSubmittedLavel.setBackground(getResources().getDrawable(R.drawable.shape_status_completed));
        viewCollegeoRInstituteLavel.setBackground(getResources().getDrawable(R.drawable.shape_status_current));
        imgNodalBodyLevel.setAlpha(alfa);
        view_NodalBodyLevel.setBackground(getResources().getDrawable(R.drawable.shape_status_current));
        dividerNodalBody.setBackground(getResources().getDrawable(R.drawable.shape_status_current));
        dividerCollegeInstitute.setAlpha(alfa);
        imgCollegeoRInstituteLavel.setAlpha(alfa);
        dividerCollegeInstitute.setBackground(getResources().getDrawable(R.drawable.shape_status_current));
        txtCollege_InstituteLabel.setAlpha(alfa);
        txtNodalBodyLabel.setAlpha(alfa);
        view_DepartmentOrHeadLevel.setBackground(getResources().getDrawable(R.drawable.shape_status_current));
        dividerDepartmentOrHeadLevel.setBackground(getResources().getDrawable(R.drawable.shape_status_current));
        imgDepartmentOrHeadLevel.setAlpha(alfa);

        txtDeptHeadOfficeLabel.setAlpha(myf);




    }

    private void setStatus1(float alfa) {
        float myf= (float) 0.5;
        viewAppSubmittedLavel.setBackground(getResources().getDrawable(R.drawable.shape_status_completed));
        viewCollegeoRInstituteLavel.setBackground(getResources().getDrawable(R.drawable.shape_status_completed));
        imgNodalBodyLevel.setAlpha(myf);
        view_NodalBodyLevel.setBackground(getResources().getDrawable(R.drawable.shape_status_current));
        dividerNodalBody.setBackground(getResources().getDrawable(R.drawable.shape_status_current));
        dividerCollegeInstitute.setBackground(getResources().getDrawable(R.drawable.shape_status_completed));
        imgCollegeoRInstituteLavel.setAlpha(alfa);

        txtCollege_InstituteLabel.setAlpha(alfa);
        txtNodalBodyLabel.setAlpha(myf);
        view_DepartmentOrHeadLevel.setAlpha(myf);
        dividerDepartmentOrHeadLevel.setBackground(getResources().getDrawable(R.drawable.shape_status_current));
        imgDepartmentOrHeadLevel.setAlpha(myf);
        view_DepartmentOrHeadLevel.setBackground(getResources().getDrawable(R.drawable.shape_status_current));
        txtDeptHeadOfficeLabel.setAlpha(myf);
    }

    private void setStatus2(float alfa) {
        float myf= (float) 0.5;
        viewAppSubmittedLavel.setBackground(getResources().getDrawable(R.drawable.shape_status_completed));
        viewCollegeoRInstituteLavel.setBackground(getResources().getDrawable(R.drawable.shape_status_completed));
        imgNodalBodyLevel.setAlpha(alfa);
        view_NodalBodyLevel.setBackground(getResources().getDrawable(R.drawable.shape_status_completed));
        dividerNodalBody.setBackground(getResources().getDrawable(R.drawable.shape_status_completed));
        dividerCollegeInstitute.setBackground(getResources().getDrawable(R.drawable.shape_status_completed));
        imgCollegeoRInstituteLavel.setAlpha(alfa);

        txtCollege_InstituteLabel.setAlpha(alfa);
        txtNodalBodyLabel.setAlpha(alfa);
        view_DepartmentOrHeadLevel.setBackground(getResources().getDrawable(R.drawable.shape_status_current));
        dividerDepartmentOrHeadLevel.setBackground(getResources().getDrawable(R.drawable.shape_status_current));
        txtDeptHeadOfficeLabel.setAlpha(myf);
        imgDepartmentOrHeadLevel.setAlpha(myf);

    }

    private void setStatus3(float alfa) {
        viewAppSubmittedLavel.setBackground(getResources().getDrawable(R.drawable.shape_status_completed));
        viewCollegeoRInstituteLavel.setBackground(getResources().getDrawable(R.drawable.shape_status_completed));
        imgNodalBodyLevel.setAlpha(alfa);
        view_NodalBodyLevel.setBackground(getResources().getDrawable(R.drawable.shape_status_completed));
        dividerNodalBody.setBackground(getResources().getDrawable(R.drawable.shape_status_completed));

        imgCollegeoRInstituteLavel.setAlpha(alfa);
        dividerCollegeInstitute.setBackground(getResources().getDrawable(R.drawable.shape_status_completed));
        txtCollege_InstituteLabel.setAlpha(alfa);
        txtNodalBodyLabel.setAlpha(alfa);
        view_DepartmentOrHeadLevel.setBackground(getResources().getDrawable(R.drawable.shape_status_completed));
        dividerDepartmentOrHeadLevel.setBackground(getResources().getDrawable(R.drawable.shape_status_completed));
        txtDeptHeadOfficeLabel.setAlpha(alfa);
        imgDepartmentOrHeadLevel.setAlpha(alfa);
    }
}