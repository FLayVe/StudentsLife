package com.example.chat.di

import androidx.lifecycle.ViewModel
import com.example.chat.ui.ChatsViewModel
import com.studentslife.ui.viewModel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ChatViewModelModule {
    @Binds
    @[IntoMap ViewModelKey(ChatsViewModel::class)]
    fun provideChatsViewModel(viewModel: ChatsViewModel): ViewModel
}