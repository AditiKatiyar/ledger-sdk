package lib.dehaat.ledger.data.repositories

import lib.dehaat.ledger.data.mapper.AccountingApiResponseMapper
import lib.dehaat.ledger.data.source.AccountingSource
import lib.dehaat.ledger.domain.repositories.IAccountingRepository
import lib.dehaat.ledger.entities.*
import javax.inject.Inject

class AccountingRepository @Inject constructor(
    private val source: AccountingSource,
    private val mapper: AccountingApiResponseMapper
) : IAccountingRepository {

    override suspend fun getLedger(): ApiResultEntity<LedgerEntity> =
        source.getLedger().let { mapper.toLedgerEntity(it) }

    override suspend fun getLedgerTransactions(
        redirectionUrl: String,
        queries: Map<String, Any>
    ): ApiResultEntity<LedgerTransactionsEntity> =
        source.getLedgerTransactions(redirectionUrl, queries)
            .let { mapper.toLedgerTransactionsEntity(it) }

    override suspend fun getCredits(
        redirectionUrl: String
    ): ApiResultEntity<CreditsEntity> =
        source.getCredits(redirectionUrl).let { mapper.toCreditsEntity(it) }

    override suspend fun getTransactionDetail(
        redirectionUrl: String
    ): ApiResultEntity<TransactionDetailEntity> =
        source.getTransactionDetail(redirectionUrl).let { mapper.toTransactionDetailEntity(it) }
}