package com.example.shapecalculator.bangunruang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.shapecalculator.MainActivity;
import com.example.shapecalculator.R;

public class Tabung extends AppCompatActivity {

    EditText edJari, edTinggi;
    Button buttonHitung, buttonReset;
    TextView tvHasil;
    ImageView ivBangunRuang,ivBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabung);

        ivBack = findViewById(R.id.back);
        edJari = findViewById(R.id.edJari);
        edTinggi = findViewById(R.id.edTinggi);
        buttonHitung = findViewById(R.id.buttonHitung);
        buttonReset = findViewById(R.id.buttonReset);
        tvHasil = findViewById(R.id.tvHasil);
        ivBangunRuang = findViewById(R.id.ivLogo);

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        Glide.with(this).load("https://upload.wikimedia.org/wikipedia/commons/thumb/8/81/Zylinder-1-tab.svg/232px-Zylinder-1-tab.svg.png").into(ivBangunRuang);
        buttonHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edJari.getText().toString().isEmpty() || edTinggi.getText().toString().isEmpty()) {
                    Toast.makeText(Tabung.this, "inputan tidak boleh ada yang kosong.", Toast.LENGTH_SHORT).show();
                }
                else {
                    double jari = Double.parseDouble(edJari.getText().toString());
                    double tinggi = Double.parseDouble(edTinggi.getText().toString());
                    double hasil = 2 * 3.14 * jari * (jari + tinggi);
                    String hasilString = String.format("%.2f", hasil);
                    tvHasil.setText(hasilString);
                }
            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edJari.setText("");
                edTinggi.setText("");
                tvHasil.setText("0");
            }
        });
    }
}