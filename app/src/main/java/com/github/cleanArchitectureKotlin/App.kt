package com.github.cleanArchitectureKotlin

import android.app.Application
import com.github.cleanArchitectureKotlin.app.di.component.ApplicationComponent
import com.github.cleanArchitectureKotlin.app.di.component.DaggerApplicationComponent
import com.github.cleanArchitectureKotlin.app.di.module.ApplicationModule


class App : Application() {

    companion object {
        lateinit var graph: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        initializeDagger()
    }

    private fun initializeDagger() {
        graph = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }
}