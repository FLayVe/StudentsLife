package com.studentslife.ui.viewModel

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

open class BaseViewModel: ViewModel() {
    protected val compositeDisposible = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        compositeDisposible.dispose()
    }

}