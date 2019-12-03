package de.test.antennapod.ui;

import android.content.Intent;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.runner.AndroidJUnit4;
import de.danoeh.antennapodSA.R;
import de.danoeh.antennapodSA.activity.MainActivity;
import de.danoeh.antennapodSA.fragment.QueueFragment;
import de.test.antennapod.EspressoTestUtils;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.endsWith;

/**
 * User interface tests for queue fragment.
 */
@RunWith(AndroidJUnit4.class)
public class QueueFragmentTest {

    @Rule
    public IntentsTestRule<MainActivity> activityRule = new IntentsTestRule<>(MainActivity.class, false, false);

    @Before
    public void setUp() {
        EspressoTestUtils.clearPreferences();
        EspressoTestUtils.makeNotFirstRun();
        EspressoTestUtils.clearDatabase();
        EspressoTestUtils.setLastNavFragment(QueueFragment.TAG);
        activityRule.launchActivity(new Intent());
    }

    @Test
    public void testLockEmptyQueue() {
        onView(withContentDescription(R.string.lock_queue)).perform(click());
        onView(allOf(withClassName(endsWith("Button")), withText(R.string.lock_queue))).perform(click());
        onView(withContentDescription(R.string.unlock_queue)).perform(click());
    }

    @Test
    public void testSortEmptyQueue() {
        Espresso.openContextualActionModeOverflowMenu();
        onView(withText(R.string.sort)).perform(click());
        onView(withText(R.string.random)).perform(click());
    }

    @Test
    public void testKeepEmptyQueueSorted() {
        Espresso.openContextualActionModeOverflowMenu();
        onView(withText(R.string.sort)).perform(click());
        onView(withText(R.string.keep_sorted)).perform(click());
    }
}
