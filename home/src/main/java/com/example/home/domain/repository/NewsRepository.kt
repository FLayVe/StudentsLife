package com.example.home.domain.repository

import androidx.lifecycle.LiveData
import com.example.home.domain.model.News
import io.reactivex.Single

interface NewsRepository {
    fun getNews(): Single<List<News>>
}