package com.udacity.gradle;

import android.content.Context;
import android.util.Log;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.IdlingResource;
import androidx.test.filters.LargeTest;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.backend.jokesServer.model.Joke;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Timer;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@LargeTest

public class ExampleInstrumentedTest {

    private static final String TAG = "ExampleInstrumentedTest";
    @Rule
    public ActivityTestRule<MainActivity> mTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Before
    public void initIdleResources() {
        onView(withId(R.id.button)).perform(click());

        onView(withId(R.id.joke_text_view)).check(matches(not(withText(""))));
    }

    @Test
    public void test() {

    }

}