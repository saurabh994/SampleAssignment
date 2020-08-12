package com.example.diagonalprogram.data.response

import com.example.diagonalprogram.data.model.ContentItem

data class MovieResponse(
    val page: Page? = null
)

data class ContentItems(
    val content: List<ContentItem>? = null
)

data class Page(
    val title: String? = null,
    val totalContentItems: String? = null,
    val pageNum: String? = null,
    val pageSize: String? = null,
    val contentItems: ContentItems? = null
)