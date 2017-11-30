package com.github.cleanArchitectureKotlin.app.di.subcomponent.splash

import com.github.cleanArchitectureKotlin.app.di.module.ActivityModule
import com.github.cleanArchitectureKotlin.app.di.scope.ActivityScope
import com.github.cleanArchitectureKotlin.app.navigator.Navigator
import com.github.cleanArchitectureKotlin.app.ui.splash.activity.SplashActivity
import com.github.cleanArchitectureKotlin.app.ui.splash.activity.SplashView
import com.github.cleanArchitectureKotlin.app.ui.splash.presenter.SplashPresenter
import com.github.cleanArchitectureKotlin.domain.useCase.getCurrentUser.GetCurrentUserUseCase
import dagger.Module
import dagger.Provides


@Module
class SplashActivityModule(activity: SplashActivity) : ActivityModule(activity) {

    @Provides @ActivityScope
    fun provideSplashView(): SplashView = activity as SplashView

    @Provides @ActivityScope
    fun provideSplashPresenter(view: SplashView, navigator: Navigator,
                               getCurrentUserUseCase: GetCurrentUserUseCase)
            = SplashPresenter(view, navigator, getCurrentUserUseCase)
}