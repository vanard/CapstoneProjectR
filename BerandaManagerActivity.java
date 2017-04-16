package com.example.android.capstoneprojectr;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.android.capstoneprojectr.FragmentActivity.PensiunFragment;

public class BerandaManagerActivity extends AppCompatActivity {

    Button btnPHK, btnPengajuanPensiun, btnLaporan, btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda_manager);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        showLaporanKaryawan();
        showPengajuanPensiun();
        showPHK();
        GoOut();
    }

    public void showPHK(){
        btnPHK = (Button) findViewById(R.id.phk_button);
        btnPHK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showPHKActivity = new Intent(BerandaManagerActivity.this, PHKActivity.class);
                startActivity(showPHKActivity);
            }
        });
    }

    public void showPengajuanPensiun(){
        btnPengajuanPensiun = (Button) findViewById(R.id.btn_pengajuan_pensiun);
        btnPengajuanPensiun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showPengajuanPensiunActivity = new Intent(BerandaManagerActivity.this, PengajuanPensiunActivity.class);
                startActivity(showPengajuanPensiunActivity);
            }
        });
    }

    public void showLaporanKaryawan(){
        btnLaporan = (Button) findViewById(R.id.btn_laporan);
        btnLaporan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showLaporanKaryawanActivity = new Intent(BerandaManagerActivity.this, LaporanKaryawanActivity.class);
                startActivity(showLaporanKaryawanActivity);
            }
        });
    }

    public void GoOut(){
        btnLogout = (Button) findViewById(R.id.btn_logout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(BerandaManagerActivity.this);
                builder.setTitle(R.string.quit_dialog_confirm_title);
                builder.setMessage(R.string.quit_dialog_confirm_msg);
                builder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface arg0, int arg1){
                        System.exit(0);
                        //Intent intent = new Intent(Intent.ACTION_MAIN);
                        //intent.addCategory(Intent.CATEGORY_HOME);
                        //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        //startActivity(intent);
                    }
                });
                builder.setNegativeButton(android.R.string.no, null);
                builder.show();
            }
        });
    }
}
