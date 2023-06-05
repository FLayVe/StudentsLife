package com.example.home.data.api

import com.example.home.domain.model.News
import io.reactivex.Single
import retrofit2.http.GET

internal interface NewsApi {
    fun getNews(): Single<List<News>>
}