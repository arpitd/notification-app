package com.tcb.baskbank.presentation

sealed class Screen(val route: String) {
    object WelcomeComponent: Screen("welcome_component")
    object DashboardComponent: Screen("dashboard_component")
    object CategoryDetailComponent: Screen("category_detail_component")
}
