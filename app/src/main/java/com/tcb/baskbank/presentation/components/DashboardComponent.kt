package com.tcb.baskbank.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.wear.compose.material.*
import com.tcb.baskbank.R
import com.tcb.baskbank.presentation.Screen
import com.tcb.baskbank.presentation.data.Category
import com.tcb.baskbank.presentation.theme.BgColor
import com.tcb.baskbank.presentation.theme.Purple200
import com.tcb.baskbank.presentation.theme.ScreenBG
import com.tcb.baskbank.presentation.theme.TextColor


@Composable
fun DashboardComponent(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(ScreenBG)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 14.dp, end = 14.dp)
        ) {
            CategoryList(navController)
        }
    }
}

@Composable
fun CategoryList(navController: NavController) {
    val listOfCategories = listOf(
        Category(R.drawable.dashboard, "Dashboard"),
        Category(R.drawable.activity_center, "Activity Center"),
        Category(R.drawable.transaction_icon, "Deposits"),
        Category(R.drawable.credit_icon, "Credit"),
        Category(R.drawable.account_icon, "Payment Center"),
        Category(R.drawable.investment, "Investment"),
        Category(R.drawable.mort_finance, "Mortgage Finance"),
        Category(R.drawable.bell_icon, "Notifications"),
        Category(R.drawable.settings, "Settings"),
    )

    ScalingLazyColumn(
        autoCentering = true,
        anchorType = ScalingLazyListAnchorType.ItemCenter
    ) {
        item {
            ListHeader {
                UserProfile()
            }
        }
        items(listOfCategories) { category ->
            CategoryItem(category, navController)
        }
    }
}

@Composable
fun CategoryItem(item: Category, navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(34.dp)
            .padding(start = 2.dp, top = 2.dp, end = 2.dp, bottom = 4.dp)
            .background(color = BgColor, shape = RoundedCornerShape(6.dp))
            .clickable {
                // navController.navigate(Screen.CategoryDetailComponent.route)
                navController.navigate(Screen.CreditOverviewComponent.route)
            },
        horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Spacer(modifier = Modifier.width(5.dp))
        Icon(
            modifier = Modifier
                .width(21.dp)
                .height(21.dp),
            painter = painterResource(id = item.icon),
            contentDescription = item.name,
            tint = Purple200
        )
        Text(
            text = item.name,
            style = TextStyle(
                fontSize = 12.sp,
                color = TextColor,
            )
        )
    }
}

@Composable
fun UserProfile() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        //.height(28.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier
                .width(18.dp)
                .height(18.dp),
            painter = painterResource(id = R.drawable.avatar_icon),
            contentDescription = "avatar"
        )
        Spacer(
            modifier = Modifier
                .width(4.dp)
        )
        Text(
            text = "Hello! ",
            fontSize = 12.sp,
            fontWeight = FontWeight(700),
            color = Color.White
        )
        Text(
            text = "Alex",
            fontSize = 12.sp,
            fontWeight = FontWeight(400),
            color = Color.White
        )
    }
}

@Preview(device = Devices.WEAR_OS_SMALL_ROUND, showSystemUi = true)
@Composable
fun DefaultPreview() {
    // DashboardComponent()
}