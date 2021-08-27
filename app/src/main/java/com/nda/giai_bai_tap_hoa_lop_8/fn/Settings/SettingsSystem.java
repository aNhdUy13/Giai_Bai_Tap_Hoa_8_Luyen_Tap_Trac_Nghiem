package com.nda.giai_bai_tap_hoa_lop_8.fn.Settings;

import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.WorkerThread;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.app.SearchManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.nda.giai_bai_tap_hoa_lop_8.BuildConfig;
import com.nda.giai_bai_tap_hoa_lop_8.R;
import com.nda.giai_bai_tap_hoa_lop_8.fn.Ads.AdapterWithNativeAd;
import com.startapp.sdk.ads.nativead.NativeAdPreferences;
import com.startapp.sdk.ads.nativead.StartAppNativeAd;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SettingsSystem extends AppCompatActivity {
    /**
     * Activity fn
     * @param savedInstanceState
     */
    ImageView imgBack;
    CardView cvShareApp,cvTimetable;

    /**
     Regarding native ads
     */
    private static final String LOG_TAG = "native_ads";
    @Nullable
    protected AdapterWithNativeAd adapter;
    RecyclerView rcv_nativeAds;
    CardView cv_nativeAds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_system);
        mapting();
        initiate();
        nativeAds();

    }

    private void initiate() {
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        shareApp();
        cvTimetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogTimetable();
            }
        });
    }

    private void dialogTimetable() {
        Dialog dialog = new Dialog((SettingsSystem.this));
        dialog.setContentView(R.layout.dialog_timetable);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button btn_searchLink_openApp      = (Button) dialog.findViewById(R.id.searchLink_openapp);
        TextView txtLink            = (TextView) dialog.findViewById(R.id.txtLink);
        TextView title_app_status         = (TextView) dialog.findViewById(R.id.title_app_status);


        String packageName = "com.nda.timetable";
        if (isPackageAvailable(packageName))
        {
            title_app_status.setText("Phần Mềm Tính Điểm\n(ĐÃ TẢI)");
            btn_searchLink_openApp.setText("Mở Ứng Dụng");
            btn_searchLink_openApp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentOpen = getPackageManager().getLaunchIntentForPackage(packageName);
                    startActivity(intentOpen);
                }
            });
        }
        else
        {
            btn_searchLink_openApp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentSearch = new Intent(Intent.ACTION_WEB_SEARCH);
                    String term = txtLink.getText().toString();
                    intentSearch.putExtra(SearchManager.QUERY, term);
                    startActivity(intentSearch);
                }
            });
        }
        dialog.show();
    }
    private boolean isPackageAvailable(String packageName)
    {
        boolean available = true;
        try{
            getPackageManager().getPackageInfo(packageName,0);
        }catch(PackageManager.NameNotFoundException e)
        {
            available = false;
        }
        return available;
    }

    private void shareApp() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        String shareBody = "https://play.google.com/store/apps/details?id=com.nda.giai_bai_tap_hoa_lop_8";
        /*The type of the content is text, obviously.*/
        intent.setType("text/plain");
        /*Applying information Subject and Body.*/
        intent.putExtra(android.content.Intent.EXTRA_SUBJECT, getString(R.string.share_subject));
        intent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        cvShareApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    startActivity(Intent.createChooser(intent, getString(R.string.share_using)));

//                    startActivity(sendIntent);
                } catch (Exception e)
                { e.printStackTrace();}

            }
        });
    }

    private void mapting() {
        imgBack = (ImageView) findViewById(R.id.imgBack);
        cvShareApp  = (CardView) findViewById(R.id.cvShareApp);
        cvTimetable  = (CardView) findViewById(R.id.cvTimetable);

    }

    private void nativeAds() {
        // NOTE always use test ads during development and testing
        //StartAppSDK.setTestAdsEnabled(BuildConfig.DEBUG);

//        setContentView(R.layout.recycler_view);

        cv_nativeAds  = (CardView) findViewById(R.id.cv_nativeAds);
        rcv_nativeAds = (RecyclerView) findViewById(R.id.rcv_nativeAds);
        rcv_nativeAds.setLayoutManager(new LinearLayoutManager(SettingsSystem.this, RecyclerView.VERTICAL, false));
        rcv_nativeAds.setAdapter(adapter = new AdapterWithNativeAd(SettingsSystem.this));

        loadData();
        loadNativeAd();
    }

    private void loadNativeAd() {
        final StartAppNativeAd nativeAd = new StartAppNativeAd(SettingsSystem.this);

        nativeAd.loadAd(new NativeAdPreferences()
                .setAdsNumber(1)
                .setAutoBitmapDownload(true)
                .setPrimaryImageSize(2), new AdEventListener() {
            @Override
            public void onReceiveAd(Ad ad) {
                if (adapter != null) {
                    cv_nativeAds.setVisibility(View.VISIBLE);
                    adapter.setNativeAd(nativeAd.getNativeAds());
                }
            }

            @Override
            public void onFailedToReceiveAd(Ad ad) {
                if (BuildConfig.DEBUG) {
                    Log.v(LOG_TAG, "onFailedToReceiveAd: " + ad.getErrorMessage());
                }
            }
        });
    }

    // TODO example of loading JSON array, change this code according to your needs
    @UiThread
    private void loadData() {
        if (adapter != null) {
//            adapter.setData(Collections.singletonList("Loading..."));
        }

        AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
            @Override
            @WorkerThread
            public void run() {
                String url = "https://raw.githubusercontent.com/StartApp-SDK/StartApp_InApp_SDK_Example/master/app/data.json";

                final List<String> data = new ArrayList<>();

                try (InputStream is = new URL(url).openStream()) {
                    if (is != null) {
                        JsonReader reader = new JsonReader(new InputStreamReader(is));
                        reader.beginArray();

                        while (reader.peek() == JsonToken.STRING) {
                            data.add(reader.nextString());
                        }

                        reader.endArray();
                    }
                } catch (RuntimeException | IOException ex) {
                    data.clear();
                    data.add(ex.toString());
                } finally {
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            if (adapter != null) {
//                                adapter.setData(data);
//                            }
//                        }
//                    });
                }
            }
        });
    }
}