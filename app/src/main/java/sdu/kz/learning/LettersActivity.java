package sdu.kz.learning;

import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.DisplayMetrics;
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

public class LettersActivity extends AppCompatActivity implements OnClickListener {

    private String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
            "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private int[] colors = {1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0};
    private Button[] letterButton;
    private int[] images_first = {R.drawable.ant, R.drawable.balll, R.drawable.carrot, R.drawable.dog, R.drawable.egg, R.drawable.flower,
            R.drawable.gift, R.drawable.horse, R.drawable.ice_cream, R.drawable.jacket, R.drawable.key, R.drawable.lemon, R.drawable.monkey,
            R.drawable.nine, R.drawable.orang, R.drawable.pen, R.drawable.queen, R.drawable.rabbit, R.drawable.snak, R.drawable.tennis,
            R.drawable.umbrella, R.drawable.violin, R.drawable.wallet, R.drawable.xerox, R.drawable.yogurt, R.drawable.zebra};
    private String[] words_first = {"Ant", "Ball", "Carrot", "Dog", "Egg", "Flower", "Gift", "Horse",
            "Ice-cream", "Jacket", "Key", "Lemon", "Monkey", "Nine", "Orange", "Pen", "Queen",
            "Rabbit", "Snake", "Tennis", "Umbrella", "Violin", "Wallet", "Xerox", "Yogurt", "Zebra"};
    private int[] images_second = {R.drawable.apple, R.drawable.butterfly, R.drawable.cat, R.drawable.drum, R.drawable.elephant, R.drawable.fox,
            R.drawable.giraffe, R.drawable.house, R.drawable.iphone, R.drawable.juice, R.drawable.king, R.drawable.leon, R.drawable.moon,
            R.drawable.nose, R.drawable.owl, R.drawable.pizza, R.drawable.question, R.drawable.ring, R.drawable.sun, R.drawable.tiger,
            R.drawable.upstairs, R.drawable.voice, R.drawable.watermelon, R.drawable.xerox, R.drawable.yo_yo, R.drawable.zebra};
    private String[] words_second = {"Apple", "Butterfly", "Cat", "Drum", "Elephant", "Fox", "Giraffe", "House",
            "Iphone", "Juice", "King", "Leon", "Moon", "Nose", "Owl", "Pizza", "Question",
            "Ring", "Sun", "Tiger", "Upstairs", "Voice", "Watermelon", "X", "Yo-yo", "Z"};

    private GridLayout gridLayout;
    private RelativeLayout relativeLayout;
    private TextView letter, imageTextFirst, imageTextSecond;
    private ImageView imageFirst, imageSecond;
    private boolean isLetter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letters);

        Typeface font = Typeface.createFromAsset(getAssets(), "taurus.ttf");
        isLetter = false;

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int x = size.x;
        int y = size.y;
        int width = x - dpToPx(80);
        int height = y - dpToPx(70);

        gridLayout = (GridLayout) findViewById(R.id.activity_letters_layout);
        letterButton = new Button[letters.length];

        relativeLayout = (RelativeLayout) findViewById(R.id.activity_letter_layout);
        letter = (TextView) findViewById(R.id.activity_letter_layout_letter);
        letter.setTypeface(font);
        imageFirst = (ImageView) findViewById(R.id.activity_letter_layout_image_first);
        imageSecond = (ImageView) findViewById(R.id.activity_letter_layout_image_second);
        imageTextFirst = (TextView) findViewById(R.id.activity_letter_layout_image_text_first);
        imageTextFirst.setTypeface(font);
        imageTextSecond = (TextView) findViewById(R.id.activity_letter_layout_image_text_second);
        imageTextSecond.setTypeface(font);
        Button back = (Button) findViewById(R.id.activity_letter_layout_back);
        back.setOnClickListener(this);

        int buttonWidth = width / 7;
        int buttonHeight = height / 6;

        for (int i = 0; i < letters.length; i++) {
            letterButton[i] = new Button(LettersActivity.this);
            letterButton[i].setId(1000 + i);
            letterButton[i].setLayoutParams(new LayoutParams(buttonWidth, buttonHeight));
            letterButton[i].setTypeface(font);
            letterButton[i].setBackgroundResource(android.R.color.transparent);
            letterButton[i].setText(letters[i]);
            letterButton[i].setTextSize(30);
            if (colors[i] == 1) {
                letterButton[i].setTextColor(Color.RED);
            } else {
                letterButton[i].setTextColor(Color.BLUE);
            }
            letterButton[i].setOnClickListener(this);
            gridLayout.addView(letterButton[i]);
        }
    }

    private int dpToPx(int dp) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int px = Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
        return px;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() >= 1000 && v.getId() < 1000 + letters.length) {
            isLetter = true;
            Animation animationFirst = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.show_letter_first);
            Animation animationSecond = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.show_letter_second);
            letter.setText(letters[v.getId() - 1000] + " " + letters[v.getId() - 1000].toLowerCase());

            imageFirst.setImageResource(images_first[v.getId() - 1000]);
            imageFirst.startAnimation(animationFirst);
            String textFirst = showMainLetter(words_first[v.getId() - 1000], v.getId() - 1000);
            imageTextFirst.setText(Html.fromHtml(textFirst));
            imageTextFirst.setAnimation(animationFirst);

            imageSecond.setImageResource(images_second[v.getId() - 1000]);
            imageSecond.startAnimation(animationSecond);
            String textSecond = showMainLetter(words_second[v.getId() - 1000], v.getId() - 1000);
            imageTextSecond.setText(Html.fromHtml(textSecond));
            imageTextSecond.setAnimation(animationSecond);

            gridLayout.setVisibility(View.GONE);
            relativeLayout.setVisibility(View.VISIBLE);
        } else if (v.getId() == R.id.activity_letter_layout_back) {
            isLetter = false;
            relativeLayout.setVisibility(View.GONE);
            gridLayout.setVisibility(View.VISIBLE);
        }
    }

    private String showMainLetter(String s, int id) {
        String text = "";
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) + "").equals(letters[id]) || (s.charAt(i) + "").equals(letters[id].toLowerCase())) {
                if (colors[id] == 1) {
                    text += "<font color=red>" + s.charAt(i) + "</font>";
                } else {
                    text += "<font color=blue>" + s.charAt(i) + "</font>";
                }
            } else {
                text += s.charAt(i);
            }
        }
        return text;
    }

    @Override
    public void onBackPressed() {
        if (isLetter) {
            isLetter = false;
            relativeLayout.setVisibility(View.GONE);
            gridLayout.setVisibility(View.VISIBLE);
        } else {
            super.onBackPressed();
            overridePendingTransition(0, 0);
        }
    }
}
