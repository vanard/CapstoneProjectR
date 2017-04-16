package com.example.android.capstoneprojectr;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.os.Environment;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Ridho Prihambodo on 2/23/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String TAG = DatabaseHelper.class.getSimpleName();
    public static final String DATABASE_NAME = "Karyawan.db";
    public static final String TABLE_NAME = "pensiun";
    public static final String COL_idPensiun = "idPensiun";
    public static final String COL_nip = "nip";
    public static final String COL_tanggal = "tanggal";
    public static final String COL_attachment = "attachment";
    public static final String COL_keterangan = "keterangan";
    public static final String COL_status = "status";
    private SQLiteDatabase myDatabase;
    private static String DB_PATH = "";
    private final Context myContext;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        if(Build.VERSION.SDK_INT>=15){
            DB_PATH = context.getApplicationInfo().dataDir+"/database/";
        }else{
            DB_PATH = Environment.getDataDirectory() + "/data/" + context.getPackageName() + "/database/";
        }
        this.myContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE pensiun ("
                + COL_idPensiun+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_nip + " TEXT, "
                + COL_tanggal + " TEXT, "
                + COL_attachment + " TEXT,"
                + COL_keterangan + " TEXT,"
                + COL_status + " TEXT); ");
        /*
        db.execSQL("CREATE TABLE karyawan ("
                + "nip INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "nama TEXT, "
                + "tempatlahir TEXT, "
                + "tanggallahir TEXT,"
                + "jk TEXT,"
                + "alamat TEXT,"
                + "tahunmasuk TEXT,"
                + "id_jabatan TEXT,"
                + "id_divisi TEXT;");

        db.execSQL("CREATE TABLE jabatan ("
                + "id_jabatan INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "jabatan TEXT;");

        db.execSQL("CREATE TABLE divisi ("
                + "id_divisi INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "divisi TEXT;");

        db.execSQL("CREATE TABLE login ("
                + "id_login INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "nip TEXT, "
                + "username TEXT, "
                + "password TEXT,"
                + "status TEXT;");
                */

        //insertPensiun(db, "1202144045", "27-02-2017", "-", "Pensiun", "Waiting");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addUser( String nip, String tanggal, String attachment, String keterangan, String status) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        //values.put(COL_idPensiun, idPensiun);
        values.put(COL_nip, nip);
        values.put(COL_tanggal, tanggal);
        values.put(COL_attachment, attachment);
        values.put(COL_keterangan, keterangan);
        values.put(COL_status, status);

        long id = db.insert(TABLE_NAME, null, values);
        db.close();

        Log.d(TAG, "user inserted" + id);
    }

    public void checkAndCoptDatabase(){
        boolean dbExist = checkDatabase();
        if(dbExist){
            Log.d("TAG", "DATABASE ALREADY EXIST");
        }else{
            this.getReadableDatabase();
        }
        try{
            copyDatabase();
        }catch(IOException e){
            e.printStackTrace();
            Log.d("TAG","ERROR COPY DATABASE");
        }

    }

    public boolean checkDatabase(){
        SQLiteDatabase checkDB=null;
        try{
            String myPath=DB_PATH+DATABASE_NAME;
            checkDB=SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
        }catch(SQLiteException e){
            e.printStackTrace();
        }

        if(checkDB!=null){
            checkDB.close();
        }
        return checkDB != null?true:false;
    }

    public void copyDatabase() throws IOException{
        InputStream myInput = myContext.getAssets().open(DATABASE_NAME);
        String outFileName = DB_PATH+DATABASE_NAME;
        OutputStream myOutput = new FileOutputStream(outFileName);
        byte[] buffer = new byte[1024];
        int length;
        while((length = myInput.read(buffer))>0){
            myOutput.write(buffer, 0, length);
        }
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }
    public void openDatabase(){
        String myPath = DB_PATH+DATABASE_NAME;
        myDatabase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);

    }
    public synchronized void close(){
        if(myDatabase!=null){
            myDatabase.close();
        }
        super.close();
    }
    public Cursor QueryData(String query){
        return myDatabase.rawQuery(query,null);
    }

    /*
    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_NAME, null);
        return res;
    }*/
}
