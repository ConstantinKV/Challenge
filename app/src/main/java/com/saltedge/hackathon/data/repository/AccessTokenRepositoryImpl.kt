package com.saltedge.hackathon.data.repository

import com.saltedge.hackathon.data.remote.ApiInterface
import com.saltedge.hackathon.data.remote.dto.token.AccessTokenResponse
import com.saltedge.hackathon.domain.repository.AccessTokenRepository
import javax.inject.Inject

class AccessTokenRepositoryImpl @Inject constructor(
    private val api: ApiInterface
) : AccessTokenRepository {

    override suspend fun requestToken(
        grantType: String,
        clientId: String,
        clientSecret: String,
        scope: String
    ): AccessTokenResponse {
        return api.requestToken(
            grantType = grantType,
            clientId = clientId,
            clientSecret = clientSecret,
            scope = scope
        )
    }
}