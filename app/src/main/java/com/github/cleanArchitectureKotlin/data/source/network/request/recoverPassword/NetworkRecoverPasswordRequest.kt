package com.github.cleanArchitectureKotlin.data.source.network.request.recoverPassword


import com.github.cleanArchitectureKotlin.data.exception.NetworkConnectionException
import com.github.cleanArchitectureKotlin.data.exception.NetworkServiceException
import com.github.cleanArchitectureKotlin.data.source.network.manager.NetworkClientManager
import com.github.cleanArchitectureKotlin.data.source.network.model.NetworkResponse
import com.github.cleanArchitectureKotlin.data.source.network.request.base.NetworkRequest
import com.github.cleanArchitectureKotlin.domain.useCase.recoverPassword.RecoverPasswordRequest


class NetworkRecoverPasswordRequest(private val recoverPasswordRequest: RecoverPasswordRequest,
                                    networkClientManager: NetworkClientManager)
    : NetworkRequest<Void>(networkClientManager) {

    @Throws(NetworkConnectionException::class, NetworkServiceException::class)
    override fun run(): NetworkResponse<Void> {
        val call = API.recoverPassword(recoverPasswordRequest.email)
        return execute(call)
    }
}