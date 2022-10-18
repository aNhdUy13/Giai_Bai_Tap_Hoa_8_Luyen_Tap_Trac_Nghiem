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

import com.nda.giai_bai_tap_hoa_lop_8.R;


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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_system);
        mapting();
        initiate();

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

}