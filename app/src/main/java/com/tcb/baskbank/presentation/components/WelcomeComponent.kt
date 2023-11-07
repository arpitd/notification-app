package com.tcb.baskbank.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.Text
import com.tcb.baskbank.R
import com.tcb.baskbank.presentation.Screen

@Composable
fun WelcomeComponent(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(18.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            modifier = Modifier
                .width(100.dp)
                .height(16.dp)
                .align(Alignment.CenterHorizontally),
            painter = painterResource(id = R.drawable.bask_logo),
            contentDescription = "bask logo"
        )
        Spacer(modifier = Modifier.height(14.dp))
        Text(
            text = "Welcome to",
            fontSize = 17.sp,
        )
        Text(
            text = "Bask Digital Bank",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                navController.navigate(Screen.DashboardComponent.route)
            },
            modifier = Modifier
                .width(38.dp)
                .height(38.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.arrow_icon),
                contentDescription = "go button arrow",
                tint = Color.White
            )
        }
    }
}