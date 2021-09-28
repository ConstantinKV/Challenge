package com.saltedge.hackathon.data.remote

import com.saltedge.hackathon.data.remote.dto.AccountsResponse
import com.saltedge.hackathon.data.remote.dto.token.AccessTokenResponse
import retrofit2.http.*

interface ApiInterface {

    @Headers(
        "Accept: application/json",
        "Content-Type: application/x-www-form-urlencoded"
    )
    @POST("/token")
    suspend fun requestToken(
        @Query("grant_type") grantType: String,
        @Query("client_id") clientId: String,
        @Query("client_secret") clientSecret: String,
        @Query("scope") scope: String,
    ): AccessTokenResponse

    @GET("/accounts")
    suspend fun getAccounts(): AccountsResponse

    @GET("accounts/{AccountId}")
    suspend fun getAccountById(@Path("AccountId") AccountId: String): AccountsResponse
}