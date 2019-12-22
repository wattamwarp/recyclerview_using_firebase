package com.example.firebase_rec;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

//    RecyclerView mrec;
//    ProductsAdapter adapter;
//    List<Product> productlist;

    RecyclerView  mrec;
    ProductsAdapter adapter;
    List<Product> productlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mrec = findViewById(R.id.recyclerView);
        mrec.setHasFixedSize(true);

        mrec.setLayoutManager(new LinearLayoutManager(this));


        productlist = new ArrayList<Product>();

        DatabaseReference dbProducts = FirebaseDatabase.getInstance().getReference("products");
        dbProducts.keepSynced(true);

        dbProducts.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.exists()){

                    for(DataSnapshot productSnapshot : dataSnapshot.getChildren()){
                        Product p = productSnapshot.getValue(Product.class);
                        productlist.add(p);
                    }

                    adapter = new ProductsAdapter(MainActivity.this, productlist);
                    mrec.setAdapter(adapter);

                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        dbProducts.keepSynced(true);

        
//        productlist.add(new Product("antilia","expensive home","4.5","1000"));
//
//        productlist.add(new Product("a","luxury homme","a10","50000000"));
//
//        productlist.add(new Product("S kalyankar","HOD","5","10"));
//
//
//
//        adapter=new ProductsAdapter(MainActivity.this,productlist);
//        mrec.setAdapter(adapter);

    }
}
