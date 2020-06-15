package com.denizd.feelings.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.denizd.feelings.model.Feeling

@Database(entities = [Feeling::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun dao(): AppDao

    companion object {
        fun build(context: Context): AppDatabase = Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "feelings_db"
        ).build()
    }
}