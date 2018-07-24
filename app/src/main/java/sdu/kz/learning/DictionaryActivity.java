package sdu.kz.learning;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.*;

/**
 * Created by Aslan on 26.03.2016.
 */
public class DictionaryActivity extends AppCompatActivity implements OnClickListener {

    private SQLiteDatabase db;

    private EditText search, searchKazakh;
    private TextView text, textKazakh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        try {
            DBHelper dbHelper = new DBHelper(this, "dict.db");
            db = dbHelper.openDatabase();
        } catch (Exception e) {
        }

        Typeface font = Typeface.createFromAsset(getAssets(), "taurus.ttf");

        search = (EditText) findViewById(R.id.activity_dictionary_search);
        search.setTypeface(font);
        searchKazakh = (EditText) findViewById(R.id.activity_dictionary_search_kazakh);
        searchKazakh.setTypeface(font);

        Button send = (Button) findViewById(R.id.activity_dictionary_button);
        send.setTypeface(font);
        send.setOnClickListener(this);
        Button find = (Button) findViewById(R.id.activity_dictionary_button_kazakh);
        find.setTypeface(font);
        find.setOnClickListener(this);

        text = (TextView) findViewById(R.id.activity_dictionary_text);
        text.setTypeface(font);
        textKazakh = (TextView) findViewById(R.id.activity_dictionary_text_kazakh);
        textKazakh.setTypeface(font);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.activity_dictionary_button) {
            loadSearch(search.getText().toString(), 1);
        } else if (v.getId() == R.id.activity_dictionary_button_kazakh) {
            loadSearch(searchKazakh.getText().toString(), 2);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, 0);
    }

    private Cursor getSearchedWords(String s, int type) {
        String[] columns = {"id", "english", "russian"};
        if (type == 1) {
            Cursor c = db.query("dict", columns, "english like \"" + s + "\"", null, null, null, "russian");
            return c;
        }
        Log.d("WORD", s);
        Cursor c = db.query("dict", columns, "russian like \"" + s + "\"", null, null, null, "english");
        return c;
    }

    private void loadSearch(String s, int type) {
        Cursor c = getSearchedWords(s, type);
        Log.d("HELLO", "HI");
        if (c.moveToFirst()) {
            if (type == 1) {
                text.setText(c.getString(c.getColumnIndex("russian")));
            } else if (type == 2) {
                textKazakh.setText(c.getString(c.getColumnIndex("english")));
            }
        }
    }
}
