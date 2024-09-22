package com.mert.news

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.cancel

actual open class BaseViewModel {

    actual val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.IO)

    fun clear() {
        coroutineScope.cancel()
    }
}