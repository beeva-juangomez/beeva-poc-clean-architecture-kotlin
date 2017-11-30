package com.github.cleanArchitectureKotlin.app.ui.base.mainThread

interface MainThread {
    fun post(runnable: Runnable)
}
