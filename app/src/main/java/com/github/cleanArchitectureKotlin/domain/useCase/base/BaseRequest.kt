package com.github.cleanArchitectureKotlin.domain.useCase.base

interface BaseRequest {

    fun validate(): Boolean
}
