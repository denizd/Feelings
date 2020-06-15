package com.denizd.feelings.data

import androidx.room.Dao
import androidx.room.Insert
import com.denizd.feelings.model.Feeling

@Dao
interface AppDao {

    @Insert
    fun insert(feeling: Feeling)
}