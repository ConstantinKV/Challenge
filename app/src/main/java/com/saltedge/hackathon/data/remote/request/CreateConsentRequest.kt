package com.saltedge.hackathon.data.remote.request

import com.google.gson.annotations.SerializedName
import com.saltedge.hackathon.data.remote.dto.consent.Risk

data class CreateConsentRequest(
    @SerializedName("Data") val data: CreateConsentRequestData,
    @SerializedName("Risk") val risk: Risk
)

data class CreateConsentRequestData(
    @SerializedName("Permissions") val permissions: List<String>
)