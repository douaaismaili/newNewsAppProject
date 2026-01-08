package com.douaamohamed.newsapp.common.util

import com.douaamohamed.newsapp.data.database.entity.Article
import kotlin.collections.filterNot

fun List<Article>.filterArticles(): List<Article> {
    return this.filterNot { article ->
        article.title.isNullOrEmpty() || article.description.isNullOrEmpty() || article.urlToImage.isNullOrEmpty()
    }
}