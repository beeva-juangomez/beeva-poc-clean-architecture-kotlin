package com.github.cleanArchitectureKotlin.domain.useCase.recoverPassword

import com.github.cleanArchitectureKotlin.data.exception.NetworkConnectionException
import com.github.cleanArchitectureKotlin.data.exception.NetworkServiceException
import com.github.cleanArchitectureKotlin.data.exception.UserNotFoundException
import com.github.cleanArchitectureKotlin.domain.useCase.base.BaseUseCase
import com.github.cleanArchitectureKotlin.domain.useCase.executor.MainThread
import com.github.cleanArchitectureKotlin.domain.useCase.executor.UseCaseExecutor
import com.github.cleanArchitectureKotlin.repository.UserRepository


class RecoverPasswordUseCase(private val userRepository: UserRepository,
                             executor: UseCaseExecutor, mainThread: MainThread) :
        BaseUseCase<RecoverPasswordRequest, RecoverPasswordResponse>(executor, mainThread) {

    override fun run() {
        try {
            userRepository.recoverPassword(request!!)
            notifyOnEmailSentToRecoverPassword()
        } catch (e: NetworkConnectionException) {
            notifyNetworkConnectionError()
        } catch (e: NetworkServiceException) {
            notifyNetworkServiceError()
        } catch (e: UserNotFoundException) {
            notifyUserNotFoundError()
        }

    }

    private fun notifyOnEmailSentToRecoverPassword() {
        mainThread.post(Runnable { response!!.onEmailSentToRecoverPassword() })
    }

    private fun notifyUserNotFoundError() {
        mainThread.post(Runnable { response!!.onUserNotFoundError() })
    }
}
