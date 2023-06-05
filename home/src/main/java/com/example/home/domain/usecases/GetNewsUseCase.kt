package com.example.home.domain.usecases

import com.example.home.domain.model.News
import io.reactivex.Single

interface GetNewsUseCase{
    fun execute():  Single<List<News>>
}