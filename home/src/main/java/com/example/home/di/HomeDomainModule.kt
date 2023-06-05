package com.example.home.di

import dagger.Module

@Module(
    includes = [
        HomeUseCaseModule::class
    ]
)
interface HomeDomainModule {
}