package com.saltedge.hackathon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.saltedge.hackathon.presentation.Screen
import com.saltedge.hackathon.presentation.account_list.components.AccountListScreen
import com.saltedge.hackathon.ui.theme.HackathonTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HackathonTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.AccountListScreen.route
                    ) {
                        composable(
                            route = Screen.AccountListScreen.route
                        ) {
                            AccountListScreen(navController)
                        }
//                        composable(
//                            route = Screen.AccountDetailScreen.route + "/{accountId}"
//                        ) {
//                            AccountDetailScreen()
//                        }
                    }
                }
            }
        }
    }
}