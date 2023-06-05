package com.example.other.di

import com.example.other.ui.OtherFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface OtherFragmentModule {

    @ContributesAndroidInjector
    fun provideOtherModule(): OtherFragment

}