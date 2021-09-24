package com.saltedge.hackathon.domain.repository

import com.saltedge.hackathon.data.remote.dto.AccountsResponse
import com.saltedge.hackathon.domain.model.Account

interface AccountRepository {

    suspend fun getAccounts(): AccountsResponse

    suspend fun getAccountById(accountId: String): Account?
}