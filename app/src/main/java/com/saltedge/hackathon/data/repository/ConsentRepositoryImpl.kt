package com.saltedge.hackathon.data.repository

import com.saltedge.hackathon.data.remote.ApiInterface
import com.saltedge.hackathon.data.remote.dto.consent.ConsentResponse
import com.saltedge.hackathon.data.remote.request.CreateConsentRequest
import com.saltedge.hackathon.domain.repository.ConsentRepository
import javax.inject.Inject

class ConsentRepositoryImpl@Inject constructor(
    private val api: ApiInterface
) : ConsentRepository {

    override suspend fun createConsent(
        accessToken: String,
        body: CreateConsentRequest
    ): ConsentResponse {
        return api.createConsent(accessToken = accessToken, body = body)
    }
}