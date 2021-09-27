package com.saltedge.hackathon.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.saltedge.hackathon.domain.model.Account

data class AccountDto(
    @SerializedName("Account")
    val account: AccountX,
    @SerializedName("AccountId")
    val accountId: String,
    @SerializedName("AccountSubType")
    val accountSubType: String,
    @SerializedName("AccountType")
    val accountType: String,
    @SerializedName("Currency")
    val currency: String,
    @SerializedName("Description")
    val description: String,
    @SerializedName("Nickname")
    val nickname: String,
    @SerializedName("Servicer")
    val servicer: Servicer,
    @SerializedName("SwitchStatus")
    val switchStatus: String
)

 fun AccountDto.toAccount(): Account {
     return Account(
         accountId = accountId,
         currency = currency,
         description = description,
         nickname = nickname
     )
 }