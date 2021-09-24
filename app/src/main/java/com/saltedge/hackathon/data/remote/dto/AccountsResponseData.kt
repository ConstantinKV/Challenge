package com.saltedge.hackathon.data.remote.dto

import com.google.gson.annotations.SerializedName

data class AccountsResponseData(
    @SerializedName("Account")
    val accounts: List<AccountDto>
)