package com.nda.giai_bai_tap_hoa_lop_8.fn.DetailChuong;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.nda.giai_bai_tap_hoa_lop_8.R;
import com.nda.giai_bai_tap_hoa_lop_8.fn.ShowTask_Result.ShowTask_Result;

import java.util.List;

public class AdapterDetailChuong extends RecyclerView.Adapter<AdapterDetailChuong.DetailChuongHolder> {
    DetailChuong context;
    List<Chuong> chuongList;

    public AdapterDetailChuong(DetailChuong context, List<Chuong> chuongList) {
        this.context = context;
        this.chuongList = chuongList;
    }

    @Override
    public AdapterDetailChuong.DetailChuongHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_show_detail_chuong,parent,false);
        return new DetailChuongHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  AdapterDetailChuong.DetailChuongHolder holder, int position) {

        Chuong chuong = chuongList.get(position);

        holder.txt_titleTask.setText(chuong.getTaskTitle());
        holder.cv_goToTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ShowTask_Result.class);
                Bundle bundle = new Bundle();
                bundle.putBoolean("detailTask",true);
                bundle.putString("taskTitle",chuong.getTaskTitle());
                bundle.putString("chuongDetailSignel",chuong.getChuongDetailSignal());
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return chuongList.size();
    }

    public class DetailChuongHolder extends RecyclerView.ViewHolder {
        TextView txt_titleTask;
        CardView cv_goToTask;

        public DetailChuongHolder(@NonNull  View itemView) {
            super(itemView);
            cv_goToTask = (CardView) itemView.findViewById(R.id.cv_goToTask);
            txt_titleTask   = (TextView) itemView.findViewById(R.id.txt_titleTask);
        }
    }
}
