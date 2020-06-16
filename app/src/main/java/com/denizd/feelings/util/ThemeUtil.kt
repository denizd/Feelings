package com.denizd.feelings.util

import android.content.Context
import android.graphics.Color
import com.denizd.feelings.R

fun Context.getTextColor(background: Int): Int =
    getColor(if (((0.299 * Color.red(background) +
          0.587 * Color.green(background) +
          0.114 * Color.blue(background)) / 255) > 0.5) {
        R.color.colorTextDark
    } else {
        R.color.colorTextLight
    })