package com.example.diagonalprogram.di.component

import com.example.diagonalprogram.ApplicationClass
import com.example.diagonalprogram.di.module.ApplicationModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent : AndroidInjector<ApplicationClass> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: ApplicationClass): Builder

        fun build(): ApplicationComponent
    }
}
