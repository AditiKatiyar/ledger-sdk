package lib.dehaat.ledger.domain.usecases

import lib.dehaat.ledger.domain.repositories.IAccountingRepository
import javax.inject.Inject

class TransactionDetailUseCase @Inject constructor(
    private val repository: IAccountingRepository
) {
    suspend fun getTransactionDetail(url: String) = repository.getTransactionDetail(url)
}