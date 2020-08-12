package com.example.diagonalprogram.common.widget.livedata

import androidx.lifecycle.*


fun <T> MutableLiveData<T>.notify() {
    value = value
}