package lib.dehaat.ledger.data.model

import okhttp3.ResponseBody

sealed class ApiResult<T>(val responseCode: Int) {
    class Success<T>(
        val data: T?,
        responseCode: Int = 200
    ) : ApiResult<T>(responseCode)

    class Failure<T>(
        responseCode: Int,
        val errorMessage: String?,
        val errorBody: ResponseBody? = null
    ) : ApiResult<T>(responseCode)
}
