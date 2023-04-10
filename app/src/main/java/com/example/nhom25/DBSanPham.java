package com.example.nhom25;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBSanPham extends SQLiteOpenHelper {

    public DBSanPham(@Nullable Context context) {
        super(context,"dbSanPham",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "create table tbSanPham (maSp text, tenSp text, soLuong text )";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void themDL( SanPham sp){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String sql = "insert into tbSanpham values(?,?,?)";
        sqLiteDatabase.execSQL(sql, new String[]{sp.getMaSp(),sp.getTenSP(), sp.getSoLuong()});
    }
    public ArrayList<SanPham> hienThiDL(){
        ArrayList<SanPham> data = new ArrayList<>();
        String sql = "select * from tbSanPham";
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        if (cursor.moveToFirst()){
            do {
                SanPham sp = new SanPham();
                sp.setMaSp(cursor.getString(0));
                sp.setTenSP(cursor.getString(1));
                sp.setSoLuong(cursor.getString(2));
                Log.d("abc",sp.toString());
                data.add(sp);
            }while (cursor.moveToNext());
        }
        return data;
    }
    public void XoaDL(SanPham sp){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String sql = "Delete from tbSanPham where maSP = ?";
        sqLiteDatabase.execSQL(sql, new String[]{sp.getMaSp()});
    }
    public void SuaDL(SanPham sp){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String sql = "Update tbSanPham set tenSP = ?, soLuong = ? where maSP = ?";
        sqLiteDatabase.execSQL(sql, new String[]{sp.getTenSP(),sp.getSoLuong(),sp.getMaSp()});
    }
}
