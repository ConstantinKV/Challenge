package com.saltedge.hackathon.presentation

sealed class Screen(val route: String) {
    object AccountListScreen: Screen("account_list_screen")
    object AccountDetailScreen: Screen("account_detail_screen")
    object AuthenticationScreen: Screen("auth_screen")
}