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
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_bangun_datar, container, false);

        View view = inflater.inflate(R.layout.fragment_bangun_datar, container, false);

        items = new ArrayList<ModelBangun>();

        // Add items to the list
        items.add(new ModelBangun("Persegi",  "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f7/Regular_quadrilateral.svg/250px-Regular_quadrilateral.svg.png"));
        items.add(new ModelBangun("Segitiga",  "https://upload.wikimedia.org/wikipedia/commons/3/35/Enneagram_triangle.png"));
        items.add(new ModelBangun("Lingkaran",  "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a0/Circle_-_black_simple.svg/800px-Circle_-_black_simple.svg.png"));
        items.add(new ModelBangun("Trapesium",  "https://drive.google.com/uc?export=download&id=1MCgUQ1iTKA8h3-Cf65983sO5Ovp_0AsO"));


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
//        Intent intent = new Intent(getActivity(), PreviewProduct.class);
//        intent.putExtra("nama", adapter.getItem(position).getNamaMakanan());
//        startActivity(intent);
        Toast.makeText(getActivity(), "You clicked " + adapter.getItem(position).getNamaBangun() + " on row number " + position, Toast.LENGTH_SHORT).show();
    }
}