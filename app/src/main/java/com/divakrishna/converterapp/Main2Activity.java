package com.divakrishna.converterapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView hasilConvert, satuanPilihan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        hasilConvert = findViewById(R.id.hasil_convert);
        satuanPilihan = findViewById(R.id.satuan_pilihan);

        Intent intent = getIntent();

        hasilConvert.setText(intent.getStringExtra("HASIL_CONVERT"));
        satuanPilihan.setText(intent.getStringExtra("SATUAN_PILIHAN"));

    }
}
