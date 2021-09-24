package com.saltedge.hackathon.presentation.account_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saltedge.hackathon.common.Resource
import com.saltedge.hackathon.domain.use_case.get_accounts.GetAccountsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class AccountListViewModel @Inject constructor(
    private val getAccountsUseCase: GetAccountsUseCase
): ViewModel() {

    private val _state = mutableStateOf<AccountListState>(AccountListState())
    val state: State<AccountListState> = _state

    init {
        getAccounts()
    }

    private fun getAccounts() {
        getAccountsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = AccountListState(accounts = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = AccountListState(error = result.message ?: "Something went wrong")
                }
                is Resource.Loading -> {
                    _state.value = AccountListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}