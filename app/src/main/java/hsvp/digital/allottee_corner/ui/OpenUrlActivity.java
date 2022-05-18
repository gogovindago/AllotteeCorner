package hsvp.digital.allottee_corner.ui;

import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import hsvp.digital.allottee_corner.R;

public class OpenUrlActivity extends AppCompatActivity {
    private static String webViewUrl = "";
    TextView toolbartxt;
    ImageButton back;

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_url);
        toolbartxt = findViewById(R.id.tv_toolbarTitle);
        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        try {

            Bundle extras = getIntent().getExtras();

            if (extras != null) {

                String title = extras.getString("title");
                webViewUrl = extras.getString("bookurl");
                toolbartxt.setText(title);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading Data...");
        progressDialog.setCancelable(false);
        WebView web_view = findViewById(R.id.web_view);
        web_view.requestFocus();

        web_view.getSettings().setJavaScriptEnabled(true);


        //String myPdfUrl = "gymnasium-wandlitz.de/vplan/vplan.pdf";
        //  String url = "https://docs.google.com/viewer?embedded=true&url="+webViewUrl;
        String url = "http://drive.google.com/viewerng/viewer?embedded=true&url=" + webViewUrl;


        web_view.loadUrl(url);
        web_view.setWebViewClient(new

                                          WebViewClient() {
                                              @Override
                                              public boolean shouldOverrideUrlLoading(WebView view, String url) {
                                                  view.loadUrl(url);
                                                  return true;
                                              }
                                          });

        web_view.setWebChromeClient(new

                                            WebChromeClient() {
                                                public void onProgressChanged(WebView view, int progress) {

                                                    if (progress < 100) {
                                                        progressDialog.show();
                                                    }
                                                    if (progress == 100) {
                                                        progressDialog.dismiss();
                                                    }
                                                }
                                            });
    }


}