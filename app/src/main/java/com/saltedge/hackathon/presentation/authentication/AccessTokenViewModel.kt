package com.saltedge.hackathon.presentation.authentication

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saltedge.hackathon.common.Resource
import com.saltedge.hackathon.domain.use_case.create_consent.CreateConsentUseCase
import com.saltedge.hackathon.domain.use_case.retrieve_access_token.RetrieveAccessTokenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class AccessTokenViewModel @Inject constructor(
    private val retrieveAccessTokenUseCase: RetrieveAccessTokenUseCase,
    private val createConsentUseCase: CreateConsentUseCase
): ViewModel() {

    init {
        sendRequest()
    }

    private fun sendRequest() {
        retrieveAccessTokenUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    val accessToken = result.data?.accessToken ?: "" //TODO: check type
                    createConsent(accessToken)
                }
                is Resource.Error -> {
                    Log.d("some", "error vm ${result.message}")
                }
                is Resource.Loading -> {
                    Log.d("some", "loading vm")
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun createConsent(accessToken: String) {
        createConsentUseCase(accessToken = accessToken).launchIn(viewModelScope) //TODO: review the implementation of this method(launchIn)
    }
}