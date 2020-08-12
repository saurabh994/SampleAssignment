package com.example.diagonalprogram.common.extension

import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


fun Disposable.disposeWith(compositeDisposable: CompositeDisposable?) =
    compositeDisposable?.add(this)

//Single
fun <T> Single<T>.applyIoScheduler() = applyScheduler(Schedulers.io())

private fun <T> Single<T>.applyScheduler(scheduler: Scheduler) =
    subscribeOn(scheduler).observeOn(AndroidSchedulers.mainThread())