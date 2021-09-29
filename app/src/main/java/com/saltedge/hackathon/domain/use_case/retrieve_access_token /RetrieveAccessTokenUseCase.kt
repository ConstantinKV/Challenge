package com.saltedge.hackathon.domain.use_case.retrieve_access_token

import com.saltedge.hackathon.common.Resource
import com.saltedge.hackathon.data.remote.dto.token.AccessTokenResponse
import com.saltedge.hackathon.domain.repository.AccessTokenRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class RetrieveAccessTokenUseCase @Inject constructor(
    private val repository: AccessTokenRepository
) {

    private val clientId = "P1zLA3tA6nYG9ajTw2u5WWex6tmRB7OTi5JGKcCqSlc="
    private val clientSecret = "-Gz5gyDPARbji_sWCSvgJLoV8F1c5VVEkS2aneIUDeY="

    operator fun invoke(): Flow<Resource<AccessTokenResponse>> = flow {
        try {
            emit(Resource.Loading<AccessTokenResponse>())
            val accessToken: AccessTokenResponse = repository.requestToken(
                grantType = "client_credentials",
                clientId = clientId,
                clientSecret = clientSecret,
                scope = "accounts"
            )
            emit(Resource.Success<AccessTokenResponse>(accessToken))
        } catch (e: HttpException) {
            emit(Resource.Error<AccessTokenResponse>(message = e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error<AccessTokenResponse>(message = "Couldn't reach server. Check your Internet connection"))
        }
    }
}