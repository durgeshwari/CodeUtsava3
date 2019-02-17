package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

//https://fir-backend-be513.firebaseio.com/
/*public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //f=new FirebaseDatabase("https://fir-backend-be513.firebaseio.com/Blood grp");
    }
}*/
/*public class MainActivity extends AppCompatActivity{
    ListView listView;
    TextView t;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t=(TextView)findViewById(R.id.tv);
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Name");
       // listView = (ListView) findViewById(R.id.lists);
        Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show();
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String value=dataSnapshot.getValue(String.class).toString();
                t.setText(value);
               // arrayList.add(value);
                //arrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, arrayList);
                //listView.setAdapter(arrayAdapter);
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            }
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
            }
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }}
*/
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.firebase.database.*;

public class donate extends AppCompatActivity {
    EditText e;
    EditText editText,editText2;
    Button submit, fetch;
    DatabaseReference rootRef, demoRef,p;
    TextView demoValue;
String value1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donate);
        e=(EditText)findViewById(R.id.e1);
        editText = (EditText) findViewById(R.id.e2);
        editText2 = (EditText) findViewById(R.id.e3);
      //  demoValue = (TextView) findViewById(R.id.tvValue);
        submit = (Button) findViewById(R.id.button3);
       // fetch = (Button) findViewById(R.id.btnFetch);

        //database reference pointing to root of database
        rootRef = FirebaseDatabase.getInstance().getReference();
        value1 = e.getText().toString();
        //database reference pointing to demo node
       // demoRef =
         //       rootRef.child(value1);

//p=demoRef.child(value1);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intent = new Intent(donate.this, com.example.myapplication.map.class);
                    finish();
                    startActivity(intent);

          String s= rootRef.push().getKey();
                rootRef.child(s).setValue(value1);
                demoRef = rootRef.child(value1);
                String value = editText.getText().toString();
                String value3 = editText2.getText().toString();

                //rootRef.child(s).setValue(value,value3);
                //push creates a unique id in database
               demoRef.child("BloodGroup").setValue(value);
               demoRef.child("Age").setValue(value3);

            }


        });

        /*fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                demoRef.child("p").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String value = dataSnapshot.getValue(String.class);
                        demoValue.setText(value);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });
            }
        });*/
    }

}
