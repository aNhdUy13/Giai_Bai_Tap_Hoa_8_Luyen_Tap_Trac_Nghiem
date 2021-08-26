package com.nda.giai_bai_tap_hoa_lop_8.fn.TracNghiem;

public class TracNghiem {
    private String topicNumber;
    private String topicTItle;
    private String numQues;

    public TracNghiem(String topicNumber, String topicTItle, String numQues) {
        this.topicNumber = topicNumber;
        this.topicTItle = topicTItle;
        this.numQues = numQues;
    }

    public String getNumQues() {
        return numQues;
    }

    public void setNumQues(String numQues) {
        this.numQues = numQues;
    }

    public String getTopicNumber() {
        return topicNumber;
    }

    public void setTopicNumber(String topicNumber) {
        this.topicNumber = topicNumber;
    }

    public String getTopicTItle() {
        return topicTItle;
    }

    public void setTopicTItle(String topicTItle) {
        this.topicTItle = topicTItle;
    }
}
