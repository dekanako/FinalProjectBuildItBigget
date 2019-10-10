package com.udacity.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.udacity.jokesproviderlibrary.Joke;
import com.udacity.jokesproviderlibrary.JokesLab;
/** google cloud endpoint: which is used to generate java servlet its only work is to fetch its joke from the JokesProviderLibrary */
@Api(
        name = "jokesServer",
        version = "v1",
        description = "an API that return a joke",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)

public class ApiService {

    @ApiMethod(name = "getAJoke")
    public Joke getRandomJoke(){ return  JokesLab.newInstance().pickARandomJoke(); }
}
