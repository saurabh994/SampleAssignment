package com.example.diagonalprogram.di.module

import android.app.Application
import android.content.Context
import com.example.diagonalprogram.ApplicationClass
import com.example.diagonalprogram.di.qualifier.ApplicationContext
import dagger.Binds
import dagger.Module
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Module(
    includes = [AndroidSupportInjectionModule::class,ActivityBuilderModule::class]
)
abstract class ApplicationModule {
    @Binds
    @Singleton
    abstract fun bindApplication(application: ApplicationClass): Application

    @Binds
    @Singleton
    @ApplicationContext
    abstract fun bindApplicationContext(application: Application): Context
}
