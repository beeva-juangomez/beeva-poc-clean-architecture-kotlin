package com.github.cleanArchitectureKotlin.domain.useCase.getCurrentUser

import com.github.cleanArchitectureKotlin.domain.model.User
import com.github.cleanArchitectureKotlin.domain.useCase.base.BaseResponse


interface GetCurrentUserResponse: BaseResponse {

    fun onCurrentUserReceived(user: User)

}