package com.github.cleanArchitectureKotlin.app.di.subcomponent.recoverPassword

import com.github.cleanArchitectureKotlin.app.di.module.ActivityModule
import com.github.cleanArchitectureKotlin.app.di.scope.ActivityScope
import com.github.cleanArchitectureKotlin.app.navigator.Navigator
import com.github.cleanArchitectureKotlin.domain.useCase.recoverPassword.RecoverPasswordUseCase
import com.github.cleanArchitectureKotlin.ui.recoverPassword.activity.RecoverPasswordActivity
import com.github.cleanArchitectureKotlin.ui.recoverPassword.activity.RecoverPasswordView
import com.github.cleanArchitectureKotlin.ui.recoverPassword.presenter.RecoverPasswordPresenter
import dagger.Module
import dagger.Provides


@Module
class RecoverPasswordActivityModule(activity: RecoverPasswordActivity) : ActivityModule(activity) {

    @Provides @ActivityScope
    fun provideRecoverPasswordView(): RecoverPasswordView = activity as RecoverPasswordView

    @Provides @ActivityScope
    fun provideRecoverPasswordPresenter(view: RecoverPasswordView,
                                        navigator: Navigator,
                                        recoverPasswordUseCase: RecoverPasswordUseCase)
            = RecoverPasswordPresenter(view, navigator, recoverPasswordUseCase)
}