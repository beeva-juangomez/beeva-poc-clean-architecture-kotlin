package com.github.cleanArchitectureKotlin.app.di.module

import com.github.cleanArchitectureKotlin.domain.useCase.executor.MainThread
import com.github.cleanArchitectureKotlin.domain.useCase.executor.UseCaseExecutor
import com.github.cleanArchitectureKotlin.domain.useCase.getCurrentUser.GetCurrentUserUseCase
import com.github.cleanArchitectureKotlin.domain.useCase.login.LoginUseCase
import com.github.cleanArchitectureKotlin.domain.useCase.recoverPassword.RecoverPasswordUseCase
import com.github.cleanArchitectureKotlin.domain.useCase.signIn.SignInUseCase
import com.github.cleanArchitectureKotlin.domain.useCase.signOut.SignOutUseCase
import com.github.cleanArchitectureKotlin.data.repository.UserRepository
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideGetCurrentUserUseCase(userRepository: UserRepository, executor: UseCaseExecutor,
                                     mainThread: MainThread)
            = GetCurrentUserUseCase(userRepository, executor, mainThread)

    @Provides
    fun provideLoginUseCase(userRepository: UserRepository, executor: UseCaseExecutor,
                            mainThread: MainThread)
            = LoginUseCase(userRepository, executor, mainThread)

    @Provides
    fun provideSignInUseCase(userRepository: UserRepository, executor: UseCaseExecutor,
                             mainThread: MainThread)
            = SignInUseCase(userRepository, executor, mainThread)

    @Provides
    fun provideRecoverPasswordUseCase(userRepository: UserRepository, executor: UseCaseExecutor,
                                      mainThread: MainThread)
            = RecoverPasswordUseCase(userRepository, executor, mainThread)

    @Provides
    fun provideSignOutUseCase(userRepository: UserRepository, executor: UseCaseExecutor,
                              mainThread: MainThread)
            = SignOutUseCase(userRepository, executor, mainThread)
}
