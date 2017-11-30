package com.github.cleanArchitectureKotlin.app.ui.splash.activity

import android.os.Bundle
import com.github.cleanArchitectureKotlin.R
import com.github.cleanArchitectureKotlin.app.di.component.ApplicationComponent
import com.github.cleanArchitectureKotlin.app.di.subcomponent.splash.SplashActivityModule
import com.github.cleanArchitectureKotlin.app.ui.base.BaseActivity
import com.github.cleanArchitectureKotlin.app.ui.splash.presenter.SplashPresenter
import javax.inject.Inject


class SplashActivity : BaseActivity(), SplashView {

    @Inject
    lateinit var presenter: SplashPresenter

    override var layoutId: Int = R.layout.activity_splash

    override fun setupInjection(applicationComponent: ApplicationComponent) {
        applicationComponent.plus(SplashActivityModule(this))
                .injectTo(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.loadInitialData()
    }
}