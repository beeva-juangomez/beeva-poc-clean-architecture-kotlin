package com.github.cleanArchitectureKotlin.app.ui.base

import com.github.cleanArchitectureKotlin.app.navigator.Navigator
import com.github.cleanArchitectureKotlin.domain.useCase.base.BaseResponse

interface Presenter<out T : PresentationView> :
        BaseResponse {

    val view: T
    val navigator: Navigator

    fun clearView()

    override fun onNetworkConnectionError() {
        clearView()
    }

    override fun onNetworkServiceError() {
        clearView()
    }

    override fun onUnknownError() {
        clearView()
    }

    override fun onUserIsNotLoggedIn() {
        navigator.toLogin()
    }
}