package com.smpsantoyosef.data.utils

import com.google.gson.JsonParser
import com.smpsantoyosef.domain.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import retrofit2.Response
import com.smpsantoyosef.domain.utils.Result
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import okhttp3.ResponseBody
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException
import java.net.SocketTimeoutException

suspend fun<ResultType> apiCall(api: suspend() -> ResultType): Flow<Resource<ResultType>> {
    return withContext(Dispatchers.IO) {
        flow {
            emit(Resource.Loading)
            try {
                emit(Resource.Success(api.invoke()))
            }
            catch (e: Throwable) {
                emit(Resource.Error(msg = message(e)))
            }
        }.catch { error ->
            Timber.e(error.localizedMessage)
            emit(Resource.Loading)
            delay(5)
            emit(Resource.Error(msg = message(error)))
        }
    }
}

inline fun message(throwable: Throwable?):String{
    when (throwable) {
        is SocketTimeoutException -> return "Whoops! Connection time out. Please try again"
        is IOException -> return "Whoops! No Internet Connection. Please try again"
        is HttpException -> return try {
            val errorJsonString = throwable.response()?.errorBody()?.string()
            val errorMessage = JsonParser.parseString(errorJsonString).asJsonObject["message"].asString
            errorMessage.ifEmpty { "Whoops! Something went wrong. Please try again." }
        }catch (e:Exception){
            "Whoops! Unknown error occurred. Please try again"
        }
    }
    return "Whoops! Unknown error occurred. Please try again"
}
inline fun code(throwable: Throwable?):Int{
    return if (throwable is HttpException) (throwable).code()
    else  0
}
