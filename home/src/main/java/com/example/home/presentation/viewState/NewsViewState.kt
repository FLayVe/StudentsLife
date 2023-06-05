package com.example.home.presentation.viewState

import com.studentslife.ui.adapter.comporator.RecyclerItemComparator
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

internal class NewsViewState(
    val title: String,
    val url: String,
    val creator: String,
    val text: String
) : RecyclerItemComparator {

    sealed class Event {
        data class OnNewsClick(val name:String) : Event()
    }

    private val uiEvent = PublishSubject.create<Event>()
    val events: Observable<Event> = uiEvent.hide()

    fun onNewsClick(name: String){
        uiEvent.onNext(Event.OnNewsClick(name))
    }

    override fun isSameItem(other: Any): Boolean {
        if (this == other) return true
        if (javaClass !=  other.javaClass) return false

        return title == (other as NewsViewState).title
    }

    override fun isSameContent(other: Any): Boolean {
        other as NewsViewState
        return (title == other.title &&
                url == other.url &&
                creator == other.creator &&
                text == other.text)
    }

}