package com.example.shapecalculator.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.shapecalculator.ModelBangun;
import com.example.shapecalculator.R;
import com.example.shapecalculator.adapter.AdapterBangunDatar;
import com.example.shapecalculator.bangundatar.BelahKetupat;
import com.example.shapecalculator.bangundatar.Lingkaran;
import com.example.shapecalculator.bangundatar.Persegi;
import com.example.shapecalculator.bangundatar.Segitiga;
import com.example.shapecalculator.bangundatar.Trapesium;
import com.example.shapecalculator.bangunruang.Bola;
import com.example.shapecalculator.bangunruang.Kerucut;
import com.example.shapecalculator.bangunruang.Kubus;
import com.example.shapecalculator.bangunruang.Tabung;

import java.util.ArrayList;
import java.util.List;

public class FragmentBangunDatar extends Fragment implements AdapterBangunDatar.ItemClickListener{

    List<ModelBangun> items;
    RecyclerView recyclerView;
    AdapterBangunDatar adapter;

    public FragmentBangunDatar() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View view = inflater.inflate(R.layout.fragment_bangun_datar, container, false);

        items = new ArrayList<ModelBangun>();

        // Add items to the list
        items.add(new ModelBangun("Persegi",  "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f7/Regular_quadrilateral.svg/250px-Regular_quadrilateral.svg.png", "s x s"));
        items.add(new ModelBangun("Segitiga",  "https://upload.wikimedia.org/wikipedia/commons/3/35/Enneagram_triangle.png", "½ x a x t"));
        items.add(new ModelBangun("Lingkaran",  "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a0/Circle_-_black_simple.svg/800px-Circle_-_black_simple.svg.png", "πr²"));
        items.add(new ModelBangun("Trapesium",  "https://drive.google.com/uc?export=download&id=1MCgUQ1iTKA8h3-Cf65983sO5Ovp_0AsO", "½ x (a+b) x t"));
        items.add(new ModelBangun("Belah Ketupat","https://drive.google.com/uc?export=download&id=1zywFAzEKwJwYbjkfy8Iu6XEuyVegPxTh", "½ x d1 x d2"));




        // Find the RecyclerView in the fragment's layout
        recyclerView = view.findViewById(R.id.rvBangunDatar);

        // Set up the RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new AdapterBangunDatar(items, requireContext());
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent;

        switch (adapter.getItem(position).getNamaBangun()) {
            case "Persegi":
                intent = new Intent(getActivity(), Persegi.class);
                startActivity(intent);
                break;
            case "Segitiga":
                intent = new Intent(getActivity(), Segitiga.class);
                startActivity(intent);
                break;
            case "Lingkaran":
                intent = new Intent(getActivity(), Lingkaran.class);
                startActivity(intent);
                break;
            case "Trapesium":
                intent = new Intent(getActivity(), Trapesium.class);
                startActivity(intent);
                break;
            case "Belah Ketupat":
                intent = new Intent(getActivity(), BelahKetupat.class);
                startActivity(intent);
                break;
        }
    }
}