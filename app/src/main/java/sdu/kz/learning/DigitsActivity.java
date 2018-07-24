package sdu.kz.learning;

import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.*;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.View.*;

/**
 * Created by Aslan on 26.03.2016.
 */
public class DigitsActivity extends AppCompatActivity implements OnClickListener {

    private String[] digits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "10", "20", "30", "40", "50", "60", "70", "80", "90", "100"};
    private String[] texts = {"zero", "one", "two", "three", "four", "five",
            "six", "seven", "eight", "nine", "ten", "twenty", "thirty",
            "forty", "fifty", "sixty", "seventy", "eighty", "ninety", "hundred"};
    private Button[] digitButton;
    private int[] anims = {R.anim.move_ball_one, R.anim.move_ball_two, R.anim.move_ball_three,
            R.anim.move_ball_four, R.anim.move_ball_five, R.anim.move_ball_six, R.anim.move_ball_seven,
            R.anim.move_ball_eight, R.anim.move_ball_nine, R.anim.move_ball_ten};

    private GridLayout gridLayout;
    private RelativeLayout relativeLayout;
    private TextView digit;
    private ImageView image, one, two, three, four, five, six, seven, eight, nine, ten;
    private boolean isDigit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digits);

        Typeface font = Typeface.createFromAsset(getAssets(), "taurus.ttf");
        isDigit = false;

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int x = size.x;
        int y = size.y;
        int width = x - dpToPx(80);
        int height = y - dpToPx(70);

        gridLayout = (GridLayout) findViewById(R.id.activity_digits_layout);
        digitButton = new Button[digits.length];

        relativeLayout = (RelativeLayout) findViewById(R.id.activity_digit_layout);
        digit = (TextView) findViewById(R.id.activity_digit_layout_digit);
        image = (ImageView) findViewById(R.id.activity_digit_layout_image);
        one = (ImageView) findViewById(R.id.activity_digit_layout_one);
        two = (ImageView) findViewById(R.id.activity_digit_layout_two);
        three = (ImageView) findViewById(R.id.activity_digit_layout_three);
        four = (ImageView) findViewById(R.id.activity_digit_layout_four);
        five = (ImageView) findViewById(R.id.activity_digit_layout_five);
        six = (ImageView) findViewById(R.id.activity_digit_layout_six);
        seven = (ImageView) findViewById(R.id.activity_digit_layout_seven);
        eight = (ImageView) findViewById(R.id.activity_digit_layout_eight);
        nine = (ImageView) findViewById(R.id.activity_digit_layout_nine);
        ten = (ImageView) findViewById(R.id.activity_digit_layout_ten);
        Button back = (Button) findViewById(R.id.activity_digit_layout_back);
        back.setOnClickListener(this);

        int buttonWidth = width / 5;
        int buttonHeight = height / 4;

        for (int i = 0; i < digits.length; i++) {
            digitButton[i] = new Button(DigitsActivity.this);
            digitButton[i].setId(2000 + i);
            digitButton[i].setLayoutParams(new LayoutParams(buttonWidth, buttonHeight));
            digitButton[i].setTypeface(font);
            digitButton[i].setBackgroundResource(android.R.color.transparent);
            digitButton[i].setText(digits[i]);
            digitButton[i].setTextSize(30);
            digitButton[i].setTextColor(Color.WHITE);
            digitButton[i].setOnClickListener(this);
            gridLayout.addView(digitButton[i]);
        }
    }

    private int dpToPx(int dp) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int px = Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
        return px;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() >= 2000 && v.getId() < 2000 + digits.length) {
            int cur = v.getId() - 2000;
            if (cur > 10) {
                cur = 10;
            }
            isDigit = true;
            digit.setText(digits[v.getId() - 2000] + " [" + texts[v.getId() - 2000] + "]");
            switch (cur) {
                case 0:
                    one.clearAnimation();
                    one.setVisibility(View.GONE);
                case 1:
                    two.clearAnimation();
                    two.setVisibility(View.GONE);
                case 2:
                    three.clearAnimation();
                    three.setVisibility(View.GONE);
                case 3:
                    four.clearAnimation();
                    four.setVisibility(View.GONE);
                case 4:
                    five.clearAnimation();
                    five.setVisibility(View.GONE);
                case 5:
                    six.clearAnimation();
                    six.setVisibility(View.GONE);
                case 6:
                    seven.clearAnimation();
                    seven.setVisibility(View.GONE);
                case 7:
                    eight.clearAnimation();
                    eight.setVisibility(View.GONE);
                case 8:
                    nine.clearAnimation();
                    nine.setVisibility(View.GONE);
                case 9:
                    ten.clearAnimation();
                    ten.setVisibility(View.GONE);
                default:
                    break;
            }
            Animation animate = null;
            switch (cur) {
                case 10:
                    ten.setVisibility(View.VISIBLE);
                    animate = AnimationUtils.loadAnimation(getApplicationContext(), anims[9]);
                    ten.startAnimation(animate);
                case 9:
                    nine.setVisibility(View.VISIBLE);
                    animate = AnimationUtils.loadAnimation(getApplicationContext(), anims[8]);
                    nine.startAnimation(animate);
                case 8:
                    eight.setVisibility(View.VISIBLE);
                    animate = AnimationUtils.loadAnimation(getApplicationContext(), anims[7]);
                    eight.startAnimation(animate);
                case 7:
                    seven.setVisibility(View.VISIBLE);
                    animate = AnimationUtils.loadAnimation(getApplicationContext(), anims[6]);
                    seven.startAnimation(animate);
                case 6:
                    six.setVisibility(View.VISIBLE);
                    animate = AnimationUtils.loadAnimation(getApplicationContext(), anims[5]);
                    six.startAnimation(animate);
                case 5:
                    five.setVisibility(View.VISIBLE);
                    animate = AnimationUtils.loadAnimation(getApplicationContext(), anims[4]);
                    five.startAnimation(animate);
                case 4:
                    four.setVisibility(View.VISIBLE);
                    animate = AnimationUtils.loadAnimation(getApplicationContext(), anims[3]);
                    four.startAnimation(animate);
                case 3:
                    three.setVisibility(View.VISIBLE);
                    animate = AnimationUtils.loadAnimation(getApplicationContext(), anims[2]);
                    three.startAnimation(animate);
                case 2:
                    two.setVisibility(View.VISIBLE);
                    animate = AnimationUtils.loadAnimation(getApplicationContext(), anims[1]);
                    two.startAnimation(animate);
                case 1:
                    one.setVisibility(View.VISIBLE);
                    animate = AnimationUtils.loadAnimation(getApplicationContext(), anims[0]);
                    one.startAnimation(animate);
                    break;
                default:
                    break;
            }
            gridLayout.setVisibility(View.GONE);
            relativeLayout.setVisibility(View.VISIBLE);
        } else if (v.getId() == R.id.activity_digit_layout_back) {
            isDigit = false;
            relativeLayout.setVisibility(View.GONE);
            gridLayout.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onBackPressed() {
        if (isDigit) {
            isDigit = false;
            relativeLayout.setVisibility(View.GONE);
            gridLayout.setVisibility(View.VISIBLE);
        } else {
            super.onBackPressed();
            overridePendingTransition(0, 0);
        }
    }
}
