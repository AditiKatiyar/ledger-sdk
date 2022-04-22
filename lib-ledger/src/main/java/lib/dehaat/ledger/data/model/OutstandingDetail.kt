package lib.dehaat.ledger.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class OutstandingDetail(
    @Json(name = "type")
    val viewType: String,

    val key: String,

    val value: String,

    @Json(name = "data_type")
    val dataType: String? = null
)