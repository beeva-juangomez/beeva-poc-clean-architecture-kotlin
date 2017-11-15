package com.github.cleanArchitectureKotlin.app.di.module

import com.github.cleanArchitectureKotlin.App
import com.github.cleanArchitectureKotlin.data.source.cache.CacheDataSource
import com.github.cleanArchitectureKotlin.data.source.disk.DiskDataSource
import com.github.cleanArchitectureKotlin.data.source.network.NetworkDataSource
import com.github.cleanArchitectureKotlin.data.source.network.manager.NetworkClientManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Provides @Singleton
    fun provideNetworkDataSource(networkClientManager: NetworkClientManager)
            = NetworkDataSource(networkClientManager)

    @Provides @Singleton
    fun provideDiskDataSource(appContext: App)
            = DiskDataSource(appContext)

    @Provides @Singleton
    fun provideCacheDataSource()
            = CacheDataSource()

    @Provides @Singleton
    fun provideNetworkClientManager(diskDataSource: DiskDataSource)
            = NetworkClientManager(diskDataSource)
}