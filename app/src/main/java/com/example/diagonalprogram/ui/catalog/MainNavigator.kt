package com.example.diagonalprogram.ui.catalog

import com.example.diagonalprogram.data.model.ContentItem

interface MainNavigator {
    fun onClickItem(position: Int, avatar: ContentItem)
}