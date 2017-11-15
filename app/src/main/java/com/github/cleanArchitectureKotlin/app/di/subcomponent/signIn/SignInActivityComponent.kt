package com.github.cleanArchitectureKotlin.app.di.subcomponent.signIn

import com.github.cleanArchitectureKotlin.app.di.scope.ActivityScope
import com.github.cleanArchitectureKotlin.ui.signIn.activity.SignInActivity
import dagger.Subcomponent


@ActivityScope
@Subcomponent(modules = arrayOf(
        SignInActivityModule::class
))
interface SignInActivityComponent {
    fun injectTo(activity: SignInActivity)
}