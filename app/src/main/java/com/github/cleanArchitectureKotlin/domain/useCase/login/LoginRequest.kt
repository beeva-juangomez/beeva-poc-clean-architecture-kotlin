package com.github.cleanArchitectureKotlin.domain.useCase.login

import com.github.cleanArchitectureKotlin.app.util.HASH
import com.github.cleanArchitectureKotlin.domain.useCase.base.BaseRequest
import com.github.cleanArchitectureKotlin.domain.validator.UserValidator


class LoginRequest(var email: String, var password: String, private val validator: Validator)
    : BaseRequest {

    fun securePassword() {
        password = HASH.md5(password)
    }

    override fun validate(): Boolean {
        if (!(UserValidator isEmailFormatValid(email))) {
            validator.onIncorrectEmailFormat()
            return false
        }

        if (!(UserValidator isPasswordValid(password))) {
            validator.onIncorrectPasswordFormat()
            return false
        }

        return true
    }

    interface Validator {
        fun onIncorrectEmailFormat()

        fun onIncorrectPasswordFormat()
    }
}
