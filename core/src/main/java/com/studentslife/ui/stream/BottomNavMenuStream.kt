package com.studentslife.ui.stream

import com.studentslife.ui.utils.LiveDataEventStream
import javax.inject.Inject

class BottomNavMenuStream @Inject constructor(stream: LiveDataEventStream<Boolean>){

    private val visibilityStream = stream

    fun post(visibility: Boolean) {
        visibilityStream.post(visibility)
    }

    fun stream() = visibilityStream.stream()

}