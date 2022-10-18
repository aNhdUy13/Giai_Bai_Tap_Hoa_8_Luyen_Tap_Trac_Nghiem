package com.nda.giai_bai_tap_hoa_lop_8.fn.ShowTask_Result;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.UiThread;
import androidx.annotation.WorkerThread;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.nda.giai_bai_tap_hoa_lop_8.R;
import com.nda.giai_bai_tap_hoa_lop_8.fn.Widget.FloatingWindowGFG;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ShowTask_Result extends AppCompatActivity implements View.OnClickListener {
    /**
     *  Activity fn
     */
    TextView txt_title, txt_task_question, txt_task_result,txt_toast;
    Intent intent;
    Bundle bundle;
    String taskTitle, chuongDetailSignal;
    ImageView imgBack, img_ques, img_close, img_zoom;
    String question;
    String result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_task_result);
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

        img_ques.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogQues();
            }
        });
        try {
            img_zoom.setOnClickListener(this);
        }
        catch (Exception e)
        {
            Toast toast = new Toast(this);
            LayoutInflater layoutInflater = getLayoutInflater();
            View view = layoutInflater.inflate(R.layout.toast_custom_error, (ViewGroup) findViewById(R.id.toast_custom_widget));
            toast.setGravity(Gravity.BOTTOM,0,40);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setView(view);
            toast.show();
        }

        intent  = getIntent();
        bundle = intent.getExtras();
        if (bundle.containsKey("detailTask"))
        {
            taskTitle = intent.getStringExtra("taskTitle");
            chuongDetailSignal =intent.getStringExtra("chuongDetailSignel");

            txt_title.setText(taskTitle);
            readSignal(chuongDetailSignal);
        }
    }

    /**
     *  Read signal and input data
     * @param chuongDetailSignal
     */
    @SuppressLint("SetTextI18n")
    private void readSignal(String chuongDetailSignal) {

        chuong1();
        chuong2();
        chuong3();
        chuong4();
        chuong5();
        chuong6();

    }
    private void chuong6() {
        if (chuongDetailSignal.equals("c6_1"))
        {
            question = getResources().getString(R.string.c6_1_question);
            result = getResources().getString(R.string.c6_1_result);
            showQuesResult(question, result);
        }

        if (chuongDetailSignal.equals("c6_2"))
        {
            question = getResources().getString(R.string.c6_2_question);
            result = getResources().getString(R.string.c6_2_result);
            showQuesResult(question, result);
        }

        if (chuongDetailSignal.equals("c6_3"))
        {
            question = getResources().getString(R.string.c6_3_question);
            result = getResources().getString(R.string.c6_3_result);
            showQuesResult(question, result);
        }

        if (chuongDetailSignal.equals("c6_4"))
        {
            question = getResources().getString(R.string.c6_4_question);
            result = getResources().getString(R.string.c6_4_result);
            showQuesResult(question, result);
        }

        if (chuongDetailSignal.equals("c6_5"))
        {
            question = getResources().getString(R.string.c6_5_question);
            result = getResources().getString(R.string.c6_5_result);
            showQuesResult(question, result);
        }

    }

    private void chuong5() {
        if (chuongDetailSignal.equals("c5_1"))
        {
            question = getResources().getString(R.string.c5_1_question);
            result = getResources().getString(R.string.c5_1_result);
            showQuesResult(question, result);
        }

        if (chuongDetailSignal.equals("c5_2"))
        {
            question = getResources().getString(R.string.c5_2_question);
            result = getResources().getString(R.string.c5_2_result);
            showQuesResult(question, result);
        }

        if (chuongDetailSignal.equals("c5_3"))
        {
            question = getResources().getString(R.string.c5_3_question);
            result = getResources().getString(R.string.c5_3_result);
            showQuesResult(question, result);
        }

        if (chuongDetailSignal.equals("c5_4"))
        {
            question = getResources().getString(R.string.c5_4_question);
            result = getResources().getString(R.string.c5_4_result);
            showQuesResult(question, result);
        }

        if (chuongDetailSignal.equals("c5_5"))
        {
            question = getResources().getString(R.string.c5_5_question);
            result = getResources().getString(R.string.c5_5_result);
            showQuesResult(question, result);
        }

        if (chuongDetailSignal.equals("c5_6"))
        {
            question = getResources().getString(R.string.c5_6_question);
            result = getResources().getString(R.string.c5_6_result);
            showQuesResult(question, result);
        }

        if (chuongDetailSignal.equals("c5_7"))
        {
            question = getResources().getString(R.string.c5_7_question);
            result = getResources().getString(R.string.c5_7_result);
            showQuesResult(question, result);
        }

        if (chuongDetailSignal.equals("c5_8"))
        {
            question = getResources().getString(R.string.c5_8_question);
            result = getResources().getString(R.string.c5_8_result);
            showQuesResult(question, result);
        }

        if (chuongDetailSignal.equals("c5_9"))
        {
            question = getResources().getString(R.string.c5_9_question);
            result = getResources().getString(R.string.c5_9_result);
            showQuesResult(question, result);
        }

    }

    private void chuong4()
    {
        if (chuongDetailSignal.equals("c4_1"))
        {
            question = getResources().getString(R.string.c4_1_question);
            result = getResources().getString(R.string.c4_1_result);
            showQuesResult(question, result);
        }

        if (chuongDetailSignal.equals("c4_2"))
        {
            question = getResources().getString(R.string.c4_2_question);
            result = getResources().getString(R.string.c4_2_result);
            showQuesResult(question, result);
        }

        if (chuongDetailSignal.equals("c4_3"))
        {
            question = getResources().getString(R.string.c4_3_question);
            result = getResources().getString(R.string.c4_3_result);
            showQuesResult(question, result);
        }

        if (chuongDetailSignal.equals("c4_4"))
        {
            question = getResources().getString(R.string.c4_4_question);
            result = getResources().getString(R.string.c4_4_result);
            showQuesResult(question, result);
        }

        if (chuongDetailSignal.equals("c4_5"))
        {
            question = getResources().getString(R.string.c4_5_question);
            result = getResources().getString(R.string.c4_5_result);
            showQuesResult(question, result);
        }

        if (chuongDetailSignal.equals("c4_6"))
        {
            question = getResources().getString(R.string.c4_6_question);
            result = getResources().getString(R.string.c4_6_result);
            showQuesResult(question, result);
        }
        if (chuongDetailSignal.equals("c4_7"))
        {
            question = getResources().getString(R.string.c4_7_question);
            result = getResources().getString(R.string.c4_7_result);
            showQuesResult(question, result);
        }
    }
    private void chuong3()
    {
        if (chuongDetailSignal.equals("c3_1"))
        {
            question = getResources().getString(R.string.c3_1_question);
            result = getResources().getString(R.string.c3_1_result);
            showQuesResult(question, result);
        }

        if (chuongDetailSignal.equals("c3_2"))
        {
            question = getResources().getString(R.string.c3_2_question);
            result = getResources().getString(R.string.c3_2_result);
            showQuesResult(question, result);
        }

        if (chuongDetailSignal.equals("c3_3"))
        {
            question = getResources().getString(R.string.c3_3_question);
            result = getResources().getString(R.string.c3_3_result);
            showQuesResult(question, result);
        }

        if (chuongDetailSignal.equals("c3_4"))
        {
            question = getResources().getString(R.string.c3_4_question);
            result = getResources().getString(R.string.c3_4_result);
            showQuesResult(question, result);
        }

        if (chuongDetailSignal.equals("c3_5"))
        {
            question = getResources().getString(R.string.c3_5_question);
            result = getResources().getString(R.string.c3_5_result);
            showQuesResult(question, result);
        }

        if (chuongDetailSignal.equals("c3_6"))
        {
            question = getResources().getString(R.string.c3_6_question);
            result = getResources().getString(R.string.c3_6_result);
            showQuesResult(question, result);
        }
    }

    private void chuong2()
    {
        if (chuongDetailSignal.equals("c2_1"))
        {
            question = getResources().getString(R.string.c2_1_question);
            result = getResources().getString(R.string.c2_1_result);
            showQuesResult(question, result);
        }

        if (chuongDetailSignal.equals("c2_2"))
        {
            question = getResources().getString(R.string.c2_2_question);
            result = getResources().getString(R.string.c2_2_result);
            showQuesResult(question, result);
        }

        if (chuongDetailSignal.equals("c2_3"))
        {
            question = getResources().getString(R.string.c2_3_question);
            result = getResources().getString(R.string.c2_3_result);
            showQuesResult(question, result);
        }

        if (chuongDetailSignal.equals("c2_4"))
        {
            question = getResources().getString(R.string.c2_4_question);
            result = getResources().getString(R.string.c2_4_result);
            showQuesResult(question, result);
        }

        if (chuongDetailSignal.equals("c2_5"))
        {
            question = getResources().getString(R.string.c2_5_question);
            result = getResources().getString(R.string.c2_5_result);
            showQuesResult(question, result);
        }

        if (chuongDetailSignal.equals("c2_6"))
        {
            question = getResources().getString(R.string.c2_6_question);
            result = getResources().getString(R.string.c2_6_result);
            showQuesResult(question, result);
        }

    }

    private void chuong1() {
        if (chuongDetailSignal.equals("c1_1"))
        {
            question = getResources().getString(R.string.c1_1_question);
            result = getResources().getString(R.string.c1_1_result);
            showQuesResult(question, result);
        }

        if (chuongDetailSignal.equals("c1_2"))
        {
            question = getResources().getString(R.string.c1_2_question);
            result = getResources().getString(R.string.c1_2_result);
            showQuesResult(question, result);
        }

        if (chuongDetailSignal.equals("c1_3"))
        {
            question = getResources().getString(R.string.c1_3_question);
            result = getResources().getString(R.string.c1_3_result);
            showQuesResult(question, result);
        }

        if (chuongDetailSignal.equals("c1_4"))
        {
            question = getResources().getString(R.string.c1_4_question);
            result = getResources().getString(R.string.c1_4_result);
            showQuesResult(question, result);
        }

        if (chuongDetailSignal.equals("c1_5"))
        {
            question = getResources().getString(R.string.c1_5_question);
            result = getResources().getString(R.string.c1_5_result);
            showQuesResult(question, result);
        }

        if (chuongDetailSignal.equals("c1_6"))
        {
            question = getResources().getString(R.string.c1_6_question);
            result = getResources().getString(R.string.c1_6_result);
            showQuesResult(question, result);
        }

        if (chuongDetailSignal.equals("c1_7"))
        {
            question = getResources().getString(R.string.c1_7_question);
            result = getResources().getString(R.string.c1_7_result);
            showQuesResult(question, result);
        }

        if (chuongDetailSignal.equals("c1_8"))
        {
            question = getResources().getString(R.string.c1_8_question);
            result = getResources().getString(R.string.c1_8_result);
            showQuesResult(question, result);
        }

        if (chuongDetailSignal.equals("c1_9"))
        {
            question = getResources().getString(R.string.c1_9_question);
            result = getResources().getString(R.string.c1_9_result);
            showQuesResult(question, result);
        }

        if (chuongDetailSignal.equals("c1_10"))
        {
            question = getResources().getString(R.string.c1_10_question);
            result = getResources().getString(R.string.c1_10_result);
            showQuesResult(question, result);
        }

        if (chuongDetailSignal.equals("c1_11"))
        {
            question = getResources().getString(R.string.c1_11_question);
            result = getResources().getString(R.string.c1_11_result);
            showQuesResult(question, result);
        }
    }

    private void zoomFunction() {
    }

    /**
     *  Show Chú Ý
     */
    private void dialogQues() {
        Dialog dialog = new Dialog(ShowTask_Result.this);
        dialog.setContentView(R.layout.dialog_chu_y);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        img_close   = (ImageView) dialog.findViewById(R.id.img_close);
        img_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }



    private void showQuesResult(String question, String result)
    {
        txt_task_question.setText(question);
        txt_task_result.setText(result);
    }


    private void mapting() {
        imgBack = (ImageView) findViewById(R.id.imgBack);
        txt_title           = (TextView) findViewById(R.id.txt_title);
        txt_task_question      = (TextView) findViewById(R.id.txt_task_question);
        txt_task_result     = (TextView) findViewById(R.id.txt_task_result);

        img_zoom    = (ImageView) findViewById(R.id.img_zoom);
        img_ques    = (ImageView) findViewById(R.id.img_ques);

    }

    @Override
    public void onClick(View v)
    {
        String title,question, result;
        title =  txt_title.getText().toString().trim();
        question    = txt_task_question.getText().toString().trim();
        result      = txt_task_result.getText().toString().trim();


        Intent intentService = new Intent(ShowTask_Result.this,FloatingWindowGFG.class);
        intentService.putExtra("title",title);
        intentService.putExtra("question",question);
        intentService.putExtra("result",result);

        Toast toast = new Toast(this);
        LayoutInflater layoutInflater = getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.toast_custom_widget, (ViewGroup) findViewById(R.id.toast_custom_widget));
        toast.setGravity(Gravity.BOTTOM,0,40);
        toast.setDuration(Toast.LENGTH_LONG);
        txt_toast   = (TextView) view.findViewById(R.id.txt_toast);
        toast.setView(view);

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M)
        {
            startService(intentService);
            toast.show();
        }
        else if(Settings.canDrawOverlays(this))
        {
            startService(intentService);
            toast.show();

        }
        else
        {
            txt_toast.setText("Bạn Cần cẤP QUYỀN Để Sử Dụng Tính Năng");
            toast.show();
            askPermission();


        }

    }

    @SuppressLint("WrongConstant")
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void askPermission() {
        if (!Settings.canDrawOverlays(this)) {
            Intent localIntent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
            localIntent.setData(Uri.parse("package:" + getPackageName()));
            localIntent.setFlags(268435456);
            startActivity(localIntent);
        }
    }

}