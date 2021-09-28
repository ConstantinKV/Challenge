package com.saltedge.hackathon.domain.repository

import com.saltedge.hackathon.data.remote.dto.token.AccessTokenResponse

interface TokenRepository {

    suspend fun requestToken(
        grantType: String,
        clientId: String,
        clientSecret: String,
        scope: String
    ): AccessTokenResponse
}