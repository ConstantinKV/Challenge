package com.saltedge.hackathon.data.repository

import com.saltedge.hackathon.data.remote.ApiInterface
import com.saltedge.hackathon.data.remote.dto.AccountDto
import com.saltedge.hackathon.data.remote.dto.AccountsResponse
import com.saltedge.hackathon.data.remote.dto.toAccount
import com.saltedge.hackathon.domain.model.Account
import com.saltedge.hackathon.domain.repository.AccountRepository
import javax.inject.Inject

class AccountRepositoryImpl @Inject constructor(
    private val api: ApiInterface
) : AccountRepository {

    override suspend fun getAccounts(): AccountsResponse {
        return api.getAccounts()
    }

    override suspend fun getAccountById(accountId: String): Account? {
        val response: AccountsResponse = api.getAccountById(accountId)
        val accountDto: AccountDto? = response.data.accounts.firstOrNull { it.accountId == accountId }
        return accountDto?.toAccount()
    }
}