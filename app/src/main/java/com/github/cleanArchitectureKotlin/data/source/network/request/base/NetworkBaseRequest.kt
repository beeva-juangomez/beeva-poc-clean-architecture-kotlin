package com.github.cleanArchitectureKotlin.data.source.network.request.base


import com.github.cleanArchitectureKotlin.data.exception.NetworkConnectionException
import com.github.cleanArchitectureKotlin.data.exception.NetworkServiceException
import com.github.cleanArchitectureKotlin.data.source.network.manager.NetworkManager
import com.github.cleanArchitectureKotlin.data.source.network.model.NetworkResponse

import retrofit2.Call

abstract class NetworkBaseRequest<T> {

    var call: Call<T>? = null
        private set

    @Throws(NetworkConnectionException::class, NetworkServiceException::class)
    protected fun execute(call: Call<T>): NetworkResponse<T> {
        this.call = call
        return NetworkManager.execute(this)
    }

    @Throws(NetworkConnectionException::class, NetworkServiceException::class)
    abstract fun run(): NetworkResponse<T>
}
