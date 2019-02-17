package com.example.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class entering extends AppCompatActivity {
TextView name,bloodGrp;
Button insert;
FirebaseDatabase fbdb;
DatabaseReference dbref;
info inf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (TextView) findViewById(R.id.textView6);
        bloodGrp = (TextView) findViewById(R.id.textView7);
        insert = (Button) findViewById(R.id.button4);
        fbdb = FirebaseDatabase.getInstance();
        dbref = fbdb.getReference("info");
       inf =new info();

    }
    private  void values(){
        inf.setName(name.getText().toString());
        inf.setBloodgrp(bloodGrp.getText().toString());
    }
    private void insert(View view){
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                values();
            dbref.child("userinfo").setValue(inf);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        }
        }


