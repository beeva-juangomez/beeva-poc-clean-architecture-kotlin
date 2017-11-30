package com.github.cleanArchitectureKotlin.domain.useCase.signUp

import com.github.cleanArchitectureKotlin.app.ui.base.mainThread.MainThread
import com.github.cleanArchitectureKotlin.data.exception.MapperException
import com.github.cleanArchitectureKotlin.data.exception.NetworkConnectionException
import com.github.cleanArchitectureKotlin.data.exception.NetworkServiceException
import com.github.cleanArchitectureKotlin.data.exception.UserAlreadyExistsException
import com.github.cleanArchitectureKotlin.data.repository.UserRepository
import com.github.cleanArchitectureKotlin.domain.model.User
import com.github.cleanArchitectureKotlin.domain.useCase.base.BaseUseCase
import com.github.cleanArchitectureKotlin.domain.useCase.executor.UseCaseExecutor


class SignUpUseCase(private val userRepository: UserRepository,
                    executor: UseCaseExecutor, mainThread: MainThread) :
        BaseUseCase<SignUpRequest, SignUpResponse>(executor, mainThread) {

    override fun run() {
        try {
            request!!.securePassword()
            val response = userRepository.signUp(request!!)
            notifyUserSignedUp(response.data!!)
        } catch (e: NetworkConnectionException) {
            notifyNetworkConnectionError()
        } catch (e: NetworkServiceException) {
            notifyNetworkServiceError()
        } catch (e: UserAlreadyExistsException) {
            notifyUserAlreadyExists()
        } catch (e: java.security.NoSuchAlgorithmException) {
            notifyUnknownError()
        } catch (e: MapperException) {
            notifyUnknownError()
        }

    }

    private fun notifyUserSignedUp(user: User) {
        mainThread.post(Runnable { response!!.onUserSignedUp(user) })
    }

    private fun notifyUserAlreadyExists() {
        mainThread.post(Runnable { response!!.onUserAlreadyExists() })
    }
}
