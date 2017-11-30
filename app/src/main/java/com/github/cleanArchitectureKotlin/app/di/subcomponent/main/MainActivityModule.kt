package com.github.cleanArchitectureKotlin.app.di.subcomponent.main

import com.github.cleanArchitectureKotlin.app.di.module.ActivityModule
import com.github.cleanArchitectureKotlin.app.di.scope.ActivityScope
import com.github.cleanArchitectureKotlin.app.navigator.Navigator
import com.github.cleanArchitectureKotlin.app.ui.main.activity.MainActivity
import com.github.cleanArchitectureKotlin.app.ui.main.activity.MainView
import com.github.cleanArchitectureKotlin.app.ui.main.presenter.MainPresenter
import com.github.cleanArchitectureKotlin.domain.useCase.signOut.SignOutUseCase
import dagger.Module
import dagger.Provides


@Module
class MainActivityModule(activity: MainActivity) : ActivityModule(activity) {

    @Provides @ActivityScope
    fun provideMainView(): MainView = activity as MainView

    @Provides @ActivityScope
    fun provideMainPresenter(view: MainView, navigator: Navigator, signOutUseCase: SignOutUseCase)
            = MainPresenter(view, navigator, signOutUseCase)
}
