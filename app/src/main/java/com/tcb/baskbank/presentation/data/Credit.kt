package com.tcb.baskbank.presentation.data

import androidx.compose.ui.graphics.Color

data class Credit(
    val id: Int,
    val name: String,
    val acc: String,
    val facilities: String,
    val loans: String,
    val rm: String,
    val color: Color = Color(0xFFF5F5F5)
)
