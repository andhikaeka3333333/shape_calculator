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
import com.example.shapecalculator.bangundatar.BelahKetupat;
import com.example.shapecalculator.bangundatar.Trapesium;

public class Balok extends AppCompatActivity {

    EditText edTinggi, edPanjang, edLebar;
    Button buttonHitung, buttonReset;
    TextView tvHasil;
    ImageView ivBangunRuang, ivBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balok);

        ivBack = findViewById(R.id.back);
        edPanjang = findViewById(R.id.edPanjang);
        edLebar = findViewById(R.id.edLebar);
        edTinggi = findViewById(R.id.edTinggi);
        buttonHitung = findViewById(R.id.buttonHitung);
        buttonReset = findViewById(R.id.buttonReset);
        tvHasil = findViewById(R.id.tvHasil);
        ivBangunRuang = findViewById(R.id.ivLogo);

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Balok.this, MainActivity.class);
                intent.putExtra("backToFragmentRuang", true);
                startActivity(intent);
            }
        });

        Glide.with(this).load("https://drive.google.com/uc?export=download&id=1oWhQWxM9Gbn5LmzDqF5j40y20lwdVAl9").into(ivBangunRuang);
        buttonHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edPanjang.getText().toString().isEmpty() || edLebar.getText().toString().isEmpty() || edTinggi.getText().toString().isEmpty()) {
                    Toast.makeText(Balok.this, "inputan tidak boleh ada yang kosong.", Toast.LENGTH_SHORT).show();
                }
                else {
                    double panjang = Double.parseDouble(edPanjang.getText().toString());
                    double lebar = Double.parseDouble(edLebar.getText().toString());
                    double tinggi = Double.parseDouble(edTinggi.getText().toString());
                    double hasil = 2 * ((panjang*lebar)+(lebar*tinggi)+(panjang*tinggi));
                    tvHasil.setText(hasil + "");
                }
            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edPanjang.setText("");
                edLebar.setText("");
                edTinggi.setText("");
                tvHasil.setText("0");
            }
        });
    }
}