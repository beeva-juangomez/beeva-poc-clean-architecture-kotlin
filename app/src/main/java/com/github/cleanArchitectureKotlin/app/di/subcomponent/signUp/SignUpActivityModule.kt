package com.github.cleanArchitectureKotlin.app.di.subcomponent.signUp

import com.github.cleanArchitectureKotlin.app.di.module.ActivityModule
import com.github.cleanArchitectureKotlin.app.di.scope.ActivityScope
import com.github.cleanArchitectureKotlin.app.navigator.Navigator
import com.github.cleanArchitectureKotlin.app.ui.signUp.activity.SignUpActivity
import com.github.cleanArchitectureKotlin.app.ui.signUp.activity.SignUpView
import com.github.cleanArchitectureKotlin.app.ui.signUp.presenter.SignUpPresenter
import com.github.cleanArchitectureKotlin.domain.useCase.signUp.SignUpUseCase
import dagger.Module
import dagger.Provides


@Module
class SignUpActivityModule(activity: SignUpActivity) : ActivityModule(activity) {

    @Provides @ActivityScope
    fun provideSignInView(): SignUpView = activity as SignUpView

    @Provides @ActivityScope
    fun provideSignUpPresenter(view: SignUpView, navigator: Navigator, signUpUseCase: SignUpUseCase)
            = SignUpPresenter(view, navigator, signUpUseCase)
}