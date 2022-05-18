package hsvp.digital.allottee_corner.ui;

import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import java.util.ArrayList;

import hsvp.digital.allottee_corner.R;
import hsvp.digital.allottee_corner.adapter.howtoApplyAdapter;
import hsvp.digital.allottee_corner.adapter.keydocumentsreqAdapter;
import hsvp.digital.allottee_corner.databinding.ActivityHowtoApplyBinding;
import hsvp.digital.allottee_corner.model.HowToApplyModel;
import hsvp.digital.allottee_corner.model.KeyDocumentsRequired;
import hsvp.digital.allottee_corner.utility.BaseActivity;

public class HowtoApplyActivity extends BaseActivity implements howtoApplyAdapter.ItemListener, keydocumentsreqAdapter.ItemListener {
    ActivityHowtoApplyBinding binding;
    ArrayList howtoApplySteparrayList = new ArrayList();
    ArrayList KeyDocumentsRequiredarrayList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_howto_apply);

        howtoApplySteparrayList.add(new HowToApplyModel("STEP 1", " Click Registration link at the portal, if you are new user. Existing user can click on the login button.", 1));
        howtoApplySteparrayList.add(new HowToApplyModel("STEP 2", " Enter the Parivar Pehchaan Patra (Family Id), a List of members will be displayed, Select your Name and Click on \"Generate OTP\" button.", 2));
        howtoApplySteparrayList.add(new HowToApplyModel("STEP 3", " Enter the OTP received on your registered Mobile No. and Click on \"Verify OTP\" button.", 3));
        howtoApplySteparrayList.add(new HowToApplyModel("STEP 4", " After OTP Verification, all the details get auto filled in the Registration Form, cross check your information.\n", 4));
        howtoApplySteparrayList.add(new HowToApplyModel("STEP 5", " Select Your Department and College, and create your Password and Click on \"Register\" Button.\n", 5));
        howtoApplySteparrayList.add(new HowToApplyModel("STEP 6", " Click login link at the portal and enter User ID and password to apply the scholarship.\n", 6));
        howtoApplySteparrayList.add(new HowToApplyModel("STEP 7", " Provide all necessary details like Course, Roll No., Eligibility etc.", 7));
        howtoApplySteparrayList.add(new HowToApplyModel("STEP 8", " Click on the “Apply” button to save your application.", 8));


        howtoApplyAdapter adaptermain = new howtoApplyAdapter(this, howtoApplySteparrayList, this);
        binding.rv.setAdapter(adaptermain);
        GridLayoutManager manager = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
        binding.rv.setLayoutManager(manager);

/*Aadhaar Card Copy
Applicant’s Photograph
Applicant's Signature
Income Certificate
Haryana Domicile Certificate
Caste certificate
10th Class Certificate
12th Class Certificate
Parivar Pehchaan Patra
Fee Receipt
Last Exam Passed Certificate (Except for 1st Year Students),
BPL Certificate (if applicable)
Father's Death Certificate (if applicable)*/

        KeyDocumentsRequiredarrayList.add(new KeyDocumentsRequired("Aadhaar Card Copy", 1));
        KeyDocumentsRequiredarrayList.add(new KeyDocumentsRequired("Applicant’s Photograph", 2));
        KeyDocumentsRequiredarrayList.add(new KeyDocumentsRequired("Applicant's Signature", 3));
        KeyDocumentsRequiredarrayList.add(new KeyDocumentsRequired("Income Certificate", 4));
        KeyDocumentsRequiredarrayList.add(new KeyDocumentsRequired("Haryana Domicile Certificate", 5));
        KeyDocumentsRequiredarrayList.add(new KeyDocumentsRequired("Caste certificate", 6));
        KeyDocumentsRequiredarrayList.add(new KeyDocumentsRequired("10th Class Certificate", 7));
        KeyDocumentsRequiredarrayList.add(new KeyDocumentsRequired("12th Class Certificate", 8));
        KeyDocumentsRequiredarrayList.add(new KeyDocumentsRequired("Fee Receipt", 9));
        KeyDocumentsRequiredarrayList.add(new KeyDocumentsRequired("Last Exam Passed Certificate (Except for 1st Year Students)", 10));
        KeyDocumentsRequiredarrayList.add(new KeyDocumentsRequired("BPL Certificate (if applicable)", 11));
        KeyDocumentsRequiredarrayList.add(new KeyDocumentsRequired("Father's Death Certificate (if applicable))", 12));


        keydocumentsreqAdapter keydocumentsreqAdapter = new keydocumentsreqAdapter(this, KeyDocumentsRequiredarrayList, this);
        binding.rvdocreq.setAdapter(keydocumentsreqAdapter);
        GridLayoutManager managerkeydoc = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
        binding.rvdocreq.setLayoutManager(managerkeydoc);


    }

    @Override
    public void onItemClick(HowToApplyModel item, int currposition) {

    }

    @Override
    public void onItemClick(KeyDocumentsRequired item, int currposition) {

    }

    @Override
    public void initData() {
        binding.toolbar.tvToolbarTitle.setText("How to apply");
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
}