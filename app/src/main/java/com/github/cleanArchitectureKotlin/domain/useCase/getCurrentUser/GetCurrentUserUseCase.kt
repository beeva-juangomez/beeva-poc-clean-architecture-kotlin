package com.github.cleanArchitectureKotlin.domain.useCase.getCurrentUser

import com.github.cleanArchitectureKotlin.app.ui.base.mainThread.MainThread
import com.github.cleanArchitectureKotlin.data.exception.UserNotFoundException
import com.github.cleanArchitectureKotlin.data.repository.UserRepository
import com.github.cleanArchitectureKotlin.domain.model.User
import com.github.cleanArchitectureKotlin.domain.useCase.base.BaseUseCase
import com.github.cleanArchitectureKotlin.domain.useCase.executor.UseCaseExecutor


class GetCurrentUserUseCase(private val userRepository: UserRepository,
                            executor: UseCaseExecutor, mainThread: MainThread) :
        BaseUseCase<GetCurrentUserRequest, GetCurrentUserResponse>(executor, mainThread) {

    override fun run() {
        try {
            val response = userRepository.getCurrentUser()
            notifyCurrentUserReceived(response.data!!)
        } catch (e: UserNotFoundException) {
            notifyUserNotFound()
        }
    }

    private fun notifyCurrentUserReceived(user: User) {
        mainThread.post(Runnable { response!!.onCurrentUserReceived(user) })
    }

    private fun notifyUserNotFound() {
        mainThread.post(Runnable { response!!.onUserIsNotLoggedIn() })
    }
}