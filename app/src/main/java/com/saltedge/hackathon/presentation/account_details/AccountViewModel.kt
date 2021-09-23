package com.saltedge.hackathon.presentation.account_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saltedge.hackathon.common.Constants
import com.saltedge.hackathon.common.Resource
import com.saltedge.hackathon.domain.use_case.get_account.GetAccountUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class AccountViewModel @Inject constructor(
    private val getAccountUseCase: GetAccountUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf<AccountState>(AccountState())
    val state: State<AccountState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_ACCOUNT_ID)?.let { accountId ->
            getAccount(accountId = accountId)
        }
    }

    private fun getAccount(accountId: String) {
        getAccountUseCase(accountId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = AccountState(account = result.data)
                }
                is Resource.Error -> {
                    _state.value = AccountState(error = result.message ?: "Something went wrong")
                }
                is Resource.Loading -> {
                    _state.value = AccountState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}