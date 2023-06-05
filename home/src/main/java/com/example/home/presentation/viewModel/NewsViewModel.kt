package com.example.home.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.home.domain.model.News
import com.example.home.domain.usecases.GetNewsUseCase
import com.example.home.presentation.mapper.NewsMapper
import com.example.home.presentation.viewState.NewsViewState
import com.studentslife.ui.model.RecyclerItem
import com.studentslife.ui.utils.SingleLiveEvent
import com.studentslife.ui.viewModel.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

internal class NewsViewModel
@Inject constructor(
    private val getNewsUseCase: GetNewsUseCase,
    private val newsMapper: NewsMapper
) : BaseViewModel() {

    private val _events = SingleLiveEvent<Event>()
    val events: LiveData<Event> get() = _events

    private val _newsList = MutableLiveData<List<RecyclerItem>>()
    val newsList: LiveData<List<RecyclerItem>> get() = _newsList

    private val _progressBar = MutableLiveData<Boolean>()
    val progressBar: LiveData<Boolean> get() = _progressBar

    fun getNews() {
        compositeDisposible += getNewsUseCase.execute()
            .subscribeOn(Schedulers.io())
            .map {
                it.map {
                    newsMapper.toViewState(it).also {
                        compositeDisposible += it.events.subscribeBy(
                            onNext = {
                                onNewsViewStateEvent(it)
                            }
                        )
                    }
                }
            }
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { _progressBar.value = true }
            .doFinally { _progressBar.value = false }
            .subscribeBy(
                onSuccess = {
                    _newsList.value = it.map {
                        newsMapper.toRecyclerItem(it)
                    }
            },
                onError = {
                    _events.setValue(Event.OnError(it))
                }
            )

    }

    private fun onNewsViewStateEvent(event: NewsViewState.Event) {
        when (event) {
            is NewsViewState.Event.OnNewsClick -> {
                _events.setValue(Event.OpenNews(event.name))
            }
        }
    }

    sealed class Event {
        data class OpenNews(val newsTitle: String) : Event()
        data class ShowToast(val text: String) : Event()
        data class OnError(
            val throwable: Throwable,
            val description: String? = null
        ) : Event()
    }
}