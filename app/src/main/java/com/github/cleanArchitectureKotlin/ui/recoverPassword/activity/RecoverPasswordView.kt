package com.github.cleanArchitectureKotlin.ui.recoverPassword.activity

import com.github.cleanArchitectureKotlin.ui.base.PresentationView


interface RecoverPasswordView: PresentationView {

    fun showIncorrectEmailFormatError()

    fun showUserNotFoundError()

    fun showRecoverPasswordLoading()

    fun hideRecoverPasswordLoading()
}