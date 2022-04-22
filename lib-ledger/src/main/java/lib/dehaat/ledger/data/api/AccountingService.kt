package lib.dehaat.ledger.data.api

import lib.dehaat.ledger.data.model.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap
import retrofit2.http.Url

interface AccountingService {

    @GET("/accounting/ledger/v3")
    suspend fun getLedger(): Response<LedgerResponse>

    @GET("/accounting/invoices")
    suspend fun getInvoiceKey(
        @Query("invoice_id") id: Long
    ): Response<InvoiceKeyResponse>

    @GET
    suspend fun getCredits(
        @Url redirectionUrl: String
    ): Response<CreditsResponse>

    @GET
    suspend fun getLedgerTransactions(
        @Url redirectionUrl: String,
        @QueryMap queries: Map<String, Any>
    ): Response<LedgerTransactionsResponse>

    @GET
    suspend fun getTransactionDetail(
        @Url redirectionUrl: String
    ): Response<TransactionDetailResponse>
}