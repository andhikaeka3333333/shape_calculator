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

public class Kubus extends AppCompatActivity {

    EditText edSisi;
    Button buttonHitung, buttonReset;
    TextView tvHasil;
    ImageView ivBangunRuang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kubus);

        edSisi = findViewById(R.id.edSisi);
        buttonHitung = findViewById(R.id.buttonHitung);
        buttonReset = findViewById(R.id.buttonReset);
        tvHasil = findViewById(R.id.tvHasil);
        ivBangunRuang = findViewById(R.id.ivLogo);

        Glide.with(this).load("https://drive.google.com/uc?export=download&id=10Ddz_4-ioTbq_Tcr5g_mofxa8LCZtreO").into(ivBangunRuang);
        buttonHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edSisi.getText().toString().isEmpty()) {
                    Toast.makeText(Kubus.this, "Sisi tidak boleh kosong.", Toast.LENGTH_SHORT).show();
                }
                else {
                    double sisi = Double.parseDouble(edSisi.getText().toString());
                    double hasil = 6 * sisi * sisi;
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