package me.cafecode.android.newspaper.data.models

import java.util.*

data class News(var author: String? = null,
                var title: String? = null,
                var description: String? = null,
                var url: String? = null,
                var urlToImage: String? = null,
                var publishedAt: Date? = null)
