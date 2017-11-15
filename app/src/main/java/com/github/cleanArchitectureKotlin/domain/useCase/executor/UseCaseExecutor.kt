package com.github.cleanArchitectureKotlin.domain.useCase.executor

import com.github.cleanArchitectureKotlin.domain.useCase.base.BaseUseCase


interface UseCaseExecutor {
    fun run(baseUseCase: BaseUseCase<*, *>)
}