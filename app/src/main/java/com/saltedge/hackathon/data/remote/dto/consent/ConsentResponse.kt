package com.saltedge.hackathon.data.remote.dto.consent

import com.google.gson.annotations.SerializedName

data class ConsentResponse(
    @SerializedName("Data")
    val data: Data,
    @SerializedName("Links")
    val links: Links,
    @SerializedName("Meta")
    val meta: Meta,
    @SerializedName("Risk")
    val risk: Risk
)