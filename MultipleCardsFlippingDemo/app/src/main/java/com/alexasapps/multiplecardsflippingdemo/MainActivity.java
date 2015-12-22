package com.alexasapps.multiplecardsflippingdemo;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int[] imageViewIds = {R.id.imgApples, R.id.imgBannana, R.id.imgKiwi, R.id.imgLemon, R.id.imgLimes, R.id.imgOrange,
            R.id.imgRaspBerry, R.id.imgStrawberry, R.id.imgWatermelon};
    int[] backImageIds = {R.id.imgBack, R.id.imgBack1, R.id.imgBack2, R.id.imgBack3, R.id.imgBack4, R.id.imgBack5,
            R.id.imgBack6, R.id.imgBack7, R.id.imgBack8};

    Button btnFlip;

    boolean isBackVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final AnimatorSet setRightOut = (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(),
                R.animator.flip_right_out);


        final AnimatorSet setLeftIn = (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(),
                R.animator.flight_left_in);

        btnFlip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isBackVisible) {
                    for (int i = 0; i < imageViewIds.length; i++) {
                        setRightOut.setTarget(imageViewIds[i]);
                        setLeftIn.setTarget(backImageIds[i]);
                        setRightOut.start();
                        setLeftIn.start();
                    }

                    isBackVisible = true;
                } else {
                    for (int i = 0; i < imageViewIds.length; i++) {
                        setRightOut.setTarget(backImageIds[5]);
                        setLeftIn.setTarget(imageViewIds[1]);
                        setRightOut.start();
                        setLeftIn.start();
                    }

                    isBackVisible = false;
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
