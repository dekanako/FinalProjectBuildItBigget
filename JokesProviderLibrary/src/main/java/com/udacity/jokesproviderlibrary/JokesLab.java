package com.udacity.jokesproviderlibrary;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/** singleton class to avoid having multiple instances
 * the only job of the class is to provide a joke
 */
public class JokesLab {
    private static JokesLab sJokesLab;
    private List<Joke> mJokes;
    public static JokesLab newInstance(){
        if (sJokesLab == null){
            sJokesLab = new JokesLab();
        }
        return sJokesLab;
    }


    private JokesLab() {
        mJokes = new ArrayList<>();

        mJokes.add(new Joke("Q: Why should you sit in a corner when you get cold?\n" +
                "\n" +
                "A: Because most corners are 90 degrees."));

        mJokes.add(new Joke("Q: What do you call an alligator wearing a vest?\n" +
                "\n" +
                "A: An Investigator!"));

        mJokes.add(new Joke("Q: What did the fish say when it swam into a wall?\n" +
                "\n" +
                "A:  Dam! "));

        mJokes.add(new Joke("Knock! Knock!\n" +
                "\n" +
                "Who’s there?\n" +
                "\n" +
                "Says.\n" +
                "\n" +
                "Says who?\n" +
                "\n" +
                "Says me, that’s who!"));

        mJokes.add(new Joke("Q. Why is Peter Pan flying all the time?\n" +
                "\n" +
                "A. He Neverlands!\n" +
                "\n"));

        mJokes.add(new Joke("How do you prevent a Summer cold?\n" +
                "\n" +
                "Catch it in the Winter!"));

        mJokes.add(new Joke("Q: Erin, spell mouse.\n" +
                "A: M O U S.\n" +
                "Q: Yes–and what’s on the end of it?\n" +
                "A: A tail?"));

    }

    private List<Joke> getJokes() {
        return mJokes;
    }

    //expose a random joke
    public static Joke pickARandomJoke(){
        Random random = new Random();
        int randomJoke = random.nextInt(JokesLab.newInstance().getJokes().size()-1);
        return JokesLab.newInstance().getJokes().get(randomJoke);
    }

}
