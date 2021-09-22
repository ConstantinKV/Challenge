package com.saltedge.hackathon.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.saltedge.hackathon.domain.model.Account

data class AccountDto(
    val Account: AccountX,
    val AccountId: String,
    val AccountSubType: String,
    val AccountType: String,
    @SerializedName("Currency") //TODO: use name convection for all variables
    val currency: String,
    val Description: String,
    val Nickname: String,
    val Servicer: Servicer,
    val SwitchStatus: String
)

 fun AccountDto.toAccount(): Account {
     return Account(
         currency = currency,
         description = Description,
         nickname = Nickname
     )
 }