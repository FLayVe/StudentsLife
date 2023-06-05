package com.studentslife.ui.utils

import androidx.annotation.MainThread
import androidx.annotation.Nullable
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import java.util.concurrent.atomic.AtomicBoolean

class SingleLiveEvent<T> : MutableLiveData<T>() {

    private val mPending = AtomicBoolean(false)

    @MainThread
    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {

        if (hasActiveObservers()) {
            throw IllegalStateException("Multiple observers registered")
        }

        super.observe(owner, Observer<T>{ it ->
            if (mPending.compareAndSet(true, false)){
                observer.onChanged(it)
            }
        })
    }

    @MainThread
    override fun setValue(@Nullable value: T) {
        mPending.set(true)
        super.setValue(value)
    }
}