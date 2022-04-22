package lib.dehaat.ledger.domain.usecases

import lib.dehaat.ledger.domain.repositories.IAccountingRepository

class LedgerListingUseCase(
    private val repository: IAccountingRepository
) {
    suspend fun getLedger() =
        repository.getLedger()

    suspend fun getLedgerTransactions(url: String, queries: Map<String, Any>) =
        repository.getLedgerTransactions(url, queries)

    suspend fun getCredits(url: String) =
        repository.getCredits(url)
}