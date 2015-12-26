package com.alexasapps.multiplecardsflippingdemo;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.alexasapps.model.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class CardFlipping extends Activity {

    boolean isBackVisible = false;

    public ImageView[] frontImages;
    public ImageView[] backImages;

    public boolean c1Clicked = false;
    public boolean c2Clicked = false;

    public ArrayList<Card> cards = new ArrayList<Card>();

    public void setCards(ImageView[] frontImages, ImageView[] backImages) {

        for (int i = 0; i < frontImages.length; i++) {
            Card card = new Card();
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
                findViewById(R.id.imgBack3), (ImageView) findViewById(R.id.imgBack4), (ImageView) findViewById(R.id.imgBack5), (ImageView) findViewById(R.id.imgBack6), (ImageView) findViewById(R.id.imgBack7), (ImageView) findViewById(R.id.imgBack8),
                (ImageView) findViewById(R.id.imgBack9)};
        backImages = new ImageView[]{(ImageView) findViewById(R.id.imgApples), (ImageView) findViewById(R.id.imgBannana), (ImageView) findViewById(R.id.imgKiwi),
                (ImageView) findViewById(R.id.imgOrange), (ImageView) findViewById(R.id.imgRaspberry), (ImageView) findViewById(R.id.imgLimes), (ImageView) findViewById(R.id.imgStrawBerry), (ImageView) findViewById(R.id.imgWatermelon), (ImageView) findViewById(R.id.imgLemon)};

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

        Toast toast = Toast.makeText(getApplicationContext(), "zise: " + cards.size(), Toast.LENGTH_SHORT);
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
                                    c1Clicked = true;
                                } else {
                                    if (!c2Clicked) {
                                        Toast toast = Toast.makeText(getApplicationContext(), "ON SECOND CLIcK", Toast.LENGTH_SHORT);
                                        toast.show();
                                        c2Clicked = true;

                                    }
                                }
                            } else {
                                Toast toast = Toast.makeText(getApplicationContext(), "ON ELSE ", Toast.LENGTH_SHORT);
                                toast.show();
                                setRightOut.setTarget(backImages[i]);
                                setLeftIn.setTarget(frontImages[i]);
                                setRightOut.start();
                                setLeftIn.start();
                                isBackVisible = false;
                            }
                        }
                }
            });

        }

    }
}
