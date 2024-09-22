package com.mert.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

actual open class BaseViewModel: ViewModel() {

    actual val coroutineScope = viewModelScope
}