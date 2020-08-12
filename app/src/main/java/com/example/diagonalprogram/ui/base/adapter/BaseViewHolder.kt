package com.example.diagonalprogram.ui.base.adapter

import androidx.databinding.ViewDataBinding
import com.example.diagonalprogram.BR
import androidx.recyclerview.widget.RecyclerView

class BaseViewHolder<T>(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: T, callbackForPosition: Any) {
        binding.setVariable(BR.item, item)
        binding.executePendingBindings()
    }

    fun getBinding(): ViewDataBinding = binding
}
