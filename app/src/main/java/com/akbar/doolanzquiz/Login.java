package com.akbar.doolanzquiz;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    String username, password;
    TextView txtRegis;
    Button btLogin;
    EditText edUsername, edPass;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btLogin = (Button) findViewById(R.id.btnLogin);
        edUsername = (EditText) findViewById(R.id.editUserLog);
        edPass = (EditText) findViewById(R.id.editPassLog);
        txtRegis = (TextView) findViewById(R.id.txRegis);

        txtRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in = new Intent(Login.this, MainActivity.class);
                startActivity(in);
            }
        });

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = edUsername.getText().toString();
                password = edPass.getText().toString();

                if (edUsername.getText().toString().length() == 0) {
                    edPass.setError("Username harus diisi!");

                } else if (edUsername.getText().toString().length() == 0) {
                    edPass.setError("Password harus diisi!");
                } else if (!username.isEmpty() && !password.isEmpty()) {
                    if (!username.equals("admin") || !password.equals("378")) {
//                        Toast.makeText(getApplicationContext(),
//                                "Username/Password Salah!!",
//                                Toast.LENGTH_SHORT).show();
                        Intent in = new Intent(Login.this, Menu_UI.class);
                        startActivity(in);
                    } else if (!username.equals("user") || !password.equals("123")) {
                        Toast.makeText(getApplicationContext(),
                                "Login Sukses Lurr",
                                Toast.LENGTH_SHORT).show();
                        Intent in = new Intent(Login.this, MenuAdmin.class);
                        startActivity(in);
                    }

            }
        }
    });
    }
}
/Menu login username yang harus diisi masuk ke menu permainan quiz/