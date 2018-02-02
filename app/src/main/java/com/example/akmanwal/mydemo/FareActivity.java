package com.example.akmanwal.mydemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FareActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fare);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent getDataHere = getIntent();
        String trainCode = getDataHere.getStringExtra("trainCode");
        String sourceCode = getDataHere.getStringExtra("sourceCode");
        String destCode = getDataHere.getStringExtra("destCode");
        String page = getDataHere.getStringExtra("Age");
        String trainClass = getDataHere.getStringExtra("classCode");
        String trainDate = getDataHere.getStringExtra("trainDate");

        getFareEstimation(trainCode,sourceCode,destCode,page,trainClass,trainDate);
    }

    private void getFareEstimation(String trainCode,String sourceCode,String destCode,String page,String trainClass,String trainDate) {
       final retrofit2.Call<FareEstimation> fareEstimationCall = IndianRailwayApi.getFareEstimationService()
               .getFare(trainCode,sourceCode,destCode,page,trainClass,trainDate);
                 fareEstimationCall.enqueue(new Callback<FareEstimation>() {
           @Override
           public void onResponse(Call<FareEstimation> call, Response<FareEstimation> response) {
               FareEstimation fareEstimation = response.body();

               if(fareEstimation.getResponseCode()>200)
               {
                   Toast.makeText(FareActivity.this, "please enter valid entries...", Toast.LENGTH_SHORT).show();
               }
               else {
                   recyclerView.setAdapter(new FareAdapter(FareActivity.this, fareEstimation));
                   Toast.makeText(FareActivity.this, "Success: Ashish", Toast.LENGTH_SHORT).show();
               }
               }

           @Override
           public void onFailure(Call<FareEstimation> call, Throwable t) {
               Toast.makeText(FareActivity.this, "server is busy...", Toast.LENGTH_SHORT).show();
           }
       });
    }
}