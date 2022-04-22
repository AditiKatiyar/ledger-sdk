package lib.dehaat.ledger.entities

data class CreditsEntity(
    val availableCreditLimit: Double?,
    val credits: List<CreditEntity>
)

data class CreditEntity(
    val viewType: String,
    val creditLabel: String,
    val bgColor: String,
    val dividerColor: String,
    val outstandingAmountLabel: String,
    val outstandingAmount: Double,
    val creditLimitLabel: String,
    val creditLimit: Double,
    val outstandingDetails: List<OutstandingDetailEntity>?
)
