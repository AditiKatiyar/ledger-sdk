package lib.dehaat.ledger.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LedgerResponse(
    val data: Ledger
)

@JsonClass(generateAdapter = true)
data class Ledger(
    val outstanding: Outstanding,

    @Json(name = "data_urls")
    val dataUrls: List<DataUrl>
)

@JsonClass(generateAdapter = true)
data class Outstanding(
    @Json(name = "outstanding_amount")
    val outstandingAmount: Double,

    @Json(name = "is_pay_now_enabled")
    val isPayNowEnabled: Boolean,

    @Json(name = "outstanding_details")
    val outstandingDetails: List<OutstandingDetail>?,

    @Json(name = "credit_lines")
    val creditLines: List<CreditLine>?
)

@JsonClass(generateAdapter = true)
data class CreditLine(
    @Json(name = "type")
    val viewType: String,
    val name: String,
    val amount: Double?
)

@JsonClass(generateAdapter = true)
data class DataUrl(
    @Json(name = "type")
    val type: String,

    val name: String,

    @Json(name = "redirection_url")
    val redirectionUrl: String
)