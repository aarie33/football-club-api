package arie

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.pressBack
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import arie.footballclubapi.HomeActivity
import arie.footballclubapi.R.id.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeActivityTest {
    @Rule
    @JvmField var activityRule = ActivityTestRule(HomeActivity::class.java)

//    @Test
//    fun testRecyclerViewBehaviour() {
//        onView(withId(list_team))
//                .check(matches(isDisplayed()))
//        onView(withId(list_team)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(10))
//        onView(withId(list_team)).perform(
//                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(10, click()))
//    }

    @Test
    fun testAppBehaviour() {
        onView(withId(spinner))
                .check(matches(isDisplayed()))
        onView(withId(spinner)).perform(click())
        onView(withText("Spanish La Liga")).perform(click())

        onView(withText("Barcelona"))
                .check(matches(isDisplayed()))
        onView(withText("Barcelona")).perform(click())

        onView(withId(add_to_favorite))
                .check(matches(isDisplayed()))
        onView(withId(add_to_favorite)).perform(click())
        onView(withText("Added to favorite"))
                .check(matches(isDisplayed()))
        pressBack()

        onView(withId(navigation))
                .check(matches(isDisplayed()))
        onView(withId(favorites)).perform(click())
    }
}