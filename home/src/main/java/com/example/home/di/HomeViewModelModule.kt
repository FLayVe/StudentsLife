package com.example.home.di

import androidx.lifecycle.ViewModel
import com.example.home.presentation.viewModel.NewsViewModel
import com.studentslife.ui.viewModel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal interface HomeViewModelModule {
    @Binds
    @[IntoMap ViewModelKey(NewsViewModel::class)]
    fun provideNewsViewModel(viewModel: NewsViewModel): ViewModel
}