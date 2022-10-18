package com.nda.giai_bai_tap_hoa_lop_8.fn.TracNghiem;

import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.WorkerThread;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.nda.giai_bai_tap_hoa_lop_8.R;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class TracNghiemSystem extends AppCompatActivity {
    /**
     * Activity fn
     */
    ImageView imgBack;
    TextView txt_title;

    /**
     * Setup RCV
     */
    RecyclerView rcv_showTracNghiemTopic;
    List<TracNghiem> tracNghiemList;
    AdapterTracNghiem mAdapterTracNghiem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trac_nghiem_system);
        mapting();
        initiate();
        setupRecycleView();

    }

    private void initiate() {
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setupRecycleView()
    {
        rcv_showTracNghiemTopic = (RecyclerView) findViewById(R.id.rcv_showTracNghiemTopic);
        tracNghiemList  = new ArrayList<>();
        mAdapterTracNghiem = new AdapterTracNghiem(this,tracNghiemList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rcv_showTracNghiemTopic.setLayoutManager(linearLayoutManager);
        rcv_showTracNghiemTopic.setAdapter(mAdapterTracNghiem);

        readTracNghiemTopic();
    }
    private void readTracNghiemTopic() {

        InputStream inputStream = getResources().openRawResource(R.raw.trac_nghiem_topic);
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(inputStream, Charset.forName("UTF-8"))
        );

        String line;
        try {
            while ((line = bufferedReader.readLine()) != null)
            {
                String[] split =  line.split(";");
                TracNghiem tracNghiem;
//||
                if (split[0].length() > 0  && split[1].length() > 0)
                {
                    tracNghiem = new TracNghiem(split[0],split[1], split[2]);
                }
                else
                {
                    tracNghiem = new TracNghiem("X","X","X");
                }

                tracNghiemList.add(tracNghiem);

            }
            mAdapterTracNghiem.notifyDataSetChanged();

        } catch (Exception e)
        {
            Toast.makeText(this, "Có Lỗi Xảy Ra : Load Topic Practice !", Toast.LENGTH_SHORT).show();
        }

    }



    private void mapting() {
        imgBack = (ImageView) findViewById(R.id.imgBack);


    }

}