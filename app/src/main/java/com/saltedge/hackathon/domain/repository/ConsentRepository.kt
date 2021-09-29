package com.saltedge.hackathon.domain.repository

import com.saltedge.hackathon.data.remote.dto.consent.ConsentResponse
import com.saltedge.hackathon.data.remote.request.CreateConsentRequest

interface ConsentRepository {

    suspend fun createConsent(accessToken: String, body: CreateConsentRequest): ConsentResponse
}
