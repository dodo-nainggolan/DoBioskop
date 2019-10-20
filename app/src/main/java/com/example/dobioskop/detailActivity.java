package com.example.dobioskop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class detailActivity extends AppCompatActivity {
    public static final String EXTRA_PERSON = "extra_person";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView tvJudul = findViewById(R.id.teks_judul);
        TextView tvDeskripsi = findViewById(R.id.teks_deksripsi);
        TextView tvRilis = findViewById(R.id.teks_rilis);
        ImageView tvFotoDetail = findViewById(R.id.foto_detail);

        moviesParcelable moviesParcelable = getIntent().getParcelableExtra("myData");
        tvJudul.setText(moviesParcelable.getJudul());
        tvDeskripsi.setText(moviesParcelable.getDeskripsi());
        tvRilis.setText(moviesParcelable.getRilis());
        tvFotoDetail.setImageResource(moviesParcelable.getFoto());



    }
}
