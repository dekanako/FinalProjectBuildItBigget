package com.udacity.gradle;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.udacity.gradle.builditbigger.backend.jokesServer.model.Joke;
import com.udacity.jokesdisplaylibrary.JokesDisplay;

/**the app is downloading a joke from the server then sending it to the JokeDisplayLibrary */
public class MainActivity extends AppCompatActivity
        implements JokesLoadingListener {

    private static final String LOG_TAG = MainActivity.class.getName();

    private ProgressBar mBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBar = findViewById(R.id.progressBar);

        if (BuildConfig.FLAVOR.equals("free")) {
            AdView mAdView = findViewById(R.id.adView);
            AdRequest adRequest = new AdRequest.Builder()
                    .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                    .build();
            mAdView.loadAd(adRequest);
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

    public void tellJoke(View view) {
        new JokesSyncTask(this).execute();
    }

    @Override
    public void preJokesLoad() {
        Log.d(LOG_TAG,"pre");
        mBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onJokesLoaded(Joke joke) {
        Log.d("jokes loaded"+LOG_TAG," ");
        mBar.setVisibility(View.INVISIBLE);
        startActivity(JokesDisplay.newIntent(joke.getJoke(),this));
    }


}
