package com.github.cleanArchitectureKotlin.data.source.network.request.base


import com.github.cleanArchitectureKotlin.data.source.network.manager.NetworkClientManager
import com.github.cleanArchitectureKotlin.data.source.network.service.API

abstract class NetworkRequest<T>(networkClientManager: NetworkClientManager) : NetworkBaseRequest<T>() {
    open var API: API = networkClientManager.client
}