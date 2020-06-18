package com.denizd.feelings.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.denizd.feelings.model.Entry

@Dao
interface AppDao {

    @get:Query("SELECT * FROM entry ORDER BY time")
    val allEntries: LiveData<List<Entry>>

    @Insert
    fun insert(entry: Entry)
}