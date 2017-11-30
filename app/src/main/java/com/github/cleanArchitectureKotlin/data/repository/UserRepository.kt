package com.github.cleanArchitectureKotlin.data.repository

import com.github.cleanArchitectureKotlin.data.exception.UserNotFoundException
import com.github.cleanArchitectureKotlin.data.source.cache.CacheDataSource
import com.github.cleanArchitectureKotlin.data.source.disk.DiskDataSource
import com.github.cleanArchitectureKotlin.data.source.network.NetworkDataSource
import com.github.cleanArchitectureKotlin.domain.model.User
import com.github.cleanArchitectureKotlin.domain.useCase.base.Response
import com.github.cleanArchitectureKotlin.domain.useCase.login.LoginRequest
import com.github.cleanArchitectureKotlin.domain.useCase.recoverPassword.RecoverPasswordRequest
import com.github.cleanArchitectureKotlin.domain.useCase.signUp.SignUpRequest


class UserRepository(private val networkDataSource: NetworkDataSource,
                     private val diskDataSource: DiskDataSource,
                     private val cacheDataSource: CacheDataSource) {

    fun getCurrentUser(): Response<User> {
        var user = cacheDataSource.user
        if (user == null) user = diskDataSource.getUser() else return Response(user)
        if (user == null) throw UserNotFoundException() else return Response(user)
    }

    fun login(request: LoginRequest): Response<User> {
        val response = networkDataSource.login(request)
        val user = response.data
        saveUser(user)
        return response
    }

    fun signUp(request: SignUpRequest): Response<User> {
        val response = networkDataSource.signUp(request)
        val user = response.data
        saveUser(user)
        return response
    }

    private fun saveUser(user: User?) {
        user?.let {
            cacheDataSource.user = user
            diskDataSource.deleteAllUsers()
            diskDataSource.insertUser(it)
        }
    }

    fun recoverPassword(request: RecoverPasswordRequest): Response<Void>
            = networkDataSource.recoverPassword(request)

    fun signOut() {
        diskDataSource.deleteAllTables()
    }
}