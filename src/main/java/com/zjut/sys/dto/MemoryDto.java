package com.zjut.sys.dto;

/**
 * Created by xjy on 2017/5/15.
 */
public class MemoryDto {
    private double MenToal;
    private double MenUsed;
    private double rate;

    public MemoryDto() {
    }

    public double getMenToal() {
        return MenToal;
    }

    public void setMenToal(double menToal) {
        this.MenToal = menToal;
    }

    public double getMenUsed() {
        return MenUsed;
    }

    public void setMenUsed(double menUsed) {
        this.MenUsed = menUsed;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "MemoryDto{" +
                "MenToal=" + MenToal +
                ", MenUsed=" + MenUsed +
                ", rate=" + rate +
                '}';
    }
}
