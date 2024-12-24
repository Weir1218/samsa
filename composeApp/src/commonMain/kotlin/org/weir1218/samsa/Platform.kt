package org.weir1218.samsa

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform