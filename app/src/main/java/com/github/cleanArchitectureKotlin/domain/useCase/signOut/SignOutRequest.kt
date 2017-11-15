package com.github.cleanArchitectureKotlin.domain.useCase.signOut

import com.github.cleanArchitectureKotlin.domain.useCase.base.BaseRequest


class SignOutRequest: BaseRequest {

    override fun validate(): Boolean {
        return true
    }
}