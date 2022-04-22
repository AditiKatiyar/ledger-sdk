package lib.dehaat.ledger.entities

data class OutstandingDetailEntity(
    val viewType: String,
    val key: String,
    val value: String,
    val dataType: String? = null
)
