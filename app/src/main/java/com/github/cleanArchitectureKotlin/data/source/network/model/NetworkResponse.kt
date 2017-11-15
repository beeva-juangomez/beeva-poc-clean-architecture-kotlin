package com.github.cleanArchitectureKotlin.data.source.network.model


class NetworkResponse<T>(var data: T? = null, var error: NetworkError? = null) {

    val isSuccessful: Boolean
        get() = error == null
}