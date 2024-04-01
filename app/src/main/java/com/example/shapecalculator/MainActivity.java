package com.example.shapecalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.shapecalculator.fragment.FragmentBangunDatar;
import com.example.shapecalculator.fragment.FragmentBangunRuang;
import com.example.shapecalculator.fragment.FragmentProfile;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new FragmentBangunRuang())
                .commit();

    }

    private BottomNavigationView.OnItemSelectedListener navListener =
            new BottomNavigationView.OnItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    if (item.getItemId() == R.id.bangunruang) {
                        selectedFragment = new FragmentBangunRuang();
                    } else if (item.getItemId() == R.id.bangundatar) {
                        selectedFragment = new FragmentBangunDatar();
                    } else if (item.getItemId() == R.id.profile) {
                        selectedFragment = new FragmentProfile();
                    }

                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, selectedFragment)
                            .commit();

                    return true;
                }
            };
}