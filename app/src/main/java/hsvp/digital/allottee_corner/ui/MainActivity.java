package hsvp.digital.allottee_corner.ui;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.android.play.core.install.model.AppUpdateType;
import com.google.android.play.core.install.model.InstallStatus;
import com.google.android.play.core.install.model.UpdateAvailability;
import com.google.android.play.core.tasks.Task;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

import hsvp.digital.allottee_corner.R;
import hsvp.digital.allottee_corner.adapter.DrawerItemCustomAdapter;
import hsvp.digital.allottee_corner.adapter.LatestUpdatesAdapter;
import hsvp.digital.allottee_corner.adapter.OptionsAdapter;
import hsvp.digital.allottee_corner.adapter.SliderAdapter;
import hsvp.digital.allottee_corner.app.MyApplication;
import hsvp.digital.allottee_corner.databinding.ActivityMainBinding;
import hsvp.digital.allottee_corner.model.DataModelLeftNew;
import hsvp.digital.allottee_corner.model.HomePageResponse;
import hsvp.digital.allottee_corner.model.LatestUpdatesmodel;
import hsvp.digital.allottee_corner.model.OptionDataModel;
import hsvp.digital.allottee_corner.utility.BaseActivity;
import hsvp.digital.allottee_corner.utility.CSPreferences;
import hsvp.digital.allottee_corner.utility.GlobalClass;

public class MainActivity extends BaseActivity implements OptionsAdapter.ItemListener, LatestUpdatesAdapter.ItemListener {
    RecyclerView recyclerView;
    ArrayList arrayList = new ArrayList();
    List<HomePageResponse.Banner> sliderItemList = new ArrayList<HomePageResponse.Banner>();
    SliderView sliderView;
    SliderAdapter sliderAdapter;
    List<DataModelLeftNew> dataModelLeftList;
    ArrayList LatestUpdatesarrayList = new ArrayList<>();
    private AppUpdateManager appUpdateManager;
    private InstallStateUpdatedListener installStateUpdatedListener;
    private static final int FLEXIBLE_APP_UPDATE_REQ_CODE = 123;

    private static DrawerLayout mDrawerLayout;
    SimpleDraweeView toggle;
    ImageView profile_image, goyesno;
    TextView toolbartxt, uname, textView, txtrole,
            txtwelcome, btnlogin, txtMemberId, txtstudentId;
    Toolbar toolbar;
    Context context;
    private ActionBarDrawerToggle mDrawerToggle;
    private ListView mDrawerList;
    String role, User_Profile_Photo;
    boolean skiplogin;
    RelativeLayout uprofile;
    BottomNavigationView bottomNavigation;
    int scrollCount = 0;

    LatestUpdatesAdapter adapterUpdates;


