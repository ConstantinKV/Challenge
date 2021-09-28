package com.saltedge.hackathon.domain.use_case.get_accounts

import com.saltedge.hackathon.common.Resource
import com.saltedge.hackathon.data.remote.dto.toAccount
import com.saltedge.hackathon.domain.model.Account
import com.saltedge.hackathon.domain.repository.AccountRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetAccountsUseCase @Inject constructor(
    private val repository: AccountRepository
) {

    operator fun invoke(): Flow<Resource<List<Account>>> = flow {
        try {
            emit(Resource.Loading<List<Account>>())
            val accounts: List<Account> = repository.getAccounts().data.accounts.map { it.toAccount() }
            emit(Resource.Success<List<Account>>(accounts))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Account>>(message = e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Account>>(message = "Couldn't reach server. Check your Internet connection"))
        }
    }
}