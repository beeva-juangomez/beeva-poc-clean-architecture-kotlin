package com.github.cleanArchitectureKotlin.app.ui.login.activity

import com.github.cleanArchitectureKotlin.app.ui.base.PresentationView

interface LoginView: PresentationView {
    
    fun showIncorrectEmailFormatError()

    fun showIncorrectPasswordFormatError()

    fun showIncorrectLoginUserDataError()

    fun showLoginLoading()

    fun hideLoginLoading()
}
