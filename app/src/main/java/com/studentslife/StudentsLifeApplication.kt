package com.studentslife

import android.app.Application
import com.studentslife.di.component.AppComponent
import com.studentslife.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class  StudentsLifeApplication: Application(), HasAndroidInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Any>

    private val appComponent: AppComponent =  DaggerAppComponent.factory().create(this)

    override fun androidInjector(): AndroidInjector<Any> {
        return activityInjector
    }

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }
}