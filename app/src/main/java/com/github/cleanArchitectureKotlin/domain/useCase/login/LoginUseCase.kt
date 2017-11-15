package com.github.cleanArchitectureKotlin.domain.useCase.login

import com.github.cleanArchitectureKotlin.data.exception.IncorrectAuthenticationCredentialsException
import com.github.cleanArchitectureKotlin.data.exception.MapperException
import com.github.cleanArchitectureKotlin.data.exception.NetworkConnectionException
import com.github.cleanArchitectureKotlin.data.exception.NetworkServiceException
import com.github.cleanArchitectureKotlin.domain.model.User
import com.github.cleanArchitectureKotlin.domain.useCase.base.BaseUseCase
import com.github.cleanArchitectureKotlin.domain.useCase.executor.MainThread
import com.github.cleanArchitectureKotlin.domain.useCase.executor.UseCaseExecutor
import com.github.cleanArchitectureKotlin.data.repository.UserRepository
import java.security.NoSuchAlgorithmException


class LoginUseCase(private val userRepository: UserRepository,
                   executor: UseCaseExecutor, mainThread: MainThread) :
        BaseUseCase<LoginRequest, LoginResponse>(executor, mainThread) {

    override fun run() {
        try {
            request!!.securePassword()
            val response = userRepository.login(request!!)
            notifyUserLoggedIn(response.data!!)
        } catch (e: NetworkConnectionException) {
            notifyNetworkConnectionError()
        } catch (e: NetworkServiceException) {
            notifyNetworkServiceError()
        } catch (e: IncorrectAuthenticationCredentialsException) {
            notifyIncorrectLoginUserData()
        } catch (e: NoSuchAlgorithmException) {
            notifyUnknownError()
        } catch (e: MapperException) {
            notifyUnknownError()
        }

    }

    private fun notifyUserLoggedIn(user: User) {
        mainThread.post(Runnable { response!!.onUserLoggedIn(user) })
    }

    private fun notifyIncorrectLoginUserData() {
        mainThread.post(Runnable { response!!.onIncorrectLoginUserData() })
    }
}
