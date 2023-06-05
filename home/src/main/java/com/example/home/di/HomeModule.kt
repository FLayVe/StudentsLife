package com.example.home.di

import dagger.Module

@Module(
    includes = [
        NewsFragmentModule::class,
        HomeDomainModule::class,
        HomeViewModelModule::class
    ]
)
interface HomeModule