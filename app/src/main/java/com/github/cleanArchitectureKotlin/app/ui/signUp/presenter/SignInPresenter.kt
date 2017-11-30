package com.github.cleanArchitectureKotlin.app.ui.signUp.presenter

import com.github.cleanArchitectureKotlin.app.navigator.Navigator
import com.github.cleanArchitectureKotlin.app.ui.base.Presenter
import com.github.cleanArchitectureKotlin.app.ui.signUp.activity.SignUpView
import com.github.cleanArchitectureKotlin.domain.model.User
import com.github.cleanArchitectureKotlin.domain.useCase.signUp.SignUpRequest
import com.github.cleanArchitectureKotlin.domain.useCase.signUp.SignUpResponse
import com.github.cleanArchitectureKotlin.domain.useCase.signUp.SignUpUseCase

class SignUpPresenter(override val view: SignUpView,
                      override val navigator: Navigator,
                      var signUpUseCase: SignUpUseCase) :
        Presenter<SignUpView>, SignUpRequest.Validator, SignUpResponse {

    fun signUp(name: String, surname: String, email: String, password: String,
               repeatedPassword: String) {
        view.showSignUpLoading()

        val request = SignUpRequest(name, surname, email, password, repeatedPassword, this)
        signUpUseCase.execute(request, this)
    }

    override fun onUserSignedUp(user: User) {
        navigator.toMain()
    }

    override fun onUserAlreadyExists() {
        view.showUserAlreadyExistsError()
        clearView()
    }

    override fun onIncorrectNameFormat() {
        view.showIncorrectNameFormatError()
        clearView()
    }

    override fun onIncorrectSurnameFormat() {
        view.showIncorrectSurnameFormatError()
        clearView()
    }

    override fun onIncorrectEmailFormat() {
        view.showIncorrectEmailFormatError()
        clearView()
    }

    override fun onIncorrectPasswordFormat() {
        view.showIncorrectPasswordFormatError()
        clearView()
    }

    override fun onIncorrectMatchingPasswords() {
        view.showIncorrectMatchingPasswordsError()
        clearView()
    }

    override fun clearView() {
        view.hideSignUpLoading()
    }

}
