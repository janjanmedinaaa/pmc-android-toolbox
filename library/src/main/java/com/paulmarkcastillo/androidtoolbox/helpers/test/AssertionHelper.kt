package com.paulmarkcastillo.androidtoolbox.helpers.test

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.actionWithAssertions
import androidx.test.espresso.action.ViewActions.clearText
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.action.ViewActions.swipeDown
import androidx.test.espresso.action.ViewActions.swipeLeft
import androidx.test.espresso.action.ViewActions.swipeRight
import androidx.test.espresso.action.ViewActions.swipeUp
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.Intents.times
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.matcher.IntentMatchers.hasExtraWithKey
import androidx.test.espresso.matcher.ViewMatchers.Visibility
import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import androidx.test.espresso.matcher.ViewMatchers.isChecked
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.isEnabled
import androidx.test.espresso.matcher.ViewMatchers.isNotChecked
import androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.not
import com.paulmarkcastillo.androidtoolbox.helpers.test.CustomMatchers.Companion.withErrorText
import com.paulmarkcastillo.androidtoolbox.helpers.test.CustomMatchers.Companion.withHintText
import com.paulmarkcastillo.androidtoolbox.helpers.test.CustomMatchers.Companion.withItemCount
import com.paulmarkcastillo.androidtoolbox.helpers.test.CustomMatchers.Companion.withRecyclerView

/**
 * AssertionHelper contains a common/general
 * way of accessing or checking the elements
 * of the presented UI in test.
 */
class AssertionHelper {

    companion object {
        fun assertActivityLaunched(activityClassName: String, times: Int = 1) {
            intended(hasComponent(activityClassName), times(times))
        }

        fun assertActivityLaunchedHasExtras(
            vararg extras: String,
            activityClassName: String,
            times: Int = 1
        ) {
            assertActivityLaunched(
                activityClassName,
                times
            )
            extras.forEach {
                intended(hasExtraWithKey(it))
            }
        }

        fun assertSwitchToggled(
            switchViewId: Int,
            beforeIsChecked: Boolean = false
        ): ViewInteraction {
            return when (beforeIsChecked) {
                true -> onView(withId(switchViewId)).check(matches(isNotChecked()))
                false -> onView(withId(switchViewId)).check(matches(isChecked()))
            }
        }

        fun assertTextInputLayoutHintTextIsDisplayed(id: Int, expectedHint: String): ViewInteraction {
            return onView(withId(id)).check(matches(withHintText(expectedHint)))
        }

        fun assertTextInputLayoutErrorTextIsDisplayed(id: Int, expectedError: String): ViewInteraction {
            return onView(withId(id)).check(matches(withErrorText(expectedError)))
        }

        fun assertViewsAreDisplayed(
            vararg viewIds: Int,
            inScrollableView: Boolean = false
        ): List<ViewInteraction> {
            return when (inScrollableView) {
                true -> viewIds.map {
                    onView(allOf(withId(it), withEffectiveVisibility(Visibility.VISIBLE)))
                        .perform(actionWithAssertions(
                            CustomScrollToAction()
                        ))
                        .check(matches(isDisplayed()))
                }
                false -> viewIds.map {
                    onView(allOf(withId(it), withEffectiveVisibility(Visibility.VISIBLE)))
                        .check(matches(isDisplayed()))
                }
            }
        }

        fun assertViewsAreDisplayed(
            matcher: Matcher<View>,
            shown: Boolean = true
        ): ViewInteraction {
            val check = if (shown) isDisplayed() else not(isDisplayed())
            return onView(matcher)
                .check(matches(check))
        }

        fun assertTextIsDisplayed(text: String, inScrollableView: Boolean = false): Boolean {
            return try {
                if (inScrollableView) {
                    onView(
                        allOf(withText(text), withEffectiveVisibility(Visibility.VISIBLE))
                    )
                        .perform(actionWithAssertions(
                            CustomScrollToAction()
                        ))
                        .check(matches(isDisplayed()))
                } else {
                    onView(
                        allOf(withText(text), withEffectiveVisibility(Visibility.VISIBLE))
                    ).check(matches(isDisplayed()))
                }
                true
            } catch (e: NoMatchingViewException) {
                false
            }
        }

        fun assertViewIsDisplayed(viewId: Int, visible: Boolean): Boolean {
            val matches = if (visible) isDisplayed() else not(isDisplayed())
            return try {
                onView(allOf(withId(viewId))).check(matches(matches))
                true
            } catch (e: NoMatchingViewException) {
                false
            }
        }

        fun performClearTextViews(editTextIds: IntArray): List<ViewInteraction> {
            for (editTextId in editTextIds) {
                onView(withId(editTextId)).perform(clearText())
            }

            return editTextIds.map { onView(withId(it)).check(matches(isDisplayed())) }
        }

        fun performClick(viewId: Int, inScrollableView: Boolean = false): ViewInteraction {
            return when (inScrollableView) {
                true -> onView(allOf(withId(viewId), withEffectiveVisibility(Visibility.VISIBLE)))
                    .perform(CustomScrollToAction(), click())
                false -> onView(allOf(withId(viewId), withEffectiveVisibility(Visibility.VISIBLE)))
                    .perform(click())
            }
        }

        fun performClick(matcher: Matcher<View>, inScrollableView: Boolean = false): ViewInteraction {
            return when (inScrollableView) {
                true -> onView(matcher).perform(scrollTo(), click())
                false -> onView(matcher).perform(click())
            }
        }

        fun viewContainsString(textViewId: Int, expectedString: String) {
            onView(withId(textViewId)).check(matches(withText(expectedString)))
        }

        fun performClick(matcher: Matcher<View>, spannableText: String): ViewInteraction {
            return onView(matcher).perform(
                CustomMatchers.clickClickableSpan(
                    spannableText
                )
            )
        }

        fun performTypeText(viewId: Int, text: String): ViewInteraction {
            return onView(allOf(withId(viewId), withEffectiveVisibility(Visibility.VISIBLE)))
                .perform(typeText(text), closeSoftKeyboard())
        }

        fun isEnabled(viewId: Int, enabled: Boolean) {
            val match = if (enabled) isEnabled() else not(
                isEnabled()
            )
            onView(withId(viewId)).check(matches(match))
        }

        fun isChecked(viewId: Int, checked: Boolean) {
            val match = if (checked) isChecked() else not(
                isChecked()
            )
            onView(withId(viewId)).check(matches(match))
        }

        fun performWithRecyclerView(recyclerViewId: Int, position: Int, targetId: Int) {
            val target =
                CustomMatchers.clickChildViewWithId(targetId)
            onView(allOf(withId(recyclerViewId), withEffectiveVisibility(Visibility.VISIBLE)))
                .perform(
                    RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                        position,
                        target
                    )
                )
        }

