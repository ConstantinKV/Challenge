package com.saltedge.hackathon.data.remote.dto

import com.google.gson.annotations.SerializedName

data class Meta(
    @SerializedName("TotalPages")
    val totalPages: Int
)