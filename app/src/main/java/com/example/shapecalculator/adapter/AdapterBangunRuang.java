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

public class AdapterBangunRuang extends RecyclerView.Adapter<AdapterBangunRuang.ViewHolder> {
    private Context context;
    private List<ModelBangun> listData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    public AdapterBangunRuang(List<ModelBangun> listData, Context context){
        this.listData = listData;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public AdapterBangunRuang.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_view_bangunruang, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterBangunRuang.ViewHolder holder, int position) {
        ModelBangun items = this.listData.get(position);

        holder.tvNamaBangunRuang.setText(items.getNamaBangun());
        holder.tvRumusBangunRuang.setText(items.getRumusBangun());

        Glide.with(holder.itemView.getContext())
                .load(items.getGambarBangun())
                .into(holder.ivImageBangunRuang);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView tvNamaBangunRuang, tvRumusBangunRuang;
        ImageView ivImageBangunRuang;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamaBangunRuang = itemView.findViewById(R.id.tvNamaBangunRuang);
            tvRumusBangunRuang = itemView.findViewById(R.id.tvRumusBangunRuang);
            ivImageBangunRuang = itemView.findViewById(R.id.ivImageBangunRuang);
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


