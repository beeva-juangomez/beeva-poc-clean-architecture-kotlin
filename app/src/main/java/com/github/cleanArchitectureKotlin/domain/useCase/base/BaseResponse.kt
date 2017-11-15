package com.github.cleanArchitectureKotlin.domain.useCase.base

interface BaseResponse {

    fun onNetworkConnectionError()

    fun onNetworkServiceError()

    fun onUnknownError()

    fun onUserIsNotLoggedIn()
}
