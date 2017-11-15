package com.github.cleanArchitectureKotlin.domain.useCase.recoverPassword

import com.github.cleanArchitectureKotlin.domain.useCase.base.BaseResponse


interface RecoverPasswordResponse : BaseResponse {

    fun onEmailSentToRecoverPassword()

    fun onUserNotFoundError()
}
