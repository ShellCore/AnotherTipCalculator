package com.shellcore.android.anothertipcalculator;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Cesar on 15/06/2017.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    private static final String BILL_AMOUNT = "100";

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void tipTotalAmount15Percent() {
        onView(withId(R.id.edt_bill_amount))
                .perform(typeText(BILL_AMOUNT), closeSoftKeyboard());

        onView(withText("15% tip")).perform(click());

        String expectedText = "115.0";

        onView(withId(R.id.txt_total_amount)).check(matches(withText(expectedText)));
    }

    @Test
    public void tipTotalAmount20Percent() {
        onView(withId(R.id.edt_bill_amount))
                .perform(typeText(BILL_AMOUNT), closeSoftKeyboard());

        onView(withText("20% tip")).perform(click());

        String expectedText = "120.0";

        onView(withId(R.id.txt_total_amount)).check(matches(withText(expectedText)));
    }

    @Test
    public void tipTotalAmount30Percent() {
        onView(withId(R.id.edt_bill_amount))
                .perform(typeText(BILL_AMOUNT), closeSoftKeyboard());

        onView(withText("30% tip")).perform(click());

        String expectedText = "130.0";

        onView(withId(R.id.txt_total_amount)).check(matches(withText(expectedText)));
    }

    @Test
    public void tipTotalAmount40Percent() {
        onView(withId(R.id.edt_bill_amount))
                .perform(typeText(BILL_AMOUNT), closeSoftKeyboard());

        onView(withText("40% tip")).perform(click());

        String expectedText = "140.0";

        onView(withId(R.id.txt_total_amount)).check(matches(withText(expectedText)));
    }
}