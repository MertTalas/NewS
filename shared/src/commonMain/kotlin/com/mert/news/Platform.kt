package com.mert.news

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform