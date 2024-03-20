package com.example.shapecalculator.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.shapecalculator.ModelBangun;
import com.example.shapecalculator.R;

import java.util.List;

public class AdapterBangunDatar extends RecyclerView.Adapter<AdapterBangunDatar.ViewHolder> {
    private Context context;
    private List<ModelBangun> listData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    public AdapterBangunDatar(List<ModelBangun> listData, Context context){
        this.listData = listData;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public AdapterBangunDatar.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_view_bangundatar, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterBangunDatar.ViewHolder holder, int position) {
        ModelBangun items = this.listData.get(position);

        holder.tvNamaBangunDatar.setText(items.getNamaBangun());

        Glide.with(holder.itemView.getContext())
                .load(items.getGambarBangun())
                .into(holder.ivImageBangunDatar);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView tvNamaBangunDatar;
        ImageView ivImageBangunDatar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamaBangunDatar = itemView.findViewById(R.id.tvNamaBangunDatar);
            ivImageBangunDatar = itemView.findViewById(R.id.ivImageBangunDatar);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    public ModelBangun getItem(int id) {
        return listData.get(id);
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}


