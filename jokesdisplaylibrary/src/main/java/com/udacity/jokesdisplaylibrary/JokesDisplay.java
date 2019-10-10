package com.udacity.jokesdisplaylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
/**this library is receiving and displaying a joke only*/
public class JokesDisplay extends AppCompatActivity {
    private static final String EXTRA_JOKE = "com.udacity.jokesdisplaylibrary.JokesDisplay";

    public static Intent newIntent(String joke,Context context){
        Intent intent = new Intent(context,JokesDisplay.class);
        intent.putExtra(EXTRA_JOKE,joke);
        return intent;
    }

    private TextView mJokeTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes_display);

        getSupportActionBar().setTitle("Jokes display android library");

        mJokeTextView = findViewById(R.id.joke_text_view);
        mJokeTextView.setText(getIntent().getStringExtra(EXTRA_JOKE));


    }
}
