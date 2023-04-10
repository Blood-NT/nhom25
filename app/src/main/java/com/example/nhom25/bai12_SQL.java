package com.example.nhom25;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class bai12_SQL extends AppCompatActivity {
    EditText edtMaSp, edtTenSP, edtSL;
    Button btnThem, btnXoa, btnSua, btnHT;
    ListView tvDS;
    ArrayList<SanPham> data_sp = new ArrayList<>();
    ArrayAdapter adapter_sp;
    DBSanPham dbSanPham;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai12_sql);
        setControl();
        setEvent();
    }

    private void setEvent() {
        data_sp.add(new SanPham("1","2","3"));
        dbSanPham = new DBSanPham(this);
        adapter_sp = new ArrayAdapter(this, android.R.layout.simple_list_item_1,data_sp);
        tvDS.setAdapter(adapter_sp);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                themDL();
            }
        });
        btnHT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HienThiDL();
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XoaDL();
            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SuaDL();
            }
        });
    }

    private void SuaDL() {
        SanPham sp = new SanPham();
        sp.setMaSp(edtMaSp.getText().toString());
        sp.setTenSP(edtTenSP.getText().toString());
        sp.setSoLuong(edtSL.getText().toString());
        dbSanPham.SuaDL(sp);
        HienThiDL();
    }

    private void XoaDL() {
        SanPham sp = new SanPham();
        sp.setMaSp(edtMaSp.getText().toString());
        dbSanPham.XoaDL(sp);
        HienThiDL();
    }

    private void HienThiDL() {
        data_sp.clear();
        data_sp.addAll(dbSanPham.hienThiDL());
        adapter_sp.notifyDataSetChanged();
    }

    private void themDL() {
        SanPham sp = new SanPham();
        sp.setMaSp(edtMaSp.getText().toString());
        sp.setTenSP(edtTenSP.getText().toString());
        sp.setSoLuong(edtSL.getText().toString());
        dbSanPham.themDL(sp);
    }
    private void setControl() {
        edtMaSp = findViewById(R.id.edtMaSP);
        edtTenSP = findViewById(R.id.edtTenSP);
        edtSL = findViewById(R.id.edtSL);
        btnThem = findViewById(R.id.btnThem);
        btnSua = findViewById(R.id.btnSua);
        btnXoa = findViewById(R.id.btnXoa);
        tvDS = findViewById(R.id.tvDS);
        btnHT = findViewById(R.id.btnHT);


    }

}
