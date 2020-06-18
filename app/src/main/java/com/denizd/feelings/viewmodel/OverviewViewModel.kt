package com.denizd.feelings.viewmodel

import androidx.lifecycle.LiveData
import com.denizd.feelings.model.Entry

class OverviewViewModel : BaseViewModel() {

    val allEntries: LiveData<List<Entry>> = repo.db.allEntries
}