    public static void drawerCheck() {

        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            mDrawerLayout.openDrawer(GravityCompat.START);
        }
    }

    ActivityMainBinding binding;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        context = MyApplication.context;
        toggle = findViewById(R.id.toggle);
        toolbartxt = findViewById(R.id.toolbartxt);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mDrawerList = findViewById(R.id.left_drawer);
        recyclerView = findViewById(R.id.recyclerView);

        btnlogin = findViewById(R.id.btnlogin);

        goyesno = findViewById(R.id.goyesno);


        txtMemberId = findViewById(R.id.txtMemberId);
        txtstudentId = findViewById(R.id.txtstudentId);
        uname = findViewById(R.id.uname);
        textView = findViewById(R.id.textView);
        txtrole = findViewById(R.id.txtrole);
        txtwelcome = findViewById(R.id.txtwelcome);
        profile_image = findViewById(R.id.profile_image);
        uprofile = findViewById(R.id.uprofile);


        try {

/*AadhaarNo
CasteCategoryName
FamilyIncome*/
            skiplogin = CSPreferences.getBoolean(this, "skiplogin");
            txtMemberId.setText(CSPreferences.readString(this, "MemberId"));
            txtstudentId.setText(CSPreferences.readString(this, "MemberId"));
            uname.setText(CSPreferences.readString(this, "PhoneNo"));
            textView.setText(CSPreferences.readString(this, "Email"));
            txtrole.setText(CSPreferences.readString(this, "UserType"));

            toolbartxt.setText(CSPreferences.readString(this, "User_Name"));


            role = CSPreferences.readString(this, "UserType");

            txtwelcome.setText(CSPreferences.readString(this, "User_Name"));

            if (role.equalsIgnoreCase("NodalBodyDHE")) {

                String username = CSPreferences.readString(this, "User_Name");


                toolbartxt.setText(firstLetterWord(username.replaceAll("[^a-zA-Z0-9]", " ")));
                txtwelcome.setText(firstLetterWord(username.replaceAll("[^a-zA-Z0-9]", " ")));

            } else {

                txtwelcome.setText(CSPreferences.readString(this, "User_Name"));
                toolbartxt.setText(CSPreferences.readString(this, "User_Name"));
            }


            //  binding.txtstudentName.setText("Welcome, " + CSPreferences.readString(this, "User_Name"));
            // binding.txtstudentMobileNo.setText("MobileNo -  " + CSPreferences.readString(this, "PhoneNo"));
            //  binding.txtstudentEmailId.setText("Email-Id -   " + CSPreferences.readString(this, "Email"));
            //  binding.txtstudentUserId.setText("UserId -      " + CSPreferences.readString(this, "MemberId"));
            //  binding.txtUserType.setText("User Type -  " + CSPreferences.readString(this, "UserType"));


            // below line is having image url to be added..
            //  SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.my_image_view);
         /*   SimpleDraweeView draweeView2 = (SimpleDraweeView) findViewById(R.id.my_image_view2);

            int color = getResources().getColor(R.color.white);
            RoundingParams roundingParams = RoundingParams.fromCornersRadius(5f);
            roundingParams.setBorder(color, 8.0f);
            roundingParams.setRoundAsCircle(true);
            draweeView2.getHierarchy().setRoundingParams(roundingParams);


            // draweeView.setImageResource(R.drawable.banner);
            draweeView2.setImageResource(R.mipmap.ic_launcher_round);
            draweeView2.setImageURI(CSPreferences.readString(MainActivity.this, "User_Profile_Photo"));

            if (CSPreferences.readString(MainActivity.this, "User_Profile_Photo") == null || CSPreferences.readString(MainActivity.this, "User_Profile_Photo").isEmpty()) {

                draweeView2.setImageResource(R.mipmap.ic_launcher_round);


            } else {
                draweeView2.setImageURI(CSPreferences.readString(MainActivity.this, "User_Profile_Photo"));

            }

       */

        } catch (Exception e) {
            e.printStackTrace();

        }

        Glide.with(MainActivity.this)
                .load(CSPreferences.readString(MainActivity.this, "User_Profile_Photo")) // image url
                .placeholder(R.mipmap.ic_launcher_round) // any placeholder to load at start
                .error(R.mipmap.ic_launcher_round)  // any image in case of error
                .override(140, 140) // resizing
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(profile_image);


        if (role.equalsIgnoreCase("department") || role.equalsIgnoreCase("masteradmin")) {
            int color = getResources().getColor(R.color.white);
            RoundingParams roundingParams = RoundingParams.fromCornersRadius(1f);
            roundingParams.setBorder(color, 1.0f);
            roundingParams.setRoundAsCircle(true);
            toggle.getHierarchy().setRoundingParams(roundingParams);

            toggle.setImageResource(R.drawable.ic_menu);
        } else if (skiplogin) {

            int color = getResources().getColor(R.color.white);
            RoundingParams roundingParams = RoundingParams.fromCornersRadius(1f);
            roundingParams.setBorder(color, 1.0f);
            roundingParams.setRoundAsCircle(true);
            toggle.getHierarchy().setRoundingParams(roundingParams);
            toggle.setImageResource(R.drawable.ic_menu);

        } else {
            int color = getResources().getColor(R.color.white);
            RoundingParams roundingParams = RoundingParams.fromCornersRadius(1f);
            roundingParams.setBorder(color, 1.0f);
            roundingParams.setRoundAsCircle(true);
            toggle.getHierarchy().setRoundingParams(roundingParams);


            toggle.setImageURI(CSPreferences.readString(MainActivity.this, "User_Profile_Photo"));


        }


        if (skiplogin) {

            uprofile.setClickable(false);
            goyesno.setVisibility(View.GONE);
            btnlogin.setVisibility(View.VISIBLE);


        } else {

            uprofile.setClickable(true);
            goyesno.setVisibility(View.GONE);
            if (role.equalsIgnoreCase("department") || role.equalsIgnoreCase("masteradmin") || role.equalsIgnoreCase("NodalBodyDHE")) {

                binding.textView.setVisibility(View.GONE);
                binding.txtrole.setVisibility(View.GONE);
                binding.txtstudentId.setVisibility(View.GONE);
                binding.txtMemberId.setVisibility(View.GONE);

            }

            btnlogin.setVisibility(View.INVISIBLE);


        }

        // sliderView = findViewById(R.id.imageSlider);

        setupToolbar();


        LatestUpdatesarrayList.add(new LatestUpdatesmodel(1, "Portal for inviting fresh applications for various scholarships for 2021-22 academic Session is Open Now.\n शैक्षणिक सत्र 2021-22 के लिए विभिन्न छात्रवृत्ति के लिए नए आवेदन आमंत्रित करने के लिए पोर्टल अभी खुला है|"));
        LatestUpdatesarrayList.add(new LatestUpdatesmodel(2, "Eligible Students are requested to register and apply for scholarship by 15.04.2022 positively.\n पात्र छात्रों से अनुरोध है कि 15.04.2022 तक पंजीकरण कराकर छात्रवृत्ति के लिए आवेदन अवश्य करें। ।"));
        LatestUpdatesarrayList.add(new LatestUpdatesmodel(3, "Please Check the Eligibility and How to Apply before Registration and applying for Scholarship. \nकृपया पात्रता की जांच करें और छात्रवृत्ति के लिए पंजीकरण और आवेदन करने से पहले आवेदन कैसे करें पढ़ें।"));
        LatestUpdatesarrayList.add(new LatestUpdatesmodel(4, "Students who already register in previous academic session, need not to register again. They can login directly and apply for the scholarship. \nजो छात्र पिछले शैक्षणिक सत्र में पहले ही पंजीकरण करा चुके हैं, उन्हें दोबारा पंजीकरण करने की आवश्यकता नहीं है। वे सीधे लॉगिन कर सकते हैं और छात्रवृत्ति के लिए आवेदन कर सकते हैं।"));


        adapterUpdates = new LatestUpdatesAdapter(this, LatestUpdatesarrayList, this);
        final LinearLayoutManager managerUpdates = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);


        arrayList.add(new OptionDataModel(R.string.Dashboard, R.drawable.ic_baseline_featured_play_list_24, 2, "#FFFFFF"));

        arrayList.add(new OptionDataModel(R.string.ownerdetail, R.drawable.ic_baseline_how_to_reg_24, 222, "#FFFFFF"));
        arrayList.add(new OptionDataModel(R.string.currentoutstanding, R.drawable.ic_baseline_balance_24, 333, "#FFFFFF"));
        arrayList.add(new OptionDataModel(R.string.futureoutstanding, R.drawable.ic_baseline_balance_24, 444, "#FFFFFF"));
        arrayList.add(new OptionDataModel(R.string.paymentmade, R.drawable.ic_baseline_menu_book_24, 555, "#FFFFFF"));
        arrayList.add(new OptionDataModel(R.string.checkappstatus, R.drawable.ic_baseline_fact_check_24, 666, "#FFFFFF"));

        arrayList.add(new OptionDataModel(R.string.alloteeaccountstatement, R.drawable.ic_baseline_how_to_reg_24, 777, "#FFFFFF"));
        arrayList.add(new OptionDataModel(R.string.AlloteeNotice, R.drawable.ic_baseline_format_list_numbered_24, 888, "#FFFFFF"));
        arrayList.add(new OptionDataModel(R.string.AlloteeHistory, R.drawable.ic_baseline_format_list_numbered_24, 8888, "#FFFFFF"));


        OptionsAdapter adaptermain = new OptionsAdapter(this, arrayList, this);
        recyclerView.setAdapter(adaptermain);
        GridLayoutManager manager = new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);

