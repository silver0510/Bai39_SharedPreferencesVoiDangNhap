package com.example.sinki.bai39_sharedpreferencesvoidangnhap;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText txtUser,txtPassword;
    Button btnDangNhap,btnThoat;
    CheckBox chkLuuThongTin;

    String luuTenThongTinDangNhap = "login";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {

    }

    private void addControls() {
        txtUser = (EditText) findViewById(R.id.txtUser);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        btnDangNhap = (Button) findViewById(R.id.btnDangNhap);
        btnThoat = (Button) findViewById(R.id.btnThoat);
        chkLuuThongTin = (CheckBox) findViewById(R.id.chkLuuThongTin);


    }

    @Override
    //dùng để lưu trạng thái
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences = getSharedPreferences(luuTenThongTinDangNhap,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("UserName",txtUser.getText().toString());
        editor.putString("Password",txtPassword.getText().toString());
        editor.putBoolean("Save",chkLuuThongTin.isChecked());
        editor.commit();
    }

    @Override
    //dùng để phục hồi trạng thái
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences(luuTenThongTinDangNhap,MODE_PRIVATE);
        String userName = sharedPreferences.getString("UserName","");
        String password = sharedPreferences.getString("Password","");
        boolean save = sharedPreferences.getBoolean("Save",false);
        if(save)
        {
            txtUser.setText(userName);
            txtPassword.setText(password);
            chkLuuThongTin.setChecked(true);
        }

    }
}
