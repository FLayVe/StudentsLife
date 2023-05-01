package com.example.chat.di

import com.example.chat.ui.ChatsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ChatFragmentModule {

    @ContributesAndroidInjector
    fun provideChatsFragment(): ChatsFragment
}