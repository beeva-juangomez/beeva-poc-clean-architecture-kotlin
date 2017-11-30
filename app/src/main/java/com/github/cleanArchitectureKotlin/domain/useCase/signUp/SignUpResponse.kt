package com.github.cleanArchitectureKotlin.domain.useCase.signUp

import com.github.cleanArchitectureKotlin.domain.model.User
import com.github.cleanArchitectureKotlin.domain.useCase.base.BaseResponse


interface SignUpResponse : BaseResponse {

    fun onUserSignedUp(user: User)

    fun onUserAlreadyExists()
}
