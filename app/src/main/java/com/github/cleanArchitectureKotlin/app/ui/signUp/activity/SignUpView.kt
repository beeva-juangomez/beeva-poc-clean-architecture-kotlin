package com.github.cleanArchitectureKotlin.app.ui.signUp.activity

import com.github.cleanArchitectureKotlin.app.ui.base.PresentationView


interface SignUpView: PresentationView {

    fun showIncorrectNameFormatError()

    fun showIncorrectSurnameFormatError()

    fun showIncorrectEmailFormatError()

    fun showIncorrectPasswordFormatError()

    fun showUserAlreadyExistsError()

    fun showIncorrectMatchingPasswordsError()

    fun showSignUpLoading()

    fun hideSignUpLoading()
}