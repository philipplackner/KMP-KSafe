package com.plcoding.kmp_ksafe

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "KSafe Demo"
    ) {
        App()
    }
}
