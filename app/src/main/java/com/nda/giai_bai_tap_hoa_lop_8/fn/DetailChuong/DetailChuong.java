package com.nda.giai_bai_tap_hoa_lop_8.fn.DetailChuong;

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
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.nda.giai_bai_tap_hoa_lop_8.MainActivity;
import com.nda.giai_bai_tap_hoa_lop_8.R;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class DetailChuong extends AppCompatActivity {
    /**
     *  Class fn + Set data to RCV
     */
    RecyclerView rcv_showTopic;
    ImageView imgBack;
    TextView txt_title;
    List<Chuong> chuongList;
    AdapterDetailChuong mAdapterDetailChuong;

    /**
     *  Get push data from main
     */
    Intent intent;
    Bundle bundle;
    String chuongNumber, title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_chuong);
        mapting();
        setupRecycleView();

        initiate();

    }
    private void setupRecycleView() {
        chuongList  = new ArrayList<>();
        mAdapterDetailChuong = new AdapterDetailChuong(this,chuongList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rcv_showTopic.setLayoutManager(linearLayoutManager);
        rcv_showTopic.setAdapter(mAdapterDetailChuong);

    }
    private void initiate()
    {
        /**
         * Class fn
         */
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chuongList.clear();
                startActivity(new Intent(DetailChuong.this, MainActivity.class));
            }
        });

        /**
         *  Receive data from main
         */
        intent = getIntent();
        bundle = intent.getExtras();

        if (bundle.containsKey("c1"))
        {
            chuongNumber = intent.getStringExtra("c_number");
            title =intent.getStringExtra("c_title");
            readChuongDetail(title, chuongNumber);
        }
        if (bundle.containsKey("c2"))
        {
            chuongNumber = intent.getStringExtra("c_number");
            title =intent.getStringExtra("c_title");
            readChuongDetail(title,chuongNumber);
        }
        if (bundle.containsKey("c3"))
        {
            chuongNumber = intent.getStringExtra("c_number");

            title =intent.getStringExtra("c_title");
            readChuongDetail(title,chuongNumber);
        }
        if (bundle.containsKey("c4"))
        {
            chuongNumber = intent.getStringExtra("c_number");

            title =intent.getStringExtra("c_title");
            readChuongDetail(title,chuongNumber);
        }
        if (bundle.containsKey("c5"))
        {
            chuongNumber = intent.getStringExtra("c_number");

            title =intent.getStringExtra("c_title");
            readChuongDetail(title,chuongNumber);
        }
        if (bundle.containsKey("c6"))
        {
            chuongNumber = intent.getStringExtra("c_number");

            title =intent.getStringExtra("c_title");
            readChuongDetail(title,chuongNumber);
        }
    }

    private void readChuongDetail(String title, String chuongNumber) {
        txt_title.setText(title);

        InputStream inputStream = getResources().openRawResource(R.raw.task_topic);
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(inputStream, Charset.forName("UTF-8"))
        );

        Chuong chuong;
        String line;
        try {
            while ((line = bufferedReader.readLine()) != null)
            {
                String[] split =  line.split(";");

                if (split[0].equals(chuongNumber))
                {
                    chuong = new Chuong(split[0],split[1], split[2]);
                    chuongList.add(chuong);
                }
            }
            mAdapterDetailChuong.notifyDataSetChanged();

        } catch (Exception e)
        {
            Toast.makeText(this, "Có Lỗi Xảy Ra : Load Topic Practice !", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onBackPressed() {
        chuongList.clear();
        startActivity(new Intent(DetailChuong.this, MainActivity.class));
    }

    private void mapting() {
        rcv_showTopic   = (RecyclerView) findViewById(R.id.rcv_showTopic);
        imgBack         = (ImageView) findViewById(R.id.imgBack);
        txt_title       = (TextView) findViewById(R.id.txt_title);
    }

}