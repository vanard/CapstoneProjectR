package com.example.android.capstoneprojectr.item;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.android.capstoneprojectr.R;

/**
 * Created by Ridho Prihambodo on 3/10/2017.
 */

public class SetViewHolder extends RecyclerView.ViewHolder {

    public TextView txt_idPensiun;
    public TextView txt_nip;
    public TextView txt_tanggal;
    public TextView txt_attachment;
    public TextView txt_keterangan;
    public TextView txt_status;

    public SetViewHolder(View itemView) {
        super(itemView);

        txt_idPensiun = (TextView) itemView.findViewById(R.id.txt_id);
        txt_nip = (TextView) itemView.findViewById(R.id.txt_nip);
        txt_tanggal = (TextView) itemView.findViewById(R.id.txt_tanggal);
        txt_attachment = (TextView) itemView.findViewById(R.id.txt_attachment);
        txt_keterangan = (TextView) itemView.findViewById(R.id.txt_keterangan);
        txt_status = (TextView) itemView.findViewById(R.id.txt_status);

    }
}
