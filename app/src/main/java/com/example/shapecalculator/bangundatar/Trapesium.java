package com.example.shapecalculator.bangundatar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.shapecalculator.R;

public class Trapesium extends AppCompatActivity {


    EditText edAtas, edBawah, edTinggi;
    Button buttonHitung, buttonReset;
    TextView tvHasil;
    ImageView ivBangunRuang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trapesium);

        edAtas = findViewById(R.id.edAtas);
        edBawah = findViewById(R.id.edBawah);
        edTinggi = findViewById(R.id.edTinggi);
        buttonHitung = findViewById(R.id.buttonHitung);
        buttonReset = findViewById(R.id.buttonReset);
        tvHasil = findViewById(R.id.tvHasil);
        ivBangunRuang = findViewById(R.id.ivLogo);

        Glide.with(this).load("https://drive.google.com/uc?export=download&id=1MCgUQ1iTKA8h3-Cf65983sO5Ovp_0AsO").into(ivBangunRuang);
        buttonHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edAtas.getText().toString().isEmpty() || edBawah.getText().toString().isEmpty() || edTinggi.getText().toString().isEmpty()) {
                    Toast.makeText(Trapesium.this, "inputan tidak boleh ada yang kosong.", Toast.LENGTH_SHORT).show();
                }
                else {
                    double alas = Double.parseDouble(edAtas.getText().toString());
                    double bawah = Double.parseDouble(edBawah.getText().toString());
                    double tinggi = Double.parseDouble(edTinggi.getText().toString());
                    double hasil = 0.5 * (alas + bawah) * tinggi;
                    tvHasil.setText(hasil + "");
                }
            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edAtas.setText("");
                edBawah.setText("");
                edTinggi.setText("");
                tvHasil.setText("0");
            }
        });
    }
}