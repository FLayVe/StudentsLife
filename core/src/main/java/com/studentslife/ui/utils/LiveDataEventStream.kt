package com.studentslife.ui.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

class LiveDataEventStream <T> @Inject constructor() {

    private val liveData = MutableLiveData<T>()

    fun post(data: T) {
        liveData.value = data!!
    }

    fun stream(): LiveData<T> = liveData

    fun value(): T? = liveData.value

}