package com.github.cleanArchitectureKotlin.app.ui.recoverPassword.activity

import com.github.cleanArchitectureKotlin.app.ui.base.PresentationView


interface RecoverPasswordView: PresentationView {

    fun showIncorrectEmailFormatError()

    fun showUserNotFoundError()

    fun showRecoverPasswordLoading()

    fun hideRecoverPasswordLoading()
}