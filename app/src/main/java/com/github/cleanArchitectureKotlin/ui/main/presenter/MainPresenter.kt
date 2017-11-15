package com.github.cleanArchitectureKotlin.ui.main.presenter

import com.github.cleanArchitectureKotlin.app.navigator.Navigator
import com.github.cleanArchitectureKotlin.domain.useCase.signOut.SignOutUseCase
import com.github.cleanArchitectureKotlin.ui.base.Presenter
import com.github.cleanArchitectureKotlin.ui.main.activity.MainView


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