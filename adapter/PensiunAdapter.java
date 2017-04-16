package com.example.android.capstoneprojectr.adapter;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.capstoneprojectr.OnTapListener;
import com.example.android.capstoneprojectr.R;
import com.example.android.capstoneprojectr.item.Item;
import com.example.android.capstoneprojectr.item.SetViewHolder;

import java.util.Collections;
import java.util.List;

/**
 * Created by Ridho Prihambodo on 3/10/2017.
 */

public class PensiunAdapter extends RecyclerView.Adapter<SetViewHolder> {

    private Activity activity;
    List<Item> items = Collections.emptyList();
    private OnTapListener onTapListener;

    public PensiunAdapter(Activity activity, List<Item> items){
        this.activity=activity;
        this.items=items;
    }
    @Override
    public SetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item_list,parent,false);
        return new SetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SetViewHolder holder, final int position) {
        holder.txt_idPensiun.setText(items.get(position).getIdPensiun());
        holder.txt_nip.setText(items.get(position).getNip());
        holder.txt_tanggal.setText(items.get(position).getTanggal());
        holder.txt_attachment.setText(items.get(position).getAttachment());
        holder.txt_keterangan.setText(items.get(position).getKeterangan());
        holder.txt_status.setText(items.get(position).getStatus());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onTapListener !=null){
                    onTapListener.OnTapView(position);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setOnTapListener(OnTapListener onTapListener){
        this.onTapListener=onTapListener;
    }
}
