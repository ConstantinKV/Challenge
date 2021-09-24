package com.saltedge.hackathon.data.remote.dto

import com.google.gson.annotations.SerializedName

data class AccountsResponse(
    @SerializedName("Data")
    val data: AccountsResponseData,
    @SerializedName("Links")
    val links: Links,
    @SerializedName("Meta")
    val meta: Meta
)