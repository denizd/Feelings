package com.denizd.feelings.data

import android.content.Context

class AppRepository private constructor(context: Context) {

    val db: AppDao = AppDatabase.build(context).dao()

    companion object {
        private lateinit var instance: AppRepository
        fun init(context: Context): AppRepository {
            instance = AppRepository(context)
            return instance
        }
        fun get(): AppRepository = instance
    }
}