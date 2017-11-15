package com.github.cleanArchitectureKotlin.ui.signIn.activity

import com.github.cleanArchitectureKotlin.ui.base.PresentationView


interface SignInView: PresentationView {

    fun showIncorrectNameFormatError()

    fun showIncorrectSurnameFormatError()

    fun showIncorrectEmailFormatError()

    fun showIncorrectPasswordFormatError()

    fun showUserAlreadyExistsError()

    fun showIncorrectMatchingPasswordsError()

    fun showSignInLoading()

    fun hideSignInLoading()
}