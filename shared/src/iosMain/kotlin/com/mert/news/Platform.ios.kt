package com.mert.news

actual class Platform() {
    actual val osName: String
        get() = "UIDevice.currentDevice.systemName"
    actual val osVersion: String
        get() = "UIDevice.currentDevice.systemVersion"
    actual val deviceModel: String
        get() = "UIDevice.currentDevice.model"
    actual val density: Int
        get() = -1

    actual fun logSystemInfo() {

    }
}