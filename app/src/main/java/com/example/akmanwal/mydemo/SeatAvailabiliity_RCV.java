package com.example.akmanwal.mydemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telecom.Call;
import android.widget.Toast;

import retrofit2.Callback;
import retrofit2.Response;

public class SeatAvailabiliity_RCV extends AppCompatActivity {

    RecyclerView rcv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_availabiliity__rcv);

        rcv = (RecyclerView)findViewById(R.id.rcv);
        rcv.setLayoutManager(new LinearLayoutManager(this));

        Intent getTrainDataHere = getIntent();
        String trainCode = getTrainDataHere.getStringExtra("trainCode");
        String sourceCode = getTrainDataHere.getStringExtra("sourceCode");
        String destCode = getTrainDataHere.getStringExtra("destCode");
        String classCode = getTrainDataHere.getStringExtra("classCode");
        String trainDate = getTrainDataHere.getStringExtra("trainDate");

        getSeatAvailability(trainCode,sourceCode,destCode,classCode,trainDate);

    }

    private void getSeatAvailability(String trainCode, String sourceCode, String destCode, String trainDate, String classCode) {
        final retrofit2.Call<SeatAvailability> seatAvailabilityCall = IndianRailwayApi.getSeatAvailabilityService()
                .getAvailability(trainCode,sourceCode,destCode,classCode,trainDate);
        seatAvailabilityCall.enqueue(new Callback<SeatAvailability>()
        {
            @Override
            public void onResponse(retrofit2.Call<SeatAvailability> call, Response<SeatAvailability> response) {

                SeatAvailability seatAvailability = response.body();
                int availCount=seatAvailability.getAvailability().size();
                if(availCount ==0 )
                {
                    Toast.makeText(SeatAvailabiliity_RCV.this, "please enter valid entries...", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(SeatAvailabiliity_RCV.this, "Success: Ashish", Toast.LENGTH_SHORT).show();
                }
                rcv.setAdapter(new SeatAvailabilityAdapter(SeatAvailabiliity_RCV.this, seatAvailability));
               //seatAvailability.getAvailability() we need to pass complete reference object here later on

            }

            @Override
            public void onFailure(retrofit2.Call<SeatAvailability> call, Throwable t) {

                Toast.makeText(SeatAvailabiliity_RCV.this, "Server is busy", Toast.LENGTH_SHORT).show();
            }
        });
    }
}