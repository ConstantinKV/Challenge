package com.saltedge.hackathon.domain.repository

import com.saltedge.hackathon.data.remote.dto.AccountDto
import com.saltedge.hackathon.data.remote.dto.AccountsDto

interface AccountRepository {

    suspend fun getAccounts(): List<AccountsDto>

    suspend fun getAccountById(accountId: String): AccountDto
}