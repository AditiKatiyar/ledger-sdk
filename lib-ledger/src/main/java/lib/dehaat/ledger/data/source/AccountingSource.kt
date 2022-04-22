package lib.dehaat.ledger.data.source

import lib.dehaat.ledger.data.api.AccountingService
import lib.dehaat.ledger.data.getResult
import javax.inject.Inject

class AccountingSource @Inject constructor(
    private val service: AccountingService
) {
    suspend fun getLedger() =
        getResult { service.getLedger() }

    suspend fun getLedgerTransactions(
        redirectionUrl: String,
        queries: Map<String, Any>
    ) = getResult { service.getLedgerTransactions(redirectionUrl, queries) }

    suspend fun getCredits(redirectionUrl: String) =
        getResult { service.getCredits(redirectionUrl) }

    suspend fun getTransactionDetail(redirectionUrl: String) =
        getResult { service.getTransactionDetail(redirectionUrl) }
}