package com.example.android.capstoneprojectr.FragmentActivity;

import android.app.Fragment;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.android.capstoneprojectr.DatabaseHelper;
import com.example.android.capstoneprojectr.OnTapListener;
import com.example.android.capstoneprojectr.R;
import com.example.android.capstoneprojectr.adapter.PensiunAdapter;
import com.example.android.capstoneprojectr.item.Item;

import java.util.ArrayList;


/**
 * Created by Ridho Prihambodo on 3/10/2017.
 */

public class PensiunFragment extends Fragment {
    private RecyclerView recyclerView;
    private DatabaseHelper databaseHelper;
    private ArrayList<Item> arrayList= new ArrayList<Item>();
    private Cursor cursor;
    private PensiunAdapter adapter;
    private Item item;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.activity_pensiun_approval, container, false);
        recyclerView = (RecyclerView) viewGroup.findViewById(R.id.recycler_view);
        loadDatabase();
        return viewGroup;
    }

    public void loadDatabase(){
        databaseHelper = new DatabaseHelper(getActivity());
        try {
            databaseHelper.checkDatabase();
            databaseHelper.openDatabase();
        }catch(SQLiteException e){
            e.printStackTrace();
        }
        try{
        cursor = databaseHelper.QueryData("select * from pensiun");
        if(cursor !=null){
            if(cursor.moveToFirst()){
                do{
                    Item item = new Item();
                    item.setIdPensiun(cursor.getInt(0));
                    item.setNip(cursor.getString(1));
                    item.setTanggal(cursor.getString(2));
                    item.setAttachment(cursor.getString(3));
                    item.setKeterangan(cursor.getString(4));
                    item.setStatus(cursor.getString(5));
                    arrayList.add(item);
                }while(cursor.moveToNext());

            }
        }
        }catch(SQLiteException e){
            e.printStackTrace();
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        adapter = new PensiunAdapter(getActivity(), arrayList);
        adapter.setOnTapListener(new OnTapListener() {
            @Override
            public void OnTapView(int position) {
                Toast.makeText(getContext(), "Click to "+position, Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);


    }
}
