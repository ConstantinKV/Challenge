package com.saltedge.hackathon.data.remote.dto

import com.google.gson.annotations.SerializedName

data class Servicer(
    @SerializedName("Identification")
    val identification: String,
    @SerializedName("SchemeName")
    val schemeName: String
)