package org.weir1218.samsa

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "samsa",
    ) {
        App()
    }
}