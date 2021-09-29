package com.saltedge.hackathon.data.remote.dto.consent

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("ConsentId")
    val consentId: String,
    @SerializedName("CreationDateTime")
    val creationDateTime: String,
    @SerializedName("Permissions")
    val permissions: List<String>,
    @SerializedName("Status")
    val status: String,
    @SerializedName("StatusUpdateDateTime")
    val statusUpdateDateTime: String
)