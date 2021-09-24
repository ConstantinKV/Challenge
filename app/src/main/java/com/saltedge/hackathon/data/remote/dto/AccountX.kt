package com.saltedge.hackathon.data.remote.dto

import com.google.gson.annotations.SerializedName

data class AccountX(
    @SerializedName("Identification")
    val identification: String,
    @SerializedName("Name")
    val name: String,
    @SerializedName("SchemeName")
    val schemeName: String,
    @SerializedName("SecondaryIdentification")
    val secondaryIdentification: String
)