package com.nda.giai_bai_tap_hoa_lop_8;

import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.WorkerThread;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IBinder;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.nda.giai_bai_tap_hoa_lop_8.fn.Ads.AdapterWithNativeAd;
import com.nda.giai_bai_tap_hoa_lop_8.fn.DetailChuong.DetailChuong;
import com.nda.giai_bai_tap_hoa_lop_8.fn.Settings.SettingsSystem;
import com.nda.giai_bai_tap_hoa_lop_8.fn.TracNghiem.TracNghiemSystem;
import com.startapp.sdk.ads.nativead.NativeAdPreferences;
import com.startapp.sdk.ads.nativead.StartAppNativeAd;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.StartAppSDK;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    /**
     * Setup slide show
     */
    ViewFlipper vf_main;
    Animation slideIn, slideOut;

    /**
     *  setup action data
     */
    CardView ic_chuong_1, ic_chuong_2, ic_chuong_3, ic_chuong_4, ic_chuong_5, ic_chuong_6, ic_trac_nghiem, ic_setting;
    Intent intent;
    Bundle bundle;
    String chuongNumber, title;
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
        setContentView(R.layout.activity_main);
        //StartAppSDK.setTestAdsEnabled(true);
        StartAppAd.disableSplash();

        mappting();
        slideShow();
        initiate();
        nativeAds();


    }

    private void initiate()
    {
        intent  = new Intent(MainActivity.this, DetailChuong.class);
        bundle  = new Bundle();

        ic_chuong_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = "Chương 1: Chất - Nguyên tử - Phân tử";
                bundle.putBoolean("c1",true);
                chuongNumber = "c1";
                bundle.putString("c_number", chuongNumber);
                bundle.putString("c_title", title);
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });

        ic_chuong_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = "Chương 2: Phản ứng hóa học";
                bundle.putBoolean("c2",true);
                chuongNumber = "c2";
                bundle.putString("c_number", chuongNumber);
                bundle.putString("c_title", title);
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });

        ic_chuong_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = "Chương 3: Mol và tính toán hóa học";
                bundle.putBoolean("c3",true);
                chuongNumber = "c3";
                bundle.putString("c_number", chuongNumber);
                bundle.putString("c_title", title);
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });

        ic_chuong_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = "Chương 4: Oxi - Không khí";
                bundle.putBoolean("c4",true);
                chuongNumber = "c4";
                bundle.putString("c_number", chuongNumber);
                bundle.putString("c_title", title);
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });

        ic_chuong_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = "Chương 5: Hiđro - Nước";
                bundle.putBoolean("c5",true);
                chuongNumber = "c5";
                bundle.putString("c_number", chuongNumber);
                bundle.putString("c_title", title);
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });

        ic_chuong_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = "Chương 6: Dung dịch";
                bundle.putBoolean("c6",true);
                chuongNumber = "c6";
                bundle.putString("c_number", chuongNumber);
                bundle.putString("c_title", title);
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });

        ic_trac_nghiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TracNghiemSystem.class));
            }
        });

        ic_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SettingsSystem.class));
            }
        });

    }

    private void slideShow() {
        slideIn= AnimationUtils.loadAnimation(this,R.anim.slide_in);
        slideOut= AnimationUtils.loadAnimation(this,R.anim.slide_out);

        int[] image = {R.mipmap.ic_slide_1 ,R.mipmap.ic_slide_2,R.mipmap.ic_slide_3,
                R.mipmap.ic_slide_4, R.mipmap.ic_slide_5,R.mipmap.ic_slide_6};

        for(int i = 0 ; i <image.length; i++)
        {
            ImageView imgView = new ImageView(MainActivity.this);
            imgView.setImageResource(image[i]);
            vf_main.addView(imgView);
        }
        vf_main.setInAnimation(slideIn);
        vf_main.setOutAnimation(slideOut);
        vf_main.setAutoStart(true);
        vf_main.setFlipInterval(6000);
        vf_main.startFlipping();
    }

    private void mappting() {
        vf_main = (ViewFlipper) findViewById(R.id.vf_main);

        ic_chuong_1 = (CardView) findViewById(R.id.ic_chuong_1);
        ic_chuong_2 = (CardView) findViewById(R.id.ic_chuong_2);
        ic_chuong_3 = (CardView) findViewById(R.id.ic_chuong_3);
        ic_chuong_4 = (CardView) findViewById(R.id.ic_chuong_4);
        ic_chuong_5 = (CardView) findViewById(R.id.ic_chuong_5);
        ic_chuong_6 = (CardView) findViewById(R.id.ic_chuong_6);

        ic_trac_nghiem  = (CardView) findViewById(R.id.ic_trac_nghiem);
        ic_setting      = (CardView) findViewById(R.id.ic_setting);


    }

    private void nativeAds() {
        // NOTE always use test ads during development and testing
        //StartAppSDK.setTestAdsEnabled(BuildConfig.DEBUG);

//        setContentView(R.layout.recycler_view);

        cv_nativeAds  = (CardView) findViewById(R.id.cv_nativeAds);
        rcv_nativeAds = (RecyclerView) findViewById(R.id.rcv_nativeAds);
        rcv_nativeAds.setLayoutManager(new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false));
        rcv_nativeAds.setAdapter(adapter = new AdapterWithNativeAd(MainActivity.this));

        loadData();
        loadNativeAd();
    }

    private void loadNativeAd() {
        final StartAppNativeAd nativeAd = new StartAppNativeAd(MainActivity.this);

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