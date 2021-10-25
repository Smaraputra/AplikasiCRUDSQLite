package id.smaraputra.tugassqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import id.smaraputra.tugassqlite.model.MahasiswaModel;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "mahasiswadb";
    private static final int DB_VERSION = 1;

    private static final String NAMA_TABEL = "mahasiswa";
    private static final String KOLOM_ID = "id_mahasiswa";
    private static final String KOLOM_NAMA = "nama_mahasiswa";
    private static final String KOLOM_NIM = "nim_mahasiswa";

    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + NAMA_TABEL + " ("
                + KOLOM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KOLOM_NAMA + " TEXT, "
                + KOLOM_NIM + " TEXT);";
        db.execSQL(query);
    }

    public ArrayList<MahasiswaModel> listMahasiswa(){
        String sql = " select * from " + NAMA_TABEL + ";";
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<MahasiswaModel> storeListMahasiswa = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, null);
        if(cursor.moveToFirst()){
            do{
                int id = Integer.parseInt(cursor.getString(0));
                String namein = cursor.getString(1);
                String nimin = cursor.getString(2);
                storeListMahasiswa.add(new MahasiswaModel(id, namein, nimin));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return storeListMahasiswa;
    }

    public ArrayList<MahasiswaModel> listMahasiswaOne(int idin){
        String sql = " select * from " + NAMA_TABEL + " where id_mahasiswa = " + idin + ";";
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<MahasiswaModel> storeListMahasiswaOne = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, null);
        if(cursor.moveToFirst()){
            do{
                int id = Integer.parseInt(cursor.getString(0));
                String namein = cursor.getString(1);
                String nimin = cursor.getString(2);
                storeListMahasiswaOne.add(new MahasiswaModel(id, namein, nimin));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return storeListMahasiswaOne;
    }

    public void tambahMahasiswa(String nama, String nim) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KOLOM_NAMA, nama);
        values.put(KOLOM_NIM, nim);

        db.insert(NAMA_TABEL, null, values);
    }

    public void deleteMahasiswa(int idin) {
        String idstr = String.valueOf(idin);
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(NAMA_TABEL, "id_mahasiswa=?", new String[]{idstr});
        db.close();
    }

    public void updateMahasiswa(int idin, String nama, String nim) {
        String idstr = String.valueOf(idin);
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KOLOM_NAMA, nama);
        values.put(KOLOM_NIM, nim);

        db.update(NAMA_TABEL, values, "id_mahasiswa=?", new String[]{idstr});
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + NAMA_TABEL);
            onCreate(db);
        }
    }
}