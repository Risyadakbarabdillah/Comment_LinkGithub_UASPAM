package com.akbar.doolanzquiz;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//import com.akbar.doolanzquiz.api.PanggilApi;
//import com.akbar.doolanzquiz.model.Value;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private String url = "http://192.168.43.4:8282/androidDoolanz/";
    TextView txtLogin;
    EditText edUser, edPass, edNama;
    Button btRegis;
    String nama, username, password;
    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btRegis = (Button) findViewById(R.id.btnReg);
        edNama = (EditText) findViewById(R.id.editNama);
        edUser = (EditText) findViewById(R.id.editUserReg);
        edPass = (EditText) findViewById(R.id.editPassReg);
        txtLogin = (TextView) findViewById(R.id.txLogin);

        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in = new Intent(MainActivity.this, Login.class);
                startActivity(in);
            }
        });

        btRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //RegistrasiUser();
//                Intent in = new Intent(MainActivity.this, Login.class);
//                startActivity(in);

//    private void RegistrasiUser(){
//        // untuk menampilkan progress dialog
//        progress = new ProgressDialog(this);
//        progress.setCancelable(false);
//        progress.setMessage("Loading...");
//        progress.show();
//
//        username = edUser.getText().toString();
//        password = edPass.getText().toString();
//        nama = edNama.getText().toString();
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(url)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        PanggilApi api = retrofit.create(PanggilApi.class);
//        Call<Value> call = api.daftar(nama,username,password);
//
//        call.enqueue(new Callback<Value>() {
//            @Override
//            public void onResponse(Call<Value> call, Response<Value> response) {
//                String status = response.body().getStatus();
//                String message = response.body().getMessage();
//
//                progress.dismiss();
//                if (status.equals("1")){
//                    Toast.makeText(MainActivity.this, message + ", Sugeng Rawuh "+nama, Toast.LENGTH_LONG).show();
//
////                    startActivity(new Intent(Login.this, Menu_UI.class));
//                }else {
//                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Value> call, Throwable t) {
//                t.printStackTrace();
//                progress.dismiss();
//                Toast.makeText(MainActivity.this, "Aktifkan koneksi Internet!", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
            }
        });
    }
}
/main menu pada activity yang menaktifkan koneksi internet/