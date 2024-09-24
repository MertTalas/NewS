package com.mert.news.articles

import com.mert.news.articles.api.ArticleRaw
import com.mert.news.articles.api.ArticlesService

class ArticlesUseCase(private val service: ArticlesService) {

    suspend fun getArticles(): List<Article> {
        val articleRaw = service.fetchArticles()
        return mapArticles(articleRaw)
    }

    private fun mapArticles(articleRaw: List<ArticleRaw>): List<Article> = articleRaw.map{
        Article(
            title = it.title ?: "Title can not be displayed",
            description = it.description ?: "Click to find out more",
            date = it.publishedAt ?: "Date can not be known",
            imgUrl = it.urlToImage ?: "There is no image for this article"
        )
    }
}