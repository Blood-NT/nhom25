package com.example.nhom25;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Calendar;

public class bai7 extends AppCompatActivity {

    EditText edt_hvt, edt_sdt, edt_tinh, edt_ngay, edt_gio;
    Spinner spn_phuongtien;
    Button btn_dky, btn_out;
    String[] tmpspiner = {"máy bay", "ô tô", "xe máy"};
    String pickitem = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai7);

        setup();
        run();
    }


    private void setup() {
        edt_hvt = findViewById(R.id.edt_hvt);
        edt_sdt = findViewById(R.id.edt_sdt);
        edt_tinh = findViewById(R.id.edt_tinh);
        edt_ngay = findViewById(R.id.edt_ngay);
        edt_gio = findViewById(R.id.edt_gio);

        spn_phuongtien = findViewById(R.id.spn_phuongtien);


        btn_dky = findViewById(R.id.btn_dky);
        btn_out = findViewById(R.id.btn_out);

    }

    private void run() {

        ArrayAdapter<String> adapterTmp = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tmpspiner);
        adapterTmp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_phuongtien.setAdapter(adapterTmp);

        spn_phuongtien.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                pickitem = adapterView.getItemAtPosition(i).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        edt_gio.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();

                TimePickerDialog timePickerDialog = new TimePickerDialog(bai7.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        // Xử lý khi người dùng chọn thời gian mới
                        edt_gio.setText(hourOfDay+":"+minute);
                    }
                },
                        calendar.get(Calendar.HOUR_OF_DAY),
                        calendar.get(Calendar.MINUTE),
                        true
                );
                timePickerDialog.show();
            }
            });


        edt_tinh.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {


// Tạo AlertDialog
                AlertDialog.Builder builder = new AlertDialog.Builder(bai7.this);
                builder.setTitle("Chọn tỉnh thành");
// Thêm danh sách tỉnh thành vào AlertDialog
                final String[] provinces = {"Hà Nội", "TP Hồ Chí Minh", "Đà Nẵng", "Hải Phòng", "Nha Trang"};
                builder.setItems(provinces, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
// Xử lý khi người dùng chọn tỉnh thành
                        edt_tinh.setText(provinces[i].toString());
                    }
                });
// Hiển thị AlertDialog
                builder.show();
            }

        });
        edt_ngay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
// Tạo DatePickerDialog
                DatePickerDialog datePickerDialog = new DatePickerDialog(bai7.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
// Xử lý khi người dùng chọn ngày
                        edt_ngay.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                }, Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
// Hiển thị DatePickerDialog
                datePickerDialog.show();
            }
        });

        btn_dky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(bai7.this);
                builder.setTitle("Thông tin");
                builder.setMessage("Họ và tên: "+ edt_hvt.getText() + "\nĐiện thoại: "+ edt_sdt.getText()+"\nTĩnh:"+edt_tinh.getText()+"\nNgày: "+edt_ngay.getText()+"\nGiờ: "+edt_gio.getText()+"Phương tiện: "+pickitem);
                builder.setCancelable(true);

                builder.setPositiveButton(
                        "Đăng ký",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                }
                        });

                builder.setNegativeButton(
                        "Hủy",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert = builder.create();
                alert.show();
            }
        });
        btn_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(bai7.this);
                builder.setTitle("Thoát ứng dụng");
                builder.setMessage("Bạn muốn thoát ứng dụng?");
                builder.setCancelable(true);

                builder.setPositiveButton(
                        "Có",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                            }
                        });

                builder.setNegativeButton(
                        "Không",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }


}

