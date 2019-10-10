package com.udacity.gradle;

import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.Nullable;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.json.gson.GsonFactory;
import com.udacity.gradle.builditbigger.backend.jokesServer.JokesServer;
import com.udacity.gradle.builditbigger.backend.jokesServer.model.Joke;

import java.io.IOException;

public class JokesSyncTask extends AsyncTask<Void,Void, Joke> {
    private JokesLoadingListener mJokesLoadingListener;

    private static final String TAG = "JokesSyncTask";

    public JokesSyncTask(JokesLoadingListener jokesLoadingListener) {
        mJokesLoadingListener = jokesLoadingListener;


    }

    @Override
    protected void onPreExecute() {
        mJokesLoadingListener.preJokesLoad();
        Log.d(TAG,"PRE EXECUTE");
    }

    @Override
    protected Joke doInBackground(Void... voids) {
        Log.d(TAG,"Still in background");
        JokesServer.Builder jokesServer = new JokesServer.Builder(AndroidHttp.newCompatibleTransport()
                ,new GsonFactory(),null);

        jokesServer.setRootUrl("http://10.0.2.2:8080/_ah/api").build();
        Joke joke = null;
        try {
            joke = jokesServer.build().getAJoke().execute();
        } catch (IOException e) {
            Log.e(TAG,"errr",e);
            e.printStackTrace();
        }
        Log.d(TAG,joke.hashCode()+"");
        return joke;
    }

    @Override
    protected void onPostExecute(Joke joke) {
        Log.d(TAG,"post execute");
        mJokesLoadingListener.onJokesLoaded(joke);
    }

}
