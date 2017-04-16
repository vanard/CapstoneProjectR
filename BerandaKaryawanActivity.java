package com.example.android.capstoneprojectr;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BerandaKaryawanActivity extends AppCompatActivity {

    private Button btnPensiun;
    private Button btnInfo;
    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda_karyawan);

        showInfo();
        showPensiun();
        //GoOut();
    }

    public void showPensiun(){
        btnPensiun = (Button) findViewById(R.id.pensiun_button);
        btnPensiun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showPensiunActivity = new Intent(BerandaKaryawanActivity.this, PengajuanPensiunActivity.class);
                startActivity(showPensiunActivity);
            }
        });
    }

    public void showInfo(){
        btnInfo = (Button) findViewById(R.id.info_button);
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showInfoActivity = new Intent(BerandaKaryawanActivity.this, InfoPersyaratanActivity.class);
                startActivity(showInfoActivity);
            }
        });
    }

    public void GoOut(){
        btnLogout = (Button) findViewById(R.id.btn_logout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(BerandaKaryawanActivity.this);
                builder.setTitle(R.string.quit_dialog_confirm_title);
                builder.setMessage(R.string.quit_dialog_confirm_msg);
                builder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface arg0, int arg1){

                        System.exit(0);
                    }
                });
                builder.setNegativeButton(android.R.string.no, null);
                builder.show();
            }
        });
    }
}
