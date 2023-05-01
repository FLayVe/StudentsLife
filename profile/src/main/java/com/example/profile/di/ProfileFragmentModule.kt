package com.example.profile.di

import com.example.profile.ui.ProfileFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ProfileFragmentModule {

    @ContributesAndroidInjector
    fun provideProfileModule(): ProfileFragment
}