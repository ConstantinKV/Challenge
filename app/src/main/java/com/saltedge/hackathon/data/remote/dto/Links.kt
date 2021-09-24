package com.saltedge.hackathon.data.remote.dto

import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("Next")
    val next: String,
    @SerializedName("Prev")
    val prev: String,
    @SerializedName("Self")
    val self: String
)