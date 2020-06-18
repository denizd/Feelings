package com.denizd.feelings.util

import android.content.Context
import android.graphics.Color
import com.denizd.feelings.R

/**
 * Checks the luminosity of a colour to determine whether it can be considered a "light" colour
 * which contrasts dark colours
 *
 * @receiver the colour to be checked
 * @return whether the colour can be considered light
 */
fun Int.isLight(): Boolean = ((0.299 * Color.red(this) +
        0.587 * Color.green(this) +
        0.114 * Color.blue(this)) / 255) > 0.5

/**
 * Does the opposite of Int#isLight; checks if the colour is "dark" and can contrast light colours
 *
 * @receiver the colour to be checked
 * @return whether the colour can be considered dark
 */
fun Int.isDark(): Boolean = !isLight()

/**
 * Returns an appropriate text colour based on the luminosity of the parameter using Int#isLight
 *
 * @receiver used to resolve return colour
 * @param colour the colour to be checked
 * @return the resolved colour
 */
fun Context.getTextColor(colour: Int): Int =
    getColor(if (colour.isLight()) {
        R.color.colorTextDark
    } else {
        R.color.colorTextLight
    })