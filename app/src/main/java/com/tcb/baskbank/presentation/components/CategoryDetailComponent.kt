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
import java.math.RoundingMode
import java.text.DecimalFormat

@Composable
fun CategoryDetailComponent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 8.dp, end = 8.dp),
        verticalArrangement = Arrangement.Center
    ) {
        // AccountInfo()
        val cardsList = listOf(
            Account(
                cardType = "BASK INTEREST SAVINGS",
                cardNumber = "**** **** **053",
                balance = "120000.00",
                color = Purple200
            ),
            Account(
                cardType = "BASK MILAGE SAVINGS",
                cardNumber = "**** **** **4344",
                balance = "176244.12",
                color = Purple200
            ),
            Account(
                cardType = "Credit Card",
                cardNumber = "**** **** **** 1212",
                balance = "3510.00",
                color = CardColor
            ),
            Account(
                cardType = "Credit Card",
                cardNumber = "**** **** **** 4545",
                balance = "12330.00",
                color = CardColor
            ),
            Account(
                cardType = "Credit Card",
                cardNumber = "**** **** **** 5656",
                balance = "1040.00",
                color = CardColor
            )
        )

        ScalingLazyColumn(
            autoCentering = true,
            anchorType = ScalingLazyListAnchorType.ItemCenter
        ) {
            item {
                ListHeader {
                    Text(
                        text = "Accounts",
                        style = TextStyle(
                            fontSize = 15.sp,
                            lineHeight = 21.sp,
                            fontWeight = FontWeight(500),
                            color = Color(0xFFF26A21),
                            textAlign = TextAlign.Center,
                            letterSpacing = 0.3.sp,
                        )
                    )
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
                fontWeight = FontWeight(400),
                color = Color(0xFF141318),
            )
        )
        Text(
            modifier = Modifier.padding(start = 8.dp),
            text = "Available Balance",
            style = TextStyle(
                fontSize = 9.sp,
                fontWeight = FontWeight(400),
                color = Color(0xFF000000),

                )
        )
        Text(
            modifier = Modifier.padding(start = 8.dp, bottom = 4.dp),
            text = "$${decFormat.format(account.balance.toDouble())}",
            style = TextStyle(
                fontSize = 15.sp,
                fontWeight = FontWeight(400),
                color = Color(0xFF333333),
            )
        )
    }
}

@Preview(device = Devices.WEAR_OS_SMALL_ROUND, showSystemUi = true)
@Composable
fun DetailPreview1() {
    CategoryDetailComponent()
}