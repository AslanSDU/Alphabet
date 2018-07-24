package sdu.kz.learning;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.*;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Typeface font = Typeface.createFromAsset(getAssets(), "taurus.ttf");

        TextView title = (TextView) findViewById(R.id.activity_main_title);
        title.setTypeface(font);

        Button letters = (Button) findViewById(R.id.activity_main_letters);
        letters.setTypeface(font);
        letters.setOnClickListener(this);
        Button dictionary = (Button) findViewById(R.id.activity_main_dictionary);
        dictionary.setTypeface(font);
        dictionary.setOnClickListener(this);
        Button audio = (Button) findViewById(R.id.activity_main_audio);
        audio.setTypeface(font);
        audio.setOnClickListener(this);
        Button poems = (Button) findViewById(R.id.activity_main_poems);
        poems.setTypeface(font);
        poems.setOnClickListener(this);
        Button digits = (Button) findViewById(R.id.activity_main_digits);
        digits.setTypeface(font);
        digits.setOnClickListener(this);
        Button colors = (Button) findViewById(R.id.activity_main_colors);
        colors.setTypeface(font);
        colors.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        if (v.getId() == R.id.activity_main_letters) {
            intent = new Intent(MainActivity.this, LettersActivity.class);
        } else if (v.getId() == R.id.activity_main_dictionary) {
            intent = new Intent(MainActivity.this, DictionaryActivity.class);
        } else if (v.getId() == R.id.activity_main_audio) {
            intent = new Intent(MainActivity.this, AudioActivity.class);
        } else if (v.getId() == R.id.activity_main_poems) {
            intent = new Intent(MainActivity.this, PoemsActivity.class);
        } else if (v.getId() == R.id.activity_main_digits) {
            intent = new Intent(MainActivity.this, DigitsActivity.class);
        } else if (v.getId() == R.id.activity_main_colors) {
            intent = new Intent(MainActivity.this, ColorsActivity.class);
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }
}
