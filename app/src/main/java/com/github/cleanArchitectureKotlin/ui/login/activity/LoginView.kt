package com.github.cleanArchitectureKotlin.ui.login.activity

import com.github.cleanArchitectureKotlin.ui.base.PresentationView

interface LoginView: PresentationView {
    
    fun showIncorrectEmailFormatError()

    fun showIncorrectPasswordFormatError()

    fun showIncorrectLoginUserDataError()

    fun showLoginLoading()

    fun hideLoginLoading()
}
