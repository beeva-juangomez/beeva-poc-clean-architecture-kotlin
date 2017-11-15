package com.github.cleanArchitectureKotlin.domain.useCase.signOut

import com.github.cleanArchitectureKotlin.domain.useCase.base.BaseUseCase
import com.github.cleanArchitectureKotlin.domain.useCase.executor.MainThread
import com.github.cleanArchitectureKotlin.domain.useCase.executor.UseCaseExecutor
import com.github.cleanArchitectureKotlin.data.repository.UserRepository


class SignOutUseCase(private val userRepository: UserRepository,
                     executor: UseCaseExecutor, mainThread: MainThread) :
        BaseUseCase<SignOutRequest, SignOutResponse>(executor, mainThread) {

    override fun run() {
        userRepository.signOut()
    }
}