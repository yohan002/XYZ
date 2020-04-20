package com.example.xyz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<DataProduct> listproduct;
    private Context context;

    TextView tv_nama,tv_description,tv_quantity;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DataProduct dataProduct = Interface.datainterface.dataProducts.get(position);
        holder.name.setText(dataProduct.getProduct_name());
        holder.quantity.setText(dataProduct.getProduct_quantity());
        holder.description.setText(dataProduct.getProduct_description());
    }


    @Override
    public int getItemCount() {
        return Interface.datainterface.dataProducts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,description,quantity;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_nama);
            description = itemView.findViewById(R.id.tv_description);
            quantity = itemView.findViewById(R.id.tv_quantity);
        }
    }
}
