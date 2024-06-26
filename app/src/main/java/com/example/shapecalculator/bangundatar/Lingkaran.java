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
import com.example.shapecalculator.bangunruang.Bola;

 public class Lingkaran extends AppCompatActivity {

     EditText edJari;
     Button buttonHitung, buttonReset;
     TextView tvHasil;
     ImageView ivBangunRuang,ivBack;
     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_lingkaran);

         ivBack = findViewById(R.id.back);
         edJari = findViewById(R.id.edJari);
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

         Glide.with(this).load("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a0/Circle_-_black_simple.svg/800px-Circle_-_black_simple.svg.png").into(ivBangunRuang);
         buttonHitung.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if (edJari.getText().toString().isEmpty()) {
                     Toast.makeText(Lingkaran.this, "Jari-Jari tidak boleh kosong.", Toast.LENGTH_SHORT).show();
                 }
                 else {
                     double jari = Double.parseDouble(edJari.getText().toString());
                     double hasil = Math.PI * jari * jari;
                     String hasilString = String.format("%.2f", hasil);
                     tvHasil.setText(hasilString);
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