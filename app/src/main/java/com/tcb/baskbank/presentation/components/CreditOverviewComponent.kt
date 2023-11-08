package com.tcb.baskbank.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.wear.compose.material.*
import com.tcb.baskbank.presentation.Screen
import com.tcb.baskbank.presentation.data.Credit
import com.tcb.baskbank.presentation.theme.ScreenBG


@Composable
fun CreditOverviewComponent(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(ScreenBG)
    ) {
        CreditOverviewUI(navController)
    }
}

@Composable
fun CreditOverviewUI(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
        verticalArrangement = Arrangement.Center
    ) {

        val listOfCredits = listOf(
            Credit(
                id = 0,
                name = "Texas Association of Builders Affiliated",
                acc = "10002334",
                facilities = "15",
                loans = "8",
                rm = "John Crest"
            ),
            Credit(
                id = 1,
                name = "Texas Association of Builders Affiliated",
                acc = "10002334",
                facilities = "15",
                loans = "8",
                rm = "John Crest"
            ),
            Credit(
                id = 2,
                name = "Valero Energy_A",
                acc = "10007385",
                facilities = "12",
                loans = "4",
                rm = "Tim David"
            ),
            Credit(
                id = 3,
                name = "Texas Association of Builders Affiliated",
                acc = "10007445",
                facilities = "10",
                loans = "6",
                rm = "Smith John"
            ),
            Credit(
                id = 4,
                name = "Valero Energy_B",
                acc = "10009725",
                facilities = "8",
                loans = "2",
                rm = "Anderson"
            ),
            Credit(
                id = 5,
                name = "Valero Energy_C",
                acc = "10009225",
                facilities = "23",
                loans = "8",
                rm = "John Robot"
            ),
            Credit(
                id = 6,
                name = "Valero Energy_D",
                acc = "10002311",
                facilities = "13",
                loans = "5",
                rm = "John Root"
            ),
        )
        ScalingLazyColumn(
            autoCentering = true,
            anchorType = ScalingLazyListAnchorType.ItemCenter
        ) {
            item {
                ListHeader {
                    Column {
                        Text(
                            text = "Credit Overview",
                            style = TextStyle(
                                fontSize = 13.sp,
                                fontWeight = FontWeight(400),
                                color = Color.White,
                                textAlign = TextAlign.Center,
                            )
                        )
                    }
                }
            } // item closed

            items(listOfCredits) { item ->
                if (item.id == 0) {
                    AccountDetails()
                } else {
                    CreditItemUI(item, navController)
                }
            }

        }

    } // end

}

@Composable
fun CreditItemUI(credit: Credit, navController: NavController) {
    Column(
        verticalArrangement = Arrangement.spacedBy(3.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .width(180.dp)
            .height(85.dp)
            .background(color = Color(0xFFF5F5F5), shape = RoundedCornerShape(size = 8.dp))
            .padding(6.dp)
            .clickable {
                navController.navigate(Screen.CategoryDetailComponent.route)
        },
    ) {
        Text(
            text = credit.name,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight(600),
                color = Color(0xFF333333)
            )
        )
        Text(
            text = credit.acc,
            style = TextStyle(
                fontSize = 10.sp,
                fontWeight = FontWeight(400),
                color = Color(0xFF828282)
            )
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top,
        ) {
            Text(
                text = "No. of Facilities",
                style = TextStyle(
                    fontSize = 10.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF828282)
                )
            )

            Text(
                text = credit.facilities,
                style = TextStyle(
                    fontSize = 10.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF333333),
                    letterSpacing = 0.1.sp,
                )
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top,
        ) {
            Text(
                text = "No. of Loans",
                style = TextStyle(
                    fontSize = 10.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF828282)
                )
            )

            Text(
                text = credit.loans,
                style = TextStyle(
                    fontSize = 10.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF333333),
                    letterSpacing = 0.1.sp,
                )
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top,
        ) {
            Text(
                text = "RM",
                style = TextStyle(
                    fontSize = 10.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF828282)
                )
            )

            Text(
                text = credit.rm,
                style = TextStyle(
                    fontSize = 10.sp,
                    lineHeight = 14.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF333333),
                )
            )
        }

    } // Column closed
}


@Composable
fun AccountDetails() {
    Column(
        verticalArrangement = Arrangement.spacedBy(3.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .width(180.dp)
            .height(58.dp)
            .background(color = Color(0xFFE8F4FB), shape = RoundedCornerShape(size = 8.dp))
            .padding(6.dp)
    ) {
        Text(
            text = "Texas Association of Builder Affiliated",
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight(600),
                color = Color(0xFF000033),
            )
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top,
        ) {
            Text(
                text = "Customer Number:",
                style = TextStyle(
                    fontSize = 10.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000033),
                )
            )
            Text(
                text = "10007677",
                style = TextStyle(
                    fontSize = 10.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000033),
                )
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top,
        ) {
            Text(
                text = "RM",
                style = TextStyle(
                    fontSize = 10.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000033)
                )
            )

            Text(
                text = "Jack Wright",
                style = TextStyle(
                    fontSize = 10.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF000033),
                )
            )
        }
    }
}

@Preview(device = Devices.WEAR_OS_SMALL_ROUND, showSystemUi = true)
@Composable
fun CreditPreview1() {
    // CreditOverviewComponent()
}