package com.github.cleanArchitectureKotlin.app.di.component

import com.github.cleanArchitectureKotlin.app.di.module.ApplicationModule
import com.github.cleanArchitectureKotlin.app.di.module.DataModule
import com.github.cleanArchitectureKotlin.app.di.module.DomainModule
import com.github.cleanArchitectureKotlin.app.di.module.RepositoryModule
import com.github.cleanArchitectureKotlin.app.di.subcomponent.login.LoginActivityComponent
import com.github.cleanArchitectureKotlin.app.di.subcomponent.login.LoginActivityModule
import com.github.cleanArchitectureKotlin.app.di.subcomponent.main.MainActivityComponent
import com.github.cleanArchitectureKotlin.app.di.subcomponent.main.MainActivityModule
import com.github.cleanArchitectureKotlin.app.di.subcomponent.recoverPassword.RecoverPasswordActivityComponent
import com.github.cleanArchitectureKotlin.app.di.subcomponent.recoverPassword.RecoverPasswordActivityModule
import com.github.cleanArchitectureKotlin.app.di.subcomponent.signIn.SignInActivityComponent
import com.github.cleanArchitectureKotlin.app.di.subcomponent.signIn.SignInActivityModule
import com.github.cleanArchitectureKotlin.app.di.subcomponent.splash.SplashActivityComponent
import com.github.cleanArchitectureKotlin.app.di.subcomponent.splash.SplashActivityModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        ApplicationModule::class,
        DataModule::class,
        RepositoryModule::class,
        DomainModule::class
))
interface ApplicationComponent {
    fun plus(module: SplashActivityModule): SplashActivityComponent
    fun plus(module: LoginActivityModule): LoginActivityComponent
    fun plus(module: SignInActivityModule): SignInActivityComponent
    fun plus(module: RecoverPasswordActivityModule): RecoverPasswordActivityComponent
    fun plus(module: MainActivityModule): MainActivityComponent
}