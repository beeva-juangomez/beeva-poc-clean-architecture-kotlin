package com.github.cleanArchitectureKotlin.app.di.subcomponent.login

import com.github.cleanArchitectureKotlin.app.di.scope.ActivityScope
import com.github.cleanArchitectureKotlin.ui.login.activity.LoginActivity
import dagger.Subcomponent


@ActivityScope
@Subcomponent(modules = arrayOf(
        LoginActivityModule::class
))
interface LoginActivityComponent {
    fun injectTo(activity: LoginActivity)
}