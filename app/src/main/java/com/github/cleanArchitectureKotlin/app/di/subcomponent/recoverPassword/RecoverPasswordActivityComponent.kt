package com.github.cleanArchitectureKotlin.app.di.subcomponent.recoverPassword

import com.github.cleanArchitectureKotlin.app.di.scope.ActivityScope
import com.github.cleanArchitectureKotlin.ui.recoverPassword.activity.RecoverPasswordActivity
import dagger.Subcomponent


@ActivityScope
@Subcomponent(modules = arrayOf(
        RecoverPasswordActivityModule::class
))
interface RecoverPasswordActivityComponent {
    fun injectTo(activity: RecoverPasswordActivity)
}