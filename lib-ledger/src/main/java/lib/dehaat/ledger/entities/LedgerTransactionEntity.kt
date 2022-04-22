package lib.dehaat.ledger.entities

data class LedgerTransactionsEntity(
    val transactionInfo: TransactionInfoEntity,
    val transactions: List<LedgerTransactionEntity>
)

data class TransactionInfoEntity(
    val purchase: Double,
    val payment: Double
)

data class LedgerTransactionEntity(
    val viewType: String,

    val amount: Double,

    val timestamp: Long,

    val documentType: String,

    val displayName: String,

    val redirectionUrl: String?,

    val note: String?,

    val noteColor: String?,

    val paymentMode: String? = null,

    val creditNoteReason: String? = null
)