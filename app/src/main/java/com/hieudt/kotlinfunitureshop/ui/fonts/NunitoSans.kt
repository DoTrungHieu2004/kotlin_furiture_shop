package com.hieudt.kotlinfunitureshop.ui.fonts

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.hieudt.kotlinfunitureshop.R

val NunitoSansFamily = FontFamily(
    Font(
        R.font.nunitosans_regular,
        FontWeight.Normal
    ),
    Font(
        R.font.nunitosans_semibold,
        FontWeight.SemiBold
    ),
    Font(
        R.font.nunitosans_bold,
        FontWeight.Bold
    ),
    Font(
        R.font.nunitosans_italic,
        FontWeight.Normal,
        FontStyle.Italic
    )
)