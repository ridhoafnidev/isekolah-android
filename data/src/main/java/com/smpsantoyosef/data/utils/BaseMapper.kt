package com.smpsantoyosef.data.utils

import kotlinx.coroutines.flow.Flow
import com.smpsantoyosef.domain.utils.Result
import kotlinx.coroutines.flow.map

interface Mapper<R,E>{
    fun mapFromApiResponse(type:R):E
}

fun <R,E> mapFromApiResponse(result: Flow<Result<R>>, mapper: Mapper<R,E>): Flow<Result<E>> {
    return result.map {
        when(it) {
            is Result.Success -> Result.Success(mapper.mapFromApiResponse(it.data))
            is Result.Error -> Result.Error(it.message)
            is Result.Loading -> Result.Loading()
        }
    }
}