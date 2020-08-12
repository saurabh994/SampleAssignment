package com.example.diagonalprogram.common.widget

import android.content.Context
import android.graphics.Typeface
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.SearchView


class HzSearchView(context: Context) : SearchView(context) {
    private var hzSearchViewListener: HzSearchViewListener? = null

    init {
        textAlignment = View.TEXT_ALIGNMENT_VIEW_START
        textDirection = View.TEXT_DIRECTION_LOCALE
        maxWidth = Integer.MAX_VALUE
    }

    fun setExpandListener(listener: HzSearchViewListener) {
        hzSearchViewListener = listener
    }

    override fun onActionViewCollapsed() {
        super.onActionViewCollapsed()
        hzSearchViewListener?.onCollapseView()
    }

    override fun onActionViewExpanded() {
        super.onActionViewExpanded()
        hzSearchViewListener?.onExpandView()
    }

    interface HzSearchViewListener {
        fun onCollapseView()
        fun onExpandView()
    }
}
