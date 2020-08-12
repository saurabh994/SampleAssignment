package com.example.diagonalprogram.ui.catalog

import android.content.res.Configuration
import android.graphics.Typeface
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.SearchView.SearchAutoComplete
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.diagonalprogram.R
import com.example.diagonalprogram.common.utils.EndlessRecyclerViewScrollListener
import com.example.diagonalprogram.common.utils.GridSpacingItemDecoration
import com.example.diagonalprogram.common.widget.HzSearchView
import com.example.diagonalprogram.data.model.ContentItem
import com.example.diagonalprogram.databinding.ActivityMainBinding
import com.example.diagonalprogram.ui.base.activity.BaseActivity
import com.jakewharton.rxbinding3.appcompat.queryTextChangeEvents
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import java.util.concurrent.TimeUnit


class MainActivity : BaseActivity<ActivityMainBinding, MainActivityViewModel>(),MainNavigator {
    override val layoutViewRes: Int = R.layout.activity_main

    override val viewModelClass: Class<MainActivityViewModel> = MainActivityViewModel::class.java

    private val mainAdapter by lazy {
        MainAdapter(this)
    }

    private var menuSearch: MenuItem? = null

    override fun onViewCreated() {
        super.onViewCreated()
        setToolbar(toolbar)
        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT
        ) {
            recycler.addItemDecoration(
                GridSpacingItemDecoration(
                    3,
                    resources.getDimensionPixelOffset(R.dimen.vertical_space_detail),
                    true
                )
            )
            recycler.layoutManager = GridLayoutManager(this, 3)
        } else {
            recycler.addItemDecoration(
                GridSpacingItemDecoration(
                    7,
                    resources.getDimensionPixelOffset(R.dimen.vertical_space_detail),
                    true
                )
            )
            recycler.layoutManager = GridLayoutManager(this, 7)
        }
        recycler.adapter = mainAdapter

     recycler.addOnScrollListener(object  : EndlessRecyclerViewScrollListener(recycler.layoutManager as GridLayoutManager){
         override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
             viewModel.loadJson(page)
         }

     })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_search, menu)
        menuSearch = menu?.findItem(R.id.action_search)
        (menu?.findItem(R.id.action_search)?.actionView as HzSearchView).apply {
            setExpandListener(object : HzSearchView.HzSearchViewListener {
                override fun onCollapseView() {
                    menuSearch?.icon = ContextCompat.getDrawable(this@MainActivity, R.drawable.search1)
                }

                override fun onExpandView() {
                    menuSearch?.icon = ContextCompat.getDrawable(this@MainActivity, R.drawable.search_cancel)
                }
            })
            queryTextChangeEvents()
                .debounce(1, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                .subscribe {
                    viewModel.onSearchQueryTextChange(it.queryText.toString())
                }
        }
        return super.onCreateOptionsMenu(menu)
    }

    override fun onViewModelCreated() {
        super.onViewModelCreated()
        viewModel.filteredMovieList.observe(this, Observer {
            mainAdapter.submitList(it)
        })
        viewModel.title.observe(this, Observer {
                if (layout_toolbar.findViewById<TextView>(R.id.tv_title)!=null)
            layout_toolbar.findViewById<TextView>(R.id.tv_title).text = it
        })
    }

    override fun onClickItem(position: Int, avatar: ContentItem) {
    }
}