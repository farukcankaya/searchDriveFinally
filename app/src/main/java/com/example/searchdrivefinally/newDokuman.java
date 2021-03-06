package com.example.searchdrivefinally;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.LoaderManager;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class newDokuman extends AppCompatActivity {
    private DatabaseHelper Veritabani;
    DatabaseHelper db;
    EditText text_dokumansevk, text_dokumannumarasi, text_dokumantipi, text_kayiteden, deneme;
    Button btn_kayitet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_dokuman);
        db =  new DatabaseHelper(this);
        Veritabani = new DatabaseHelper(this);
        text_dokumannumarasi = (EditText) findViewById(R.id.text_dokumannumarasi);
        text_dokumantipi = (EditText) findViewById(R.id.text_dokumantipi);
        text_dokumansevk = (EditText) findViewById(R.id.text_dokumansevk);
        text_kayiteden = (EditText) findViewById(R.id.text_kayiteden);
        btn_kayitet = (Button) findViewById(R.id.btn_kayitet);
        btn_kayitet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    KayitEkle(text_dokumannumarasi.getText().toString(), text_dokumantipi.getText().toString(), text_dokumansevk.getText().toString(), text_kayiteden.getText().toString());

                }finally {
                    Veritabani.close();
                }
            }
        });

    }

    private void KayitEkle(String text_dokumannumarasi, String text_dokumantipi, String text_dokumansevk, String text_kayiteden) {
        SQLiteDatabase db = Veritabani.getWritableDatabase();
        ContentValues dokumanlar = new ContentValues();
        dokumanlar.put("DokumanNumarasi",text_dokumannumarasi);
        dokumanlar.put("DokumanTipi",text_dokumantipi);
        dokumanlar.put("DokumanSevkTarihi",text_dokumansevk);
        dokumanlar.put("DokumanKayitEden",text_kayiteden);
        db.insertOrThrow("tbl_dokuman", null, dokumanlar);
    }







}