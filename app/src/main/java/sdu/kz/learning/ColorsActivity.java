package sdu.kz.learning;

import android.os.Bundle;
import android.view.View;
import android.view.View.*;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Aslan on 26.03.2016.
 */
public class ColorsActivity extends AppCompatActivity implements OnClickListener {

    private String[] colors_name = {"Blue", "Green", "White", "Yellow", "Pink", "Purple",
            "Red", "Orange", "Brown", "Black", "Gray", "Sky"};
    private Button blue, green, white, yellow, pink, purple, red, orange, brown, black, gray, sky, middle;
    private int current = 0;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        blue = (Button) findViewById(R.id.activity_colors_button_blue);
        blue.setOnClickListener(this);
        green = (Button) findViewById(R.id.activity_colors_button_green);
        green.setOnClickListener(this);
        white = (Button) findViewById(R.id.activity_colors_button_white);
        white.setOnClickListener(this);
        yellow = (Button) findViewById(R.id.activity_colors_button_yellow);
        yellow.setOnClickListener(this);
        pink = (Button) findViewById(R.id.activity_colors_button_pink);
        pink.setOnClickListener(this);
        purple = (Button) findViewById(R.id.activity_colors_button_purple);
        purple.setOnClickListener(this);
        red = (Button) findViewById(R.id.activity_colors_button_red);
        red.setOnClickListener(this);
        orange = (Button) findViewById(R.id.activity_colors_button_orange);
        orange.setOnClickListener(this);
        brown = (Button) findViewById(R.id.activity_colors_button_brown);
        brown.setOnClickListener(this);
        black = (Button) findViewById(R.id.activity_colors_button_black);
        black.setOnClickListener(this);
        gray = (Button) findViewById(R.id.activity_colors_button_gray);
        gray.setOnClickListener(this);
        sky = (Button) findViewById(R.id.activity_colors_button_sky);
        sky.setOnClickListener(this);
        middle = (Button) findViewById(R.id.activity_colors_button_middle);
        middle.setOnClickListener(this);
        text = (TextView) findViewById(R.id.activity_colors_button_middle_text);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.activity_colors_button_blue) {
            middle.setBackgroundResource(R.drawable.blue);
            current = 1;
            text.setText(colors_name[current - 1]);
        } else if (v.getId() == R.id.activity_colors_button_green) {
            middle.setBackgroundResource(R.drawable.green);
            current = 2;
            text.setText(colors_name[current - 1]);
        } else if (v.getId() == R.id.activity_colors_button_white) {
            middle.setBackgroundResource(R.drawable.white);
            current = 3;
            text.setText(colors_name[current - 1]);
        } else if (v.getId() == R.id.activity_colors_button_yellow) {
            middle.setBackgroundResource(R.drawable.yellow);
            current = 4;
            text.setText(colors_name[current - 1]);
        } else if (v.getId() == R.id.activity_colors_button_pink) {
            middle.setBackgroundResource(R.drawable.pink);
            current = 5;
            text.setText(colors_name[current - 1]);
        } else if (v.getId() == R.id.activity_colors_button_purple) {
            middle.setBackgroundResource(R.drawable.purple);
            current = 6;
            text.setText(colors_name[current - 1]);
        } else if (v.getId() == R.id.activity_colors_button_red) {
            middle.setBackgroundResource(R.drawable.red);
            current = 7;
            text.setText(colors_name[current - 1]);
        } else if (v.getId() == R.id.activity_colors_button_orange) {
            middle.setBackgroundResource(R.drawable.orange);
            current = 8;
            text.setText(colors_name[current - 1]);
        } else if (v.getId() == R.id.activity_colors_button_brown) {
            middle.setBackgroundResource(R.drawable.brown);
            current = 9;
            text.setText(colors_name[current - 1]);
        } else if (v.getId() == R.id.activity_colors_button_black) {
            middle.setBackgroundResource(R.drawable.black);
            current = 10;
            text.setText(colors_name[current - 1]);
        } else if (v.getId() == R.id.activity_colors_button_gray) {
            middle.setBackgroundResource(R.drawable.gray);
            current = 11;
            text.setText(colors_name[current - 1]);
        } else if (v.getId() == R.id.activity_colors_button_sky) {
            middle.setBackgroundResource(R.drawable.sky);
            current = 12;
            text.setText(colors_name[current - 1]);
        } else if (v.getId() == R.id.activity_colors_button_middle) {
            if (current == 0) {
                text.setText("Choose color");
            } else {
                text.setText(colors_name[current - 1]);
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, 0);
    }
}