//        HomePageResponse.Banner banner = new HomePageResponse.Banner();
//
//        banner.setFilePath("https://harchhatravratti.highereduhry.ac.in/img/banner.jpg");
//        banner.setDescription("Har Chhatravratti");
//        banner.setId(1);
//        banner.setFileName("Banner");
//        sliderItemList.add(0,banner);
//
//        sliderAdapter = new SliderAdapter(this);
//        sliderItemList.addAll((Collection<? extends HomePageResponse.Banner>) sliderItemList);
//        sliderAdapter.renewItems(sliderItemList);
//
//
//        //renewItems();
//
//        sliderView.setSliderAdapter(sliderAdapter);
//        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using IndicatorAnimationType. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
//        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
//        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
//        // sliderView.setIndicatorSelectedColor(Color.WHITE);
//        // sliderView.setIndicatorUnselectedColor(Color.GRAY);
//        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
//        sliderView.startAutoCycle();
        bottomNavigation = findViewById(R.id.bottom_navigation);

        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.page_1:

                        return true;

                   /* case R.id.page_2:

                        Intent EligibilityActivity = new Intent(MainActivity.this, EligibilityActivity.class);
                        startActivity(EligibilityActivity);
                        return true;*/

                    case R.id.page_3:
                        Intent ListofCollegeIntent = new Intent(MainActivity.this, CollegeListActivity.class);
                        startActivity(ListofCollegeIntent);
                        return true;

                  /*  case R.id.page_4:
                        removeBadge(binding.bottomNavigation, R.id.page_4);

                        Intent HowtoApplyActivity = new Intent(MainActivity.this, LatestUpdatesActivity.class);
                        startActivity(HowtoApplyActivity);


                        return true;
*/
                    case R.id.page_5:


                        if (skiplogin) {
                            mDrawerLayout.closeDrawers();
                            Intent welcomeintent = new Intent(MainActivity.this, WelcomeActivity.class);
                            startActivity(welcomeintent);
                            finish();

                        } else {

                            Intent contactUs = new Intent(MainActivity.this, ProfileActivity.class);
                            startActivity(contactUs);
                            return true;
                        }
                }
                return false;
            }
        });


        // showBadge(MainActivity.this, binding.bottomNavigation, R.id.page_4, "4");
       /* BadgeDrawable badge = binding.bottomNavigation.getOrCreateBadge(R.id.page_4);
        badge.setVisible(true);
// An icon only badge will be displayed unless a number is set:
        badge.setNumber(4);
*/

        binding.simpleSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override

            public void onRefresh() {

                if (GlobalClass.isNetworkConnected(MainActivity.this)) {


                } else {

                    Toast.makeText(MainActivity.this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
                }
                binding.simpleSwipeRefreshLayout.setRefreshing(false);
            }
        });
    }


    // Function to find string which has first
    // character of each word.
    String firstLetterWord(String str) {
        String result = "";

        // Traverse the string.
        boolean v = true;
        for (int i = 0; i < str.length(); i++) {
            // If it is space, set v as true.
            if (str.charAt(i) == ' ') {
                v = true;
            }

            // Else check if v is true or not.
            // If true, copy character in output
            // string and set v as false.
            else if (str.charAt(i) != ' ' && v == true) {
                result += (str.charAt(i));
                v = false;
            }
        }

        return result;
    }


    public static void showBadge(Context context, BottomNavigationView
            bottomNavigationView, @IdRes int itemId, String value) {
        // removeBadge(bottomNavigationView, itemId);
        BottomNavigationItemView itemView = bottomNavigationView.findViewById(itemId);
        View badge = LayoutInflater.from(context).inflate(R.layout.layout_news_badge, bottomNavigationView, false);

        TextView text = badge.findViewById(R.id.badge_text_view);
        text.setText(value);
        itemView.addView(badge);
    }

  /*  public static void removeBadge(BottomNavigationView bottomNavigationView, @IdRes int itemId) {
        bottomNavigationView.removeBadge(itemId);

    }*/

    public static void removeBadge(BottomNavigationView bottomNavigationView, @IdRes int itemId) {
        BottomNavigationItemView itemView = bottomNavigationView.findViewById(itemId);
        if (itemView.getChildCount() == 4) {
            itemView.removeViewAt(4);
        }
    }

    @Override
    public void initData() {


        binding.bottomNavigation.setSelectedItemId(R.id.page_1);


        appUpdateManager = AppUpdateManagerFactory.create(getApplicationContext());
        installStateUpdatedListener = state -> {
            if (state.installStatus() == InstallStatus.DOWNLOADED) {
                popupSnackBarForCompleteUpdate();
            } else if (state.installStatus() == InstallStatus.INSTALLED) {
                removeInstallStateUpdateListener();
            } else {
                // Toast.makeText(getApplicationContext(), "InstallStateUpdatedListener: state: " + state.installStatus(), Toast.LENGTH_LONG).show();
            }
        };
        appUpdateManager.registerListener(installStateUpdatedListener);
        checkUpdate();


        dataModelLeftList = new ArrayList<DataModelLeftNew>();
        dataModelLeftList.clear();


        DataModelLeftNew my_profile = new DataModelLeftNew(R.drawable.personwhite, "My Profile", 1);
        dataModelLeftList.add(my_profile);

      /*  DataModelLeftNew Eligibility = new DataModelLeftNew(R.drawable.ic_baseline_checklist_rtl_24, "Eligibility", 11);
        dataModelLeftList.add(Eligibility);

        DataModelLeftNew HowtoApply = new DataModelLeftNew(R.drawable.ic_baseline_whitehow_to_reg_24, " How to Apply ", 111);
        dataModelLeftList.add(HowtoApply);
        DataModelLeftNew courseList = new DataModelLeftNew(R.drawable.ic_baseline_checklist_rtl_24, " Course List", 1111);
        dataModelLeftList.add(courseList);
        DataModelLeftNew collegeList = new DataModelLeftNew(R.drawable.ic_college, " College List", 2222);
        dataModelLeftList.add(collegeList);
*/

//        DataModelLeftNew rateApp = new DataModelLeftNew(R.drawable.rate_review, "Rate App", 2);
//        dataModelLeftList.add(rateApp);
//
//
//        DataModelLeftNew share_app = new DataModelLeftNew(R.drawable.share, "Share App", 3);
//        dataModelLeftList.add(share_app);
//        DataModelLeftNew OurOthersApps = new DataModelLeftNew(R.drawable.ic_baseline_apps_24, "Our Others Apps", 6);
//        dataModelLeftList.add(OurOthersApps);

//        DataModelLeftNew notification = new DataModelLeftNew(R.drawable.notifications, "My Notification", 4);
//        dataModelLeftList.add(notification);

        DataModelLeftNew about_us = new DataModelLeftNew(R.drawable.rate_review, "About Us", 5);
        dataModelLeftList.add(about_us);

        DataModelLeftNew contactus = new DataModelLeftNew(R.drawable.ic_baseline_contact_mail_24, "Contact Us", 109);
        dataModelLeftList.add(contactus);


       /* DataModelLeftNew resetPassword = new DataModelLeftNew(R.drawable.lockmain, "Reset Password", 6);
        dataModelLeftList.add(resetPassword);
*/
        DataModelLeftNew version = new DataModelLeftNew(R.mipmap.ic_launcher_round, "Version " + getAppVersion(), 21);
        dataModelLeftList.add(version);

        if (skiplogin) {


            DataModelLeftNew LoginSignup = new DataModelLeftNew(R.drawable.personwhite, "Login/Signup", 7);
            dataModelLeftList.add(LoginSignup);


        } else {

            DataModelLeftNew Logout = new DataModelLeftNew(R.drawable.ic_baseline_exit_to_app_24, "Logout", 7);
            dataModelLeftList.add(Logout);


        }

        DrawerItemCustomAdapter adapter = new DrawerItemCustomAdapter(this, R.layout.list_view_item_row, dataModelLeftList);
        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        setupDrawerToggle();


    }


    public void rateApp() {
        try {
            Intent rateIntent = rateIntentForUrl("market://details");
            startActivity(rateIntent);
        } catch (ActivityNotFoundException e) {
            Intent rateIntent = rateIntentForUrl("https://play.google.com/store/apps/details");
            startActivity(rateIntent);
        }
    }

    private Intent rateIntentForUrl(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(String.format("%s?id=%s", url, getPackageName())));
        int flags = Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_MULTIPLE_TASK;
        if (Build.VERSION.SDK_INT >= 21) {
            flags |= Intent.FLAG_ACTIVITY_NEW_DOCUMENT;
        } else {
            //noinspection deprecation
            flags |= Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET;
        }
        intent.addFlags(flags);
        return intent;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setTitle(CharSequence title) {

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    void setupToolbar() {
        toolbar = findViewById(R.id.toolbar);
        // hide the title bar  0
        setSupportActionBar(toolbar);
        (getSupportActionBar()).setDisplayShowHomeEnabled(false);
    }

    void setupDrawerToggle() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, null, R.string.app_name, R.string.app_name);
        //This is necessary to change the icon of the Drawer Toggle upon state change.
        mDrawerToggle.syncState();
    }
    /// get  app version code


    public String getAppVersion() {
        String versionCode = "";
        try {
            versionCode = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return versionCode;
    }

    @Override
    public void initListeners() {


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, WelcomeActivity.class);
                startActivity(i);
                finish();
            }
        });


        toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.drawerCheck();
            }
        });

    }

    private void checkUpdate() {

        Task<AppUpdateInfo> appUpdateInfoTask = appUpdateManager.getAppUpdateInfo();

        appUpdateInfoTask.addOnSuccessListener(appUpdateInfo -> {
            if (appUpdateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE
                    && appUpdateInfo.isUpdateTypeAllowed(AppUpdateType.FLEXIBLE)) {
                startUpdateFlow(appUpdateInfo);
            } else if (appUpdateInfo.installStatus() == InstallStatus.DOWNLOADED) {
                popupSnackBarForCompleteUpdate();
            }
        });
    }

    private void startUpdateFlow(AppUpdateInfo appUpdateInfo) {
        try {
            appUpdateManager.startUpdateFlowForResult(appUpdateInfo, AppUpdateType.FLEXIBLE, this, MainActivity.FLEXIBLE_APP_UPDATE_REQ_CODE);
        } catch (IntentSender.SendIntentException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == FLEXIBLE_APP_UPDATE_REQ_CODE) {
            if (resultCode == RESULT_CANCELED) {
                //  Toast.makeText(getApplicationContext(), "Update canceled by user! Result Code: " + resultCode, Toast.LENGTH_LONG).show();
            } else if (resultCode == RESULT_OK) {
                //  Toast.makeText(getApplicationContext(), "Update success! Result Code: " + resultCode, Toast.LENGTH_LONG).show();
            } else {
                //  Toast.makeText(getApplicationContext(), "Update Failed! Result Code: " + resultCode, Toast.LENGTH_LONG).show();
                checkUpdate();
            }
        }
    }

    private void popupSnackBarForCompleteUpdate() {
        Snackbar.make(findViewById(android.R.id.content).getRootView(), "New app is ready!", Snackbar.LENGTH_INDEFINITE)

                .setAction("Install", view -> {
                    if (appUpdateManager != null) {
                        appUpdateManager.completeUpdate();
                    }
                })
                .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                .show();
    }

    private void removeInstallStateUpdateListener() {
        if (appUpdateManager != null) {
            appUpdateManager.unregisterListener(installStateUpdatedListener);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        removeInstallStateUpdateListener();
    }


    @Override
    public void onItemClick(OptionDataModel item, int currposition) {

        if (item.Id == 2) {

            Intent intent = new Intent(this, DashboardActivity.class);
            startActivity(intent);


        } else if (item.Id == 222) {


            Intent intent = new Intent(this, OwnerDetailActivity.class);
            startActivity(intent);

        } else if (item.Id == 333) {


            Intent intent = new Intent(this, CurrentOutStandingActivity.class);
            startActivity(intent);

        } else if (item.Id == 444) {


            Intent intent = new Intent(this, FutureOutStandingActivity.class);
            startActivity(intent);

        } else if (item.Id == 555) {


            Intent intent = new Intent(this, PaymentMadeActivity.class);
            startActivity(intent);

        } else if (item.Id == 666) {


            Intent intent = new Intent(this, CheckApplicatioStatusActivity.class);
            startActivity(intent);

        } else if (item.Id == 777) {


//            Intent intent = new Intent(this, HowtoApplyActivity.class);
//            startActivity(intent);

        } else if (item.Id == 888) {


            Intent intent = new Intent(this, AllotteeNoticeActivity.class);
            startActivity(intent);

        } else if (item.Id == 8888) {


//            Intent intent = new Intent(this, CourseListActivity.class);
//            startActivity(intent);

        }


    }

    @Override
    public void onItemClick(LatestUpdatesmodel item, int currposition) {

        Intent llnewsipdate = new Intent(this, LatestUpdatesActivity.class);
        startActivity(llnewsipdate);
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);

        }

    }

    private void selectItem(int position) {

        Fragment fragment = null;

        switch (dataModelLeftList.get(position).id) {
            case 0:
                mDrawerLayout.closeDrawers();
//                Intent intent2 = new Intent(this, SchemeGuideLineActivity.class);
//                startActivity(intent2);
                // fragment = new FixturesFragment();
                // fragment = new Upload_service();
                //  fragment = new ConnectFragment();
                break;

            case 1:
                mDrawerLayout.closeDrawers();
                Intent intentprofile = new Intent(this, ProfileActivity.class);
                startActivity(intentprofile);
                break;
            case 11:
                mDrawerLayout.closeDrawers();
//                Intent intentEligibility = new Intent(this, EligibilityActivity.class);
//                startActivity(intentEligibility);
                break;
            case 111:
                mDrawerLayout.closeDrawers();
//                Intent HowtoApply = new Intent(this, HowtoApplyActivity.class);
//                startActivity(HowtoApply);
                break;
            case 1111:
                mDrawerLayout.closeDrawers();
                Intent ListofCourseIntent = new Intent(this, CourseListActivity.class);
                startActivity(ListofCourseIntent);
                break;
            case 2222:
                mDrawerLayout.closeDrawers();
                Intent ListofCollegeIntent = new Intent(this, CollegeListActivity.class);
                startActivity(ListofCollegeIntent);
                break;


            case 2:


                mDrawerLayout.closeDrawers();
                rateApp();
                //Intent intent = new Intent(this, RoomDBMainActivity.class);
                // startActivity(intent);
                // fragment = new My_chanlel();
                break;
            case 3:

                mDrawerLayout.closeDrawers();
                Intent shareIntent = new Intent(android.content.Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Har Chhatravratti");
                String app_url = "https://play.google.com/store/apps/details?id=dhe.digital.har_chhatravratti";
                shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, app_url);
                startActivity(Intent.createChooser(shareIntent, "Share via"));
                break;

            case 4:

                mDrawerLayout.closeDrawers();
                Intent LatestUpdatesIntent = new Intent(this, LatestUpdatesActivity.class);
                startActivity(LatestUpdatesIntent);
                break;
            case 5:
                mDrawerLayout.closeDrawers();


                Intent aboutUSLink = new Intent(MainActivity.this, OpenBooksActivity.class);
                aboutUSLink.putExtra("title", "About Us");
                aboutUSLink.putExtra("bookurl", GlobalClass.aboutUSLink);
                startActivity(aboutUSLink);

               /* Intent aboutUs = new Intent(this, IntroActivity.class);
                startActivity(aboutUs);
*/
                break;


            case 6:
                mDrawerLayout.closeDrawers();
                // Intent othersApps = new Intent(MainActivity.this, OpenUrlActivity.class);
                Intent othersApps = new Intent(MainActivity.this, OpenBooksActivity.class);
                othersApps.putExtra("title", "Our Other Apps");
                othersApps.putExtra("bookurl", GlobalClass.dheOtherAppsLink);
                startActivity(othersApps);
                break;

            case 7:
                mDrawerLayout.closeDrawers();
                if (skiplogin) {
                    mDrawerLayout.closeDrawers();
                    Intent welcomeintent = new Intent(this, WelcomeActivity.class);
                    startActivity(welcomeintent);
                    finish();

                } else {
                    mDrawerLayout.closeDrawers();
                    logout();

                }

                break;

            case 109:
                mDrawerLayout.closeDrawers();
                Intent contactUs = new Intent(this, ContactUsActivity.class);
                startActivity(contactUs);


                break;
            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            // setTitle(mNavigationDrawerItemTitles[position]);
            // mDrawerLayout.closeDrawer(mDrawerList);
            mDrawerLayout.closeDrawers();

        } else {
            Log.e("MainActivity", "Error in creating fragment");
        }

    }

    void logout() {

        ImageView cancel;
        TextView no, yes;
        //will create a view of our custom dialog layout
        View alertCustomdialog = LayoutInflater.from(MainActivity.this).inflate(R.layout.logout_dialog, null);
        //initialize alert builder.
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);

        //set our custom alert dialog to tha alertdialog builder
        alert.setView(alertCustomdialog);
        cancel = (ImageView) alertCustomdialog.findViewById(R.id.cancel_button);
        yes = alertCustomdialog.findViewById(R.id.yes);
        no = alertCustomdialog.findViewById(R.id.no);
        final AlertDialog dialog = alert.create();
        //this line removed app bar from dialog and make it transperent and you see the image is like floating outside dialog box.
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCanceledOnTouchOutside(false);
        //finally show the dialog box in android all
        dialog.show();
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this, "Logout", Toast.LENGTH_SHORT).show();
                mDrawerLayout.closeDrawers();
                CSPreferences.clearPref(MainActivity.this);
                Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                        Intent.FLAG_ACTIVITY_CLEAR_TASK |
                        Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

                dialog.dismiss();

            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });


    }
}