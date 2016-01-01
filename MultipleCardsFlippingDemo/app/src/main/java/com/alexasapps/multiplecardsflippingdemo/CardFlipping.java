package com.alexasapps.multiplecardsflippingdemo;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.media.Image;
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

    public Card c1;
    public Card c2;
    public Card selectedCard;

    int count = 0;

    int index1 = -1;
    int index2 = -1;

    public ArrayList<Card> cards = new ArrayList<Card>();

    List<String> backDrawables2 = new ArrayList<>(9);

    private Timer t;


    public void setCards(ImageView[] frontImages, ImageView[] backImages) {

        for (int i = 1; i <= 6; i++) {
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

    public void doTurn(Card card) {

        final AnimatorSet setRightOut = (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(),
                R.animator.flip_right_out);

        final AnimatorSet setLeftIn = (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(),
                R.animator.flight_left_in);

        if (!card.isSelected()) {

            setRightOut.setTarget(card.getFrontImage());
            setLeftIn.setTarget(card.getBackImage());
            setRightOut.start();
            setLeftIn.start();


            isBackVisible = true;

            Toast toast = Toast.makeText(getApplicationContext(), "ON FIRST CLICK", Toast.LENGTH_SHORT);
            toast.show();

            card.setSelected(true);

        } else {

            setRightOut.setTarget(card.getBackImage());
            setLeftIn.setTarget(card.getFrontImage());
            setRightOut.start();
            setLeftIn.start();

            Toast toast = Toast.makeText(getApplicationContext(), "ON SECOND CLICK", Toast.LENGTH_SHORT);
            toast.show();

            isBackVisible = false;
            card.setSelected(false);
        }

    }

    public void checkCards() {

        if (c1.getBackImage().equals(c2.getBackImage())) {

            //   c1.setEnabled(false);
            //  c2.setEnabled(false);
            c1.setMatched(true);
            c2.setMatched(true);
            /*if (this.isGameWon()) {
                JOptionPane.showMessageDialog(this, "You win!");
                System.exit(0);
            }*/
        } else {
            c1.setMatched(false);
            c2.setMatched(false);
            c1.setSelected(false);
            c2.setSelected(false);

        }
        c1 = null; // reset c1 and c2
        c2 = null;
    }

    public void turnBackwards(ImageView frontImage, ImageView backImage) {

        final AnimatorSet setRightOut = (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(),
                R.animator.flip_right_out);

        final AnimatorSet setLeftIn = (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(),
                R.animator.flight_left_in);

        setRightOut.setTarget(backImage);
        setLeftIn.setTarget(frontImage);
        setRightOut.start();
        setLeftIn.start();
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

        setCards(frontImages, backImages);


        Toast toast = Toast.makeText(getApplicationContext(), "size: " + cards.size(), Toast.LENGTH_SHORT);
        toast.show();


        for (int i = 0; i < cards.size(); i++) {
            frontImages[i].setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    for (int i = 0; i < frontImages.length; i++)
                        if (v.getId() == frontImages[i].getId()) {
                            if (!cards.get(i).isMatched())
                                doTurn(cards.get(i));
                        }

                            count = 0;
                            for (int i = 0; i < cards.size(); i++) {
                                if (cards.get(i).isSelected()) {
                                    count++;
                                }
                            }

                            if (count == 2) { // == 2
                                for (int i = 0; i < cards.size(); i++) {
                                    if (cards.get(i).isSelected()) {
                                        if (index1 == -1) {
                                            index1 = i;
                                        }
                                        else {
                                            index2 = i;
                                        }
                                    }
                                }

                                if (cards.get(index1).getBackImage().getDrawable().getConstantState().equals(cards.get(index2).getBackImage().getDrawable().getConstantState())) {

                                    cards.get(index1).setMatched(true);
                                    cards.get(index2).setMatched(true);
                                    cards.get(index1).setSelected(false);
                                    cards.get(index2).setSelected(false);
                                    index1 = -1;
                                    index2 = -1;

                                } else {
                                    doTurn(cards.get(index1));
                                    doTurn(cards.get(index2));
                                    index1=-1;
                                    index2=-1;
                                }
                            }
                        }

                }

                );

            }


        }

    }
