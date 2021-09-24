package com.saltedge.hackathon.presentation.account_list

import com.saltedge.hackathon.domain.model.Account

data class AccountListState(
    val isLoading: Boolean = false,
    val accounts: List<Account> = emptyList(),
    val error: String = ""
)