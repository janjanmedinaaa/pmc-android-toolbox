package com.paulmarkcastillo.androidtoolbox.helpers.test

import android.graphics.Rect
import android.util.Log
import android.view.View
import android.widget.HorizontalScrollView
import android.widget.ListView
import android.widget.ScrollView
import androidx.core.widget.NestedScrollView
import androidx.test.espresso.PerformException
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.isDisplayingAtLeast
import androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility
import androidx.test.espresso.util.HumanReadables
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.anyOf

/** Enables scrolling to the given view. View must be a descendant of a ScrollView or ListView. */
class CustomScrollToAction : ViewAction {

    private val TAG = CustomScrollToAction::class.java.simpleName

    override fun getConstraints(): Matcher<View> {
        return allOf<View>(
            withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE),
            isDescendantOfA(
                anyOf<View>(
                    isAssignableFrom(ScrollView::class.java),
                    isAssignableFrom(HorizontalScrollView::class.java),
                    isAssignableFrom(ListView::class.java),
                    isAssignableFrom(NestedScrollView::class.java)
                )
            )
        )
    }

    override fun perform(uiController: UiController, view: View) {
        if (isDisplayingAtLeast(90).matches(view)) {
            Log.i(TAG, "View is already displayed. Returning.")
            return
        }
        val rect = Rect()
        view.getDrawingRect(rect)
        if (!view.requestRectangleOnScreen(rect, true)) {
            Log.w(TAG, "Scrolling to view was requested, but none of the parents scrolled.")
        }
        uiController.loopMainThreadUntilIdle()
        if (!isDisplayingAtLeast(90).matches(view)) {
            throw PerformException.Builder()
                .withActionDescription(this.description)
                .withViewDescription(HumanReadables.describe(view))
                .withCause(
                    RuntimeException(
                        "Scrolling to view was attempted, but the view is not displayed"
                    )
                )
                .build()
        }
    }

    override fun getDescription(): String {
        return "scroll to"
    }
}