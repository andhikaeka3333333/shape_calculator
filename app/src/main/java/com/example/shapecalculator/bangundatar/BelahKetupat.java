package com.example.shapecalculator.bangundatar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

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
import com.example.shapecalculator.bangunruang.Kerucut;
import com.example.shapecalculator.fragment.FragmentBangunDatar;

public class BelahKetupat extends AppCompatActivity {
    EditText edDiagonalSatu, edDiagonalDua;
    Button buttonHitung, buttonReset;
    TextView tvHasil;
    ImageView ivBangunRuang,ivBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_belah_ketupat);

        ivBack = findViewById(R.id.back);
        edDiagonalSatu = findViewById(R.id.edDiagonalSatu);
        edDiagonalDua = findViewById(R.id.edDiagonalDua);
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

        Glide.with(this).load("https://drive.google.com/uc?export=download&id=1zywFAzEKwJwYbjkfy8Iu6XEuyVegPxTh").into(ivBangunRuang);
        buttonHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edDiagonalSatu.getText().toString().isEmpty() || edDiagonalDua.getText().toString().isEmpty()) {
                    Toast.makeText(BelahKetupat.this, "inputan tidak boleh ada yang kosong.", Toast.LENGTH_SHORT).show();
                }
                else {
                    double diagonalSatu = Double.parseDouble(edDiagonalSatu.getText().toString());
                    double diagonalDua = Double.parseDouble(edDiagonalDua.getText().toString());
                    double hasil = 0.5 * diagonalSatu * diagonalDua;
                    tvHasil.setText(hasil + "");
                }
            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edDiagonalSatu.setText("");
                edDiagonalDua.setText("");
                tvHasil.setText("0");
            }
        });
    }
}