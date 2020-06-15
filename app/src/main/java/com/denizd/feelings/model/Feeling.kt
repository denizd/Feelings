package com.denizd.feelings.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Feelings are rated from 0-4, labelled the following:
 * 0 -> awful
 * 1 -> bad
 * 2 -> neutral
 * 3 -> good
 * 4 -> fantastic
 */

@Entity
data class Feeling(
    val rating: Int,
    val reason: String,
    val time: Long = System.currentTimeMillis(),
    @PrimaryKey(autoGenerate = true) val id: Long = 0
)