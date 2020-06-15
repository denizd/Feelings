package com.denizd.feelings.data

import android.content.Context

object Dependencies {

    lateinit var repo: AppRepository

    fun init(context: Context) {
        repo = AppRepository.init(context)
    }
}