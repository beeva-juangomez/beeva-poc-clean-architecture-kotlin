package com.github.cleanArchitectureKotlin.data.source.network.request.signUp


import com.github.cleanArchitectureKotlin.data.exception.NetworkConnectionException
import com.github.cleanArchitectureKotlin.data.exception.NetworkServiceException
import com.github.cleanArchitectureKotlin.data.source.network.manager.NetworkClientManager
import com.github.cleanArchitectureKotlin.data.source.network.model.NetworkResponse
import com.github.cleanArchitectureKotlin.data.source.network.model.body.NetworkSignInBody
import com.github.cleanArchitectureKotlin.data.source.network.request.base.NetworkRequest
import com.github.cleanArchitectureKotlin.data.source.network.request.base.auth.NetworkUserAuthenticationResponse
import com.github.cleanArchitectureKotlin.domain.useCase.signUp.SignUpRequest

class NetworkSignUpRequest(private val signUpRequest: SignUpRequest,
                           var networkClientManager: NetworkClientManager) :
        NetworkRequest<NetworkUserAuthenticationResponse>(networkClientManager) {

    @Throws(NetworkConnectionException::class, NetworkServiceException::class)
    override fun run(): NetworkResponse<NetworkUserAuthenticationResponse> {
        val networkSignInBody = NetworkSignInBody(
                signUpRequest.name,
                signUpRequest.surname,
                signUpRequest.email,
                signUpRequest.password)

        val call = API.signUp(networkSignInBody)
        val response = execute(call)

        if (response.isSuccessful) {
            networkClientManager.updateToken(response.data!!.token)
        }

        return response
    }
}
