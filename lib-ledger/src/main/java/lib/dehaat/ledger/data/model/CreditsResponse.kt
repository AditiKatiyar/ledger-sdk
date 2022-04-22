package lib.dehaat.ledger.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CreditsResponse(
    val data: Credits
)

@JsonClass(generateAdapter = true)
data class Credits(
    @Json(name = "available_credit_limit")
    val availableCreditLimit: Double?,

    @Json(name = "items")
    val credits: List<Credit>
)

@JsonClass(generateAdapter = true)
data class Credit(
    @Json(name = "type")
    val viewType: String,

    @Json(name = "credit_line_label")
    val creditLabel: String,

    @Json(name = "bg_color")
    val bgColor: String,

    @Json(name = "divider_color")
    val dividerColor: String,

    @Json(name = "outstanding_amount_label")
    val outstandingAmountLabel: String,

    @Json(name = "outstanding_amount")
    val outstandingAmount: Double,

    @Json(name = "credit_limit_label")
    val creditLimitLabel: String,

    @Json(name = "credit_limit")
    val creditLimit: Double,

    @Json(name = "outstanding_details")
    val outstandingDetails: List<OutstandingDetail>?
)