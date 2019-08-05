package com.paulmarkcastillo.androidtoolbox.extensions

import android.content.Context
import androidx.appcompat.app.AlertDialog

fun Context?.showAlertDialog(
    title: String?,
    message: String?,
    cancelable: Boolean = false,
    positiveButtonText: String = "",
    positiveButtonFunction: () -> Unit = {},
    negativeButtonText: String = "",
    negativeButtonFunction: () -> Unit = {}
) {
    if (this == null) return
    val alertDialog = AlertDialog.Builder(this)
        .setTitle(title ?: "")
        .setMessage(message ?: "")
        .setCancelable(cancelable)
        .create()

    if (positiveButtonText.isNotEmpty()) {
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, positiveButtonText) { dialog, _ ->
            dialog.dismiss()
            positiveButtonFunction.invoke()
        }
    }

    if (negativeButtonText.isNotEmpty()) {
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, negativeButtonText) { dialog, _ ->
            dialog.dismiss()
            negativeButtonFunction.invoke()
        }
    }
    alertDialog.show()
}