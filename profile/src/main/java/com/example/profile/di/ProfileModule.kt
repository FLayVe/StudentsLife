package com.example.profile.di

import dagger.Module

@Module(
    includes = [
        ProfileFragmentModule::class
    ]
)
interface ProfileModule