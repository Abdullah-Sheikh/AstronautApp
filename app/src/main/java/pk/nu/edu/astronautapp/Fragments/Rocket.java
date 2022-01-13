package pk.nu.edu.astronautapp.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import org.json.JSONObject;

import pk.nu.edu.astronautapp.Model.Distance;
import pk.nu.edu.astronautapp.Model.RocketModel;
import pk.nu.edu.astronautapp.R;

public class Rocket extends Fragment {

    private LinearLayout Theme_layer ;
    TextView direction , speed , distanceFromMoon, distanceFromEarth , timeE , oxygenLevel , fuel;







    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.rocket_frag,container,false);


        direction = (TextView) v.findViewById(R.id.dir);
        speed= (TextView) v.findViewById(R.id.speed);
        distanceFromEarth = (TextView) v.findViewById(R.id.dist_from_earth);
        distanceFromMoon= (TextView) v.findViewById(R.id.dist_from_moon);
        timeE= (TextView) v.findViewById(R.id.time_elspsed);

        oxygenLevel = (TextView) v.findViewById(R.id.oxygen_level);
        fuel = (TextView)v.findViewById(R.id.fuel_Remaining);



        DatabaseReference ref;
        FirebaseDatabase database  = FirebaseDatabase.getInstance();

       ref =  database.getReference().child("Rockets/Rocket1");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
              RocketModel rocket = dataSnapshot.getValue(RocketModel.class);
              direction.setText("Direction              "+rocket.getDirection());
              speed.setText("Speed              "+rocket.getSpeed());
              fuel.setText("Fuel Remaining          "+rocket.getFuel());
              timeE.setText("Time elspsed          "+rocket.getLunchtime());
              oxygenLevel.setText("Oxygen level          "+(rocket.getOygenlevel()));





                DatabaseReference ref1;
                FirebaseDatabase database1  = FirebaseDatabase.getInstance();

                ref1 =  database1.getReference().child("Rockets/Rocket1/distances");
                ref1.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        Distance distance = dataSnapshot.getValue(Distance.class);
                        System.out.println();


                        distanceFromEarth.setText(String.valueOf("Earth                 "+(distance.getEarth())));
                        distanceFromMoon.setText(String.valueOf("Moon                    "+(distance.getMoon())));

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });















        return v;
    }






}