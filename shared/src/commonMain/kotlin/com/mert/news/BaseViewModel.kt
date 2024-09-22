package com.mert.news

import kotlinx.coroutines.CoroutineScope

expect open class BaseViewModel() {

    val coroutineScope: CoroutineScope
}