package com.divakrishna.converterapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText inputSuhu;
    RadioButton reamur, kelvin, farenheit;
    Button tombolConvert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputSuhu = findViewById(R.id.input_suhu);
        reamur = findViewById(R.id.reamur);
        kelvin = findViewById(R.id.kelvin);
        farenheit = findViewById(R.id.farenheit);
        tombolConvert = findViewById(R.id.tombol_convert);

        tombolConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    double input = Double.parseDouble(inputSuhu.getText().toString());
                    double output = 0;
                    String satuan = "";
                    if (reamur.isChecked()){
                        output = (4/5)*input;
                        satuan = "Reamur";
                    } else if(farenheit.isChecked()){
                        output = ((9/5)*input)+32;
                        satuan = "Farenheit";
                    } else if(kelvin.isChecked()){
                        output = input + 273;
                        satuan = "Kelvin";
                    }
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    intent.putExtra("HASIL_CONVERT", String.valueOf(output));
                    intent.putExtra("SATUAN_PILIHAN", satuan);
                    startActivity(intent);
                }catch(Exception e){
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Masukan suhu", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
