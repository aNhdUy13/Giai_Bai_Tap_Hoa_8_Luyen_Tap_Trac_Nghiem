package com.nda.giai_bai_tap_hoa_lop_8.fn.TracNghiem.DoneExam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.nda.giai_bai_tap_hoa_lop_8.R;
import com.nda.giai_bai_tap_hoa_lop_8.fn.TracNghiem.DetailTracNghiem.Question;

import java.util.ArrayList;
import java.util.List;

public class ExamFinished extends AppCompatActivity {
    Button btn_outFinished, btn_re_exam;

    TextView txt_showEnd_correctAns, txt_showEnd_wrongAns, txt_showEnd_emptyAns;

    List<Question> questionList = new ArrayList<>();

    int trueAns = 0;
    int falseAns = 0;
    int emptyAns = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_finished);

        mapting();
        /**
         *  Get data from screen slide
         */
        Intent intent = getIntent();
        questionList = (List<Question>) intent.getExtras().getSerializable("listQuestion");


        /**
         *  Display true + false + empty answer
         */
        checkAns();
        txt_showEnd_correctAns.setText(String.valueOf(trueAns));
        txt_showEnd_wrongAns.setText(String.valueOf(falseAns));
        txt_showEnd_emptyAns.setText(String.valueOf(emptyAns));




        btn_outFinished.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    /**
     *  Method check answer
     */
    public void checkAns()
    {
        for (int i = 0 ; i < questionList.size() ; i ++)
        {
            if (questionList.get(i).getUserAns().equals(""))
            {
                emptyAns ++;
            }
            else if (questionList.get(i).getCorrectAns().equals(questionList.get(i).getUserAns()))
            {
                trueAns ++;
            }
            else
            {
                falseAns ++;
            }
        }
    }


    private void mapting() {
        btn_outFinished = (Button) findViewById(R.id.btn_outFinished);
        btn_re_exam = (Button) findViewById(R.id.btn_re_exam);

        txt_showEnd_correctAns  = (TextView) findViewById(R.id.txt_showEnd_correctAns);
        txt_showEnd_wrongAns  = (TextView) findViewById(R.id.txt_showEnd_wrongAns);
        txt_showEnd_emptyAns  = (TextView) findViewById(R.id.txt_showEnd_emptyAns);

    }
}