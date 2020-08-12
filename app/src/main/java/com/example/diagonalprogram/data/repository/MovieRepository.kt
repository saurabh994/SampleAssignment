package com.example.diagonalprogram.data.repository

import android.content.Context
import com.example.diagonalprogram.common.utils.JSONUtils
import com.example.diagonalprogram.data.model.ContentItem
import com.example.diagonalprogram.data.response.MovieResponse
import com.example.diagonalprogram.data.response.Page
import com.example.diagonalprogram.di.qualifier.ApplicationContext
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.reactivex.Single
import javax.inject.Inject

class MovieRepository @Inject constructor(@param:ApplicationContext private val context: Context) {
     fun loadMovies(fileName: String):Single<Page> =
            Single.create {
            val data = JSONUtils.loadAssetsJsonObject(
                context,
                fileName
            ).toString()
                println("====gson" + (Gson().fromJson<Page>(
                    data,
                    object : TypeToken<Page>() {}.type
                )))
                it.onSuccess(Gson().fromJson<Page>(
                    data,
                    object : TypeToken<Page>() {}.type
                ))
            }
    }