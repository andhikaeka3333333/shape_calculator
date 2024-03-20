package com.example.shapecalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class KalkulatorBangunRuang extends AppCompatActivity {

    private TextView textViewBangun;
    private Button buttonHitung;
    private LinearLayout layoutInputs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulator_bangun_ruang);

        //textViewBangun = findViewById(R.id.textViewBangun);
        layoutInputs = findViewById(R.id.layoutInputs);
        buttonHitung = findViewById(R.id.buttonHitung);

        Intent intent = getIntent();
        String namaBangun = intent.getStringExtra("nama");
        //textViewBangun.setText("Calculator for " + namaBangun);

        if (namaBangun.equals("Kubus")) {
            addInputField("Sisi");
        } else if (namaBangun.equals("Kerucut")) {
            addInputField("Jari-jari");
            addInputField("Tinggi");
        } else if (namaBangun.equals("Tabung")) {
            addInputField("Jari-jari");
            addInputField("Tinggi");
        } else if (namaBangun.equals("Bola")) {
            addInputField("Jari-jari");
        }

        buttonHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungLuas(namaBangun);
            }
        });


    }

    private void addInputField(String label) {
        EditText editText = new EditText(this);
        editText.setHint(label);
        editText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        Drawable backgroundDrawable = ContextCompat.getDrawable(this, R.drawable.edittext_background);
        editText.setBackground(backgroundDrawable);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(8, 10, 8, 16);

        editText.setLayoutParams(layoutParams);
        layoutInputs.addView(editText);
    }

    private void hitungLuas(String namaBangun) {
        double luas = 0;
        int count = layoutInputs.getChildCount();
        List<Double> inputs = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            View view = layoutInputs.getChildAt(i);
            if (view instanceof EditText) {
                EditText editText = (EditText) view;
                double value = Double.parseDouble(editText.getText().toString());
                inputs.add(value);
            }
        }

        switch (namaBangun) {
            case "Kubus":
                double sisi = inputs.get(0);
                luas = 6 * sisi * sisi;
                break;
            case "Kerucut":
                double jariJari = inputs.get(0);
                double tinggi = inputs.get(1);
                luas = Math.PI * jariJari * (jariJari + Math.sqrt(tinggi * tinggi + jariJari * jariJari));
                break;
            case "Tabung":
                jariJari = inputs.get(0);
                tinggi = inputs.get(1);
                luas = 2 * Math.PI * jariJari * (jariJari + tinggi);
                break;
            case "Bola":
                jariJari = inputs.get(0);
                luas = 4 * Math.PI * jariJari * jariJari;
                break;
        }

        Toast.makeText(this, "Luas " + namaBangun + " adalah " + luas, Toast.LENGTH_SHORT).show();
    }
}