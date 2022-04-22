package lib.dehaat.ledger.data

import lib.dehaat.ledger.BuildConfig
import lib.dehaat.ledger.data.model.ApiResult
import retrofit2.Response

suspend fun <T> getResult(call: suspend () -> Response<T>): ApiResult<T> = try {
    val response: Response<T> = call()
    try {
        handleApiSuccess(response)
    } catch (e: Exception) {
        if (BuildConfig.DEBUG) e.printStackTrace()
        ApiResult.Failure(response.code(), e.message)
    }
} catch (e: Exception) {
    if (BuildConfig.DEBUG) e.printStackTrace()
    ApiResult.Failure(0, e.message)
}

private fun <T> handleApiSuccess(response: Response<T>): ApiResult<T> {
    val responseCode = response.code()
    val body = response.body()
    val errorBody = response.errorBody()
    return if (responseCode in 200..202)
        ApiResult.Success(body)
    else ApiResult.Failure(
        responseCode,
        "",// todo@Aditi: parse error message. e.g. 'AppUtils.getErrorMessage(responseCode, errorBody)'
        errorBody
    )
}