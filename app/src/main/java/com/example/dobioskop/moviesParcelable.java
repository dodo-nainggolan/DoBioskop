package com.example.dobioskop;

import android.os.Parcel;
import android.os.Parcelable;

public class moviesParcelable implements Parcelable {
    private int foto;
    private String judul;
    private String deskripsi;
    private String rilis;

    public moviesParcelable() {

    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getRilis() {
        return rilis;
    }

    public void setRilis(String rilis) {
        this.rilis = rilis;
    }



    protected moviesParcelable(Parcel in) {
        foto = in.readInt();
        judul = in.readString();
        deskripsi = in.readString();
        rilis = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(foto);
        dest.writeString(judul);
        dest.writeString(deskripsi);
        dest.writeString(rilis);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<moviesParcelable> CREATOR = new Creator<moviesParcelable>() {
        @Override
        public moviesParcelable createFromParcel(Parcel in) {
            return new moviesParcelable(in);
        }

        @Override
        public moviesParcelable[] newArray(int size) {
            return new moviesParcelable[size];
        }
    };
}
