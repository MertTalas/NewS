package com.mert.news.articles.di

import com.mert.news.articles.articlesModule

val sharedKoinModules = listOf(
    articlesModule,
    networkModule
)