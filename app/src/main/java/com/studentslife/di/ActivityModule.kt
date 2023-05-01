package com.studentslife.di

import com.studentslife.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal interface ActivityModule{
    @ContributesAndroidInjector
    fun mainActivity(): MainActivity
}