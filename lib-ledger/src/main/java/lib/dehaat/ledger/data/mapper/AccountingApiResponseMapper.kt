package lib.dehaat.ledger.data.mapper

import lib.dehaat.ledger.data.model.*
import lib.dehaat.ledger.entities.*
import javax.inject.Inject

class AccountingApiResponseMapper @Inject constructor() {

    fun toLedgerEntity(
        result: ApiResult<LedgerResponse>
    ): ApiResultEntity<LedgerEntity> = when (result) {
        is ApiResult.Failure ->
            ApiResultEntity.Failure(result.responseCode, result.errorMessage, result.errorBody)
        is ApiResult.Success ->
            ApiResultEntity.Success(createLedgerEntity(result.data?.data))
    }

    fun toLedgerTransactionsEntity(
        result: ApiResult<LedgerTransactionsResponse>
    ): ApiResultEntity<LedgerTransactionsEntity> = when (result) {
        is ApiResult.Failure ->
            ApiResultEntity.Failure(result.responseCode, result.errorMessage, result.errorBody)
        is ApiResult.Success ->
            ApiResultEntity.Success(createLedgerTransactionsEntity(result.data?.data))
    }

    fun toCreditsEntity(
        result: ApiResult<CreditsResponse>
    ): ApiResultEntity<CreditsEntity> = when (result) {
        is ApiResult.Failure ->
            ApiResultEntity.Failure(result.responseCode, result.errorMessage, result.errorBody)
        is ApiResult.Success ->
            ApiResultEntity.Success(createCreditsEntity(result.data?.data))
    }

    fun toTransactionDetailEntity(
        result: ApiResult<TransactionDetailResponse>
    ): ApiResultEntity<TransactionDetailEntity> = when (result) {
        is ApiResult.Failure ->
            ApiResultEntity.Failure(result.responseCode, result.errorMessage, result.errorBody)
        is ApiResult.Success ->
            ApiResultEntity.Success(createTransactionDetailEntity(result.data?.data))
    }

    private fun createLedgerEntity(data: Ledger?) = data?.let {
        LedgerEntity(
            createOutstandingEntity(it.outstanding),
            createDataUrlEntity(it.dataUrls)
        )
    }

    private fun createOutstandingEntity(outstanding: Outstanding) = with(outstanding) {
        OutstandingEntity(
            outstandingAmount,
            isPayNowEnabled,
            createOutstandingDetailsEntity(outstandingDetails),
            createCreditLinesEntity(creditLines)
        )
    }

    private fun createOutstandingDetailsEntity(
        outstandingDetails: List<OutstandingDetail>?
    ) = outstandingDetails?.map {
        with(it) {
            OutstandingDetailEntity(viewType, key, value, dataType)
        }
    }

    private fun createCreditLinesEntity(
        creditLines: List<CreditLine>?
    ) = creditLines?.map {
        with(it) {
            CreditLineEntity(viewType, name, amount)
        }
    }

    private fun createDataUrlEntity(
        dataUrls: List<DataUrl>
    ) = dataUrls.map {
        with(it) {
            DataUrlEntity(type, name, redirectionUrl)
        }
    }

    private fun createLedgerTransactionsEntity(
        data: LedgerTransactions?
    ) = data?.let {
        LedgerTransactionsEntity(
            createTransactionInfoEntity(it.transactionInfo),
            createTransactionEntity(it.transactions)
        )
    }

    private fun createTransactionInfoEntity(
        transactionInfo: TransactionInfo
    ) = with(transactionInfo) { TransactionInfoEntity(purchase, payment) }

    private fun createTransactionEntity(
        transactions: List<LedgerTransaction>
    ) = transactions.map {
        with(it) {
            LedgerTransactionEntity(
                viewType,
                amount,
                timestamp,
                documentType,
                displayName,
                redirectionUrl,
                note,
                noteColor,
                paymentMode,
                creditNoteReason
            )
        }
    }

    private fun createCreditsEntity(data: Credits?) = data?.let {
        CreditsEntity(
            it.availableCreditLimit,
            createCreditEntity(it.credits)
        )
    }

    private fun createCreditEntity(
        credits: List<Credit>
    ) = credits.map {
        with(it) {
            CreditEntity(
                viewType,
                creditLabel,
                bgColor,
                dividerColor,
                outstandingAmountLabel,
                outstandingAmount,
                creditLimitLabel,
                creditLimit,
                createOutstandingDetailsEntity(it.outstandingDetails)
            )
        }
    }

    private fun createTransactionDetailEntity(
        data: TransactionDetail?
    ) = data?.let { TransactionDetailEntity(it.items) }
}