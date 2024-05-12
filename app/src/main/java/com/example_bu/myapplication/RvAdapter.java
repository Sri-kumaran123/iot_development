package com.example_bu.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.MyViewHolder> {
    int[] arr;
    public RvAdapter(int[] arr) {
        this.arr=arr;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview1,parent,false);
        MyViewHolder my=new MyViewHolder(view);
        return my;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.im.setImageResource(arr[position]);
            holder.tx.setText("hi");
    }

    @Override
    public int getItemCount() {
        return arr.length-1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView im;
        TextView tx;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            im=itemView.findViewById(R.id.card_image);
            tx=itemView.findViewById(R.id.card_text);

        }
    }
}
