package com.example.shapecalculator.bangundatar;

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
import com.example.shapecalculator.bangunruang.Kubus;

public class Persegi extends AppCompatActivity {

    EditText edSisi;
    Button buttonHitung, buttonReset;
    TextView tvHasil;
    ImageView ivBangunRuang , ivBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persegi);

        ivBack = findViewById(R.id.back);
        edSisi = findViewById(R.id.edSisi);
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

        Glide.with(this).load("https://upload.wikimedia.org/wikipedia/commons/thumb/f/f7/Regular_quadrilateral.svg/250px-Regular_quadrilateral.svg.png").into(ivBangunRuang);
        buttonHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edSisi.getText().toString().isEmpty()) {
                    Toast.makeText(Persegi.this, "Sisi tidak boleh kosong.", Toast.LENGTH_SHORT).show();
                }
                else {
                    double sisi = Double.parseDouble(edSisi.getText().toString());
                    double hasil = sisi * sisi;
                    tvHasil.setText(hasil + "");
                }
            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edSisi.setText("");
                tvHasil.setText("0");
            }
        });
    }
}