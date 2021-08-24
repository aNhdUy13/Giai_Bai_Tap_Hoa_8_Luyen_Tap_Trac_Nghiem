package com.nda.giai_bai_tap_hoa_lop_8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.nda.giai_bai_tap_hoa_lop_8.fn.DetailChuong.DetailChuong;
import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.StartAppSDK;

public class MainActivity extends AppCompatActivity {
    /**
     * Setup slide show
     */
    ViewFlipper vf_main;
    Animation slideIn, slideOut;

    /**
     *  setup action data
     */
    CardView ic_chuong_1, ic_chuong_2, ic_chuong_3, ic_chuong_4, ic_chuong_5, ic_chuong_6;
    Intent intent;
    Bundle bundle;
    String chuongNumber, title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StartAppSDK.setTestAdsEnabled(true);
        StartAppAd.disableSplash();

        mappting();
        slideShow();
        initiate();


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


    }

}