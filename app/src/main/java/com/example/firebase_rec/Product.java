package com.example.firebase_rec;

public class Product {
    public Product() {
        //this.title = title;
    }

    //String image;
    String title,shortdesc,rating,price,id;

    public Product(String price,String rating, String shortdesc, String title,String id) {
        //this.image = image;
        this.price = price;
        this.rating = rating;
        this.shortdesc = shortdesc;
        this.title = title;
        this.id=id;




    }



    public String getTitle() {
        return title;
    }

    public String getShortdesc() {
        return shortdesc;
    }

    public String getRating() {
        return rating;
    }

    public String getPrice() {
        return price;
    }

    public String getID(){
        return id;
    }
}
