package com.example.diagonalprogram.ui.catalog

import androidx.lifecycle.MutableLiveData
import com.example.diagonalprogram.common.extension.applyIoScheduler
import com.example.diagonalprogram.common.extension.disposeWith
import com.example.diagonalprogram.common.widget.livedata.ListLiveData
import com.example.diagonalprogram.data.model.ContentItem
import com.example.diagonalprogram.data.repository.MovieRepository
import com.example.diagonalprogram.di.scope.ActivityScope
import com.example.diagonalprogram.ui.base.viewmodel.BaseActivityViewModel
import javax.inject.Inject

@ActivityScope
class MainActivityViewModel @Inject constructor(private val movieRepository: MovieRepository): BaseActivityViewModel() {
    val movieList = ListLiveData<ContentItem>()
    val filteredMovieList = ListLiveData<ContentItem>()
    val title = MutableLiveData<String>()
    val isLoading = MutableLiveData<Boolean>().apply { value=false }

    override fun handleCreate() {
        super.handleCreate()
         movieList.clear()
         loadJson(0)
    }

    fun loadJson(page: Int) {
            var fileName = ""
            fileName = when(page){
                0 -> "content-1.json"
                1 -> "content-2.json"
                2 -> "content-3.json"
                else -> ""
            }
            movieRepository.loadMovies(fileName)
                .applyIoScheduler().doOnSubscribe{isLoading.value = true }
                .doOnTerminate{isLoading.value = false}
                .subscribe({ next ->
                        title.value = next.title?:""
                        next.contentItems?.content.let {
                        if (it != null) {
                            movieList.addAll(it)
                            filteredMovieList.value = movieList.value
                        }
                    }
                }, { error ->
                })
                .disposeWith(compositeDisposable)
    }

    fun onSearchQueryTextChange(newText: String?) {
        if (newText?.length!! >=3 || newText.isEmpty()) {
            if (newText.isNullOrEmpty()) {
                filteredMovieList.value = movieList.value
            }
            else {
                filteredMovieList.value = movieList.value?.filter {
                    it.name?.contains(newText, true)!!
                } as MutableList<ContentItem>
            }
        }
    }
}