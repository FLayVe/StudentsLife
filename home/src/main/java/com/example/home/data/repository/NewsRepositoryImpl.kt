package com.example.home.data.repository

import com.example.home.data.api.NewsApi
import com.example.home.data.factory.NewsFactory
import com.example.home.domain.model.News
import com.example.home.domain.repository.NewsRepository
import io.reactivex.Single
import javax.inject.Inject

internal class NewsRepositoryImpl
@Inject constructor(
    private val newsFactory: NewsFactory
    private val newsApi: NewsApi
): NewsRepository {
    override fun getNews(): Single<List<News>> {
        return newsApi.getNews().map {
            it.map {
                newsFactory.get(it)
            }
        }
    }
}