package com.example.diagonalprogram.ui.catalog

import androidx.recyclerview.widget.DiffUtil
import com.example.diagonalprogram.R
import com.example.diagonalprogram.data.model.ContentItem
import com.example.diagonalprogram.ui.base.adapter.BaseListAdapter
import com.example.diagonalprogram.ui.base.adapter.BaseViewHolder

class MainAdapter(val listener: MainNavigator) :
    BaseListAdapter<ContentItem>(ConnectionDiffCallback()) {

    override fun getLayoutIdForPosition(position: Int): Int = R.layout.item_movie

    override fun onBindViewHolder(holder: BaseViewHolder<ContentItem>, position: Int) {
        super.onBindViewHolder(holder, position)
    }

    class ConnectionDiffCallback : DiffUtil.ItemCallback<ContentItem>() {
        override fun areItemsTheSame(oldItem: ContentItem, newItem: ContentItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ContentItem, newItem: ContentItem): Boolean {
            return oldItem == newItem
        }
    }

    override fun getCallbackForPosition(position: Int): Any {
        return listener
    }
}