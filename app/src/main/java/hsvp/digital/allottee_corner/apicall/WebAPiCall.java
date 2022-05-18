package hsvp.digital.allottee_corner.apicall;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import cn.pedant.SweetAlert.SweetAlertDialog;
import hsvp.digital.allottee_corner.allinterface.AadharFromMemIdData_interface;
import hsvp.digital.allottee_corner.allinterface.ForgotPasswordData_interface;
import hsvp.digital.allottee_corner.allinterface.GEtAadharNoFromMEMIDData_interface;
import hsvp.digital.allottee_corner.allinterface.GetAcademicSessionData_interface;
import hsvp.digital.allottee_corner.allinterface.GetAdminDashboardDataListData_interface;
import hsvp.digital.allottee_corner.allinterface.GetAllCourseForApplyListData_interface;
import hsvp.digital.allottee_corner.allinterface.GetAllCourseTypeListData_interface;
import hsvp.digital.allottee_corner.allinterface.GetApplicationStatusData_interface;
import hsvp.digital.allottee_corner.allinterface.GetCheckApplicationExistData_interface;
import hsvp.digital.allottee_corner.allinterface.GetCheckStudentExistData_interface;
import hsvp.digital.allottee_corner.allinterface.GetCollegeDashboardDataListData_interface;
import hsvp.digital.allottee_corner.allinterface.GetCollegeListData_interface;
import hsvp.digital.allottee_corner.allinterface.GetCourseListData_interface;
import hsvp.digital.allottee_corner.allinterface.GetCourseYearData_interface;
import hsvp.digital.allottee_corner.allinterface.GetDepartmentListData_interface;
import hsvp.digital.allottee_corner.allinterface.GetDepartmrntDashboardDataListData_interface;
import hsvp.digital.allottee_corner.allinterface.GetDeptByCourseIdListData_interface;
import hsvp.digital.allottee_corner.allinterface.GetDistrictListData_interface;
import hsvp.digital.allottee_corner.allinterface.GetMemberBasicDetailData_interface;
import hsvp.digital.allottee_corner.allinterface.GetNodalBodyDHEDashboardDataListData_interface;
import hsvp.digital.allottee_corner.allinterface.GetScholarshipListData_interface;
import hsvp.digital.allottee_corner.allinterface.GetScholarshipschemeData_interface;
import hsvp.digital.allottee_corner.allinterface.LoginData_interface;
import hsvp.digital.allottee_corner.allinterface.OtpForMEMIDData_interface;
import hsvp.digital.allottee_corner.allinterface.RegistrationData_interface;
import hsvp.digital.allottee_corner.allinterface.SentOtpForgotPasswordData_interface;
import hsvp.digital.allottee_corner.allinterface.verifyOtpForMEMIDData_interface;
import hsvp.digital.allottee_corner.model.AadharnoFromMemIDResponse;
import hsvp.digital.allottee_corner.model.AcademicSessionResponse;
import hsvp.digital.allottee_corner.model.AdminDashboardResponse;
import hsvp.digital.allottee_corner.model.AllDepartmentResponse;
import hsvp.digital.allottee_corner.model.AllDistrictsResponse;
import hsvp.digital.allottee_corner.model.CheckApplicationExistResponse;
import hsvp.digital.allottee_corner.model.CheckStudentAlreadyExistResponse;
import hsvp.digital.allottee_corner.model.CollegeDashboardResponse;
import hsvp.digital.allottee_corner.model.CollegeListResponse;
import hsvp.digital.allottee_corner.model.CourseYearResponse;
import hsvp.digital.allottee_corner.model.CoursesListResponse;
import hsvp.digital.allottee_corner.model.CoursesTypeResponse;
import hsvp.digital.allottee_corner.model.DepartmentByCourseIdForApplyResponse;
import hsvp.digital.allottee_corner.model.DepartmentDashboardResponse;
import hsvp.digital.allottee_corner.model.ForgotPasswordRequest;
import hsvp.digital.allottee_corner.model.ForgotPasswordResponse;
import hsvp.digital.allottee_corner.model.GetAadharnoFromMemIDRequest;
import hsvp.digital.allottee_corner.model.GetAadharnoFromMemIDResponse;
import hsvp.digital.allottee_corner.model.GetAllCoursesResponse;
import hsvp.digital.allottee_corner.model.GetApplicationStatusByAadharResponse;
import hsvp.digital.allottee_corner.model.GetMemberbasicdetailsfromFIDUIDRequest;
import hsvp.digital.allottee_corner.model.GetMemberbasicdetailsfromFIDUIDResponse;
import hsvp.digital.allottee_corner.model.GetScholarshipSchemesResponse;
import hsvp.digital.allottee_corner.model.LoginRequest;
import hsvp.digital.allottee_corner.model.LoginResponse;
import hsvp.digital.allottee_corner.model.NodalBodyDHEDashboardResponse;
import hsvp.digital.allottee_corner.model.OTPRequestforMEMIDRequest;
import hsvp.digital.allottee_corner.model.OTPRequestforMEMIDResponse;
import hsvp.digital.allottee_corner.model.OtpForgotPasswordResponse;
import hsvp.digital.allottee_corner.model.ScholarshipSchemesResponse;
import hsvp.digital.allottee_corner.model.StudentRegistrationResponse;
import hsvp.digital.allottee_corner.model.VerifyOTPRequestforMEMIDRequest;
import hsvp.digital.allottee_corner.model.VerifyOTPRequestforMEMIDResponse;
import hsvp.digital.allottee_corner.retrofitinterface.ApiClient;
import hsvp.digital.allottee_corner.retrofitinterface.ApiClient2;
import hsvp.digital.allottee_corner.ui.MainActivity;
import hsvp.digital.allottee_corner.utility.GlobalClass;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class WebAPiCall {


    SweetAlertDialog pDialog;
    ProgressDialog pd;


    public void dailogsuccessanddismis(final Context context, final Activity activity, String msgtitle, String msgcontentText) {
        SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(context);
        sweetAlertDialog.setTitle(msgtitle + "!");
        sweetAlertDialog.setContentText(msgcontentText);
        sweetAlertDialog.setVolumeControlStream(2);
        sweetAlertDialog.getAlerType();
        sweetAlertDialog.setCancelable(false);
        sweetAlertDialog.changeAlertType(2);
        sweetAlertDialog.setCanceledOnTouchOutside(false);
        sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sweetAlertDialog) {

                sweetAlertDialog.dismissWithAnimation();

            }
        });
        sweetAlertDialog.show();

    }


    public void dailogsuccessWithActivity(final Context context, final Activity activity, String msgtitle, String msgcontentText) {
        SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(context);
        sweetAlertDialog.setTitle(msgtitle + "!");
        sweetAlertDialog.setContentText(msgcontentText);
        sweetAlertDialog.setVolumeControlStream(2);
        sweetAlertDialog.getAlerType();
        sweetAlertDialog.changeAlertType(2);
        sweetAlertDialog.setCancelable(false);
        sweetAlertDialog.setCanceledOnTouchOutside(false);
        sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sweetAlertDialog) {
                sweetAlertDialog.dismissWithAnimation();
                activity.finish();
            }
        });
        sweetAlertDialog.show();

    }

    public void dailogsuccess(final Context context, String msgtitle, String msgcontentText) {
        SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(context);
        sweetAlertDialog.setTitle(msgtitle + "!");
        sweetAlertDialog.setContentText(msgcontentText);
        sweetAlertDialog.setVolumeControlStream(2);
        sweetAlertDialog.getAlerType();
        sweetAlertDialog.changeAlertType(2);
        sweetAlertDialog.setCancelable(false);
        sweetAlertDialog.setCanceledOnTouchOutside(false);
        sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sweetAlertDialog) {
                sweetAlertDialog.dismiss();

            }
        });
        sweetAlertDialog.show();

    }

    public void dailogError(final Context context, String msgtitle, String msgcontentText) {
        SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(context);
        sweetAlertDialog.setTitle(msgtitle + "!");
        sweetAlertDialog.setContentText(msgcontentText);
        sweetAlertDialog.setVolumeControlStream(2);
        sweetAlertDialog.getAlerType();
        sweetAlertDialog.changeAlertType(1);
        sweetAlertDialog.setCancelable(false);
        sweetAlertDialog.setCanceledOnTouchOutside(false);
        sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sweetAlertDialog) {
                sweetAlertDialog.dismiss();
            }
        });
        sweetAlertDialog.show();

    }


    public void dailogshow(final Context context) {
        pDialog = new SweetAlertDialog(context);
        pDialog.changeAlertType(5);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText("Loading");
        pDialog.setCancelable(false);
        pDialog.show();

//        pd = new ProgressDialog(context);
//        pd.setMessage("loading...");
//        pd.setCancelable(false);
//        pd.show();
    }

    public void loadershowwithMsg(final Context context, String msg) {
        pDialog = new SweetAlertDialog(context);
        pDialog.changeAlertType(5);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText(msg);
        pDialog.setCancelable(false);
        pDialog.show();

//        pd = new ProgressDialog(context);
//        pd.setMessage("loading...");
//        pd.setCancelable(false);
//        pd.show();
    }

    public void dailoghide(final Context context) {
        // pd.dismiss();
        pDialog.dismissWithAnimation();
    }


    public void GetDistrictListDataMethod(final Activity activity, final Context context, SwipeRefreshLayout simpleSwipeRefreshLayout, final GetDistrictListData_interface anInterface) {

        simpleSwipeRefreshLayout.setRefreshing(true);

        //  loadershowwithMsg(context, "Loading...");

        Call<AllDistrictsResponse> responseCall = ApiClient.getClient().getAllDistrictsListDataAPi();
        responseCall.enqueue(new Callback<AllDistrictsResponse>() {
            @Override
            public void onResponse(Call<AllDistrictsResponse> call, Response<AllDistrictsResponse> response) {
                simpleSwipeRefreshLayout.setRefreshing(false);
                // dailoghide(context);
                if (response.isSuccessful()) {

                    if (response.body().getResponse() == 200) {


                        anInterface.GetDistrictListData(response.body().getData());

                    } else {

                    }


                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }
            }

            @Override
            public void onFailure(Call<AllDistrictsResponse> call, Throwable t) {
                simpleSwipeRefreshLayout.setRefreshing(false);

                // dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void GetScholarshipSchemesListDataMethod(final Activity activity, final Context context, final GetScholarshipListData_interface anInterface) {

        //  simpleSwipeRefreshLayout.setRefreshing(true);

        loadershowwithMsg(context, "Loading...");

        Call<GetScholarshipSchemesResponse> responseCall = ApiClient.getClient().getAllScholarshipSchemesListDataAPi();
        responseCall.enqueue(new Callback<GetScholarshipSchemesResponse>() {
            @Override
            public void onResponse(Call<GetScholarshipSchemesResponse> call, Response<GetScholarshipSchemesResponse> response) {
                //  simpleSwipeRefreshLayout.setRefreshing(false);
                dailoghide(context);
                if (response.isSuccessful()) {

                    if (response.body().getResponse() == 200) {


                        anInterface.GetScholarshipListData(response.body().getData());

                    } else {

                    }


                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }
            }

            @Override
            public void onFailure(Call<GetScholarshipSchemesResponse> call, Throwable t) {
                // simpleSwipeRefreshLayout.setRefreshing(false);

                dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void GetCoursesTypeMethod(final Activity activity, final Context context, final GetAllCourseTypeListData_interface anInterface) {

        //  simpleSwipeRefreshLayout.setRefreshing(true);

        loadershowwithMsg(context, "Loading...");

        Call<CoursesTypeResponse> responseCall = ApiClient.getClient().GetCoursesTypeDataAPi();
        responseCall.enqueue(new Callback<CoursesTypeResponse>() {
            @Override
            public void onResponse(Call<CoursesTypeResponse> call, Response<CoursesTypeResponse> response) {
                //  simpleSwipeRefreshLayout.setRefreshing(false);
                dailoghide(context);
                if (response.isSuccessful()) {

                    if (response.body().getResponse() == 200) {


                        anInterface.GetCoursesTypeData(response.body().getData());

                    } else {

                    }


                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }
            }

            @Override
            public void onFailure(Call<CoursesTypeResponse> call, Throwable t) {
                // simpleSwipeRefreshLayout.setRefreshing(false);

                dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void GetAllCoursesForApplyMethod(final Activity activity, final Context context, final GetAllCourseForApplyListData_interface anInterface) {

        //  simpleSwipeRefreshLayout.setRefreshing(true);

        loadershowwithMsg(context, "Loading...");

        Call<GetAllCoursesResponse> responseCall = ApiClient.getClient().GetAllCoursesForApplyListDataAPi();
        responseCall.enqueue(new Callback<GetAllCoursesResponse>() {
            @Override
            public void onResponse(Call<GetAllCoursesResponse> call, Response<GetAllCoursesResponse> response) {
                //  simpleSwipeRefreshLayout.setRefreshing(false);
                dailoghide(context);
                if (response.isSuccessful()) {

                    if (response.body().getResponse() == 200) {


                        anInterface.GetCourseForApplyData(response.body().getData());

                    } else {

                    }


                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }
            }

            @Override
            public void onFailure(Call<GetAllCoursesResponse> call, Throwable t) {
                // simpleSwipeRefreshLayout.setRefreshing(false);

                dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void GetDepartmentListDataMethod(final Activity activity, final Context context, SwipeRefreshLayout simpleSwipeRefreshLayout, final GetDepartmentListData_interface anInterface) {

        simpleSwipeRefreshLayout.setRefreshing(true);

        //  loadershowwithMsg(context, "Loading...");

        Call<AllDepartmentResponse> responseCall = ApiClient.getClient().getAllDepartmentListDataAPi();
        responseCall.enqueue(new Callback<AllDepartmentResponse>() {
            @Override
            public void onResponse(Call<AllDepartmentResponse> call, Response<AllDepartmentResponse> response) {
                simpleSwipeRefreshLayout.setRefreshing(false);
                // dailoghide(context);
                if (response.isSuccessful()) {

                    if (response.body().getResponse() == 200) {


                        anInterface.GetDepartmentListData(response.body().getData());

                    } else {

                    }


                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }
            }

            @Override
            public void onFailure(Call<AllDepartmentResponse> call, Throwable t) {
                simpleSwipeRefreshLayout.setRefreshing(false);

                // dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void GetCoursesListDataMethod(final Activity activity, final Context context, SwipeRefreshLayout simpleSwipeRefreshLayout, final GetCourseListData_interface anInterface) {

        simpleSwipeRefreshLayout.setRefreshing(true);

        //  loadershowwithMsg(context, "Loading...");

        Call<CoursesListResponse> responseCall = ApiClient.getClient().getCoursesListDataAPi();
        responseCall.enqueue(new Callback<CoursesListResponse>() {
            @Override
            public void onResponse(Call<CoursesListResponse> call, Response<CoursesListResponse> response) {
                simpleSwipeRefreshLayout.setRefreshing(false);
                // dailoghide(context);
                if (response.isSuccessful()) {

                    if (response.body().getResponse() == 200) {


                        anInterface.GetCourseListData(response.body().getData());

                    } else {

                    }


                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }
            }

            @Override
            public void onFailure(Call<CoursesListResponse> call, Throwable t) {
                simpleSwipeRefreshLayout.setRefreshing(false);

                // dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void GetAllAcademicSessionDataMethod(final Activity activity, final Context context, final GetAcademicSessionData_interface anInterface) {

        loadershowwithMsg(context, "Loading...");

        Call<AcademicSessionResponse> responseCall = ApiClient.getClient().getAcademicSessionDataAPi();
        responseCall.enqueue(new Callback<AcademicSessionResponse>() {
            @Override
            public void onResponse(Call<AcademicSessionResponse> call, Response<AcademicSessionResponse> response) {
                dailoghide(context);
                if (response.isSuccessful()) {

                    if (response.body().getResponse() == 200) {


                        anInterface.GetAcademicSessionData(response.body().getData());

                    } else {

                    }


                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }
            }

            @Override
            public void onFailure(Call<AcademicSessionResponse> call, Throwable t) {
                dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void GetAllScholarshipSchemesDataMethod(final Activity activity, final Context context, final GetScholarshipschemeData_interface anInterface) {

        loadershowwithMsg(context, "Loading...");

        Call<ScholarshipSchemesResponse> responseCall = ApiClient.getClient().getScholarshipSchemesDataAPi();
        responseCall.enqueue(new Callback<ScholarshipSchemesResponse>() {
            @Override
            public void onResponse(Call<ScholarshipSchemesResponse> call, Response<ScholarshipSchemesResponse> response) {
                dailoghide(context);
                if (response.isSuccessful()) {

                    if (response.body().getResponse() == 200) {

                        anInterface.GetScholarshipschemeData(response.body().getData());

                    } else {

                    }

                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }
            }

            @Override
            public void onFailure(Call<ScholarshipSchemesResponse> call, Throwable t) {
                dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void getApplicationStatusByAadharDataMethod(final Activity activity, final Context context, final GetApplicationStatusData_interface anInterface, String AadharNumber,
                                                       String schemeId, String
                                                               SessionName, ConstraintLayout consapptracking, LinearLayoutCompat lldetail, TextView txtlabel) {

        loadershowwithMsg(context, "Loading...");

        Call<GetApplicationStatusByAadharResponse> responseCall = ApiClient.getClient().getApplicationStatusDataAPi(AadharNumber,
                schemeId,
                SessionName);
        responseCall.enqueue(new Callback<GetApplicationStatusByAadharResponse>() {
            @Override
            public void onResponse(Call<GetApplicationStatusByAadharResponse> call, Response<GetApplicationStatusByAadharResponse> response) {
                dailoghide(context);

                if (response.isSuccessful()) {

                    if (response.body().getResponse() == 200) {
                        txtlabel.setVisibility(View.VISIBLE);
                        consapptracking.setVisibility(View.VISIBLE);
                        lldetail.setVisibility(View.VISIBLE);
                        anInterface.GetApplicationStatusData(response.body().getData());


                    } else if (response.body().getResponse() == 400) {
                        txtlabel.setVisibility(View.GONE);
                        consapptracking.setVisibility(View.GONE);
                        lldetail.setVisibility(View.GONE);
                        GlobalClass.dailogError(activity, "No data found.", "No Application found with this data.");


                    }


                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }
            }

            @Override
            public void onFailure(Call<GetApplicationStatusByAadharResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void CheckApplicationExistMethod(final Activity activity, final Context context, final GetCheckApplicationExistData_interface anInterface, String StudentId, String academicSession, String schemeId) {


        loadershowwithMsg(context, "Loading...");

        Call<CheckApplicationExistResponse> responseCall = ApiClient.getClient().CheckApplicationExistAPi(StudentId, academicSession, schemeId);
        responseCall.enqueue(new Callback<CheckApplicationExistResponse>() {
            @Override
            public void onResponse(Call<CheckApplicationExistResponse> call, Response<CheckApplicationExistResponse> response) {
                dailoghide(context);

                if (response.isSuccessful()) {

                    if (response.body().getResponse() == 200) {

                        anInterface.GetCheckApplicationExist(response.body().getData());


                    } else if (response.body().getResponse() == 400) {
                        GlobalClass.dailogError(activity, "No data found.", "No Data found with this data.");

                    }

                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }
            }

            @Override
            public void onFailure(Call<CheckApplicationExistResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void getCourse_YearMethod(final Activity activity, final Context context, final GetCourseYearData_interface anInterface, String StudentId, String academicSession, String CourseId, String schemeId) {


        loadershowwithMsg(context, "Loading...");

        Call<CourseYearResponse> responseCall = ApiClient.getClient().getCourse_YearAPi(StudentId, academicSession, CourseId, schemeId);
        responseCall.enqueue(new Callback<CourseYearResponse>() {
            @Override
            public void onResponse(Call<CourseYearResponse> call, Response<CourseYearResponse> response) {
                dailoghide(context);

                if (response.isSuccessful()) {

                    if (response.body().getResponse() == 200) {

                        anInterface.GetCourseYearData(response.body().getData());


                    } else if (response.body().getResponse() == 400) {
                        GlobalClass.dailogError(activity, "No data found.", "No Data found with this data.");

                    }

                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }
            }

            @Override
            public void onFailure(Call<CourseYearResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void getDepartmentByCourseIdAPiMethod(final Activity activity, final Context context, final GetDeptByCourseIdListData_interface anInterface, String CourseId
    ) {


        loadershowwithMsg(context, "Loading...");

        Call<DepartmentByCourseIdForApplyResponse> responseCall = ApiClient.getClient().getDepartmentByCourseIdAPi(CourseId);
        responseCall.enqueue(new Callback<DepartmentByCourseIdForApplyResponse>() {
            @Override
            public void onResponse(Call<DepartmentByCourseIdForApplyResponse> call, Response<DepartmentByCourseIdForApplyResponse> response) {
                dailoghide(context);

                if (response.isSuccessful()) {

                    if (response.body().getResponse() == 200) {

                        anInterface.GetDeptByCourseIdData(response.body().getData());


                    } else if (response.body().getResponse() == 400) {
                        GlobalClass.dailogError(activity, "No data found.", "No Data found with this data.");

                    }

                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }
            }

            @Override
            public void onFailure(Call<DepartmentByCourseIdForApplyResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void getNodalBodyDHEDashboardAPiMethod(final Activity activity, final Context context, final GetNodalBodyDHEDashboardDataListData_interface anInterface, String NodalBody_Id,
                                                  String AcademicSession, String schemeId) {


        loadershowwithMsg(context, "Loading...");

        Call<NodalBodyDHEDashboardResponse> responseCall = ApiClient.getClient().getNodalBodyDHEDashboardAPi(NodalBody_Id, AcademicSession, schemeId);
        responseCall.enqueue(new Callback<NodalBodyDHEDashboardResponse>() {
            @Override
            public void onResponse(Call<NodalBodyDHEDashboardResponse> call, Response<NodalBodyDHEDashboardResponse> response) {
                dailoghide(context);

                if (response.isSuccessful()) {

                    if (response.body().getResponse() == 200) {

                        anInterface.GetNodalBodyDHEDashboardData(response.body().getData());


                    } else if (response.body().getResponse() == 400) {
                        GlobalClass.dailogError(activity, "No data found.", "No Data found with this data.");


                    }


                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }
            }

            @Override
            public void onFailure(Call<NodalBodyDHEDashboardResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void getPMSDashboardAdminAPiMethod(final Activity activity, final Context context, final GetAdminDashboardDataListData_interface anInterface, String CastName,
                                              String session, String schemeId) {


        loadershowwithMsg(context, "Loading...");

        Call<AdminDashboardResponse> responseCall = ApiClient.getClient().getPMSDashboardAdminAPi(CastName, session, schemeId);
        responseCall.enqueue(new Callback<AdminDashboardResponse>() {
            @Override
            public void onResponse(Call<AdminDashboardResponse> call, Response<AdminDashboardResponse> response) {
                dailoghide(context);

                if (response.isSuccessful()) {

                    if (response.body().getResponse() == 200) {

                        anInterface.GetAdminDashboardData(response.body().getData());


                    } else if (response.body().getResponse() == 400) {
                        GlobalClass.dailogError(activity, "No data found.", "No Data found with this data.");


                    }


                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }
            }

            @Override
            public void onFailure(Call<AdminDashboardResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void getNodalBodyDashboardAPiMethod(final Activity activity, final Context context, final GetCollegeDashboardDataListData_interface anInterface,
                                               String session, String NodalBody_Id) {


        loadershowwithMsg(context, "Loading...");

        Call<CollegeDashboardResponse> responseCall = ApiClient.getClient().getNodalBodyDashboardAPi(session, NodalBody_Id);
        responseCall.enqueue(new Callback<CollegeDashboardResponse>() {
            @Override
            public void onResponse(Call<CollegeDashboardResponse> call, Response<CollegeDashboardResponse> response) {
                dailoghide(context);

                if (response.isSuccessful()) {

                    if (response.body().getResponse() == 200) {

                        anInterface.GetCollegeDashboardData(response.body().getData());


                    } else if (response.body().getResponse() == 400) {
                        GlobalClass.dailogError(activity, "No data found.", "No Data found with this data.");


                    }


                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }
            }

            @Override
            public void onFailure(Call<CollegeDashboardResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void getCollegeDashboardAPiMethod(final Activity activity, final Context context, final GetCollegeDashboardDataListData_interface anInterface,
                                             String session, String DepartmentId) {


        loadershowwithMsg(context, "Loading...");

        Call<CollegeDashboardResponse> responseCall = ApiClient.getClient().getCollegeDashboarAPi(session, DepartmentId);
        responseCall.enqueue(new Callback<CollegeDashboardResponse>() {
            @Override
            public void onResponse(Call<CollegeDashboardResponse> call, Response<CollegeDashboardResponse> response) {
                dailoghide(context);

                if (response.isSuccessful()) {

                    if (response.body().getResponse() == 200) {

                        anInterface.GetCollegeDashboardData(response.body().getData());


                    } else if (response.body().getResponse() == 400) {
                        GlobalClass.dailogError(activity, "No data found.", "No Data found with this data.");


                    }


                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }
            }

            @Override
            public void onFailure(Call<CollegeDashboardResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }

    public void getPMSDashboardDepartmentAPiMethod(final Activity activity, final Context context, final GetDepartmrntDashboardDataListData_interface anInterface, String CastName,
                                                   String session, String schemeId) {


        loadershowwithMsg(context, "Loading...");

        Call<DepartmentDashboardResponse> responseCall = ApiClient.getClient().getPMSDashboarDepartmentAPi(CastName, session, schemeId);
        responseCall.enqueue(new Callback<DepartmentDashboardResponse>() {
            @Override
            public void onResponse(Call<DepartmentDashboardResponse> call, Response<DepartmentDashboardResponse> response) {
                dailoghide(context);

                if (response.isSuccessful()) {

                    if (response.body().getResponse() == 200) {

                        anInterface.GetDepartmentDashboardData(response.body().getData());


                    } else if (response.body().getResponse() == 400) {
                        GlobalClass.dailogError(activity, "No data found.", "No Data found with this data.");


                    }


                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }
            }

            @Override
            public void onFailure(Call<DepartmentDashboardResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void getCollegesListDataAPiMethod(final Activity activity, final Context context, final GetCollegeListData_interface anInterface, String DistrictsId,
                                             String DeptmntId) {

        loadershowwithMsg(context, "Loading...");

        Call<CollegeListResponse> responseCall = ApiClient.getClient().getCollegesListDataAPi(DistrictsId,
                DeptmntId);
        responseCall.enqueue(new Callback<CollegeListResponse>() {
            @Override
            public void onResponse(Call<CollegeListResponse> call, Response<CollegeListResponse> response) {
                dailoghide(context);

                if (response.isSuccessful()) {

                    if (response.body().getResponse() == 200) {

                        anInterface.GetCollegeData(response.body().getData());


                    } else if (response.body().getResponse() == 400) {
                        GlobalClass.dailogError(activity, "No data found.", "No College found with this data.");


                    }


                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }
            }

            @Override
            public void onFailure(Call<CollegeListResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }

    public void getCollegesListPMSDataAPiMethod(final Activity activity, final Context context, final GetCollegeListData_interface anInterface, String DistrictsId,
                                             String DeptmntId,String userAcademicSession) {

        loadershowwithMsg(context, "Loading...");

        Call<CollegeListResponse> responseCall = ApiClient.getClient().getCollegesListPMSDataAPi(DistrictsId,
                DeptmntId,userAcademicSession);
        responseCall.enqueue(new Callback<CollegeListResponse>() {
            @Override
            public void onResponse(Call<CollegeListResponse> call, Response<CollegeListResponse> response) {
                dailoghide(context);

                if (response.isSuccessful()) {

                    if (response.body().getResponse() == 200) {

                        anInterface.GetCollegeData(response.body().getData());


                    } else if (response.body().getResponse() == 400) {
                        GlobalClass.dailogError(activity, "No data found.", "No College found with this data.");


                    }


                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }
            }

            @Override
            public void onFailure(Call<CollegeListResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void loginPostDataMethod(final Activity activity, final Context context, final LoginData_interface loginData_interface, LoginRequest request) {

        loadershowwithMsg(context, "We are veryfing your Detail for login.");

        Call<LoginResponse> userpost_responseCall = ApiClient.getClient().LoginUser(request);
        userpost_responseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                dailoghide(context);
                if (response.isSuccessful()) {


                    if (response.body().getResponse() == 200) {

                        loginData_interface.alluserdata((LoginResponse.Data) response.body().getData());
                        Intent intentlogin = new Intent(context, MainActivity.class);
                        intentlogin.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        intentlogin.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        context.startActivity(intentlogin);
                        activity.finish();


                    } else {
                        dailogError(context, "Credentials Not Found!", "You have entered wrong credentials.");
                    }

                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void GetMemberbasicdetailsfromFIDUIDtDataMethod(final Activity activity, final Context context, final GetMemberBasicDetailData_interface anInterface, GetMemberbasicdetailsfromFIDUIDRequest request) {

        loadershowwithMsg(context, "We are fetching your Detail.");

        Call<GetMemberbasicdetailsfromFIDUIDResponse> userpost_responseCall = ApiClient2.getClient().GetMemberbasicdetailsfromFIDUID(request);
        userpost_responseCall.enqueue(new Callback<GetMemberbasicdetailsfromFIDUIDResponse>() {
            @Override
            public void onResponse(Call<GetMemberbasicdetailsfromFIDUIDResponse> call, Response<GetMemberbasicdetailsfromFIDUIDResponse> response) {
                dailoghide(context);
                if (response.isSuccessful()) {


                    if (response.body().getStatus().equalsIgnoreCase("Successfull")) {

                        anInterface.alluserBasicDetaildata(response.body().getResult().getDropdown());

                    } else {
                        dailogError(context, "Data Not Found!", "You have entered wrong Family Id.");
                    }

                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }

            }

            @Override
            public void onFailure(Call<GetMemberbasicdetailsfromFIDUIDResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }

    public void GetOTPRequestforMEMIDDataMethod(final Activity activity, final Context context, final OtpForMEMIDData_interface anInterface, OTPRequestforMEMIDRequest request) {

        loadershowwithMsg(context, "Sending Otp.");

        Call<OTPRequestforMEMIDResponse> userpost_responseCall = ApiClient2.getClient().GetOTPRequestforMEMID(request);
        userpost_responseCall.enqueue(new Callback<OTPRequestforMEMIDResponse>() {
            @Override
            public void onResponse(Call<OTPRequestforMEMIDResponse> call, Response<OTPRequestforMEMIDResponse> response) {
                dailoghide(context);
                if (response.isSuccessful()) {


                    if (response.body().getStatus().equalsIgnoreCase("Successfull")) {

                        anInterface.OtpForMEMIDDdata(response.body().getResult());

                    } else {
                        dailogError(context, "Server Busy!", "Please try again sometime.");
                    }

                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }

            }

            @Override
            public void onFailure(Call<OTPRequestforMEMIDResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void GetVerifyOTPRequestforMEMIDDataMethod(final Activity activity, final Context context, final verifyOtpForMEMIDData_interface anInterface, VerifyOTPRequestforMEMIDRequest request) {

        loadershowwithMsg(context, "Verifying Otp.");

        Call<VerifyOTPRequestforMEMIDResponse> userpost_responseCall = ApiClient2.getClient().GetVerifyOTPRequestforMEMID(request);
        userpost_responseCall.enqueue(new Callback<VerifyOTPRequestforMEMIDResponse>() {
            @Override
            public void onResponse(Call<VerifyOTPRequestforMEMIDResponse> call, Response<VerifyOTPRequestforMEMIDResponse> response) {
                dailoghide(context);
                if (response.isSuccessful()) {


                    if (response.body().getStatus().equalsIgnoreCase("Successfull")) {

                        anInterface.verifyOtpForMEMIDDdata(response.body().getResult());

                    } else if (response.body().getStatus().equalsIgnoreCase("Failed")) {
                        dailogError(context, "OTP Expired!", response.body().getMessage());
                    } else {
                        dailogError(context, "Server Busy!", "Please try again.");
                    }

                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }

            }

            @Override
            public void onFailure(Call<VerifyOTPRequestforMEMIDResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void GetadharnoFromMemIDDataMethod(final Activity activity, final Context context, final GEtAadharNoFromMEMIDData_interface anInterface, GetAadharnoFromMemIDRequest request) {

        loadershowwithMsg(context, "Verifying Otp.");

        Call<GetAadharnoFromMemIDResponse> userpost_responseCall = ApiClient2.getClient().GetAadharnoFromMemID(request);
        userpost_responseCall.enqueue(new Callback<GetAadharnoFromMemIDResponse>() {
            @Override
            public void onResponse(Call<GetAadharnoFromMemIDResponse> call, Response<GetAadharnoFromMemIDResponse> response) {
                dailoghide(context);
                if (response.isSuccessful()) {


                    if (response.body().getStatus().equalsIgnoreCase("Successfull")) {

                        anInterface.AadharNoFromMEMIDdata(response.body());

                    } else {
                        dailogError(context, "Server Busy!", "Please try again.");
                    }

                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }

            }

            @Override
            public void onFailure(Call<GetAadharnoFromMemIDResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void getCheckStudentAlreadyExistMethod(final Activity activity, final Context context, final GetCheckStudentExistData_interface anInterface, String MemberId) {

        loadershowwithMsg(context, "Loading...");
//23456789
        Call<CheckStudentAlreadyExistResponse> responseCall = ApiClient.getClient().getCheckStudentAlreadyExistAPi(MemberId);
        responseCall.enqueue(new Callback<CheckStudentAlreadyExistResponse>() {
            @Override
            public void onResponse(Call<CheckStudentAlreadyExistResponse> call, Response<CheckStudentAlreadyExistResponse> response) {
                dailoghide(context);

                if (response.isSuccessful()) {

                    if (response.body().getResponse() == 200) {

                        anInterface.GetCheckStudentExistData(response.body().getData(), 200);


                    } else if (response.body().getResponse() == 400) {
                        anInterface.GetCheckStudentExistData(response.body().getData(), 400);

//{"response":400,"sys_message":"No Data Returned","data":null}
                    }


                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }
            }

            @Override
            public void onFailure(Call<CheckStudentAlreadyExistResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void getSetOtpForgotPasswordMethod(final Activity activity, final Context context, final SentOtpForgotPasswordData_interface anInterface, String MobileNO, String MemberId) {

        loadershowwithMsg(context, "Loading...");
//23456789
        Call<OtpForgotPasswordResponse> responseCall = ApiClient.getClient().SendOTPFogotPasswordAPi(MobileNO, MemberId);
        responseCall.enqueue(new Callback<OtpForgotPasswordResponse>() {
            @Override
            public void onResponse(Call<OtpForgotPasswordResponse> call, Response<OtpForgotPasswordResponse> response) {
                dailoghide(context);

                if (response.isSuccessful()) {

                    if (response.body().getResponse() == 200) {

                        anInterface.sentOtpforgotPassworddata(response.body());


                    } else {
                        dailogError(context, "Server Busy!", "Please try again.");

                    }


                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }
            }

            @Override
            public void onFailure(Call<OtpForgotPasswordResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }

    public void getAadharnoFromMemIDAPiMethod(final Activity activity, final Context context, final AadharFromMemIdData_interface anInterface, String MemberId) {

        loadershowwithMsg(context, "Loading...\n Fetching your Aadhar.");
//23456789
        Call<AadharnoFromMemIDResponse> responseCall = ApiClient.getClient().GetAadharnoFromMemIDAPi(MemberId);
        responseCall.enqueue(new Callback<AadharnoFromMemIDResponse>() {
            @Override
            public void onResponse(Call<AadharnoFromMemIDResponse> call, Response<AadharnoFromMemIDResponse> response) {
                dailoghide(context);

                if (response.isSuccessful()) {

                    if (response.body().getResponse() == 200) {

                        anInterface.AadharFromMemIddata(response.body().getData());


                    } else {
                        dailogError(context, "Server Busy!", "Please try again.");

                    }


                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }
            }

            @Override
            public void onFailure(Call<AadharnoFromMemIDResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void forgotPostDataMethod(final Activity activity, final Context context, final ForgotPasswordData_interface anInterface, ForgotPasswordRequest request) {

        loadershowwithMsg(context, "We are Updating your Password.");

        Call<ForgotPasswordResponse> userpost_responseCall = ApiClient.getClient().UpdatePassword(request);
        userpost_responseCall.enqueue(new Callback<ForgotPasswordResponse>() {
            @Override
            public void onResponse(Call<ForgotPasswordResponse> call, Response<ForgotPasswordResponse> response) {
                dailoghide(context);
                if (response.isSuccessful()) {


                    if (response.body().getResponse() == 200) {

                        anInterface.forgotPasswordMethod(response.body());


                    } else {
                        dailogError(context, "Credentials Not Found!", "You have entered wrong credentials.");
                    }

                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }

            }

            @Override
            public void onFailure(Call<ForgotPasswordResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }

    public void RegistrationMethod(final Activity activity, final Context context, final RegistrationData_interface anInterface, String RegistrationIp, String FCMToken, String FamilyID,

                                   String memberID,
                                   String firstName,
                                   String lastName,
                                   String fullName,
                                   String fatherFullName,
                                   String motherFullName,
                                   String gender,
                                   String houseNo,
                                   String streetNo,
                                   String address_LandMark,
                                   String pinCode,
                                   String dCode,
                                   String btCode,
                                   String btCodeLGD,
                                   String wvCode,
                                   String districtName,
                                   String btName,
                                   String wvName,
                                   String aadhaarNo,
                                   String dob,
                                   String mobileNo,
                                   String casteCategory,
                                   String familyIncome,
                                   String email,
                                   String bpl,
                                   String bplCardNO,
                                   String dCodeLGD,
                                   String wvCodeLGD,
                                   String casteCategoryName,
                                   String disabilityType,
                                   String isDivyang,
                                   String divyangPercentage,
                                   String IsDenotifiedTribe, String isDOBVerified,
                                   String isCasteVerified,
                                   String isIncomeVerified,
                                   String isBPLVerified,
                                   String isDivyangVerified,
                                   String subCaste_code,
                                   String subCaste_name,
                                   String casteDescription,
                                   String divyangCategory,
                                   String deprived,
                                   String Religion,
                                   String AuthPwd) {

        loadershowwithMsg(context, "Registration process is going on...");

        Call<StudentRegistrationResponse> userpost_responseCall = ApiClient.getClient().StudentRegistration_Api(RegistrationIp, FCMToken, FamilyID,
                memberID,
                firstName,
                lastName,
                fullName,
                fatherFullName,
                motherFullName,
                gender,
                houseNo,
                streetNo,
                address_LandMark,
                pinCode,
                dCode,
                btCode,
                btCodeLGD,
                wvCode,
                districtName,
                btName,
                wvName,
                aadhaarNo,
                dob,
                mobileNo,
                casteCategory,
                familyIncome,
                email,
                bpl,
                bplCardNO,
                dCodeLGD,
                wvCodeLGD,
                casteCategoryName,
                disabilityType,
                isDivyang,
                divyangPercentage,
                IsDenotifiedTribe,
                isDOBVerified,
                isCasteVerified,
                isIncomeVerified,
                isBPLVerified,
                isDivyangVerified,
                subCaste_code,
                subCaste_name,
                casteDescription,
                divyangCategory,
                deprived,
                Religion,
                AuthPwd);
        userpost_responseCall.enqueue(new Callback<StudentRegistrationResponse>() {
            @Override
            public void onResponse(Call<StudentRegistrationResponse> call, Response<StudentRegistrationResponse> response) {
                dailoghide(context);
                if (response.isSuccessful()) {


                    assert response.body() != null;
                    if (response.body().getResponse() == 200) {

                        anInterface.registrationuserdata(response.body().getData());

                    } else if (response.body().getResponse() == 300) {
                        //  dailogError(context, "Current session is in-active", response.body().getSysMessage());

                        SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(context);
                        sweetAlertDialog.setTitle(" FAILED!");
                        sweetAlertDialog.setContentText(response.body().getSysMessage());
                        sweetAlertDialog.setVolumeControlStream(2);
                        sweetAlertDialog.getAlerType();
                        sweetAlertDialog.changeAlertType(1);
                        sweetAlertDialog.setCanceledOnTouchOutside(false);
                        sweetAlertDialog.setCancelable(false);
                        sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.dismiss();
                                activity.finish();
                            }
                        });
                        sweetAlertDialog.show();


                    } else {
                        dailogError(context, "Something went wrong!", "Plz try Again.");
                    }

                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }

            }

            @Override
            public void onFailure(Call<StudentRegistrationResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }





























/*

    public void getHomePageDataMethod(final Activity activity, final Context context, LinearLayout llmain, SwipeRefreshLayout mSwipeRefreshLayout, final GetbannersData_interface getbannersData_interface, String UserMobileNo) {

        // loadershowwithMsg(context, "Loading...");
        mSwipeRefreshLayout.setRefreshing(true);

        Call<HomePageResponse> responseCall = ApiClient.getClient().getHomePageDataAPi(UserMobileNo);
        responseCall.enqueue(new Callback<HomePageResponse>() {
            @Override
            public void onResponse(Call<HomePageResponse> call, Response<HomePageResponse> response) {
                // dailoghide(context);
                if (response.isSuccessful()) {

                    if (response.body().getResponse() == 200) {

                        mSwipeRefreshLayout.setRefreshing(false);

                        llmain.setVisibility(View.VISIBLE);

                        getbannersData_interface.GetbannersData(response.body().getData().getBanners());

                        getbannersData_interface.GetRegisteredUserData(response.body().getData().getTotalRegs());
                        getbannersData_interface.GetAdminAllData(response.body().getData().getOfficers());
                        getbannersData_interface.GetRegisteredUserStatusData(response.body().getData().getRegistrations());
                        getbannersData_interface.GetOtherRegisteredUserStatusData(response.body().getData().getOtherregistrations());


                    } else {
                        llmain.setVisibility(View.GONE);

                    }


                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }
            }


            @Override
            public void onFailure(Call<HomePageResponse> call, Throwable t) {
                llmain.setVisibility(View.GONE);
                mSwipeRefreshLayout.setRefreshing(false);
                // dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }

    public void resetforgotPostDataMethod(final Activity activity, final Context context, ResetForget_interface resetForget_interface, ResetPasswordRequest request) {

        loadershowwithMsg(context, "We are Changing your password.");

        Call<ResetPasswordResponse> userpost_responseCall = ApiClient.getClient().ResetforgotPassword(request);
        userpost_responseCall.enqueue(new Callback<ResetPasswordResponse>() {
            @Override
            public void onResponse(Call<ResetPasswordResponse> call, Response<ResetPasswordResponse> response) {
                dailoghide(context);
                if (response.isSuccessful()) {

                    if (response.body().getResponse() == 200) {

                        //dailogsuccessWithActivity(context, activity, "Password Re-Set Done.", "Successfully Reset your Password.");
                        GlobalClass.showtost(context, "Password Reset Done.\n Successfully Reset your Password.");


                        resetForget_interface.resetpassword(response.body().getResponse());

                    } else {
                        // GlobalClass.showtost(context, "This  Number is Not Registered with Us.");
                        dailogError(activity, "Failed!", "Are you sure Old password is Correct? Try Again.");

                    }

                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }
            }

            @Override
            public void onFailure(Call<ResetPasswordResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }

    public void GetAllHearingSpeechDataMethod(final Activity activity, final Context context, RecyclerView llmain, SwipeRefreshLayout mSwipeRefreshLayout, final GetAllHearingSpeechData_interface getAllHearingSpeechData_interface) {

        // loadershowwithMsg(context, "Loading...");
        mSwipeRefreshLayout.setRefreshing(true);

        Call<HearingSpeechimpairedDataResponse> responseCall = ApiClient.getClient().getAllGetHearingSpeechimpairedDataAPi();
        responseCall.enqueue(new Callback<HearingSpeechimpairedDataResponse>() {
            @Override
            public void onResponse(Call<HearingSpeechimpairedDataResponse> call, Response<HearingSpeechimpairedDataResponse> response) {
                // dailoghide(context);
                if (response.isSuccessful()) {

                    if (response.body().getResponse() == 200) {

                        mSwipeRefreshLayout.setRefreshing(false);

                        llmain.setVisibility(View.VISIBLE);

                        getAllHearingSpeechData_interface.GetHearingSpeechData(response.body().getData());


                    } else {

                    }


                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }
            }

            @Override
            public void onFailure(Call<HearingSpeechimpairedDataResponse> call, Throwable t) {
                mSwipeRefreshLayout.setRefreshing(false);
                // dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void getAllDataMethod(final Activity activity, final Context context, RecyclerView llmain, SwipeRefreshLayout mSwipeRefreshLayout, final GetAllData_interface getAllData_interface, String typeId) {

        // loadershowwithMsg(context, "Loading...");
        mSwipeRefreshLayout.setRefreshing(true);

        Call<ViewAllResponse> responseCall = ApiClient.getClient().getAllDataAPi(typeId);
        responseCall.enqueue(new Callback<ViewAllResponse>() {
            @Override
            public void onResponse(Call<ViewAllResponse> call, Response<ViewAllResponse> response) {
                // dailoghide(context);
                mSwipeRefreshLayout.setRefreshing(false);

                if (response.isSuccessful()) {

                    if (response.body().getResponse() == 200) {
                        llmain.setVisibility(View.VISIBLE);

                        getAllData_interface.GetAllData(response.body().getData());


                    } else {

                    }


                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }
            }

            @Override
            public void onFailure(Call<ViewAllResponse> call, Throwable t) {
                mSwipeRefreshLayout.setRefreshing(false);

                // dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }

    public void getAllDataMethod2(final Activity activity, final Context context, final GetAllData_interface getAllData_interface, String typeId) {

        loadershowwithMsg(context, "Loading...");
        //  mSwipeRefreshLayout.setRefreshing(true);

        Call<ViewAllResponse> responseCall = ApiClient.getClient().getAllDataAPi(typeId);
        responseCall.enqueue(new Callback<ViewAllResponse>() {
            @Override
            public void onResponse(Call<ViewAllResponse> call, Response<ViewAllResponse> response) {
                dailoghide(context);
                //  mSwipeRefreshLayout.setRefreshing(false);

                if (response.isSuccessful()) {

                    if (response.body().getResponse() == 200) {
                        //  llmain.setVisibility(View.VISIBLE);

                        getAllData_interface.GetAllData(response.body().getData());


                    } else {

                    }


                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }
            }

            @Override
            public void onFailure(Call<ViewAllResponse> call, Throwable t) {
                //  mSwipeRefreshLayout.setRefreshing(false);

                dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }

    public void getLibraryTypeByIdDataMethod(final Activity activity, final Context context, RecyclerView llmain, SwipeRefreshLayout mSwipeRefreshLayout, final GetLibTypeByIdData_interface getLibTypeByIdData_interface, String typeId) {

        // loadershowwithMsg(context, "Loading...");
        mSwipeRefreshLayout.setRefreshing(true);

        Call<LibraryTypeByIdResponse> responseCall = ApiClient.getClient().getLibraryTypeByIdDataAPi(typeId);
        responseCall.enqueue(new Callback<LibraryTypeByIdResponse>() {
            @Override
            public void onResponse(Call<LibraryTypeByIdResponse> call, Response<LibraryTypeByIdResponse> response) {
                // dailoghide(context);
                mSwipeRefreshLayout.setRefreshing(false);

                if (response.isSuccessful()) {

                    if (response.body().getResponse() == 200) {
                        llmain.setVisibility(View.VISIBLE);

                        getLibTypeByIdData_interface.GetAllLibTypeByIdData(response.body().getData());


                    } else {

                    }


                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }
            }

            @Override
            public void onFailure(Call<LibraryTypeByIdResponse> call, Throwable t) {
                mSwipeRefreshLayout.setRefreshing(false);

                // dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void getSubjectSughamDataMethod(final Activity activity, final Context context, final GetAllSubjectSughamData_interface anInterface, DivyangjanSubjectSughamRequest courseName) {

        loadershowwithMsg(context, "Loading...");


        Call<DivyangjanSubjectSughamResponse> responseCall = ApiClient.getClient().SubjectSughamListDataAPi(courseName);
        responseCall.enqueue(new Callback<DivyangjanSubjectSughamResponse>() {
            @Override
            public void onResponse(Call<DivyangjanSubjectSughamResponse> call, Response<DivyangjanSubjectSughamResponse> response) {
                dailoghide(context);

                if (response.isSuccessful()) {

                    if (response.body().getResponse() == 200) {

                        anInterface.GetAllSubjectSughamData(response.body().getData());


                    } else {

                    }


                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }
            }

            @Override
            public void onFailure(Call<DivyangjanSubjectSughamResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }

    public void getSubjectHearingDataMethod(final Activity activity, final Context context, final GetAllSubjectHearingData_interface anInterface, DivyangjanSubjectHearingRequest courseName) {

        loadershowwithMsg(context, "Loading...");


        Call<SubjectHearingResponse> responseCall = ApiClient.getClient().SubjectHearingListDataAPi(courseName);
        responseCall.enqueue(new Callback<SubjectHearingResponse>() {
            @Override
            public void onResponse(Call<SubjectHearingResponse> call, Response<SubjectHearingResponse> response) {
                dailoghide(context);

                if (response.isSuccessful()) {

                    if (response.body().getResponse() == 200) {

                        anInterface.GetAllSubjectHearingData(response.body().getData());


                    } else {

                    }


                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }
            }

            @Override
            public void onFailure(Call<SubjectHearingResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void postCreateUserMethod(final Activity activity, final Context context, final GetCreateUserData_interface anInterface, RegisterRequest request) {

        loadershowwithMsg(context, "Loading...");


        Call<RegisterResponse> responseCall = ApiClient.getClient().CreateUserDataAPi(request);
        responseCall.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                dailoghide(context);

                if (response.isSuccessful()) {

                    if (response.body().getResponse() == 200) {

                        anInterface.GetCreateUserAllData(response.body().getData());


                    } else if(response.body().getResponse() == 400 ) {
                        GlobalClass.dailogError(activity,"Already Exist.","This Mobile Number is belonging to Other User,\n Please use other Mobile number.");

                    } else  {

                    }


                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void getHeadingVisuallyImapiredDataMethod(final Activity activity, final Context context, final GetAllHeadingData_interface anInterface, HeadingVisuallyImapiredRequest subjecttype) {

        loadershowwithMsg(context, "Loading...");


        Call<HeadingVisuallyImapiredResponse> responseCall = ApiClient.getClient().HeadingVisuallyImapiredListDataAPi(subjecttype);
        responseCall.enqueue(new Callback<HeadingVisuallyImapiredResponse>() {
            @Override
            public void onResponse(Call<HeadingVisuallyImapiredResponse> call, Response<HeadingVisuallyImapiredResponse> response) {
                dailoghide(context);

                if (response.isSuccessful()) {

                    if (response.body().getResponse() == 200) {

                        anInterface.GetAllHeadingImapiredData(response.body().getData());


                    } else {

                    }


                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }
            }

            @Override
            public void onFailure(Call<HeadingVisuallyImapiredResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void getDivyangjanSubjectVisuallyImapiredDataMethod(final Activity activity, final Context context, final GetAllsubjectVisuallyImparedData_interface anInterface) {

        loadershowwithMsg(context, "Loading...");


        Call<DivyangjanSubjectVisuallyImapiredResponse> responseCall = ApiClient.getClient().getAllDivyangjanSubjectVisuallyImapiredAPi();
        responseCall.enqueue(new Callback<DivyangjanSubjectVisuallyImapiredResponse>() {
            @Override
            public void onResponse(Call<DivyangjanSubjectVisuallyImapiredResponse> call, Response<DivyangjanSubjectVisuallyImapiredResponse> response) {
                dailoghide(context);

                if (response.isSuccessful()) {

                    if (response.body().getResponse() == 200) {

                        anInterface.GetAllSubjectVisuallyImapiredData(response.body().getData());


                    } else {

                    }


                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }
            }

            @Override
            public void onFailure(Call<DivyangjanSubjectVisuallyImapiredResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void getVisuallyImapiredListDataMethod(final Activity activity, final Context context, final GetAllvisuallyImparedLibData_interface anInterface, DivyangjanvisuallyImparedRequest courseName) {

        loadershowwithMsg(context, "Loading...");


        Call<VisualyImapiredcontentResponse> responseCall = ApiClient.getClient().VisuallyImapiredListDataAPi(courseName);
        responseCall.enqueue(new Callback<VisualyImapiredcontentResponse>() {
            @Override
            public void onResponse(Call<VisualyImapiredcontentResponse> call, Response<VisualyImapiredcontentResponse> response) {
                dailoghide(context);

                if (response.isSuccessful()) {

                    if (response.body().getResponse() == 200) {

                        anInterface.GetAllVisualyImapiredLibData(response.body().getData());


                    } else {

                    }


                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }
            }

            @Override
            public void onFailure(Call<VisualyImapiredcontentResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void getSughamLibraryDataMethod(final Activity activity, final Context context, final GetAllSughamLibData_interface anInterface, DivyangjanSughamLibraryRequest courseName) {

        loadershowwithMsg(context, "Loading...");


        Call<DivyangjanSughamLibraryResponse> responseCall = ApiClient.getClient().SughamLibraryListDataAPi(courseName);
        responseCall.enqueue(new Callback<DivyangjanSughamLibraryResponse>() {
            @Override
            public void onResponse(Call<DivyangjanSughamLibraryResponse> call, Response<DivyangjanSughamLibraryResponse> response) {
                dailoghide(context);

                if (response.isSuccessful()) {

                    if (response.body().getResponse() == 200) {

                        anInterface.GetAllSughamLibData(response.body().getData());


                    } else {

                    }


                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }
            }

            @Override
            public void onFailure(Call<DivyangjanSughamLibraryResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void getHearingContentListDataAPiDataMethod(final Activity activity, final Context context, final GetAllHearingContentData_interface anInterface, DivyangjanHearingContentRequest courseName) {

        loadershowwithMsg(context, "Loading...");


        Call<HearingContentResponse> responseCall = ApiClient.getClient().HearingContentListDataAPi(courseName);
        responseCall.enqueue(new Callback<HearingContentResponse>() {
            @Override
            public void onResponse(Call<HearingContentResponse> call, Response<HearingContentResponse> response) {
                dailoghide(context);

                if (response.isSuccessful()) {

                    if (response.body().getResponse() == 200) {

                        anInterface.GetHearingContentLibData(response.body().getData());


                    } else {

                    }


                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }
            }

            @Override
            public void onFailure(Call<HearingContentResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void GetAllLibraryTypesDataMethod(final Activity activity, final Context context, RecyclerView llmain, SwipeRefreshLayout mSwipeRefreshLayout, final GetAllLibraryTypesData_interface getAllLibraryTypesData_interface) {

        // loadershowwithMsg(context, "Loading...");
        mSwipeRefreshLayout.setRefreshing(true);

        Call<LibraryTypeAndCoutResponse> responseCall = ApiClient.getClient().getAllLibraryTypeAPi();
        responseCall.enqueue(new Callback<LibraryTypeAndCoutResponse>() {
            @Override
            public void onResponse(Call<LibraryTypeAndCoutResponse> call, Response<LibraryTypeAndCoutResponse> response) {
                // dailoghide(context);
                if (response.isSuccessful()) {

                    if (response.body().getResponse() == 200) {

                        mSwipeRefreshLayout.setRefreshing(false);

                        llmain.setVisibility(View.VISIBLE);

                        getAllLibraryTypesData_interface.GetLibrarytypesData(response.body().getData());


                    } else {

                    }


                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }
            }

            @Override
            public void onFailure(Call<LibraryTypeAndCoutResponse> call, Throwable t) {
                mSwipeRefreshLayout.setRefreshing(false);
                // dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }

    public void ProfileDataMethod(final Activity activity, final Context context, ConstraintLayout llmain, final ProfileData_interface profileData_interface, String MobileNo) {

        loadershowwithMsg(context, "Loading...");

        Call<ProfileDataResponse> responseCall = ApiClient.getClient().getProfileDataAPi(MobileNo);
        responseCall.enqueue(new Callback<ProfileDataResponse>() {
            @Override
            public void onResponse(Call<ProfileDataResponse> call, Response<ProfileDataResponse> response) {
                dailoghide(context);
                if (response.isSuccessful()) {

                    if (response.body().getResponse() == 200) {
                        llmain.setVisibility(View.VISIBLE);

                        profileData_interface.userprofiledata(response.body().getData());


                    } else {

                    }


                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }
            }

            @Override
            public void onFailure(Call<ProfileDataResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void loginPostDataMethod(final Activity activity, final Context context, final LoginData_interface loginData_interface, LoginRequest request) {

        loadershowwithMsg(context, "We are veryfing your Detail for login.");

        Call<LoginResponse> userpost_responseCall = ApiClient.getClient().LoginUser(request);
        userpost_responseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                dailoghide(context);
                if (response.isSuccessful()) {


                    if (response.body().getResponse() == 200) {

                        loginData_interface.alluserdata((LoginResponse.Data) response.body().getData());
                        Intent intentlogin = new Intent(context, MainActivity.class);
                        intentlogin.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        intentlogin.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        context.startActivity(intentlogin);
                        activity.finish();


                    } else {
                        dailogError(context, "Credentials Not Found!", "You have entered wrong credentials.");
                    }

                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void forgotPasswordPostDataMethod(final Activity activity, final Context context, ForgotPasswordRequest request) {

        loadershowwithMsg(context, "We are Sending auto generated password on your Registered Mobile number.");

        // Call<LoginResponse> userpost_responseCall = ApiClient.getClient().LoginUser(PhoneNo, Password, FcmToken);
        Call<ForgotPasswordResponse> userpost_responseCall = ApiClient.getClient().ForgetPasswordUser(request);
        userpost_responseCall.enqueue(new Callback<ForgotPasswordResponse>() {
            @Override
            public void onResponse(Call<ForgotPasswordResponse> call, Response<ForgotPasswordResponse> response) {
                dailoghide(context);
                if (response.isSuccessful()) {


                    if (response.body().getResponse() == 200) {

                        dailogsuccessWithActivity(context, activity, " Password has been Changed and Sent Successfully.", "New auto generated password has been sent on your Registered Mobile number .");


                    } else {
                        dailogError(context, "Mobile Number Not Found!", "The Mobile Number You have entered is not Regitered with Us.");
                    }


                } else {
                    GlobalClass.showtost(context, "Something went wrong. Please try after sometimes." + response.message());
                }

            }

            @Override
            public void onFailure(Call<ForgotPasswordResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void VerifyOtpPostDataMethod(final Activity activity, final Context context, OtpVerifyData_interface otpVerifyData_interface, VerifyOtpRequest request) {

        loadershowwithMsg(context, "Registration Process is going on....");

        // Call<LoginResponse> userpost_responseCall = ApiClient.getClient().LoginUser(PhoneNo, Password, FcmToken);
        Call<VerifyOtpResponse> userpost_responseCall = ApiClient.getClient().verifyOTP(request);
        userpost_responseCall.enqueue(new Callback<VerifyOtpResponse>() {
            @Override
            public void onResponse(Call<VerifyOtpResponse> call, Response<VerifyOtpResponse> response) {
                dailoghide(context);
                if (response.isSuccessful()) {


                    if (response.body().getResponse() == 200) {

                        // dailogsuccessanddismis(context,activity, "New Password Sent Successfull.", "New auto generated password has been sent on your Registered Mobile number .");
                        otpVerifyData_interface.userOtpVerifydata(response.body().getResponse());


                    } else {
                        dailogError(context, "Mobile Number Not Found!", "The Mobile Number You have entered is not Regitered with Us.");
                    }


                } else {
                    GlobalClass.showtost(context, "Something went wrong. Please try after sometimes." + response.message());
                }

            }

            @Override
            public void onFailure(Call<VerifyOtpResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void allRegistered_listMethod(final Context context, String CollegeId, String VerificattionStatus, final GetAllRegisteredUserData_interface allRegisteredUserData_interface) {

        loadershowwithMsg(context, "Getting All Registered User List...");
        Call<RegisteredListResponse> userpost_responseCall = ApiClient.getClient().RegisteredListDataAPi(CollegeId, VerificattionStatus);
        userpost_responseCall.enqueue(new Callback<RegisteredListResponse>() {
            @Override
            public void onResponse(Call<RegisteredListResponse> call, Response<RegisteredListResponse> response) {
                dailoghide(context);
                if (response.isSuccessful() && response.code() == 200) {
                    // GlobalClass.showtost(context, "" + response.message());
                    allRegisteredUserData_interface.GetAllRegisteredUserData((response.body().getData()));
                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }
            }

            @Override
            public void onFailure(Call<RegisteredListResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                //Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
                // Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void allFilteredRegistered_listMethod(final Context context, String DistrictIDORCastIDORCOurseID, final GetAllRegisteredUserData_interface allRegisteredUserData_interface) {

        loadershowwithMsg(context, "Getting All Registered User List...");
        Call<RegisteredListResponse> userpost_responseCall = ApiClient.getClient().FilteredListDataAPi(DistrictIDORCastIDORCOurseID);
        userpost_responseCall.enqueue(new Callback<RegisteredListResponse>() {
            @Override
            public void onResponse(Call<RegisteredListResponse> call, Response<RegisteredListResponse> response) {
                dailoghide(context);
                if (response.isSuccessful() && response.code() == 200) {
                    // GlobalClass.showtost(context, "" + response.message());
                    allRegisteredUserData_interface.GetAllRegisteredUserData((response.body().getData()));
                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }
            }

            @Override
            public void onFailure(Call<RegisteredListResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                //Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
                // Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }

    public void allCouseClass_listMethod(final Context context, final GetAllCourseClassData_interface anInterface) {

        loadershowwithMsg(context, "Getting All Course/Class List...");
        Call<DivyangjanCourseSughamResponse> userpost_responseCall = ApiClient.getClient().DivyangjanGetCourseClassDataAPi();
        userpost_responseCall.enqueue(new Callback<DivyangjanCourseSughamResponse>() {
            @Override
            public void onResponse(Call<DivyangjanCourseSughamResponse> call, Response<DivyangjanCourseSughamResponse> response) {
                dailoghide(context);
                if (response.isSuccessful() && response.code() == 200) {
                    //  GlobalClass.showtost(context, "" + response.message());
                    anInterface.GetAllCourseClassData((response.body().getData()));
                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }
            }

            @Override
            public void onFailure(Call<DivyangjanCourseSughamResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                //Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
                // Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void allDistrict_listMethod(final Context context, final GetAllDistricData_interface getAllDistricData_interface) {

        loadershowwithMsg(context, "Getting All District List...");
        Call<DivyangjanGetDistrictResponse> userpost_responseCall = ApiClient.getClient().DivyangjanGetDistrictDataAPi();
        userpost_responseCall.enqueue(new Callback<DivyangjanGetDistrictResponse>() {
            @Override
            public void onResponse(Call<DivyangjanGetDistrictResponse> call, Response<DivyangjanGetDistrictResponse> response) {
                dailoghide(context);
                if (response.isSuccessful() && response.code() == 200) {
                    // GlobalClass.showtost(context, "" + response.message());
                    getAllDistricData_interface.GetAllDistricData((response.body().getData()));
                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }
            }

            @Override
            public void onFailure(Call<DivyangjanGetDistrictResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                //Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
                // Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }

    public void allSubjectCombination_listMethod(final Context context, String collegeID, String courseID, String SectionId, final GetSubjectCombinationData_interface getSubjectCombinationData_interface) {

        loadershowwithMsg(context, "Getting  Subject Combination List...");
        Call<SubjectCombinationResponse> userpost_responseCall = ApiClient.getClient().SubjectCombinationAPi(collegeID, courseID, SectionId);
        userpost_responseCall.enqueue(new Callback<SubjectCombinationResponse>() {
            @Override
            public void onResponse(Call<SubjectCombinationResponse> call, Response<SubjectCombinationResponse> response) {
                dailoghide(context);
                if (response.isSuccessful() && response.code() == 200) {
                    // GlobalClass.showtost(context, "" + response.message());
                    getSubjectCombinationData_interface.GetSubjectCombinationData((response.body().getData()));
                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }
            }

            @Override
            public void onFailure(Call<SubjectCombinationResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                //Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
                // Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }

    public void allSection_listMethod(final Context context, String collegeID, String courseID, final GetAllSectionData_interface allSectionData_interface) {

        loadershowwithMsg(context, "Getting All Section List...");
        Call<SectionResponse> userpost_responseCall = ApiClient.getClient().SectionDataAPi(collegeID, courseID);
        userpost_responseCall.enqueue(new Callback<SectionResponse>() {
            @Override
            public void onResponse(Call<SectionResponse> call, Response<SectionResponse> response) {
                dailoghide(context);
                if (response.isSuccessful() && response.code() == 200) {
                    // GlobalClass.showtost(context, "" + response.message());
                    allSectionData_interface.GetAllSectionData((response.body().getData()));
                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }
            }

            @Override
            public void onFailure(Call<SectionResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                //Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
                // Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }

    public void allFilterCourse_listMethod(final Context context, final GetAllFilterCourseSearchData_interface getAllFilterCourseSearchData_interface) {

        loadershowwithMsg(context, "Getting  Course List...");
        Call<FilterAllCourseResponse> userpost_responseCall = ApiClient.getClient().GetFilterAllCourseDataAPi();
        userpost_responseCall.enqueue(new Callback<FilterAllCourseResponse>() {
            @Override
            public void onResponse(Call<FilterAllCourseResponse> call, Response<FilterAllCourseResponse> response) {
                dailoghide(context);
                if (response.isSuccessful() && response.code() == 200) {
                    //  GlobalClass.showtost(context, "" + response.message());
                    getAllFilterCourseSearchData_interface.GetAllFilterSearchCourseResponseData((response.body().getData()));
                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }
            }

            @Override
            public void onFailure(Call<FilterAllCourseResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                //Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
                // Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }

    public void allCourse_listMethod(final Context context, String collegeID, final GetCourseByCollegeIdData_interface getCourseByCollegeIdData_interface) {

        loadershowwithMsg(context, "Getting All Course List...");
        Call<CourseByCollegeIDResponse> userpost_responseCall = ApiClient.getClient().CourseDataAPi(collegeID);
        userpost_responseCall.enqueue(new Callback<CourseByCollegeIDResponse>() {
            @Override
            public void onResponse(Call<CourseByCollegeIDResponse> call, Response<CourseByCollegeIDResponse> response) {
                dailoghide(context);
                if (response.isSuccessful() && response.code() == 200) {
                    //  GlobalClass.showtost(context, "" + response.message());
                    getCourseByCollegeIdData_interface.GetAllCourseByCollegeIDData((response.body().getData()));
                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }
            }

            @Override
            public void onFailure(Call<CourseByCollegeIDResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                //Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
                // Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }

    public void allCollege_listMethod(final Context context, String distric, final GetAllCollegeData_interface getAllCollegeData_interface) {

        loadershowwithMsg(context, "Getting All College List...");
        Call<CollegeListResponse> userpost_responseCall = ApiClient.getClient().CollegeDataAPi(distric);
        userpost_responseCall.enqueue(new Callback<CollegeListResponse>() {
            @Override
            public void onResponse(Call<CollegeListResponse> call, Response<CollegeListResponse> response) {
                dailoghide(context);
                if (response.isSuccessful() && response.code() == 200) {
                    // GlobalClass.showtost(context, "" + response.message());
                    getAllCollegeData_interface.GetAllCollegeData((response.body().getData()));
                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }
            }

            @Override
            public void onFailure(Call<CollegeListResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                //Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
                // Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }

    public void allCast_listMethod(final Context context, final GetAllCastCategoryData_interface allCastCategoryData_interface) {

        loadershowwithMsg(context, "Getting All Cast Category List...");
        Call<CastCategoryResponse> userpost_responseCall = ApiClient.getClient().CastCategoryDataAPi();
        userpost_responseCall.enqueue(new Callback<CastCategoryResponse>() {
            @Override
            public void onResponse(Call<CastCategoryResponse> call, Response<CastCategoryResponse> response) {
                dailoghide(context);
                if (response.isSuccessful() && response.code() == 200) {
                    // GlobalClass.showtost(context, "" + response.message());
                    allCastCategoryData_interface.GetAllCastCategoryData((response.body().getData()));
                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }
            }

            @Override
            public void onFailure(Call<CastCategoryResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                //Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
                // Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void allCourseHearing_listMethod(final Context context, final GetAllHearingcourseData_interface anInterface) {

        loadershowwithMsg(context, "Getting All Course List...");
        Call<CourseHearingResponse> userpost_responseCall = ApiClient.getClient().CourseHearingListDataAPi();
        userpost_responseCall.enqueue(new Callback<CourseHearingResponse>() {
            @Override
            public void onResponse(Call<CourseHearingResponse> call, Response<CourseHearingResponse> response) {
                dailoghide(context);
                if (response.isSuccessful() && response.code() == 200) {
                    // GlobalClass.showtost(context, "" + response.message());
                    anInterface.GetAllCourseHearingData((response.body().getData()));
                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }
            }

            @Override
            public void onFailure(Call<CourseHearingResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                //Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
                // Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void allState_listMethod(final Context context, final GetAllStateData_interface getAllStateData_interface) {

        loadershowwithMsg(context, "Getting State List...");
        Call<StateResponse> userpost_responseCall = ApiClient.getClient().StateResponseDataAPi();
        userpost_responseCall.enqueue(new Callback<StateResponse>() {
            @Override
            public void onResponse(Call<StateResponse> call, Response<StateResponse> response) {
                dailoghide(context);
                if (response.isSuccessful() && response.code() == 200) {
                    // GlobalClass.showtost(context, "" + response.message());
                    getAllStateData_interface.GetAllStateResponseData((response.body().getData()));
                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }
            }

            @Override
            public void onFailure(Call<StateResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                //Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
                // Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }

    public void allDisabilityTypeOtherUser_listMethod(final Context context, final GetAllDisabilityTypeOthersUserData_interface getAllDisabilityTypeOthersUserData_interface) {

        loadershowwithMsg(context, "Getting  Disability Type List...");
        Call<DisabilityTypeResponse> userpost_responseCall = ApiClient.getClient().DivyangjanGetDisabilityTypeOthersUserDataAPi();
        userpost_responseCall.enqueue(new Callback<DisabilityTypeResponse>() {
            @Override
            public void onResponse(Call<DisabilityTypeResponse> call, Response<DisabilityTypeResponse> response) {
                dailoghide(context);
                if (response.isSuccessful() && response.code() == 200) {
                    // GlobalClass.showtost(context, "" + response.message());
                    getAllDisabilityTypeOthersUserData_interface.GetAllDisabilityTypeOthersUserData((response.body().getData()));
                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }
            }

            @Override
            public void onFailure(Call<DisabilityTypeResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                //Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
                // Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void registrationPostDataMethodForOtherStudent(final Activity activity, final Context context,
                                                          RequestBody
                                                                  MobileNo,
                                                          RequestBody
                                                                  StudentId,
                                                          MultipartBody.Part CertificatePath) {

        loadershowwithMsg(context, "Completion of Registration process is going on...");
        Call<RegistrationRespone> userpost_responseCall = ApiClient.getClient().completeRegistrationByOtherStudent(StudentId,
                MobileNo,
                CertificatePath);
        userpost_responseCall.enqueue(new Callback<RegistrationRespone>() {

            @Override
            public void onResponse(Call<RegistrationRespone> call, Response<RegistrationRespone> response) {
                dailoghide(context);
                if (response.code() == 200) {
                    if (response.body().getResponse() == 200) {
                        // dailogsuccessWithActivity(context, activity, "Registration successful", "Registration process completed successful.");
                        boolean firstTimelogin = true;

*/
/*
                        try {
                            CSPreferences.putString(activity, "User_Name", response.body().getData().get(0).getName());
                            CSPreferences.putString(activity, "Status", response.body().getData().get(0).getActive());
                            CSPreferences.putString(activity, "PhoneNo", response.body().getData().get(0).getMobile());
                            CSPreferences.putString(activity, "Email", response.body().getData().get(0).getEmail());
                            CSPreferences.putString(activity, "token", response.body().getData().get(0).getMobile());
                            CSPreferences.putBolean(activity, "firstTimelogin", firstTimelogin);
                            CSPreferences.putBolean(activity, "skiplogin", false);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }*//*

                        Intent intent = new Intent(activity, MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                        activity.startActivity(intent);


                    } else if (response.body().getResponse() == 0) {
                        dailogError(context, "Error!", "Server is busy,Registration process failed!,Please try after sometimes");

                        //  dailogError(context, "Error!", "This Number is already Registered with Us, you can try with other Number!");
                    } else {
                        dailogError(context, "Error!", "Server is busy,Registration process failed!,Please try after sometimes");


                    }


                } else {
                    //  GlobalClass.showtost(context, "" + response.message());
                }
            }

            @Override
            public void onFailure(Call<RegistrationRespone> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }

    public void registrationPostDataMethod(final Activity activity, final Context context, RequestBody
            District_Id,
                                           RequestBody
                                                   college,
                                           RequestBody
                                                   Course,
                                           RequestBody
                                                   Section,
                                           RequestBody
                                                   Combination,
                                           RequestBody
                                                   RollNo,
                                           RequestBody
                                                   StudentName,
                                           RequestBody
                                                   FatherName,
                                           RequestBody
                                                   DOB,
                                           RequestBody
                                                   Gender,
                                           RequestBody
                                                   MobileNo,
                                           RequestBody
                                                   ParentMobileNo,
                                           RequestBody
                                                   PercentageOfDisability,
                                           RequestBody
                                                   Diabiltyid,
                                           RequestBody
                                                   DifferentlyAbledCategory,

                                           RequestBody
                                                   DifferentlyAskedCategory_Type,


                                           RequestBody
                                                   CasteCategory,
                                           RequestBody
                                                   Address,
                                           RequestBody
                                                   confirmpassword,

                                           RequestBody
                                                   StateId,
                                           RequestBody
                                                   EmailID,
                                           RequestBody
                                                   FcmToken_Id,
                                           RequestBody
                                                   Sem,
                                           RequestBody
                                                   OtherCollege,
                                           RequestBody
                                                   OtherCourse,
                                           RequestBody
                                                   OtherSection,
                                           RequestBody
                                                   OtherSubjectCombination,
                                           RequestBody
                                                   StudentId,


                                           RequestBody
                                                   userType,
                                           MultipartBody.Part FileName,
                                           MultipartBody.Part CertificatefileName) {

        loadershowwithMsg(context, "Completion of Registration process is going on...");
        Call<RegistrationRespone> userpost_responseCall = ApiClient.getClient().completeRegistrationByHryStudent(District_Id,
                college,
                Course,
                Section,
                Combination,
                RollNo,
                StudentName,
                FatherName,
                DOB,
                Gender,
                MobileNo,
                ParentMobileNo,
                PercentageOfDisability,
                Diabiltyid,
                DifferentlyAbledCategory,
                DifferentlyAskedCategory_Type,
                CasteCategory,
                Address,
                confirmpassword,
                StateId,
                EmailID,
                FcmToken_Id,
                userType,
                Sem,
                OtherCollege,
                OtherCourse,
                OtherSection,
                OtherSubjectCombination,
                StudentId,
                FileName,
                CertificatefileName);
        userpost_responseCall.enqueue(new Callback<RegistrationRespone>() {

            @Override
            public void onResponse(Call<RegistrationRespone> call, Response<RegistrationRespone> response) {
                dailoghide(context);
                if (response.code() == 200) {
                    if (response.body().getResponse() == 200) {
                        // dailogsuccessWithActivity(context, activity, "Registration successful", "Registration process completed successful.");
                        boolean firstTimelogin = true;


                        try {
                            CSPreferences.putString(activity, "User_Name", response.body().getData().get(0).getName());
                            CSPreferences.putString(activity, "Status", response.body().getData().get(0).getActive());
                            CSPreferences.putString(activity, "PhoneNo", response.body().getData().get(0).getMobile());
                            CSPreferences.putString(activity, "Email", response.body().getData().get(0).getEmail());
                            CSPreferences.putString(activity, "token", response.body().getData().get(0).getMobile());
                            CSPreferences.putBolean(activity, "firstTimelogin", firstTimelogin);
                            CSPreferences.putBolean(activity, "skiplogin", false);


//                            if (data2.getPic() == null) {
//                                data2.setPic(imageurl);
//                            }
//
//                            CSPreferences.putString(activity, "pic", data2.getPic());

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

//                        CSPreferences.putString(activity, "id", response.body().getData().get(0).getMobile());
//                        CSPreferences.putString(activity, "User_Id", String.valueOf(response.body().getRegistration_Id()));
//                        CSPreferences.putString(activity, "User_mobile", response.body().getMobile());
//                        CSPreferences.putString(activity, "User_email", response.body().getEmail());
//                        CSPreferences.putString(activity, "User_name", response.body().getStundentName());
//                       CSPreferences.putBolean(activity, "firstTimelogin", firstTimelogin);
//
//                        // CSPreferences.putString(activity, "lativale", lativale);
//                        // CSPreferences.putString(activity, "longivalue", longivalue);
//                        //CSPreferences.putString(activity, "admissionURL", admissionURL);
//                        CSPreferences.putString(activity, "AdmissionportalUrl", response.body().getAdmissionportalUrl());
//                        CSPreferences.putString(activity, "Profilepicurl", response.body().getProfilePic());

                        Intent intent = new Intent(activity, MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                        activity.startActivity(intent);


                    } else if (response.body().getResponse() == 0) {
                        dailogError(context, "Error!", "Server is busy,Registration process failed!,Please try after sometimes");

                        //  dailogError(context, "Error!", "This Number is already Registered with Us, you can try with other Number!");
                    } else {
                        dailogError(context, "Error!", "Server is busy,Registration process failed!,Please try after sometimes");


                    }


                } else {
                    //  GlobalClass.showtost(context, "" + response.message());
                }
            }

            @Override
            public void onFailure(Call<RegistrationRespone> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }

    public void admindata_listMethod(final Context context, String token, SwipeRefreshLayout simpleSwipeRefreshLayout, final GetAdminAllData_interface dataInterface) {

        //  loadershowwithMsg(context, "Getting All Student List...");

        simpleSwipeRefreshLayout.setRefreshing(true);

        Call<AdminDataResponse> CollegeScheme = ApiClient.getClient().adminDataAPi(token);
        CollegeScheme.enqueue(new Callback<AdminDataResponse>() {
            @Override
            public void onResponse(Call<AdminDataResponse> call, Response<AdminDataResponse> response) {
                // dailoghide(context);


                simpleSwipeRefreshLayout.setRefreshing(false);

                if (response.isSuccessful() && response.code() == 200) {
                    // GlobalClass.showtost(context, "" + response.message());
                    assert response.body() != null;
                    dataInterface.GetAdminAllData((response.body().getData()));
                } else if (response.code() == 401) {
                    CSPreferences.clearPref(context);
                    Intent intent = new Intent(context, LoginActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                            Intent.FLAG_ACTIVITY_CLEAR_TASK |
                            Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                    GlobalClass.showtost(context, "" + response.message());
                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }
            }

            @Override
            public void onFailure(Call<AdminDataResponse> call, Throwable t) {
                simpleSwipeRefreshLayout.setRefreshing(false);

                // dailoghide(context);
                t.printStackTrace();
                //Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
                // Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }

*/

}















