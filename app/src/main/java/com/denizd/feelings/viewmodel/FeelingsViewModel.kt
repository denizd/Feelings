package com.denizd.feelings.viewmodel

import com.denizd.feelings.model.Feeling

class FeelingsViewModel : BaseViewModel() {

    fun insert(rating: Int, reason: String) = doAsync { repo.db.insert(Feeling(rating, reason)) }
}