package lib.dehaat.ledger.data.model

import com.google.gson.JsonArray
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TransactionDetailResponse(
    val data: TransactionDetail
)

@JsonClass(generateAdapter = true)
data class TransactionDetail(
    @Json(name = "items")
    val items: JsonArray = JsonArray()
)