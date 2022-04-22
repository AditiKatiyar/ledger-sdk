package lib.dehaat.ledger.domain.repositories

import lib.dehaat.ledger.entities.*

interface IAccountingRepository {
    suspend fun getLedger(): ApiResultEntity<LedgerEntity>

    suspend fun getLedgerTransactions(
        redirectionUrl: String,
        queries: Map<String, Any>
    ): ApiResultEntity<LedgerTransactionsEntity>

    suspend fun getCredits(
        redirectionUrl: String
    ): ApiResultEntity<CreditsEntity>

    suspend fun getTransactionDetail(
        redirectionUrl: String
    ): ApiResultEntity<TransactionDetailEntity>
}