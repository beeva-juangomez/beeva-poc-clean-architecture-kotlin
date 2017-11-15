package com.github.cleanArchitectureKotlin.data.source.disk

import com.github.cleanArchitectureKotlin.App
import com.github.cleanArchitectureKotlin.domain.model.Token
import com.github.cleanArchitectureKotlin.domain.model.User

class DiskDataSource(appContext: App) {

    companion object {
        var database: Database? = null
    }

    init {
        database = Database.createInstance(appContext)
    }

    fun insertUser(user: User) = database?.userModel()?.insertUser(user)

    fun deleteAllUsers() = database?.userModel()?.deleteAllUsers()

    fun deleteUser(user: User) = database?.userModel()?.deleteUser(user)

    fun getUser() = database?.userModel()?.getFirstUser()

    fun insertToken(token: Token) = database?.tokenModel()?.insertToken(token)

    fun deleteToken(token: Token) = database?.tokenModel()?.deleteToken(token)

    fun deleteAllTokens() = database?.tokenModel()?.deleteAllTokens()

    fun getToken() = database?.tokenModel()?.getFirstToken()

    fun deleteAllTables() {
        database?.tokenModel()?.deleteAllTokens()
        database?.userModel()?.deleteAllUsers()
    }
}
