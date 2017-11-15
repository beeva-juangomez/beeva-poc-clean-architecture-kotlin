package com.github.cleanArchitectureKotlin.data.source.disk.dao

import android.arch.persistence.room.*
import com.github.cleanArchitectureKotlin.domain.model.Token


@Dao
interface TokenDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertToken(token: Token)

    @Delete
    fun deleteToken(token: Token)

    @Query("DELETE FROM token")
    fun deleteAllTokens()

    @Query("SELECT * FROM token LIMIT 1")
    fun getFirstToken(): Token
}