package com.example.diagonalprogram.ui.base.viewmodel.factory

import androidx.lifecycle.ViewModel
import com.example.diagonalprogram.di.scope.ActivityScope
import com.example.diagonalprogram.ui.base.viewmodel.BaseActivityViewModel
import javax.inject.Inject
import javax.inject.Provider

@ActivityScope
class ActivityViewModelFactory @Inject constructor(creators: Map<Class<out BaseActivityViewModel>,
        @JvmSuppressWildcards Provider<BaseActivityViewModel>>) :
    BaseViewModelFactory(creators as Map<Class<out ViewModel>, Provider<ViewModel>>)