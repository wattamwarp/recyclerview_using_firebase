package com.example.firebase_rec;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.viewholder> {
    public ProductsAdapter(@NonNull Context mcontext, List<Product> peoductlist) {
        this.mcontext = mcontext;
        this.productlist = peoductlist;
    }

    @NonNull

    Context mcontext;
    List<Product> productlist;

    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mcontext).inflate(R.layout.product_layout,
                parent, false);
        viewholder productViewHolder = new viewholder(view);
        return productViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, final int position) {

//        Product product= productlist.get(position);
//
//        holder.textViewTitle.setText(product.getTitle());
//        holder.textviewPrice.setText(product.getPrice());
//        holder.textViewShortDesc.setText(product.getShortdesc());
//        holder.textViewRating.setText(product.getRating());
        final Product product = productlist.get(position);

        holder.textViewTitle.setText(product.getTitle());
        holder.textViewShortDesc.setText(product.getShortdesc());
        holder.textviewPrice.setText(String.valueOf(product.getPrice()));
        holder.textViewRating.setText(String.valueOf(product.getRating()));
        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name= product.getID();
                Toast.makeText(mcontext,"baburao "+name ,Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(mcontext,test.class);
                intent.putExtra("id",name);
                mcontext.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return productlist.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {

        //ImageView imageView;
        TextView textViewTitle, textViewShortDesc, textViewRating, textviewPrice;
        CardView cardview;

        public viewholder(@NonNull View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
            textViewRating = itemView.findViewById(R.id.textViewRating);
            textviewPrice = itemView.findViewById(R.id.textViewPrice);
            cardview=itemView.findViewById(R.id.cardview);

        }
    }



}//end og public class
