package com.nda.giai_bai_tap_hoa_lop_8.fn.TracNghiem;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nda.giai_bai_tap_hoa_lop_8.R;
import com.nda.giai_bai_tap_hoa_lop_8.fn.TracNghiem.DetailTracNghiem.ScreenSlideActivity;

import java.util.List;

public class AdapterTracNghiem extends RecyclerView.Adapter<AdapterTracNghiem.TracNghiemViewHolder> {
    TracNghiemSystem context;
    List<TracNghiem> tracNghiemList;

    public AdapterTracNghiem(TracNghiemSystem context, List<TracNghiem> tracNghiemList) {
        this.context = context;
        this.tracNghiemList = tracNghiemList;
    }

    @Override
    public AdapterTracNghiem.TracNghiemViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_show_topic_trac_nghiem,parent,false);
        return new TracNghiemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  AdapterTracNghiem.TracNghiemViewHolder holder, int position) {
        TracNghiem tracNghiem = tracNghiemList.get(position);

        holder.txt_showExamNumber.setText(tracNghiem.getTopicNumber());
        holder.txt_showExamTitle.setText(tracNghiem.getTopicTItle());
        holder.txt_showNumberQues.setText(tracNghiem.getNumQues());

        holder.ll_showExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ScreenSlideActivity.class);
                Bundle bundle = new Bundle();

                bundle.putBoolean("tracNghiem",true);
                bundle.putString("tracNghiemTopic",tracNghiem.getTopicNumber());
                bundle.putString("tracNghiemTitle",tracNghiem.getTopicTItle());
                intent.putExtras(bundle);

                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return tracNghiemList.size();
    }

    public class TracNghiemViewHolder extends RecyclerView.ViewHolder {
        TextView txt_showExamTitle, txt_showNumberQues, txt_showExamNumber;
        LinearLayout ll_showExam;

        public TracNghiemViewHolder(@NonNull  View itemView) {
            super(itemView);
            txt_showExamTitle   = (TextView) itemView.findViewById(R.id.txt_showExamTitle);
            txt_showNumberQues   = (TextView) itemView.findViewById(R.id.txt_showNumberQues);
            txt_showExamNumber   = (TextView) itemView.findViewById(R.id.txt_showExamNumber);

            ll_showExam     = (LinearLayout) itemView.findViewById(R.id.ll_showExam);
        }
    }
}
