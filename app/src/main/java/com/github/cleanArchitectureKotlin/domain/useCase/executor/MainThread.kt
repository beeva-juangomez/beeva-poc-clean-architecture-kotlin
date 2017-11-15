package com.github.cleanArchitectureKotlin.domain.useCase.executor

interface MainThread {
    fun post(runnable: Runnable)
}
