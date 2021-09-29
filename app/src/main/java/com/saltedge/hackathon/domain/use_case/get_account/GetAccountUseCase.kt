package com.saltedge.hackathon.domain.use_case.get_account

import com.saltedge.hackathon.common.Resource
import com.saltedge.hackathon.domain.model.Account
import com.saltedge.hackathon.domain.repository.AccountRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetAccountUseCase @Inject constructor(
    private val repository: AccountRepository
) {

    operator fun invoke(accountId: String): Flow<Resource<Account>> = flow {
        try {
            emit(Resource.Loading<Account>())
            val account: Account? = repository.getAccountById(accountId = accountId)
            if (account != null) emit(Resource.Success<Account>(account))
            else emit(Resource.Error<Account>("There is no account with this id"))
        } catch (e: HttpException) {
            emit(Resource.Error<Account>(message = e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error<Account>(message = "Couldn't reach server. Check your Internet connection"))
        }
    }
}