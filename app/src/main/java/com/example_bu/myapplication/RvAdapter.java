package com.example_bu.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.MyViewHolder> {

    private final RvInterface rvinterface;
    int[] arr;
    String[] stra;
    public RvAdapter(RvInterface rvinterface, int[] arr, String[] stra) {
        this.rvinterface = rvinterface;
        this.arr=arr;
        this.stra=stra;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview1,parent,false);
        MyViewHolder my=new MyViewHolder(view,rvinterface);
        return my;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.im.setImageResource(arr[position]);
            holder.tx.setText(stra[position]);
    }

    @Override
    public int getItemCount() {
        return arr.length;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView im;
        TextView tx;

        public MyViewHolder(@NonNull View itemView,RvInterface rvinterface) {
            super(itemView);
            im=itemView.findViewById(R.id.card_image);
            tx=itemView.findViewById(R.id.card_text);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(rvinterface!=null){
                        int pos=getAdapterPosition();
                        if(pos!=RecyclerView.NO_POSITION){
                            rvinterface.ItemClicked(pos);
                        }
                    }
                }
            });

        }
    }
}
