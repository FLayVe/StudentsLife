package com.example.home.di

import com.example.home.presentation.ui.NewsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface NewsFragmentModule {

    @ContributesAndroidInjector
    fun provideNewsFragment(): NewsFragment
}