package com.denizd.feelings.viewmodel

import com.denizd.feelings.model.Entry

class EntryViewModel : BaseViewModel() {

    fun insert(rating: Int, reason: String) = doAsync { repo.db.insert(Entry(rating, reason)) }
}