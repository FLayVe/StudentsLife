package com.example.home.di

import com.example.home.ui.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface HomeFragmentModule {

    @ContributesAndroidInjector
    fun provideHomeFragment(): HomeFragment
}