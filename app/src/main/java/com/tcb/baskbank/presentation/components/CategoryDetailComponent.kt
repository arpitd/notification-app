package com.tcb.baskbank.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.*
import com.tcb.baskbank.presentation.data.Account
import com.tcb.baskbank.presentation.theme.CardColor
import com.tcb.baskbank.presentation.theme.Purple200
import com.tcb.baskbank.presentation.theme.ScreenBG
import java.math.RoundingMode
import java.text.DecimalFormat

@Composable
fun CategoryDetailComponent() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(ScreenBG)
    ) {
        CategoryDetailUI()
    }
}

@Composable
fun CategoryDetailUI() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 8.dp, end = 8.dp),
        verticalArrangement = Arrangement.Center
    ) {
        // AccountInfo()
        val cardsList = listOf(
            Account(
                cardType = "Primary Account",
                cardNumber = "3000089393 | # of Loans: 39",
                balance = "6570500",
                color = Color(0xFFF5F5F5)
            ),
            Account(
                cardType = "Foreign Currency",
                cardNumber = "3000089988 | # of Loans: 12",
                balance = "4100121",
                color = Color(0xFFF2F7FF)
            ),
            Account(
                cardType = "Revolving Credit",
                cardNumber = "3000080008 | # of Loans: 33",
                balance = "3231198",
                color = Color(0xFFF5F5F5)
            ),
            Account(
                cardType = "Emergency Account",
                cardNumber = "3000089678 | # of Loans: 25",
                balance = "2300200",
                color = Color(0xFFF2F7FF)
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
                            text = "Facility Overview",
                            style = TextStyle(
                                fontSize = 13.sp,
                                fontWeight = FontWeight(400),
                                color = Color.White,
                                textAlign = TextAlign.Center,
                            )
                        )
                    }
                }
            } // item end
            items(cardsList) { card ->
                AccountInfo(account = card)
            }

        }
    }
}

@Composable
fun AccountInfo(account: Account) {
    val decFormat = DecimalFormat("#,###.##")
    decFormat.roundingMode = RoundingMode.CEILING
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, top = 7.dp, end = 8.dp, bottom = 7.dp)
            .background(
                color = account.color,
                shape = RoundedCornerShape(8.dp)
            ),
        verticalArrangement = Arrangement.spacedBy(2.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            modifier = Modifier.padding(start = 8.dp, top = 4.dp),
            text = account.cardType,
            style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 16.8.sp,
                fontWeight = FontWeight(600),
                color = Color(0xFF000000),
            )
        )
        Text(
            modifier = Modifier.padding(start = 8.dp),
            text = account.cardNumber,
            style = TextStyle(
                fontSize = 10.sp,
                fontWeight = FontWeight(300),
                color = Color(0xFF333333),
            )
        )
        Text(
            modifier = Modifier.padding(start = 8.dp),
            text = "Available Amount",
            style = TextStyle(
                fontSize = 9.sp,
                fontWeight = FontWeight(300),
                color = Color(0xFF333333),
                )
        )
        Text(
            modifier = Modifier.padding(start = 8.dp, bottom = 4.dp),
            text = "$${decFormat.format(account.balance.toDouble())}",
            style = TextStyle(
                fontSize = 15.sp,
                fontWeight = FontWeight(400),
                color = Color(0xFF333333)
            )
        )
    }
}

@Preview(device = Devices.WEAR_OS_SMALL_ROUND, showSystemUi = true)
@Composable
fun DetailPreview1() {
    CategoryDetailComponent()
}