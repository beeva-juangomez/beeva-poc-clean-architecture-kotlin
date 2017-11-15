package com.github.cleanArchitectureKotlin.domain.useCase.getCurrentUser

import com.github.cleanArchitectureKotlin.domain.useCase.base.BaseRequest


class GetCurrentUserRequest: BaseRequest {

    override fun validate(): Boolean {
        return true
    }
}