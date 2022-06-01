package hsvp.digital.allottee_corner.apicall;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;

import androidx.appcompat.widget.LinearLayoutCompat;

import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;
import hsvp.digital.allottee_corner.allinterface.ForgotPasswordData_interface;
import hsvp.digital.allottee_corner.allinterface.LoginData_interface;
import hsvp.digital.allottee_corner.allinterface.allottePaymentReceived2Data_interface;
import hsvp.digital.allottee_corner.allinterface.allottePaymentReceivedData_interface;
import hsvp.digital.allottee_corner.allinterface.allottePaymentReceivedDetailsData_interface;
import hsvp.digital.allottee_corner.allinterface.allottecurrentoutstandingData_interface;
import hsvp.digital.allottee_corner.allinterface.allotteeAppStatusData_interface;
import hsvp.digital.allottee_corner.allinterface.allotteeHistoryData_interface;
import hsvp.digital.allottee_corner.allinterface.allotteeNoticesData_interface;
import hsvp.digital.allottee_corner.allinterface.allotteePlotInfoData_interface;
import hsvp.digital.allottee_corner.allinterface.allotteedetailData_interface;
import hsvp.digital.allottee_corner.allinterface.allotteefutureoustandingData_interface;
import hsvp.digital.allottee_corner.allinterface.allotteefutureoustandingdetaildetailData_interface;
import hsvp.digital.allottee_corner.allinterface.allotteeplotedetailData_interface;
import hsvp.digital.allottee_corner.allinterface.fetchjointdetaildetailData_interface;
import hsvp.digital.allottee_corner.model.AlloteeHistoryResponse;
import hsvp.digital.allottee_corner.model.AllotteApplicationStatusResponse;
import hsvp.digital.allottee_corner.model.AllotteCurrentOutStandingResponse;
import hsvp.digital.allottee_corner.model.AllotteNoticesResponse;
import hsvp.digital.allottee_corner.model.AllottePaymentReceived2Response;
import hsvp.digital.allottee_corner.model.AllottePaymentReceivedDetailsResponse;
import hsvp.digital.allottee_corner.model.AllottePaymentReceivedResponse;
import hsvp.digital.allottee_corner.model.AllottePlotInfoResponse;
import hsvp.digital.allottee_corner.model.AllottefutureOutStandingDetailsResponse;
import hsvp.digital.allottee_corner.model.AllottefutureOutStandingResponse;
import hsvp.digital.allottee_corner.model.AllotteplotdetailsResponse;
import hsvp.digital.allottee_corner.model.AppStatusRequest;
import hsvp.digital.allottee_corner.model.FetchAllottedetailsResponse;
import hsvp.digital.allottee_corner.model.FetchJointHolderDetailsResponse;
import hsvp.digital.allottee_corner.model.ForgotPasswordRequest;
import hsvp.digital.allottee_corner.model.ForgotPasswordResponse;
import hsvp.digital.allottee_corner.model.LoginRequest;
import hsvp.digital.allottee_corner.model.LoginResponse;
import hsvp.digital.allottee_corner.model.PaymentReceivedDetailsRequest;
import hsvp.digital.allottee_corner.model.PlotIdRequest;
import hsvp.digital.allottee_corner.retrofitinterface.ApiClient;
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


    public void loginPostDataMethod(final Activity activity, final Context context, final LoginData_interface loginData_interface, LoginRequest request) {

        loadershowwithMsg(context, "We are veryfing your Detail for login.");

        Call<LoginResponse> userpost_responseCall = ApiClient.getClient().LoginUser(request);
        userpost_responseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                dailoghide(context);
                if (response.isSuccessful()) {


                    if (response.body().getResponse() == 200) {

                        loginData_interface.alluserdata((List<LoginResponse.Datum>) response.body().getData());
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


    public void allotteCurrentOutStandingMethod(final Activity activity, final Context context, final allottecurrentoutstandingData_interface loginData_interface, PlotIdRequest request) {

        loadershowwithMsg(context, "Loading...");
        Call<AllotteCurrentOutStandingResponse> userpost_responseCall = ApiClient.getClient().allotteCurrentOutStandingApi(request);
        userpost_responseCall.enqueue(new Callback<AllotteCurrentOutStandingResponse>() {
            @Override
            public void onResponse(Call<AllotteCurrentOutStandingResponse> call, Response<AllotteCurrentOutStandingResponse> response) {
                dailoghide(context);
                if (response.isSuccessful()) {


                    if (response.body().getResponse() == 200) {

                        loginData_interface.allallottecurrentoutstandingdata((List<AllotteCurrentOutStandingResponse.Datum>) response.body().getData());

                    } else {
                        dailogError(context, "Server Busy!", "Please try again.");
                    }

                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }

            }

            @Override
            public void onFailure(Call<AllotteCurrentOutStandingResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void allotteCurrentOutStandingDetailsApiMethod(final Activity activity, final Context context, final allottecurrentoutstandingData_interface loginData_interface, PlotIdRequest request, LinearLayoutCompat llmain) {

        loadershowwithMsg(context, "Loading...");
        Call<AllotteCurrentOutStandingResponse> userpost_responseCall = ApiClient.getClient().allotteCurrentOutStandingDetailsApi(request);
        userpost_responseCall.enqueue(new Callback<AllotteCurrentOutStandingResponse>() {
            @Override
            public void onResponse(Call<AllotteCurrentOutStandingResponse> call, Response<AllotteCurrentOutStandingResponse> response) {
                dailoghide(context);
                if (response.isSuccessful()) {


                    if (response.body().getResponse() == 200) {
                        llmain.setVisibility(View.VISIBLE);

                        loginData_interface.allallottecurrentoutstandingdata((List<AllotteCurrentOutStandingResponse.Datum>) response.body().getData());

                    } else {
                        dailogError(context, "Server Busy!", "Please try again.");
                    }

                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }

            }

            @Override
            public void onFailure(Call<AllotteCurrentOutStandingResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void allottefutureOutStandingAPiMethod(final Activity activity, final Context context, final allotteefutureoustandingData_interface loginData_interface, PlotIdRequest request) {

        loadershowwithMsg(context, "Loading...");
        Call<AllottefutureOutStandingResponse> userpost_responseCall = ApiClient.getClient().allottefutureOutStandingAPi(request);
        userpost_responseCall.enqueue(new Callback<AllottefutureOutStandingResponse>() {
            @Override
            public void onResponse(Call<AllottefutureOutStandingResponse> call, Response<AllottefutureOutStandingResponse> response) {
                dailoghide(context);
                if (response.isSuccessful()) {


                    if (response.body().getResponse() == 200) {

                        loginData_interface.allotteefutureoustandingdata((List<AllottefutureOutStandingResponse.Datum>) response.body().getData());

                    } else {
                        dailogError(context, "Server Busy!", "Please try again.");
                    }

                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }

            }

            @Override
            public void onFailure(Call<AllottefutureOutStandingResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void allotteplotdetailsMethod(final Activity activity, final Context context, final allotteeplotedetailData_interface loginData_interface, PlotIdRequest request) {

        loadershowwithMsg(context, "Loading...");
        Call<AllotteplotdetailsResponse> userpost_responseCall = ApiClient.getClient().allotteplotdetailsAPi(request);
        userpost_responseCall.enqueue(new Callback<AllotteplotdetailsResponse>() {
            @Override
            public void onResponse(Call<AllotteplotdetailsResponse> call, Response<AllotteplotdetailsResponse> response) {
                dailoghide(context);
                if (response.isSuccessful()) {


                    if (response.body().getResponse() == 200) {

                        loginData_interface.allotteeplotedetaildata((List<AllotteplotdetailsResponse.Datum>) response.body().getData());

                    } else {
                        dailogError(context, "Server Busy!", "Please try again.");
                    }

                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }

            }

            @Override
            public void onFailure(Call<AllotteplotdetailsResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void FetchAllottedetailsMethod(final Activity activity, final Context context, final allotteedetailData_interface loginData_interface, PlotIdRequest request, LinearLayoutCompat llmain) {

        loadershowwithMsg(context, "Loading...");
        Call<FetchAllottedetailsResponse> userpost_responseCall = ApiClient.getClient().FetchAllottedetailsAPi(request);
        userpost_responseCall.enqueue(new Callback<FetchAllottedetailsResponse>() {
            @Override
            public void onResponse(Call<FetchAllottedetailsResponse> call, Response<FetchAllottedetailsResponse> response) {
                dailoghide(context);
                if (response.isSuccessful()) {


                    if (response.body().getResponse() == 200) {

                        llmain.setVisibility(View.VISIBLE);

                        loginData_interface.allotteedetaildata((List<FetchAllottedetailsResponse.Datum>) response.body().getData());

                    } else {
                        dailogError(context, "Server Busy!", "Please try again.");
                    }

                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }

            }

            @Override
            public void onFailure(Call<FetchAllottedetailsResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void FetchJointHolderMethod(final Activity activity, final Context context, final fetchjointdetaildetailData_interface loginData_interface, PlotIdRequest request) {

        loadershowwithMsg(context, "Loading...");
        Call<FetchJointHolderDetailsResponse> userpost_responseCall = ApiClient.getClient().FetchJointHolderDetailsAPi(request);
        userpost_responseCall.enqueue(new Callback<FetchJointHolderDetailsResponse>() {
            @Override
            public void onResponse(Call<FetchJointHolderDetailsResponse> call, Response<FetchJointHolderDetailsResponse> response) {
                dailoghide(context);
                if (response.isSuccessful()) {


                    if (response.body().getResponse() == 200) {

                        loginData_interface.allFetchJointHolderDetailsdata((List<FetchJointHolderDetailsResponse.JHolder>) response.body().getData().getJHolder());
                        loginData_interface.allFetchdirecterdata((List<FetchJointHolderDetailsResponse.Gpa>) response.body().getData().getGpa());

                    } else {
                        dailogError(context, "Server Busy!", "Please try again.");
                    }

                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }

            }

            @Override
            public void onFailure(Call<FetchJointHolderDetailsResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void allotteNoticesMethod(final Activity activity, final Context context, final allotteeNoticesData_interface loginData_interface, PlotIdRequest request, LinearLayoutCompat llmain) {

        loadershowwithMsg(context, "Loading...");
        Call<AllotteNoticesResponse> userpost_responseCall = ApiClient.getClient().allotteNoticesAPi(request);
        userpost_responseCall.enqueue(new Callback<AllotteNoticesResponse>() {
            @Override
            public void onResponse(Call<AllotteNoticesResponse> call, Response<AllotteNoticesResponse> response) {
                dailoghide(context);
                if (response.isSuccessful()) {


                    if (response.body().getResponse() == 200) {

                        llmain.setVisibility(View.VISIBLE);

                        loginData_interface.AllotteNoticesdata((List<AllotteNoticesResponse.Datum>) response.body().getData());

                    } else {
                        dailogError(context, "Server Busy!", "Please try again.");
                    }

                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }

            }

            @Override
            public void onFailure(Call<AllotteNoticesResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void allotteHistoryMethod(final Activity activity, final Context context, final allotteeHistoryData_interface loginData_interface, PlotIdRequest request, LinearLayoutCompat llmain) {

        loadershowwithMsg(context, "Loading...");
        Call<AlloteeHistoryResponse> userpost_responseCall = ApiClient.getClient().allotteHistoryAPi(request);
        userpost_responseCall.enqueue(new Callback<AlloteeHistoryResponse>() {
            @Override
            public void onResponse(Call<AlloteeHistoryResponse> call, Response<AlloteeHistoryResponse> response) {
                dailoghide(context);
                if (response.isSuccessful()) {


                    if (response.body().getResponse() == 200) {
                        llmain.setVisibility(View.VISIBLE);
                        loginData_interface.AllotteHistorydata((List<AlloteeHistoryResponse.Datum>) response.body().getData());

                    } else {
                        dailogError(context, "Server Busy!", "Please try again.");
                    }

                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }

            }

            @Override
            public void onFailure(Call<AlloteeHistoryResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void allottePlotInfoMethod(final Activity activity, final Context context, final allotteePlotInfoData_interface loginData_interface, PlotIdRequest request, LinearLayoutCompat llmain) {

        loadershowwithMsg(context, "Loading...");
        Call<AllottePlotInfoResponse> userpost_responseCall = ApiClient.getClient().allottePlotInfoAPi(request);
        userpost_responseCall.enqueue(new Callback<AllottePlotInfoResponse>() {
            @Override
            public void onResponse(Call<AllottePlotInfoResponse> call, Response<AllottePlotInfoResponse> response) {
                dailoghide(context);
                if (response.isSuccessful()) {


                    if (response.body().getResponse() == 200) {
                        llmain.setVisibility(View.VISIBLE);
                        loginData_interface.AllottePlotInfodata((List<AllottePlotInfoResponse.Datum>) response.body().getData());

                    } else {
                        dailogError(context, "Server Busy!", "Please try again.");
                    }

                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }

            }

            @Override
            public void onFailure(Call<AllottePlotInfoResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void allotteAppStatusMethod(final Activity activity, final Context context, final allotteeAppStatusData_interface loginData_interface, AppStatusRequest request) {

        loadershowwithMsg(context, "Loading...");
        Call<AllotteApplicationStatusResponse> userpost_responseCall = ApiClient.getClient().allotteAppStatusAPi(request);
        userpost_responseCall.enqueue(new Callback<AllotteApplicationStatusResponse>() {
            @Override
            public void onResponse(Call<AllotteApplicationStatusResponse> call, Response<AllotteApplicationStatusResponse> response) {
                dailoghide(context);
                if (response.isSuccessful()) {


                    if (response.body().getResponse() == 200) {

                        loginData_interface.allotteeAppStatusdata((List<AllotteApplicationStatusResponse.Datum>) response.body().getData());

                    } else {
                        dailogError(context, "Server Busy!", "Please try again.");
                    }

                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }

            }

            @Override
            public void onFailure(Call<AllotteApplicationStatusResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void allottefutureOutStandingDetailsMethod(final Activity activity, final Context context, final allotteefutureoustandingdetaildetailData_interface loginData_interface, PlotIdRequest request, LinearLayoutCompat llmain) {

        loadershowwithMsg(context, "Loading...");
        Call<AllottefutureOutStandingDetailsResponse> userpost_responseCall = ApiClient.getClient().allottefutureOutStandingDetailsPi(request);
        userpost_responseCall.enqueue(new Callback<AllottefutureOutStandingDetailsResponse>() {
            @Override
            public void onResponse(Call<AllottefutureOutStandingDetailsResponse> call, Response<AllottefutureOutStandingDetailsResponse> response) {
                dailoghide(context);
                if (response.isSuccessful()) {


                    if (response.body().getResponse() == 200) {
                        llmain.setVisibility(View.VISIBLE);

                        loginData_interface.allottefutureOutStandingdata((List<AllottefutureOutStandingDetailsResponse.Datum>) response.body().getData());

                    } else {
                        dailogError(context, "Server Busy!", "Please try again.");
                    }

                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }

            }

            @Override
            public void onFailure(Call<AllottefutureOutStandingDetailsResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void allottePaymentReceivedMethod(final Activity activity, final Context context, final allottePaymentReceivedData_interface loginData_interface, PlotIdRequest request) {

        loadershowwithMsg(context, "Loading...");
        Call<AllottePaymentReceivedResponse> userpost_responseCall = ApiClient.getClient().allottePaymentReceivedPi(request);
        userpost_responseCall.enqueue(new Callback<AllottePaymentReceivedResponse>() {
            @Override
            public void onResponse(Call<AllottePaymentReceivedResponse> call, Response<AllottePaymentReceivedResponse> response) {
                dailoghide(context);
                if (response.isSuccessful()) {


                    if (response.body().getResponse() == 200) {

                        loginData_interface.allottePaymentReceiveddata((List<AllottePaymentReceivedResponse.Datum>) response.body().getData());

                    } else {
                        dailogError(context, "Server Busy!", "Please try again.");
                    }

                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }

            }

            @Override
            public void onFailure(Call<AllottePaymentReceivedResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void allottePaymentReceivedDetailsMethod(final Activity activity, final Context context, final allottePaymentReceivedDetailsData_interface loginData_interface, PaymentReceivedDetailsRequest request) {

        loadershowwithMsg(context, "Loading...");
        Call<AllottePaymentReceivedDetailsResponse> userpost_responseCall = ApiClient.getClient().allottePaymentReceivedDetailsPi(request);
        userpost_responseCall.enqueue(new Callback<AllottePaymentReceivedDetailsResponse>() {
            @Override
            public void onResponse(Call<AllottePaymentReceivedDetailsResponse> call, Response<AllottePaymentReceivedDetailsResponse> response) {
                dailoghide(context);
                if (response.isSuccessful()) {


                    if (response.body().getResponse() == 200) {

                        loginData_interface.allottePaymentReceivedDetailsdata((List<AllottePaymentReceivedDetailsResponse.Datum>) response.body().getData());

                    } else {
                        dailogError(context, "Server Busy!", "Please try again.");
                    }

                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }

            }

            @Override
            public void onFailure(Call<AllottePaymentReceivedDetailsResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();

                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void AllottePaymentReceived2Method(final Activity activity, final Context context, final allottePaymentReceived2Data_interface anInterface, PlotIdRequest request) {

        loadershowwithMsg(context, "Loading...");
        Call<AllottePaymentReceived2Response> userpost_responseCall = ApiClient.getClient().allottePaymentReceived2DetailsPi(request);
        userpost_responseCall.enqueue(new Callback<AllottePaymentReceived2Response>() {
            @Override
            public void onResponse(Call<AllottePaymentReceived2Response> call, Response<AllottePaymentReceived2Response> response) {
                dailoghide(context);
                if (response.isSuccessful()) {


                    if (response.body().getResponse() == 200) {

                        anInterface.allottePaymentDetail2data(response.body().getData().getPaymentDetail());
                        anInterface.allottePayment2data(response.body().getData().getPayment());

                    } else {
                        dailogError(context, "Server Busy!", "Please try again.");
                    }

                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }

            }

            @Override
            public void onFailure(Call<AllottePaymentReceived2Response> call, Throwable t) {

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


}















