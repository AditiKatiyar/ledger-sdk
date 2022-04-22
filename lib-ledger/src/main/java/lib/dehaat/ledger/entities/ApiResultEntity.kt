package lib.dehaat.ledger.entities

import okhttp3.ResponseBody

sealed class ApiResultEntity<T>(val responseCode: Int) {
    class Success<T>(
        val data: T?,
        responseCode: Int = 200
    ) : ApiResultEntity<T>(responseCode)

    class Failure<T>(
        responseCode: Int,
        val errorMessage: String?,
        val errorBody: ResponseBody? = null
    ) : ApiResultEntity<T>(responseCode)
}