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
import com.example.shapecalculator.bangunruang.Tabung;

public class Segitiga extends AppCompatActivity {

    EditText edAlas, edTinggi;
    Button buttonHitung, buttonReset;
    TextView tvHasil;
    ImageView ivBangunRuang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segitiga);

        edAlas = findViewById(R.id.edAlas);
        edTinggi = findViewById(R.id.edTinggi);
        buttonHitung = findViewById(R.id.buttonHitung);
        buttonReset = findViewById(R.id.buttonReset);
        tvHasil = findViewById(R.id.tvHasil);
        ivBangunRuang = findViewById(R.id.ivLogo);

        Glide.with(this).load("https://upload.wikimedia.org/wikipedia/commons/3/35/Enneagram_triangle.png").into(ivBangunRuang);
        buttonHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edAlas.getText().toString().isEmpty() || edTinggi.getText().toString().isEmpty()) {
                    Toast.makeText(Segitiga.this, "inputan tidak boleh ada yang kosong.", Toast.LENGTH_SHORT).show();
                }
                else {
                    double alas = Double.parseDouble(edAlas.getText().toString());
                    double tinggi = Double.parseDouble(edTinggi.getText().toString());
                    double hasil = alas * tinggi / 2;
                    tvHasil.setText(hasil + "");
                }
            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edAlas.setText("");
                edTinggi.setText("");
                tvHasil.setText("0");
            }
        });
    }
}