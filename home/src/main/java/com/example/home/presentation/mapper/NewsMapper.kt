package com.example.home.presentation.mapper

import com.example.home.BR
import com.example.home.R
import com.example.home.domain.model.News
import com.example.home.presentation.viewState.NewsViewState
import com.studentslife.ui.model.RecyclerItem
import javax.inject.Inject

internal class NewsMapper
@Inject constructor()
{
    fun toViewState(news: News) = NewsViewState(
        news.title,
        news.imageUrl,
        news.creator,
        news.text
    )

    fun toRecyclerItem(news: NewsViewState) = RecyclerItem(
        news,
        R.layout.item_news,
        BR.news
    )
}