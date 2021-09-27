package com.saltedge.hackathon.domain.model

/**
 * This is data class that we will use to display specific account data in our list
 */
data class Account(
//    val Account: AccountX,
    val accountId: String,
//    val AccountSubType: String,
//    val AccountType: String,
    val currency: String,
    val description: String,
    val nickname: String,
//    val Servicer: Servicer,
//    val SwitchStatus: String
)
