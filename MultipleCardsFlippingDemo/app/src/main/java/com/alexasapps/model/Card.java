package com.alexasapps.model;


import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.alexasapps.multiplecardsflippingdemo.R;

import java.util.Random;

public class Card {

    private int id;
    ImageView frontImage;
    ImageView backImage;
    Drawable image;

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

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
