package sdu.kz.learning;

import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.*;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Aslan on 26.03.2016.
 */
public class AudioActivity extends AppCompatActivity implements OnClickListener {

    private MediaPlayer mp3;
    private boolean playing;
    private int which;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);

        playing = false;
        which = 0;

        Typeface font = Typeface.createFromAsset(getAssets(), "taurus.ttf");

        Button first = (Button) findViewById(R.id.first);
        first.setTypeface(font);
        first.setOnClickListener(this);
        Button second = (Button) findViewById(R.id.second);
        second.setTypeface(font);
        second.setOnClickListener(this);
        Button third = (Button) findViewById(R.id.third);
        third.setTypeface(font);
        third.setOnClickListener(this);
        Button fourth = (Button) findViewById(R.id.fourth);
        fourth.setTypeface(font);
        fourth.setOnClickListener(this);
        Button fifth = (Button) findViewById(R.id.fifth);
        fifth.setTypeface(font);
        fifth.setOnClickListener(this);
        Button sixth = (Button) findViewById(R.id.sixth);
        sixth.setTypeface(font);
        sixth.setOnClickListener(this);
        Button seventh = (Button) findViewById(R.id.seventh);
        seventh.setTypeface(font);
        seventh.setOnClickListener(this);

        TextView one = (TextView) findViewById(R.id.first_text);
        one.setTypeface(font);
        TextView two = (TextView) findViewById(R.id.second_text);
        two.setTypeface(font);
        TextView three = (TextView) findViewById(R.id.third_text);
        three.setTypeface(font);
        TextView four = (TextView) findViewById(R.id.fourth_text);
        four.setTypeface(font);
        TextView five = (TextView) findViewById(R.id.fifth_text);
        five.setTypeface(font);
        TextView six = (TextView) findViewById(R.id.sixth_text);
        six.setTypeface(font);
        TextView seven = (TextView) findViewById(R.id.seventh_text);
        seven.setTypeface(font);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.first) {
            if (playing) {
                mp3.stop();
                playing = false;
                if (which != 1) {
                    playing = true;
                    which = 1;
                    mp3 = MediaPlayer.create(AudioActivity.this, R.raw.one);
                    mp3.start();
                }
            } else {
                playing = true;
                which = 1;
                mp3 = MediaPlayer.create(AudioActivity.this, R.raw.one);
                mp3.start();
            }
        } else if (v.getId() == R.id.second) {
            if (playing) {
                mp3.stop();
                playing = false;
                if (which != 2) {
                    playing = true;
                    which = 2;
                    mp3 = MediaPlayer.create(AudioActivity.this, R.raw.two);
                    mp3.start();
                }
            } else {
                playing = true;
                which = 2;
                mp3 = MediaPlayer.create(AudioActivity.this, R.raw.two);
                mp3.start();
            }
        } else if (v.getId() == R.id.third) {
            if (playing) {
                mp3.stop();
                playing = false;
                if (which != 3) {
                    playing = true;
                    which = 3;
                    mp3 = MediaPlayer.create(AudioActivity.this, R.raw.three);
                    mp3.start();
                }
            } else {
                playing = true;
                which = 3;
                mp3 = MediaPlayer.create(AudioActivity.this, R.raw.three);
                mp3.start();
            }
        } else if (v.getId() == R.id.fourth) {
            if (playing) {
                mp3.stop();
                playing = false;
                if (which != 4) {
                    playing = true;
                    which = 4;
                    mp3 = MediaPlayer.create(AudioActivity.this, R.raw.four);
                    mp3.start();
                }
            } else {
                playing = true;
                which = 4;
                mp3 = MediaPlayer.create(AudioActivity.this, R.raw.four);
                mp3.start();
            }
        } else if (v.getId() == R.id.fifth) {
            if (playing) {
                mp3.stop();
                playing = false;
                if (which != 5) {
                    playing = true;
                    which = 5;
                    mp3 = MediaPlayer.create(AudioActivity.this, R.raw.five);
                    mp3.start();
                }
            } else {
                playing = true;
                which = 5;
                mp3 = MediaPlayer.create(AudioActivity.this, R.raw.five);
                mp3.start();
            }
        } else if (v.getId() == R.id.sixth) {
            if (playing) {
                mp3.stop();
                playing = false;
                if (which != 6) {
                    playing = true;
                    which = 6;
                    mp3 = MediaPlayer.create(AudioActivity.this, R.raw.six);
                    mp3.start();
                }
            } else {
                playing = true;
                which = 6;
                mp3 = MediaPlayer.create(AudioActivity.this, R.raw.six);
                mp3.start();
            }
        } else if (v.getId() == R.id.seventh) {
            Log.d("ENTER", "Here");
            if (playing) {
                Log.d("PLAYING", "Here");
                mp3.stop();
                playing = false;
                if (which != 7) {
                    Log.d("AGAIN", "Here");
                    playing = true;
                    which = 7;
                    mp3 = MediaPlayer.create(AudioActivity.this, R.raw.seven);
                    mp3.start();
                }
            } else {
                Log.d("STOP", "Here");
                playing = true;
                which = 7;
                mp3 = MediaPlayer.create(AudioActivity.this, R.raw.seven);
                mp3.start();
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, 0);
    }
}
