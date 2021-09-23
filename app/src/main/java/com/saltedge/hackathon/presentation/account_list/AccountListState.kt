package com.saltedge.hackathon.presentation.account_list

import com.saltedge.hackathon.data.remote.dto.AccountDto

data class AccountListState(
    val isLoading: Boolean = false,
    val accounts: List<AccountDto> = emptyList(),
    val error: String = ""
)