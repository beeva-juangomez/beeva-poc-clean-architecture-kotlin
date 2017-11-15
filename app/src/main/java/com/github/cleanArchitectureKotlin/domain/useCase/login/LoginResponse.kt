package com.github.cleanArchitectureKotlin.domain.useCase.login

import com.github.cleanArchitectureKotlin.domain.model.User
import com.github.cleanArchitectureKotlin.domain.useCase.base.BaseResponse


interface LoginResponse : BaseResponse {

    fun onUserLoggedIn(user: User)

    fun onIncorrectLoginUserData()
}
