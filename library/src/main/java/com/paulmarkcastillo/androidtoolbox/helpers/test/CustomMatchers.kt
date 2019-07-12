package com.paulmarkcastillo.androidtoolbox.helpers.test

import android.text.SpannableString
import android.text.style.ClickableSpan
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.BoundedMatcher
import com.google.android.material.textfield.TextInputLayout
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.TypeSafeMatcher

class CustomMatchers {

    companion object {
        fun withErrorText(expectedErrorText: String): Matcher<View> {
            return object : TypeSafeMatcher<View>() {

                override fun matchesSafely(view: View): Boolean {
                    if (view !is TextInputLayout) {
                        return false
                    }

                    val error = (view).error ?: return false

                    val hint = error.toString()

                    return expectedErrorText == hint
                }

                override fun describeTo(description: Description) {
                    description.appendText("with error  content: $expectedErrorText")
                }
            }
        }

        fun withHintText(expectedHintText: String): Matcher<View> {
            return object : TypeSafeMatcher<View>() {

                override fun matchesSafely(view: View): Boolean {
                    if (view !is TextInputLayout) {
                        return false
                    }

                    val hint = (view).hint ?: return false

                    val hintText = hint.toString()

                    return expectedHintText == hintText
                }

                override fun describeTo(description: Description) {
                    description.appendText("with hint text: $expectedHintText")
                }
            }
        }

        fun clickChildViewWithId(id: Int): ViewAction {
            return object : ViewAction {
                override fun getConstraints(): Matcher<View>? {
                    return null
                }

                override fun getDescription(): String {
                    return "Click on a child view with specified id."
                }

                override fun perform(uiController: UiController, view: View) {
                    val v = view.findViewById<View>(id)
                    v.performClick()
                }
            }
        }

        fun typeTextWithID(id: Int, text: String): ViewAction {
            return object : ViewAction {
                override fun getConstraints(): Matcher<View>? {
                    return null
                }

                override fun getDescription(): String {
                    return "Click on a child view with specified id."
                }

                override fun perform(uiController: UiController, view: View) {
                    val v = view.findViewById<EditText>(id)
                    v.setText(text)
                }
            }
        }

        fun withViewAtPosition(position: Int, itemMatcher: Matcher<View>): Matcher<View> {
            return object : BoundedMatcher<View, RecyclerView>(RecyclerView::class.java) {
                override fun describeTo(description: Description) {
                    itemMatcher.describeTo(description)
                }

                override fun matchesSafely(recyclerView: RecyclerView): Boolean {
                    val viewHolder = recyclerView.findViewHolderForAdapterPosition(position)
                    return viewHolder != null && itemMatcher.matches(viewHolder.itemView)
                }
            }
        }

        fun withItemCount(count: Int): Matcher<View> {
            return object : BoundedMatcher<View, RecyclerView>(RecyclerView::class.java) {
                override fun describeTo(description: Description?) {
                    description?.appendText("RecyclerView with item count: $count")
                }

                override fun matchesSafely(item: RecyclerView?): Boolean {
                    return item?.adapter?.itemCount == count
                }
            }
        }

        fun withRecyclerView(recyclerViewId: Int): RecyclerViewMatcher {
            return RecyclerViewMatcher(recyclerViewId)
        }

        fun clickClickableSpan(textToClick: CharSequence): ViewAction {
            return object : ViewAction {
                override fun getConstraints(): Matcher<View> {
                    return Matchers.instanceOf(TextView::class.java)
                }

                override fun getDescription(): String {
                    return "clicking on a ClickableSpan"
                }

                override fun perform(uiController: UiController, view: View) {
                    val textView = view as TextView
                    val spannableString = textView.text as SpannableString

                    if (spannableString.isEmpty()) {
                        // TextView is empty, nothing to do
                        throw NoMatchingViewException.Builder()
                            .includeViewHierarchy(true)
                            .withRootView(textView)
                            .build()
                    }

                    // Get the links inside the TextView and check if we find textToClick
                    val spans = spannableString.getSpans(
                        0,
                        spannableString.length,
                        ClickableSpan::class.java
                    )
                    if (spans.isNotEmpty()) {
                        var spanCandidate: ClickableSpan
                        for (span in spans) {
                            spanCandidate = span
                            val start = spannableString.getSpanStart(spanCandidate)
                            val end = spannableString.getSpanEnd(spanCandidate)
                            val sequence = spannableString.subSequence(start, end)
                            if (textToClick.toString() == sequence.toString()) {
                                span.onClick(textView)
                                return
                            }
                        }
                    }

                    // textToClick not found in TextView
                    throw NoMatchingViewException.Builder()
                        .includeViewHierarchy(true)
                        .withRootView(textView)
                        .build()

                }
            }
        }
    }
}