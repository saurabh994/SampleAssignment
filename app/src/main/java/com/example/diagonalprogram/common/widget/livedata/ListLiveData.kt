package com.example.diagonalprogram.common.widget.livedata

import androidx.lifecycle.MutableLiveData

class ListLiveData<T> : MutableLiveData<MutableList<T>>() {

    init {
        value = mutableListOf()
    }

    fun get(pos: Int): T? {
        return try {
            value?.get(pos)
        } catch (e: Exception) {
            null
        }
    }

    fun addAll(items: List<T>) {
        value?.apply {
            addAll(items)
            notify()
        }
    }

    fun clear() {
        value?.apply {
            clear()
            notify()
        }
    }

    val size: Int get() = value?.size ?: 0
}

