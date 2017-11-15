package com.github.cleanArchitectureKotlin.data.source.disk.converter

import android.arch.persistence.room.TypeConverter
import com.github.cleanArchitectureKotlin.domain.model.User


class UserStatusConverter {

    @TypeConverter
    fun fromTypeToValue(status: User.Status): String? = status.toString()

    @TypeConverter
    fun fromValueToType(value: String): User.Status? = User.Status.valueOf(value)
}