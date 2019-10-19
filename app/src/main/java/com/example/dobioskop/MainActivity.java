package com.example.dobioskop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.os.Looper.prepare;

public class MainActivity extends AppCompatActivity {

    private moviesAdapter adapter;
    private String[] teksJudul;
    private String[] teksDeskripsi;
    private String[] teksRilis;
    private TypedArray dataFoto;
    private ArrayList<movies> Movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.lv_list);
        adapter = new moviesAdapter(this);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, Movies.get(i).getJudul(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addItem() {
        Movies = new ArrayList<>();
        for (int i = 0; i < teksJudul.length; i++) {
            movies movie = new movies();
            movie.setFoto(dataFoto.getResourceId(i, -1));
            movie.setJudul(teksJudul[i]);
            movie.setDeskripsi(teksDeskripsi[i]);
            movie.setRilis(teksRilis[i]);
            Movies.add(movie);
        }
        adapter.setHeroes(Movies);
    }

    private void prepare() {
        teksJudul = getResources().getStringArray(R.array.nama_film);
        teksDeskripsi = getResources().getStringArray(R.array.deskripsi_film);
        dataFoto = getResources().obtainTypedArray(R.array.data_foto);
        teksRilis = getResources().getStringArray(R.array.rilis_film);

    }
}
