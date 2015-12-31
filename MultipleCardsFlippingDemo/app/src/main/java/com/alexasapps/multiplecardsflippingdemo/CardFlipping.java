package com.alexasapps.multiplecardsflippingdemo;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.alexasapps.model.Card;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class CardFlipping extends Activity {

    boolean isBackVisible = false;

    public ImageView[] frontImages;
    public ImageView[] backImages;

    public boolean c1Clicked = false;
    public boolean c2Clicked = false;

    public ImageView selected1;
    public ImageView selected2;

    public ArrayList<Card> cards = new ArrayList<Card>();

    List<String> backDrawables2 = new ArrayList<>(9);

    public void setCards(ImageView[] frontImages, ImageView[] backImages) {

        for(int i = 1; i <=6; i++){
            backDrawables2.add("@drawable/fruit" + i);
            backDrawables2.add("@drawable/fruit" + i);
        }
        Collections.shuffle(backDrawables2);

        for (int i = 0; i < frontImages.length; i++) {

            Card card = new Card();

            int imageResource = getResources().getIdentifier(backDrawables2.get(i), null, getPackageName());
            Drawable res = getResources().getDrawable(imageResource);
            backImages[i].setImageDrawable(res);

            card.setId(i);
            card.setFrontImage(frontImages[i]);
            card.setBackImage(backImages[i]);
            cards.add(card);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frontImages = new ImageView[]{(ImageView) findViewById(R.id.imgBack1), (ImageView) findViewById(R.id.imgBack2), (ImageView)
                findViewById(R.id.imgBack3), (ImageView) findViewById(R.id.imgBack4), (ImageView) findViewById(R.id.imgBack5),
                (ImageView) findViewById(R.id.imgBack6), (ImageView) findViewById(R.id.imgBack7), (ImageView) findViewById(R.id.imgBack8),
                (ImageView) findViewById(R.id.imgBack9), (ImageView) findViewById(R.id.imgBack10), (ImageView) findViewById(R.id.imgBack11),
                (ImageView) findViewById(R.id.imgBack12)};

        backImages = new ImageView[]{(ImageView) findViewById(R.id.img1), (ImageView) findViewById(R.id.img2),
                (ImageView) findViewById(R.id.img3), (ImageView) findViewById(R.id.img4), (ImageView) findViewById(R.id.img5),
                (ImageView) findViewById(R.id.img6), (ImageView) findViewById(R.id.img7), (ImageView) findViewById(R.id.img8),
                (ImageView) findViewById(R.id.img9), (ImageView) findViewById(R.id.img10), (ImageView) findViewById(R.id.img11),
                (ImageView) findViewById(R.id.img12)};

        // final TypedArray icons = getResources().obtainTypedArray(R.array.backDrawables);
        // Drawable drawable = icons.getDrawable(0);

        setCards(frontImages, backImages);

        final AnimatorSet setRightOut = (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(),
                R.animator.flip_right_out);

        final AnimatorSet setLeftIn = (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(),
                R.animator.flight_left_in);


        /*for (int i = 0; i < frontImages.length; i++) {
            Card card = new Card();
            card.setId(i);
            frontImages[i].setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    selectedCard = card;

                }
            });
        }*/

        Toast toast = Toast.makeText(getApplicationContext(), "size: " + cards.size(), Toast.LENGTH_SHORT);
        toast.show();

        for (int i = 0; i < cards.size(); i++) {
            //for(final Card card : cards) {
            //final Card card = c;

            /*Card card = new Card();
            card.setId(i);
            card.setFrontImage(frontImages[i]);
            card.setBackImage(backImages[i]);*/
            //cards.add(card);

            frontImages[i].setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    for (int i = 0; i < frontImages.length; i++)
                        //for (ImageView iv : frontImages) {
                        if (v.getId() == frontImages[i].getId()) {
                            if (!c1Clicked || !c2Clicked) {
                                setRightOut.setTarget(frontImages[i]);
                                setLeftIn.setTarget(backImages[i]);
                                setRightOut.start();
                                setLeftIn.start();
                                isBackVisible = true;
                                if (!c1Clicked) {
                                    Toast toast = Toast.makeText(getApplicationContext(), "ON FIRST CLIK", Toast.LENGTH_SHORT);
                                    toast.show();
                                    selected1 = backImages[i];
                                    c1Clicked = true;
                                } else {
                                    if (!c2Clicked) {
                                        Toast toast = Toast.makeText(getApplicationContext(), "ON SECOND CLIcK", Toast.LENGTH_SHORT);
                                        toast.show();
                                        selected2 = backImages[i];
                                        c2Clicked = true;

                                    }
                                }
                            } else  {
                                    Toast toast = Toast.makeText(getApplicationContext(), "ON ELSE ", Toast.LENGTH_SHORT);
                                    toast.show();

                                    setRightOut.setTarget(backImages[i]);
                                    setLeftIn.setTarget(frontImages[i]);
                                    setRightOut.start();
                                    setLeftIn.start();

                                    c1Clicked = false;
                                    c2Clicked = false;
                                    isBackVisible = false;
                                }
                            }
                        }

            });

        }

    }

}
