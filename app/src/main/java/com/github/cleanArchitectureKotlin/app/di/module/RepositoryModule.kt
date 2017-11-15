package com.github.cleanArchitectureKotlin.app.di.module

import com.github.cleanArchitectureKotlin.data.source.cache.CacheDataSource
import com.github.cleanArchitectureKotlin.data.source.disk.DiskDataSource
import com.github.cleanArchitectureKotlin.data.source.network.NetworkDataSource
import com.github.cleanArchitectureKotlin.data.repository.UserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides @Singleton
    fun provideUserRepository(networkDataSource: NetworkDataSource, diskDataSource: DiskDataSource,
                              cacheDataSource: CacheDataSource)
            = UserRepository(networkDataSource, diskDataSource, cacheDataSource)
}