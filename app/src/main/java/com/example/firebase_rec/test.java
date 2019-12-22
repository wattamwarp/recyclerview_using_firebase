package com.example.firebase_rec;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class test extends AppCompatActivity {

    TextView id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        id=findViewById(R.id.id);
        String name=getIntent().getStringExtra("id");
        DatabaseReference dbref=FirebaseDatabase.getInstance().getReference().child("products").child(name);
         dbref.addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                 String id1;
                 id1 = dataSnapshot.child("price").getValue().toString();
                 id.setText(id1);


             }

             @Override
             public void onCancelled(@NonNull DatabaseError databaseError) {

             }
         });




    }
}
