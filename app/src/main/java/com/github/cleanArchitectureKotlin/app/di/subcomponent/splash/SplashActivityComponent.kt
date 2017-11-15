package com.github.cleanArchitectureKotlin.app.di.subcomponent.splash

import com.github.cleanArchitectureKotlin.app.di.scope.ActivityScope
import com.github.cleanArchitectureKotlin.ui.splash.activity.SplashActivity
import dagger.Subcomponent


@ActivityScope
@Subcomponent(modules = arrayOf(
        SplashActivityModule::class
))
interface SplashActivityComponent {
    fun injectTo(activity: SplashActivity)
}