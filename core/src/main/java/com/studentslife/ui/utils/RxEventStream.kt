package com.studentslife.ui.utils

import io.reactivex.subjects.BehaviorSubject
import io.reactivex.Observable
import javax.inject.Inject

class RxEventStream<T>

@Inject
constructor(){

    private val subject: BehaviorSubject<T> = BehaviorSubject.create()

    fun post(data: T){
        subject.onNext(data!!)
    }

    fun stream(): Observable<T> = subject.hide()
}