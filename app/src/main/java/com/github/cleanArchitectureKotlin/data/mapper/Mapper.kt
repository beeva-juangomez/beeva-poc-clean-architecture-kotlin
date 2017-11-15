package com.github.cleanArchitectureKotlin.data.mapper

import com.github.cleanArchitectureKotlin.data.exception.MapperException


internal interface Mapper<in I, out O> {

    @Throws(MapperException::class)
    fun map(input: I): O
}
