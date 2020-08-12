package com.example.diagonalprogram.di.module

import com.example.diagonalprogram.di.scope.ActivityScope
import com.example.diagonalprogram.ui.catalog.MainActivity
import com.example.diagonalprogram.ui.catalog.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    @ActivityScope
    abstract fun contributeUploadActivity(): MainActivity
}