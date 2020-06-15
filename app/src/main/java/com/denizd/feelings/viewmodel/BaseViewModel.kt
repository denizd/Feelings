package com.denizd.feelings.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.denizd.feelings.data.AppRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

abstract class BaseViewModel : ViewModel() {

    protected val repo: AppRepository = AppRepository.get()

    protected fun doAsync(func: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            func()
        }
    }
    protected fun <T> returnBlocking(func: () -> T) = runBlocking(Dispatchers.IO) { func() }
}