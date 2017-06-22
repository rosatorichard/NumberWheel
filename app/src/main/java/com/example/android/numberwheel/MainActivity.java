package com.example.android.numberwheel;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SeekBar bar;
    private TextView num;
    private int prog=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num = (TextView)findViewById(R.id.tvNum);
        bar = (SeekBar)findViewById(R.id.seekBar);


        bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {


            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                prog=progress;

                num.setText(String.valueOf(prog));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


    public void sound(View view) {

        MediaPlayer media = MediaPlayer.create(this,R.raw.sound);

        float soundBefore=(float)Math.abs(prog);
        float log=soundBefore/100;
        media.setVolume(0,log);
        media.start();

    }
}
