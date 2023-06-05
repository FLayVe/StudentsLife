package com.example.home.domain.usecases.impl

import com.example.home.domain.model.News
import com.example.home.domain.repository.NewsRepository
import com.example.home.domain.usecases.GetNewsUseCase
import io.reactivex.Single
import javax.inject.Inject

class GetNewsUseCaseImpl
@Inject constructor(
    private val newsRepository: NewsRepository
): GetNewsUseCase{

    override fun execute(): Single<List<News>> {
        return newsRepository.getNews()
    }

}