package lib.dehaat.ledger.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class LedgerEntity(
    val outstanding: OutstandingEntity,

    @Json(name = "data_urls")
    val dataUrls: List<DataUrlEntity>
)

@JsonClass(generateAdapter = true)
data class OutstandingEntity(
    @Json(name = "outstanding_amount")
    val outstandingAmount: Double,

    @Json(name = "is_pay_now_enabled")
    val isPayNowEnabled: Boolean,

    @Json(name = "outstanding_details")
    val outstandingDetails: List<OutstandingDetailEntity>?,

    @Json(name = "credit_lines")
    val creditLines: List<CreditLineEntity>?
)

@JsonClass(generateAdapter = true)
data class CreditLineEntity(
    @Json(name = "type")
    val viewType: String,
    val name: String,
    val amount: Double?
)

@JsonClass(generateAdapter = true)
data class DataUrlEntity(
    @Json(name = "type")
    val type: String,

    val name: String,

    @Json(name = "redirection_url")
    val redirectionUrl: String
)
