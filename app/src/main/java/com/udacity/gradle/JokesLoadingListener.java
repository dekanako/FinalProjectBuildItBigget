package com.udacity.gradle;

import com.udacity.gradle.builditbigger.backend.jokesServer.model.Joke;

public interface JokesLoadingListener{
    void preJokesLoad();
    void onJokesLoaded(Joke joke);
}