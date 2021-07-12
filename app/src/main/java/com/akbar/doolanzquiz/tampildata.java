package com.akbar.doolanzquiz;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.cahyonoz.doolanzquiz.model.ModelSoal;
import com.cahyonoz.doolanzquiz.adapter.AdapterSoal;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class tampildata extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private AdapterSoal rvAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Context context = tampildata.this;
    private static final int REQUEST_CODE_ADD = 1;
    private static final int REQUEST_CODE_EDIT = 2;
    private List<ModelSoal> soalList = new ArrayList<ModelSoal>();

    private ProgressDialog pDialog;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampildata);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), MenuAdmin.class);
                startActivity(intent);
            }
        });


        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view); //my_recycler_view
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        pDialog = new ProgressDialog(this);
        loadDataServerVolley();
    }

    private void gambarDatakeRecyclerView(){
        rvAdapter = new AdapterSoal(soalList);
        mRecyclerView.setAdapter(rvAdapter);
        mRecyclerView.addOnItemTouchListener(

                new RecyclerItemListener(context, new RecyclerItemListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        ModelSoal dftr = rvAdapter.getItem(position);
                        Intent intent = new Intent(tampildata.this , Soal.class);
                        //intent.putExtra("mhs", mhs);
                        //intent.putExtra("mhs", mhs);
                        intent.putExtra("soal",dftr);
                        startActivityForResult(intent , REQUEST_CODE_EDIT);
                    }
                })
        );
    }

    @Override
    protected void onActivityResult(int requestCode , int resultCode , Intent data){
        super.onActivityResult(requestCode , resultCode,data);
        switch (requestCode){
            case REQUEST_CODE_ADD:{
                if(resultCode == RESULT_OK && null != data){
                    if(data.getStringExtra("refreshflag").equals("1")){
                        loadDataServerVolley();
                    }
                }
                break;
            }
            case REQUEST_CODE_EDIT:{
                if(resultCode == RESULT_OK && null != data){
                    if(data.getStringExtra("refreshflag").equals("1")){
                        loadDataServerVolley();
                    }
                }
                break;
            }
        }
    }
    private void loadDataServerVolley(){
        String url = "http://10.0.2.2:8282/androidDoolanz/listdata.php";
        pDialog.setMessage("Memuat Data Soal...");
        showDialog();

        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("tampildata", "response:" + response);
                        hideDialog();
                        processReponse(response);
                        gambarDatakeRecyclerView();
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
            protected Map<String , String> getParams(){
                Map<String , String > params = new HashMap<>();

                return  params;
            }
        };
        Volley.newRequestQueue(this).add(postRequest);
    }

    private  void processReponse(String response){
        try{
            JSONObject jsonObj = new JSONObject(response);
            JSONArray jsonArray = jsonObj.getJSONArray("data");
            Log.d("TAG" , "data length : " + jsonArray.length());
            ModelSoal objectsoal =null;
            soalList.clear();
            for(int i = 0 ; i<jsonArray.length(); i++){
                JSONObject obj = jsonArray.getJSONObject(i);
                objectsoal = new ModelSoal();
                objectsoal.setId_soal(obj.getString("id_soal"));
                objectsoal.setNama_soal(obj.getString("nama_soal"));
                objectsoal.setJawaban1(obj.getString("jawaban1"));
                objectsoal.setJawaban2(obj.getString("jawaban2"));
                objectsoal.setJawaban3(obj.getString("jawaban3"));

                soalList.add(objectsoal);
            }
        }catch (JSONException e){
            Log.d("tampildata ", "errorJSON");
        }
    }

    private  void showDialog(){
        if(!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog(){
        if(pDialog.isShowing())
            pDialog.dismiss();
    }


}
/model soal tampilan data menu menu didalam nya/