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

public class Kerucut extends AppCompatActivity {

    EditText edJari, edSelimut;
    Button buttonHitung, buttonReset;
    TextView tvHasil;
    ImageView ivBangunRuang,ivBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kerucut);

        ivBack = findViewById(R.id.back);
        edJari = findViewById(R.id.edJari);
        edSelimut = findViewById(R.id.edSelimut);
        buttonHitung = findViewById(R.id.buttonHitung);
        buttonReset = findViewById(R.id.buttonReset);
        tvHasil = findViewById(R.id.tvHasil);
        ivBangunRuang = findViewById(R.id.ivLogo);

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kerucut.this, MainActivity.class);
                intent.putExtra("backToFragmentRuang", true);
                startActivity(intent);
            }
        });

        Glide.with(this).load("https://cdn.pixabay.com/photo/2013/07/12/14/13/cone-148003_1280.png").into(ivBangunRuang);
        buttonHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edJari.getText().toString().isEmpty() || edSelimut.getText().toString().isEmpty()) {
                    Toast.makeText(Kerucut.this, "inputan tidak boleh ada yang kosong.", Toast.LENGTH_SHORT).show();
                }
                else {
                    double jari = Double.parseDouble(edJari.getText().toString());
                    double selimut = Double.parseDouble(edSelimut.getText().toString());
                    double hasil = 3.14 * jari * (jari+selimut);
                    tvHasil.setText(hasil + "");
                }
            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edJari.setText("");
                edSelimut.setText("");
                tvHasil.setText("0");
            }
        });
    }
}