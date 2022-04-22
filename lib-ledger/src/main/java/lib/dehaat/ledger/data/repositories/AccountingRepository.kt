package lib.dehaat.ledger.data.repositories

import lib.dehaat.ledger.data.mapper.AccountingApiResponseMapper
import lib.dehaat.ledger.data.source.AccountingSource
import javax.inject.Inject

class AccountingRepository @Inject constructor(
    private val source: AccountingSource,
    private val mapper: AccountingApiResponseMapper
) {

    suspend fun getLedger() =
        source.getLedger().let { mapper.toLedgerEntity(it) }

    suspend fun getLedgerTransactions(
        redirectionUrl: String,
        queries: Map<String, Any>
    ) = source.getLedgerTransactions(redirectionUrl, queries)
        .let { mapper.toLedgerTransactionsEntity(it) }

    suspend fun getCredits(redirectionUrl: String) =
        source.getCredits(redirectionUrl).let { mapper.toCreditsEntity(it) }

    suspend fun getTransactionDetail(redirectionUrl: String) =
        source.getTransactionDetail(redirectionUrl).let { mapper.toTransactionDetailEntity(it) }
}