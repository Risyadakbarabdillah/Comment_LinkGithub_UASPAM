package com.akbar.doolanzquiz;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.cahyonoz.doolanzquiz.model.ModelSoal;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Soal extends AppCompatActivity {

    private EditText editTextSoal, editTextJwb1, editTextJwb2, editTextJwb3;
    private Button btnBatal, btnSave;

    private ModelSoal soal;

    private String action_flag = "add";
    private String refreshFlag = "0";
    private static final String TAG = "Soal";
    private ProgressDialog pDialog;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnSave = (Button) findViewById(R.id.btnSave);
        btnBatal = (Button) findViewById(R.id.btnBatal);
        btnBatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), MenuAdmin.class);
                startActivity(intent);
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveDataVolley();

                Intent intent = new Intent(Soal.this, tampildata.class);
            }
        });

        soal = new ModelSoal();
        initUI();

        Intent intent = getIntent();
        if (intent.hasExtra("soal")) {
            soal = (ModelSoal) intent.getSerializableExtra("soal");
            Log.d(TAG, "Banksoal : " + soal.toString());
            setData(soal);
            action_flag = "edit";
            editTextSoal.setEnabled(false);
        } else {
            soal = new ModelSoal();
        }
    }

    private void setData(ModelSoal mhs) {
        editTextSoal.setText(mhs.getNama_soal());
        editTextJwb1.setText(mhs.getJawaban1());
        editTextJwb2.setText(mhs.getJawaban2());
        editTextJwb3.setText(mhs.getJawaban3());
    }

    private void initUI() {
        pDialog = new ProgressDialog(Soal.this);

        editTextSoal = (EditText) findViewById(R.id.editSoal);
        editTextJwb1 = (EditText) findViewById(R.id.editJwbnBenar);
        editTextJwb2 = (EditText) findViewById(R.id.editJwbnSalah1);
        editTextJwb3 = (EditText) findViewById(R.id.editJwbnSalah2);
    }

    public void saveDataVolley() {
        refreshFlag = "1";

        final String namasoal = editTextSoal.getText().toString();
        final String jwbnsatu = editTextJwb1.getText().toString();
        final String jwbndua = editTextJwb2.getText().toString();
        final String jwbntiga = editTextJwb3.getText().toString();

        String url = "http://10.0.2.2:8282/androidDoolanz/savedatasoal.php";
        pDialog.setMessage("Save Data Soal...");
        showDialog();

        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        hideDialog();
                        Log.d("Soal", "response :" + response);

                        processResponse("Save Data", response);
                        finish();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        hideDialog();
                        error.printStackTrace();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();

                params.put("nama_soal", namasoal);
                params.put("jawaban1", jwbnsatu);
                params.put("jawaban2", jwbndua);
                params.put("jawaban3", jwbntiga);
                if (action_flag.equals("add")) {
                    params.put("id_soal", "0");

                } else {
                    params.put("id_soal", soal.getId_soal());
                }
                return params;
            }
        };
        Volley.newRequestQueue(this).add(postRequest);

    }

    private void processResponse(String paction, String response) {

        try {
            JSONObject jsonObj = new JSONObject(response);
            String errormsg = jsonObj.getString("errormsg");
            Toast.makeText(getBaseContext(), paction + " " + errormsg, Toast.LENGTH_SHORT).show();

        } catch (JSONException e) {
            Log.d("Soal", "errorJSON");
        }

    }

    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }
}
/Soal menu koding jawaban dalam ada menu JSONobject/