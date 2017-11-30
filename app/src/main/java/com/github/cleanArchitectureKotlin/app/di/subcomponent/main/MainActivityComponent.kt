package com.github.cleanArchitectureKotlin.app.di.subcomponent.main

import com.github.cleanArchitectureKotlin.app.di.scope.ActivityScope
import com.github.cleanArchitectureKotlin.app.ui.main.activity.MainActivity
import dagger.Subcomponent


@ActivityScope
@Subcomponent(modules = arrayOf(
        MainActivityModule::class
))
interface MainActivityComponent {
    fun injectTo(activity: MainActivity)
}