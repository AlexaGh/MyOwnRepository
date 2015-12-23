package com.alexasapps.multiplecardsflippingdemo;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    boolean isBackVisible = false;

    public ImageView[] frontImages;
    public ImageView[] backImages;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frontImages = new ImageView[]{(ImageView) findViewById(R.id.imgBack1), (ImageView) findViewById(R.id.imgBack2), (ImageView)
                findViewById(R.id.imgBack3), (ImageView) findViewById(R.id.imgBack4), (ImageView) findViewById(R.id.imgBack5), (ImageView) findViewById(R.id.imgBack6), (ImageView) findViewById(R.id.imgBack7), (ImageView) findViewById(R.id.imgBack8),
                (ImageView) findViewById(R.id.imgBack9)};
        backImages = new ImageView[]{(ImageView) findViewById(R.id.imgApples), (ImageView) findViewById(R.id.imgBannana), (ImageView) findViewById(R.id.imgKiwi),
                (ImageView) findViewById(R.id.imgOrange), (ImageView) findViewById(R.id.imgRaspberry), (ImageView) findViewById(R.id.imgLimes), (ImageView) findViewById(R.id.imgStrawBerry), (ImageView) findViewById(R.id.imgWatermelon), (ImageView) findViewById(R.id.imgLemon)};

        final AnimatorSet setRightOut = (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(),
                R.animator.flip_right_out);

        final AnimatorSet setLeftIn = (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(),
                R.animator.flight_left_in);

        for (int i = 0; i < frontImages.length; i++) {
            final int index = i;

            frontImages[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!isBackVisible) {
                        setRightOut.setTarget(frontImages[index]);
                        setLeftIn.setTarget(backImages[index]);
                        setRightOut.start();
                        setLeftIn.start();
                        isBackVisible = true;
                    } else {
                        setRightOut.setTarget(backImages[index]);
                        setLeftIn.setTarget(frontImages[index]);
                        setRightOut.start();
                        setLeftIn.start();
                        isBackVisible = false;
                    }
                }
            });
        }

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
