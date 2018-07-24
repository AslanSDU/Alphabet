package sdu.kz.learning;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.view.View.*;
import android.widget.TextView;

/**
 * Created by Aslan on 26.03.2016.
 */
public class PoemsActivity extends AppCompatActivity implements OnClickListener {

    private TextView textView;
    private Button prev, next;
    private int position;
    private String[] text = {"My mother.\n\nThat is your mother\nI agree she is fine\nYou love your mother\nAnd I love mine",
            "Help your mother.\n\nHelp your mother set the table\nWith a knife and fork and spoon.\nHelp your mother set the table\nEvery afternoon\nHelp your mother clean the table,\nTake the knife and fork and spoon;\nHelp your mother clean the table\nMorning, night and noon",
            "My dear mummy.\n\nI love my dear mummy\nI love her very much\nAnd do you love your mummy?\n-Of course and very much",
            "Mother’s Day\n\nEach bright flower\nIs here to say\nMy fish for you:\n\"Happy Mother’s Day\"",
            "My Dear Mummy.\n\nMy dear, dear mummy!\nI love you very much.\nI want you to be happy\nOn the 8th of March",
            "Happy Mother’s Day.\n\nI like the way you look,\nI like the way you cook,\nNow what I really want to say\nIs:\"Happy Mother’s Day\"",
            "Mother’s Day Basket.\n\nMake a basket\nFor yor mother,\nAnd fill it with flowers gay,\nThen put a card\nJust to say:\n\"Happy Mother’s Day!\"",
            "My family.\n\nI have a father,\nI have a mother,\nI have a sister,\nI have a brother.\nFather, mother, sister, brother -\nHand in hand with one another.",
            "Sam has a hat.\n\nSam has a black hat.\nHe has a black hat in his hand.",
            "Winter.\n\nNothing is quite ,so quite and clean\nAnd snow that falls in the night,\nAnd isn’t it jolly to jump from bed\nAnd find the whole world white?",
            "Days in the Month\n\nThirty days has September,\nApril, June and November;\nFebruary has twenty-eight alone.\nAll the rest have thirty-one,\nBut leap year coming once in four\nGives February one day more.",
            "About Weather\n\nIf bees stay at home,\nRain will soon come;\nIf they fly away,\nFine will be the day."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poems);

        Typeface font = Typeface.createFromAsset(getAssets(), "taurus.ttf");
        position = 0;

        textView = (TextView) findViewById(R.id.activity_poems_text);
        textView.setText(text[position]);
        textView.setTypeface(font);

        prev = (Button) findViewById(R.id.activity_poems_prev);
        prev.setText("<");
        prev.setTypeface(font);
        prev.setOnClickListener(this);
        next = (Button) findViewById(R.id.activity_poems_next);
        next.setText(">");
        next.setTypeface(font);
        next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.activity_poems_prev) {
            position--;
            if (position == -1) {
                position = text.length - 1;
            }
            textView.setText(text[position]);
        } else if (v.getId() == R.id.activity_poems_next) {
            position++;
            if (position == text.length) {
                position = 0;
            }
            textView.setText(text[position]);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, 0);
    }
}
