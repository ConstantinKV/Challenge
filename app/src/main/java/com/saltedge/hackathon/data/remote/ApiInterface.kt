package com.saltedge.hackathon.data.remote

import com.saltedge.hackathon.data.remote.dto.AccountsResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("/accounts")
    suspend fun getAccounts(): AccountsResponse

    @GET("accounts/{AccountId}")
    suspend fun getAccountById(@Path("AccountId") AccountId: String): AccountsResponse
}