package com.tcb.baskbank.presentation.data

import androidx.compose.ui.graphics.Color

data class Account(
    val cardType: String,
    val cardNumber: String,
    val balance: String,
    val color: Color
)
