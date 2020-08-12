package com.example.diagonalprogram

import android.content.Context
import androidx.multidex.MultiDex
import com.example.diagonalprogram.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class ApplicationClass : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.builder().application(this).build()
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        try {
            MultiDex.install(this)
        } catch (multiDexException: RuntimeException) {
            multiDexException.printStackTrace()
        }
    }
}