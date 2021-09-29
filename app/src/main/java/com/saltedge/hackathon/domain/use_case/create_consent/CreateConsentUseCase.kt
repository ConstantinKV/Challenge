package com.saltedge.hackathon.domain.use_case.create_consent

import com.saltedge.hackathon.common.Resource
import com.saltedge.hackathon.data.remote.dto.consent.ConsentResponse
import com.saltedge.hackathon.data.remote.dto.consent.Risk
import com.saltedge.hackathon.data.remote.request.CreateConsentRequest
import com.saltedge.hackathon.data.remote.request.CreateConsentRequestData
import com.saltedge.hackathon.domain.repository.ConsentRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CreateConsentUseCase @Inject constructor(
    private val repository: ConsentRepository
) {

    operator fun invoke(accessToken: String): Flow<Resource<ConsentResponse>> = flow {
        try {
            emit(Resource.Loading<ConsentResponse>())
            val permissions: List<String> = listOf(
                "ReadAccountsDetail",
                "ReadBalances",
                "ReadTransactionsCredits",
                "ReadTransactionsDebits",
                "ReadTransactionsDetail"
            )
            val requestBody = CreateConsentRequest(
                data = CreateConsentRequestData(
                    permissions = permissions
                ),
                risk = Risk()
            )
            val consent: ConsentResponse = repository.createConsent(
                accessToken = accessToken,
                body = requestBody
            )
            emit(Resource.Success<ConsentResponse>(consent))
        } catch (e: HttpException) {
            emit(
                Resource.Error<ConsentResponse>(
                    message = e.localizedMessage ?: "An unexpected error occured"
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error<ConsentResponse>(message = "Couldn't reach server. Check your Internet connection"))
        }
    }
}