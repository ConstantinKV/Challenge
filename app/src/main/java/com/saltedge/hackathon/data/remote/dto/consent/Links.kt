package com.saltedge.hackathon.data.remote.dto.consent

import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("Self")
    val self: String
)