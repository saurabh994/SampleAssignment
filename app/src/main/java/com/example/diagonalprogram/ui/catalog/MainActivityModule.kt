package com.example.diagonalprogram.ui.catalog

import androidx.appcompat.app.AppCompatActivity
import com.example.diagonalprogram.di.key.ActivityViewModelKey
import com.example.diagonalprogram.di.scope.ActivityScope
import com.example.diagonalprogram.ui.base.activity.BaseActivityModule
import com.example.diagonalprogram.ui.base.viewmodel.BaseActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module(includes = [BaseActivityModule::class])
abstract class MainActivityModule {
    @Binds
    @ActivityScope
    abstract fun bindActivity(activity: MainActivity): AppCompatActivity

    @Binds
    @IntoMap
    @ActivityViewModelKey(MainActivityViewModel::class)
    @ActivityScope
    abstract fun bindViewModel(viewModel: MainActivityViewModel): BaseActivityViewModel
}