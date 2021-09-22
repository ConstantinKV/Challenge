package com.saltedge.hackathon.data.remote

import com.saltedge.hackathon.data.remote.dto.AccountDto
import com.saltedge.hackathon.data.remote.dto.AccountsDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("/accounts")
    suspend fun getAccounts(): List<AccountsDto> //TODO check return type

    @GET("accounts/{AccountId}")
    suspend fun getAccountById(@Path("AccountId") AccountId: String): AccountDto
}