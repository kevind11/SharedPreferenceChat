package com.example.d2j_00.uts_a11201508751;

/**
 * Created by D2J-00 on 01/11/2017.
 */
public class Chat {
    private String mPengirim;
    private String mPesan;
    private String mTanggal;
    private int mImagaView;
    public Chat(String mPengirim, String mPesan, String mTanggal, int mImagaView){

        this.mPengirim = mPengirim;
        this.mPesan = mPesan;
        this.mTanggal = mTanggal;
        this.mImagaView = mImagaView;
    }

    public String getmPengirim() {
        return mPengirim;
    }

    public void setmPengirim(String mPengirim) {
        this.mPengirim = mPengirim;
    }

    public String getmPesan() {
        return mPesan;
    }

    public void setmPesan(String mPesan) {
        this.mPesan = mPesan;
    }

    public String getmTanggal() {
        return mTanggal;
    }

    public void setmTanggal(String mTanggal) {
        this.mTanggal = mTanggal;
    }

    public int getmImagaView() {
        return mImagaView;
    }

    public void setmImagaView(int mImagaView) {
        this.mImagaView = mImagaView;
    }


}
