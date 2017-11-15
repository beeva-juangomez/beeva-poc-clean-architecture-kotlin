package com.github.cleanArchitectureKotlin.domain.useCase.signIn

import com.github.cleanArchitectureKotlin.domain.model.User
import com.github.cleanArchitectureKotlin.domain.useCase.base.BaseResponse


interface SignInResponse : BaseResponse {

    fun onUserSignedIn(user: User)

    fun onUserAlreadyExists()
}
