package com.example.chat.di

import dagger.Module

@Module(
    includes = [
        ChatFragmentModule::class,
        ChatViewModelModule::class
    ]
)
interface ChatModule