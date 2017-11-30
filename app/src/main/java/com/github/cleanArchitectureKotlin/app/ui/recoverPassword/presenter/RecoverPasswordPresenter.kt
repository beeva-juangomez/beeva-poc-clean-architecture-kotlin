package com.github.cleanArchitectureKotlin.app.ui.recoverPassword.presenter

import com.github.cleanArchitectureKotlin.app.navigator.Navigator
import com.github.cleanArchitectureKotlin.app.ui.base.Presenter
import com.github.cleanArchitectureKotlin.app.ui.recoverPassword.activity.RecoverPasswordView
import com.github.cleanArchitectureKotlin.domain.useCase.recoverPassword.RecoverPasswordRequest
import com.github.cleanArchitectureKotlin.domain.useCase.recoverPassword.RecoverPasswordResponse
import com.github.cleanArchitectureKotlin.domain.useCase.recoverPassword.RecoverPasswordUseCase


class RecoverPasswordPresenter(override val view: RecoverPasswordView,
                               override val navigator: Navigator,
                               var recoverPasswordUseCase: RecoverPasswordUseCase) :
        Presenter<RecoverPasswordView>,
        RecoverPasswordRequest.Validator, RecoverPasswordResponse {

    fun recoverPassword(email: String) {
        view.showRecoverPasswordLoading()

        val request = RecoverPasswordRequest(email, this)
        recoverPasswordUseCase.execute(request, this)
    }

    override fun onEmailSentToRecoverPassword() {
        navigator.toLoginCleaningStack()
        clearView()
    }

    override fun onUserNotFoundError() {
        view.showUserNotFoundError()
        clearView()
    }

    override fun onEmailFormatNotValid() {
        view.showIncorrectEmailFormatError()
        clearView()
    }

    override fun clearView() {
        view.hideRecoverPasswordLoading()
    }
}
