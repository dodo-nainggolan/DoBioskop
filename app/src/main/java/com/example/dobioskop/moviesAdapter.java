package com.example.dobioskop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class moviesAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<movies> movies = new ArrayList<>();

    //setter hasil generate
    public void setHeroes(ArrayList<movies> heroes) {
        this.movies = heroes;
    }

    //constructor hasil generate
    public moviesAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.konten, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(itemView);
        movies movies = (movies) getItem(i);
        viewHolder.bind(movies);
        return itemView;
    }

    private class ViewHolder {
        private TextView teks_judul;
        private TextView teks_deskripsi;
        private ImageView img_foto;
        private TextView teks_rilis;

        ViewHolder(View view) {
            teks_judul = view.findViewById(R.id.teks_judul);
            teks_deskripsi = view.findViewById(R.id.teks_deksripsi);
            img_foto = view.findViewById(R.id.img_foto);
            teks_rilis = view.findViewById(R.id.teks_rilis);
        }

        void bind(movies movies) {
            teks_judul.setText(movies.getJudul());
            teks_deskripsi.setText(movies.getDeskripsi());
            img_foto.setImageResource(movies.getFoto());
            teks_rilis.setText(movies.getRilis());
        }
    }
}
