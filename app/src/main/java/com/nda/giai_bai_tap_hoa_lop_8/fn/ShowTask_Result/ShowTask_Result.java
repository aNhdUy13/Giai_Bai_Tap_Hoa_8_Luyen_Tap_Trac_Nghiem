package com.nda.giai_bai_tap_hoa_lop_8.fn.ShowTask_Result;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.nda.giai_bai_tap_hoa_lop_8.R;

import org.w3c.dom.Text;

public class ShowTask_Result extends AppCompatActivity {
    /**
     *  Activity fn
     */
    TextView txt_title, txt_task_question, txt_task_result;
    Intent intent;
    Bundle bundle;
    String taskTitle, chuongDetailSignal;
    ImageView imgBack;
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

    @SuppressLint("SetTextI18n")
    private void readSignal(String chuongDetailSignal) {

        chuong1();
        chuong2();
        chuong3();

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

    }
}