package com.github.cleanArchitectureKotlin.data.source.network.request.login


import com.github.cleanArchitectureKotlin.data.exception.NetworkConnectionException
import com.github.cleanArchitectureKotlin.data.exception.NetworkServiceException
import com.github.cleanArchitectureKotlin.data.source.network.manager.NetworkClientManager
import com.github.cleanArchitectureKotlin.data.source.network.model.NetworkResponse
import com.github.cleanArchitectureKotlin.data.source.network.model.body.NetworkLoginBody
import com.github.cleanArchitectureKotlin.data.source.network.request.base.NetworkRequest
import com.github.cleanArchitectureKotlin.data.source.network.request.base.auth.NetworkUserAuthenticationResponse
import com.github.cleanArchitectureKotlin.domain.useCase.login.LoginRequest

class NetworkLoginRequest(private val loginRequest: LoginRequest,
                          var networkClientManager: NetworkClientManager) : NetworkRequest<NetworkUserAuthenticationResponse>(networkClientManager) {

    @Throws(NetworkConnectionException::class, NetworkServiceException::class)
    override fun run(): NetworkResponse<NetworkUserAuthenticationResponse> {
        val networkLoginBody = NetworkLoginBody(loginRequest.email, loginRequest.password)

        val call = API.login(networkLoginBody)
        val response = execute(call)

        if (response.isSuccessful) {
            networkClientManager.updateToken(response.data!!.token)
        }

        return response
    }
}
