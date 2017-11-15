package com.github.cleanArchitectureKotlin.data.source.network


import com.github.cleanArchitectureKotlin.data.exception.*
import com.github.cleanArchitectureKotlin.data.mapper.NetworkAuthenticationResponseToUserMapper
import com.github.cleanArchitectureKotlin.data.source.network.manager.NetworkClientManager
import com.github.cleanArchitectureKotlin.data.source.network.model.NetworkError
import com.github.cleanArchitectureKotlin.data.source.network.request.login.NetworkLoginRequest
import com.github.cleanArchitectureKotlin.data.source.network.request.recoverPassword.NetworkRecoverPasswordRequest
import com.github.cleanArchitectureKotlin.data.source.network.request.signIn.NetworkSignInRequest
import com.github.cleanArchitectureKotlin.domain.model.User
import com.github.cleanArchitectureKotlin.domain.useCase.base.Response
import com.github.cleanArchitectureKotlin.domain.useCase.login.LoginRequest
import com.github.cleanArchitectureKotlin.domain.useCase.recoverPassword.RecoverPasswordRequest
import com.github.cleanArchitectureKotlin.domain.useCase.signIn.SignInRequest

class NetworkDataSource(var networkClientManager: NetworkClientManager) {

    @Throws(NetworkConnectionException::class, NetworkServiceException::class, IncorrectAuthenticationCredentialsException::class)
    fun login(request: LoginRequest): Response<User> {
        val networkResponse = NetworkLoginRequest(request, networkClientManager).run()

        if (!networkResponse.isSuccessful) {
            if (networkResponse.error?.error
                    .equals(NetworkError.Code.INCORRECT_AUTHENTICATION_CREDENTIALS.toString())) {
                throw IncorrectAuthenticationCredentialsException()
            }
            throw NetworkServiceException()
        }

        return Response(NetworkAuthenticationResponseToUserMapper().map(networkResponse.data!!))
    }

    @Throws(NetworkConnectionException::class, NetworkServiceException::class, UserAlreadyExistsException::class)
    fun signIn(request: SignInRequest): Response<User> {
        val networkResponse = NetworkSignInRequest(request, networkClientManager).run()

        if (!networkResponse.isSuccessful) {
            if (networkResponse.error?.error
                    .equals(NetworkError.Code.USER_ALREADY_EXISTS.toString())) {
                throw UserAlreadyExistsException()
            }
            throw NetworkServiceException()
        }

        return Response(NetworkAuthenticationResponseToUserMapper().map(networkResponse.data!!))
    }

    @Throws(NetworkConnectionException::class, NetworkServiceException::class, UserNotFoundException::class)
    fun recoverPassword(request: RecoverPasswordRequest): Response<Void> {
        val networkResponse = NetworkRecoverPasswordRequest(request, networkClientManager).run()

        if (!networkResponse.isSuccessful) {
            if (networkResponse.error?.error
                    .equals(NetworkError.Code.USER_NOT_FOUND.toString())) {
                throw UserNotFoundException()
            }
            throw NetworkServiceException()
        }

        return Response()
    }
}
