package hsvp.digital.allottee_corner.utility;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.text.TextUtils;
import android.widget.Toast;

import cn.pedant.SweetAlert.SweetAlertDialog;


public class GlobalClass {

    Context context;

 // test keys


public static String DeptKey = "o2etc739ut";
    public static String DeptCode = "NIC";
    public static String ServiceCode = "TestCred";
/*


    //live keys
    public static String DeptKey = "er41w944rr";
    public static String DeptCode = "DOHE";
    public static String ServiceCode = "SCH";

*/

    //Live url higher Db
  //  public static String baseurl = "https://cmapi.highereduhry.ac.in/api/commonapi/";
    public static String baseurl = "http://59.145.147.101:86/api/Hsvp/";

    //test ppp
     public static String baseurl2 = "http://164.100.137.245/PPPapi/api/Account/";

    //live ppp
  //  public static String baseurl2 = "https://pppapi.edisha.gov.in:8443/api/Account/";

    public static String nointernet = "No Internet Connection";
    public static String nodatafound = "No Data Found";
    public static String dheOtherAppsLink = "https://play.google.com/store/apps/collection/cluster?clp=igNAChkKEzU4NzQ0NzU1NTI1MDY5NDE4MDEQCBgDEiEKG2RoZS5kaWdpdGFsLmxpYnJhcnkuaGFyeWFuYRABGAMYAQ%3D%3D:S:ANO1ljIHeVw&gsr=CkOKA0AKGQoTNTg3NDQ3NTU1MjUwNjk0MTgwMRAIGAMSIQobZGhlLmRpZ2l0YWwubGlicmFyeS5oYXJ5YW5hEAEYAxgB:S:ANO1ljJnuKw";
    public static String aboutUSLink = "https://www.hsvphry.org.in/Pages/AuthorityMembers.aspx";
 public static String aadhaarLink = "https://resident.uidai.gov.in/bank-mapper";



   /* // Call fragmnet
    public static void fragment(FragmentActivity fragmentActivity, Fragment fragment, boolean addToBackStack){
        if (addToBackStack){
             fragmentActivity.getSupportFragmentManager().beginTransaction().replace(R.id.fram, fragment).addToBackStack(null).commit();
        }else {
          fragmentActivity.getSupportFragmentManager().beginTransaction().replace(R.id.fram, fragment).commit();
        }
    }*/

    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

  /*  public static void dailogshow(Context context) {
        ProgressDialog pd;

        pd = new ProgressDialog(context);
        pd.setMessage("loading...");
        pd.setCancelable(false);
        pd.show();
    }

    public static void dailoghide(Context context) {
        ProgressDialog pd;
        pd = new ProgressDialog(context);
        pd.dismiss();
    }*/


    // Show toast
    public static void showtost(Context context, String message) {
        Toast.makeText(context, "" + message, Toast.LENGTH_SHORT).show();
    }

    // Email validation
    public static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }


    public static void progressdailogShow(Context context, ProgressDialog pd) {
        pd = new ProgressDialog(context);
        pd.setMessage("loading...");
        pd.setCancelable(false);
        pd.show();
    }

    public static void progressdailogHide(Context context, ProgressDialog pd) {
        pd = new ProgressDialog(context);
        pd.dismiss();
    }


    SweetAlertDialog pDialog;
    ProgressDialog pd;


    public static void dailogsuccessWithActivityFinish(final Context context, final Activity activity, String msgtitle, String msgcontentText) {
        SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(context);
        sweetAlertDialog.setTitle(msgtitle + "!");
        sweetAlertDialog.setContentText(msgcontentText);
        sweetAlertDialog.setVolumeControlStream(2);
        sweetAlertDialog.getAlerType();
        sweetAlertDialog.changeAlertType(2);
        sweetAlertDialog.setCancelable(true);
        sweetAlertDialog.setCanceledOnTouchOutside(false);
        sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sweetAlertDialog) {

                sweetAlertDialog.dismissWithAnimation();
                // activity.finish();
            }
        });
        sweetAlertDialog.setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sweetAlertDialog) {

            }
        });
        sweetAlertDialog.show();

    }

    public static void dailogWarningsWithActivityFinish(final Context context, final Activity activity, String msgtitle, String msgcontentText) {
        SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(context);
        sweetAlertDialog.setTitle(msgtitle + "!");
        sweetAlertDialog.setContentText(msgcontentText);
        sweetAlertDialog.setCancelText("No");
        sweetAlertDialog.changeAlertType(3);
        sweetAlertDialog.showCancelButton(true);
        sweetAlertDialog.setCancelable(false);
        sweetAlertDialog.setCanceledOnTouchOutside(false);
        sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sweetAlertDialog) {

                sweetAlertDialog.dismissWithAnimation();
                // activity.finish();
            }
        });
        sweetAlertDialog.setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sweetAlertDialog) {

            }
        });
        sweetAlertDialog.show();

    }


    public static void dailogsuccessWithActivity(final Context context, final Activity activity, String msgtitle, String msgcontentText) {
        SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(context);
        sweetAlertDialog.setTitle(msgtitle + "!");
        sweetAlertDialog.setContentText(msgcontentText);
        sweetAlertDialog.setVolumeControlStream(2);
        sweetAlertDialog.getAlerType();
        sweetAlertDialog.changeAlertType(2);
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

    public static void dailogsuccess(final Context context, String msgtitle, String msgcontentText) {
        SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(context);
        sweetAlertDialog.setTitle(msgtitle + "!");
        sweetAlertDialog.setContentText(msgcontentText);
        sweetAlertDialog.setVolumeControlStream(2);
        sweetAlertDialog.getAlerType();
        sweetAlertDialog.changeAlertType(2);
        sweetAlertDialog.setCanceledOnTouchOutside(false);
        sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sweetAlertDialog) {
                sweetAlertDialog.dismiss();
            }
        });
        sweetAlertDialog.show();

    }

    public static void dailogError(final Context context, String msgtitle, String msgcontentText) {
        SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(context);
        sweetAlertDialog.setTitle(msgtitle + "!");
        sweetAlertDialog.setContentText(msgcontentText);
        sweetAlertDialog.setVolumeControlStream(2);
        sweetAlertDialog.getAlerType();
        sweetAlertDialog.changeAlertType(1);
        sweetAlertDialog.setCanceledOnTouchOutside(false);
        sweetAlertDialog.setCancelable(false);
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
}
