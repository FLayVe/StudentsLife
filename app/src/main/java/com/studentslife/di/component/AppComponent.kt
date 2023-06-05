package com.studentslife.di.component

import android.content.Context
import com.example.chat.di.ChatModule
import com.example.home.di.HomeModule
import com.example.other.di.OtherModule
import com.example.profile.di.ProfileModule
import com.studentslife.StudentsLifeApplication
import com.studentslife.di.*
import com.studentslife.di.ActivityModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules =
    [
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        ActivityModule::class,
        CoreModule::class,
        HomeModule::class,
        ChatModule::class,
        ProfileModule::class,
        OtherModule::class
    ]
)

interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(application: StudentsLifeApplication)
}