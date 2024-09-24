package com.mert.news.articles.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticlesResponse (
    @SerialName("status")
    val status: String?,
    @SerialName("totalResults")
    val totalResults: Int?,
    @SerialName("articles")
    val listOfArticles: List<ArticleRaw>?
)