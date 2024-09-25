package com.mert.news.android

import android.app.Application
import com.mert.news.android.di.viewModelsModule
import com.mert.news.articles.di.sharedKoinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class NewSApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        val modules = sharedKoinModules + viewModelsModule

        startKoin {
            androidContext(this@NewSApplication)
            modules(modules)
        }
    }
}