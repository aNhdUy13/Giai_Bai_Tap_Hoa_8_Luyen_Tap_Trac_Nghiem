package com.nda.giai_bai_tap_hoa_lop_8.fn.DetailChuong;

public class Chuong {
    private String chuong;
    private String chuongDetailSignal;
    private String taskTitle;

    public Chuong(String chuong, String chuongDetailSignal, String taskTitle) {
        this.chuong = chuong;
        this.chuongDetailSignal = chuongDetailSignal;
        this.taskTitle = taskTitle;
    }

    public String getChuong() {
        return chuong;
    }

    public void setChuong(String chuong) {
        this.chuong = chuong;
    }

    public String getChuongDetailSignal() {
        return chuongDetailSignal;
    }

    public void setChuongDetailSignal(String chuongDetailSignal) {
        this.chuongDetailSignal = chuongDetailSignal;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }
}
