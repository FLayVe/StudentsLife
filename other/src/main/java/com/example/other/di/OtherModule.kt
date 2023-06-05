package com.example.other.di

import dagger.Module

@Module(
    includes = [
        OtherFragmentModule::class
    ]
)
interface OtherModule