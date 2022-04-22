package lib.dehaat.ledger.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LedgerTransactionsResponse(
    val data: LedgerTransactions
)

@JsonClass(generateAdapter = true)
data class LedgerTransactions(
    @Json(name = "transaction_info")
    val transactionInfo: TransactionInfo,

    @Json(name = "items")
    val transactions: List<LedgerTransaction>
)

@JsonClass(generateAdapter = true)
data class TransactionInfo(
    val purchase: Double,
    val payment: Double
)

@JsonClass(generateAdapter = true)
data class LedgerTransaction(
    @Json(name = "type")
    val viewType: String,

    val amount: Double,

    @Json(name = "date")
    val timestamp: Long,

    @Json(name = "document_type")
    val documentType: String,

    @Json(name = "display_name")
    val displayName: String,

    @Json(name = "href")
    val redirectionUrl: String?,

    val note: String?,

    @Json(name = "note_color")
    val noteColor: String?,

    @Json(name = "payment_method")
    val paymentMode: String? = null,

    @Json(name = "credit_note_reason")
    val creditNoteReason: String? = null
)