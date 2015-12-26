package com.alexasapps.model;


import android.widget.ImageView;

public class Card {

    private int id;
    ImageView frontImage;
    ImageView backImage;


    public ImageView getFrontImage() {
        return frontImage;
    }

    public void setFrontImage(ImageView frontImage) {
        this.frontImage = frontImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ImageView getBackImage() {
        return backImage;
    }

    public void setBackImage(ImageView backImage) {
        this.backImage = backImage;
    }

}
