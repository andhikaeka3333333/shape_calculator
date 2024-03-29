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
import com.example.shapecalculator.adapter.AdapterBangunRuang;
import com.example.shapecalculator.bangunruang.Balok;
import com.example.shapecalculator.bangunruang.Bola;
import com.example.shapecalculator.bangunruang.Kerucut;
import com.example.shapecalculator.bangunruang.Kubus;
import com.example.shapecalculator.bangunruang.Tabung;

import java.util.ArrayList;
import java.util.List;

public class FragmentBangunRuang extends Fragment implements AdapterBangunRuang.ItemClickListener{

    List<ModelBangun> items;
    RecyclerView recyclerView;
    AdapterBangunRuang adapter;

    public FragmentBangunRuang() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_bangun_ruang, container, false);
        View view = inflater.inflate(R.layout.fragment_bangun_ruang, container, false);

        items = new ArrayList<ModelBangun>();

        // Add items to the list
        items.add(new ModelBangun("Kubus",  "https://drive.google.com/uc?export=download&id=10Ddz_4-ioTbq_Tcr5g_mofxa8LCZtreO", "6 x s²"));
        items.add(new ModelBangun("Kerucut",  "https://cdn.pixabay.com/photo/2013/07/12/14/13/cone-148003_1280.png", "πr (r+s)"));
        items.add(new ModelBangun("Tabung",  "https://upload.wikimedia.org/wikipedia/commons/thumb/8/81/Zylinder-1-tab.svg/232px-Zylinder-1-tab.svg.png", "2πr (r+t)"));
        items.add(new ModelBangun("Bola",  "https://drive.google.com/uc?export=download&id=1GvJNTZC8sYJj8mkq8skQPNTdhQ_RiNkh", "4πr²"));
        items.add(new ModelBangun("Balok",  "https://drive.google.com/uc?export=download&id=1oWhQWxM9Gbn5LmzDqF5j40y20lwdVAl9", "2 × (pl + lt + pt)"));


        // Find the RecyclerView in the fragment's layout
        recyclerView = view.findViewById(R.id.rvBangunRuang);

        // Set up the RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new AdapterBangunRuang(items, requireContext());
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onItemClick(View view, int position) {

        Intent intent;

        switch (adapter.getItem(position).getNamaBangun()) {
            case "Kubus":
                intent = new Intent(getActivity(), Kubus.class);
                startActivity(intent);
                break;
            case "Kerucut":
                intent = new Intent(getActivity(), Kerucut.class);
                startActivity(intent);
                break;
            case "Tabung":
                intent = new Intent(getActivity(), Tabung.class);
                startActivity(intent);
                break;
            case "Bola":
                intent = new Intent(getActivity(), Bola.class);
                startActivity(intent);
                break;
            case "Balok":
                intent = new Intent(getActivity(), Balok.class);
                startActivity(intent);
        }

        Toast.makeText(getActivity(), "You clicked " + adapter.getItem(position).getNamaBangun() + " on row number " + position, Toast.LENGTH_SHORT).show();

    }
}