        fun clickWithRecyclerViewAt(recyclerViewId: Int, position: Int) {
            onView(withId(recyclerViewId))
                .perform(
                    RecyclerViewActions
                        .actionOnItemAtPosition<RecyclerView.ViewHolder>(
                            position, click()
                        )
                )
        }

        fun assertTextIsDisplayedInRecyclerView(recyclerViewId: Int, position: Int, targetId: Int, text: String) {
            onView(
                withRecyclerView(recyclerViewId)
                    .atPositionOnView(position, targetId)
            )
                .check(matches(withText(text)))
        }

        fun performTypeTextWithRecyclerView(
            recyclerViewId: Int,
            position: Int,
            targetId: Int,
            text: String
        ) {
            val target =
                CustomMatchers.typeTextWithID(targetId, text)
            onView(allOf(withId(recyclerViewId), withEffectiveVisibility(Visibility.VISIBLE)))
                .perform(
                    RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                        position,
                        target
                    )
                )
        }

        fun performActionWithRecyclerView(
            recyclerViewId: Int,
            position: Int,
            targetId: Int,
            viewAction: ViewAction
        ) {
            onView(allOf(withId(recyclerViewId), withEffectiveVisibility(Visibility.VISIBLE)))
                .perform(
                    RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                        position,
                        viewAction
                    )
                )
        }

        fun recyclerViewMatcher(
            recyclerViewId: Int,
            position: Int,
            targetId: Int,
            matcher: Matcher<View>
        ) {
            onView(
                withRecyclerView(recyclerViewId)
                    .atPositionOnView(position, targetId)
            )
                .check(matches(matcher))
        }

        fun assertViewVisibleOnRecyclerView(
            recyclerViewId: Int,
            position: Int,
            targetId: Int,
            shown: Boolean
        ) {
            val check = if (shown) isDisplayed() else not(isDisplayed())
            onView(withId(recyclerViewId))
                .check(
                    matches(
                        CustomMatchers.withViewAtPosition(
                            position,
                            hasDescendant(allOf(withId(targetId), check))
                        )
                    )
                )
        }

        fun assertRecyclerViewItemCount(recyclerViewId: Int, count: Int) {
            onView(withId(recyclerViewId))
                .check(matches(withItemCount(count)))
        }

        fun performSwipeUp(container: Int) {
            onView(withId(container))
                .perform(swipeUp())
        }

        fun performSwipeDown(container: Int) {
            onView(withId(container))
                .perform(swipeDown())
        }

        fun performSwipeLeftOnRecyclerViewItem(recyclerViewId: Int, position: Int) {
            onView(withId(recyclerViewId))
                .perform(
                    RecyclerViewActions
                        .actionOnItemAtPosition<RecyclerView.ViewHolder>(position, swipeLeft())
                )
        }

        fun performSwipeRightOnRecyclerViewItem(recyclerViewId: Int, position: Int) {
            onView(withId(recyclerViewId))
                .perform(
                    RecyclerViewActions
                        .actionOnItemAtPosition<RecyclerView.ViewHolder>(position, swipeRight())
                )
        }

        fun performSwipeUpOnRecyclerViewItem(recyclerViewId: Int, position: Int) {
            onView(withId(recyclerViewId))
                .perform(
                    RecyclerViewActions
                        .actionOnItemAtPosition<RecyclerView.ViewHolder>(position, swipeUp())
                )
        }
    }
}