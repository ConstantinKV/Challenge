package com.saltedge.hackathon.data.remote

import com.saltedge.hackathon.data.remote.dto.AccountsResponse
import com.saltedge.hackathon.data.remote.dto.consent.ConsentResponse
import com.saltedge.hackathon.data.remote.dto.token.AccessTokenResponse
import com.saltedge.hackathon.data.remote.request.CreateConsentRequest
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

    //TODO:  remove the hard code and think about how to take everything out to some HeaderInterceptor
    @Headers(
        "Authorization: Bearer ACCESS_TOKEN",
        "Accept: application/json",
        "Content-Type: application/json"
    )
    @POST("/open-banking/v3.1/aisp/account-access-consents")
    suspend fun createConsent(
        @Header("ACCESS_TOKEN") accessToken: String,
        @Body body: CreateConsentRequest
    ): ConsentResponse

    @GET("/accounts")
    suspend fun getAccounts(): AccountsResponse

    @GET("accounts/{AccountId}")
    suspend fun getAccountById(@Path("AccountId") AccountId: String): AccountsResponse
}