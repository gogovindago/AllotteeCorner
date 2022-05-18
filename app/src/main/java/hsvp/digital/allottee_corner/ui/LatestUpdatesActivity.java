package hsvp.digital.allottee_corner.ui;

import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import java.util.ArrayList;

import hsvp.digital.allottee_corner.R;
import hsvp.digital.allottee_corner.adapter.LatestUpdatesAdapter;
import hsvp.digital.allottee_corner.databinding.ActivityLatestupdatesBinding;
import hsvp.digital.allottee_corner.model.LatestUpdatesmodel;
import hsvp.digital.allottee_corner.utility.BaseActivity;

public class LatestUpdatesActivity extends BaseActivity implements LatestUpdatesAdapter.ItemListener {

    ActivityLatestupdatesBinding binding;
    ArrayList LatestUpdatesarrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_latestupdates);

/*Portal for inviting fresh applications for various scholarships for 2021-22 academic Session is Open Now. शैक्षणिक सत्र 2021-22 के लिए विभिन्न छात्रवृत्ति के लिए नए आवेदन आमंत्रित करने के लिए पोर्टल अभी खुला है|
Eligible Students are requested to register and apply for scholarship by 15.02.2022 positively. पात्र छात्रों से अनुरोध है कि 15.02.2022 तक पंजीकरण कराकर छात्रवृत्ति के लिए आवेदन अवश्य करें।
Please Check the Eligibility and How to Apply before Registration and applying for Scholarship. कृपया पात्रता की जांच करें और छात्रवृत्ति के लिए पंजीकरण और आवेदन करने से पहले आवेदन कैसे करें पढ़ें।
Students who already register in previous academic session, need not to register again. They can login directly and apply for the scholarship. जो छात्र पिछले शैक्षणिक सत्र में पहले ही पंजीकरण करा चुके हैं, उन्हें दोबारा पंजीकरण करने की आवश्यकता नहीं है। वे सीधे लॉगिन कर सकते हैं और छात्रवृत्ति के लिए आवेदन कर सकते हैं।*/

        LatestUpdatesarrayList.add(new LatestUpdatesmodel(1, "Portal for inviting fresh applications for various scholarships for 2021-22 academic Session is Open Now.\n शैक्षणिक सत्र 2021-22 के लिए विभिन्न छात्रवृत्ति के लिए नए आवेदन आमंत्रित करने के लिए पोर्टल अभी खुला है|"));
        LatestUpdatesarrayList.add(new LatestUpdatesmodel(2, "Eligible Students are requested to register and apply for scholarship by 15.04.2022 positively.\n पात्र छात्रों से अनुरोध है कि 15.04.2022 तक पंजीकरण कराकर छात्रवृत्ति के लिए आवेदन अवश्य करें। ।"));
        LatestUpdatesarrayList.add(new LatestUpdatesmodel(3, "Please Check the Eligibility and How to Apply before Registration and applying for Scholarship.\n कृपया पात्रता की जांच करें और छात्रवृत्ति के लिए पंजीकरण और आवेदन करने से पहले आवेदन कैसे करें पढ़ें।"));
        LatestUpdatesarrayList.add(new LatestUpdatesmodel(4, "Students who already register in previous academic session, need not to register again. They can login directly and apply for the scholarship.\n जो छात्र पिछले शैक्षणिक सत्र में पहले ही पंजीकरण करा चुके हैं, उन्हें दोबारा पंजीकरण करने की आवश्यकता नहीं है। वे सीधे लॉगिन कर सकते हैं और छात्रवृत्ति के लिए आवेदन कर सकते हैं।"));


        LatestUpdatesAdapter adapter = new LatestUpdatesAdapter(this, LatestUpdatesarrayList, this);
        binding.rv.setAdapter(adapter);
        GridLayoutManager manager = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
        binding.rv.setLayoutManager(manager);


    }

    @Override
    public void initData() {
        binding.toolbar.tvToolbarTitle.setText("Latest updates");
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
    public void onItemClick(LatestUpdatesmodel item, int currposition) {

    }
}