package com.denizd.feelings.model

import android.content.Context
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.denizd.feelings.R

/**
 * Entries are rated from 0-4, labelled the following:
 * 0 -> awful
 * 1 -> bad
 * 2 -> neutral
 * 3 -> good
 * 4 -> fantastic
 */

@Entity
data class Entry(
    val rating: Int,
    val reason: String,
    val time: Long = System.currentTimeMillis(),
    @PrimaryKey(autoGenerate = true) val id: Long = 0
) {

    /**
     * Returns an emoji representing the feeling passed through the receiver
     *
     * @receiver the rating for a given feeling, see: [rating]
     * @param context used to resolve the string result
     * @return the feeling as an emoji
     */
    fun getEmoji(context: Context) = context.getString(when (rating) {
        0 -> R.string.feelings_awful
        1 -> R.string.feelings_bad
        2 -> R.string.feelings_neutral
        3 -> R.string.feelings_good
        else -> R.string.feelings_fantastic
    })
}