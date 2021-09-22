package com.saltedge.hackathon.data.repository

import com.saltedge.hackathon.data.remote.ApiInterface
import com.saltedge.hackathon.data.remote.dto.AccountDto
import com.saltedge.hackathon.data.remote.dto.AccountsDto
import com.saltedge.hackathon.domain.repository.AccountRepository
import javax.inject.Inject

class AccountRepositoryImpl @Inject constructor(
    private val api: ApiInterface
): AccountRepository {

    override suspend fun getAccounts(): List<AccountsDto> {
        return api.getAccounts()
    }

    override suspend fun getAccountById(accountId: String): AccountDto {
        return api.getAccountById(accountId)
    }
}