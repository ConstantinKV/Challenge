package com.saltedge.hackathon.presentation.account_details

import com.saltedge.hackathon.domain.model.Account

data class AccountState(
    val isLoading: Boolean = false,
    val account: Account? = null,
    val error: String = ""
)