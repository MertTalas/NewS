package com.mert.news.articles

import com.mert.news.BaseViewModel
import com.mert.news.articles.api.ArticlesService
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class ArticlesViewModel: BaseViewModel() {

    private val _articlesState: MutableStateFlow<ArticlesState> = MutableStateFlow(ArticlesState(loading = true))
    val articlesState: StateFlow<ArticlesState> get() = _articlesState

    private val useCase: ArticlesUseCase

    init {
        val httpClient = HttpClient {
            install(ContentNegotiation){
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
        }

        val service = ArticlesService(httpClient)
        useCase = ArticlesUseCase(service)
        getArticles()
    }

    private fun getArticles() {
        coroutineScope.launch {
            val articles = useCase.getArticles()
            _articlesState.value = ArticlesState(articles)
        }
    }
}
