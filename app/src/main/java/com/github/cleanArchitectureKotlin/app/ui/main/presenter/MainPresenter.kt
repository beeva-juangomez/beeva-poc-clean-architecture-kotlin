package com.github.cleanArchitectureKotlin.app.ui.main.presenter

import com.github.cleanArchitectureKotlin.app.navigator.Navigator
import com.github.cleanArchitectureKotlin.app.ui.base.Presenter
import com.github.cleanArchitectureKotlin.app.ui.main.activity.MainView
import com.github.cleanArchitectureKotlin.domain.useCase.signOut.SignOutUseCase


class MainPresenter(override val view: MainView,
                    override val navigator: Navigator,
                    var signOutUseCase: SignOutUseCase)
    : Presenter<MainView> {

    fun signOut() {
        signOutUseCase.execute()
        navigator.toSplash()
    }

    override fun clearView() {
        TODO("not implemented")
    }
}