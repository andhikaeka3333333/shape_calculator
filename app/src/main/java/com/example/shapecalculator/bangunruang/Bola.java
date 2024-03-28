package com.example.shapecalculator.bangunruang;

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

public class Bola extends AppCompatActivity {

    EditText edJari;
    Button buttonHitung, buttonReset;
    TextView tvHasil;
    ImageView ivBangunRuang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bola);

        edJari = findViewById(R.id.edJari);
        buttonHitung = findViewById(R.id.buttonHitung);
        buttonReset = findViewById(R.id.buttonReset);
        tvHasil = findViewById(R.id.tvHasil);
        ivBangunRuang = findViewById(R.id.ivLogo);

        Glide.with(this).load("https://drive.google.com/uc?export=download&id=1GvJNTZC8sYJj8mkq8skQPNTdhQ_RiNkh").into(ivBangunRuang);
        buttonHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edJari.getText().toString().isEmpty()) {
                    Toast.makeText(Bola.this, "Jari-Jari tidak boleh kosong.", Toast.LENGTH_SHORT).show();
                }
                else {
                    double jari = Double.parseDouble(edJari.getText().toString());
                    double hasil = 4 * 3.14 * jari * jari;
                    tvHasil.setText(hasil + "");
                }
            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edJari.setText("");
                tvHasil.setText("0");
            }
        });
    }
}