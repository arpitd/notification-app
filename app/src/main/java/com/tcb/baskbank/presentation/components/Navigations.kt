package com.tcb.baskbank.presentation.components

import androidx.compose.runtime.Composable
import androidx.wear.compose.material.ExperimentalWearMaterialApi
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.composable
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController
import com.tcb.baskbank.presentation.Screen


@OptIn(ExperimentalWearMaterialApi::class)
@Composable
fun Navigations() {

    val navController = rememberSwipeDismissableNavController()
    SwipeDismissableNavHost(navController = navController, startDestination = Screen.WelcomeComponent.route) {
        composable(route = Screen.WelcomeComponent.route) {
            WelcomeComponent(navController = navController)
        }

        composable(route = Screen.DashboardComponent.route) {
            DashboardComponent(navController = navController)
        }

        composable(route = Screen.CategoryDetailComponent.route) {
            CategoryDetailComponent(/*navController = navController*/)
        }

        composable(route = Screen.CreditOverviewComponent.route) {
            CreditOverviewComponent(navController = navController)
        }

    }

}
