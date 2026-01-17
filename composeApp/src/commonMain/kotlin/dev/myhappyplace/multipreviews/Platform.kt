package dev.myhappyplace.multipreviews

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform