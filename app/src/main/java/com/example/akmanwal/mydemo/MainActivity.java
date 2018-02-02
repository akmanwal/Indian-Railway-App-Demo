package com.example.akmanwal.mydemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button seatAvailability,fareButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    seatAvailability = (Button)findViewById(R.id.seat);
    fareButton = (Button)findViewById(R.id.fareButton);
        seatAvailability.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoSeat = new Intent(getApplicationContext(),SeatAvailabilityActivity.class);
                startActivity(gotoSeat);
            }
        });

        fareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoFare = new Intent(getApplicationContext(),FareForm.class);
                startActivity(gotoFare);
            }
        });

    }

}
