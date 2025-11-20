package com.hieudt.kotlinfunitureshop.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hieudt.kotlinfunitureshop.R
import com.hieudt.kotlinfunitureshop.ui.fonts.NunitoSansFamily
import com.hieudt.kotlinfunitureshop.ui.theme.ChineseWhite
import com.hieudt.kotlinfunitureshop.ui.theme.RaisinBlack

@Composable
fun QuantitySelector() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        SelectorButton(icon = R.drawable.ic_horizontal_rule)
        Text(
            text = "01",
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = NunitoSansFamily,
            color = RaisinBlack,
            letterSpacing = 1.sp,
            modifier = Modifier.padding(horizontal = 12.dp)
        )
        SelectorButton(icon = R.drawable.ic_add)
    }
}

@Composable
fun SelectorButton(@DrawableRes icon: Int) {
    Box(
        modifier = Modifier
            .size(36.dp)
            .background(
                color = ChineseWhite,
                shape = RoundedCornerShape(6.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null
        )
    }
}

@Preview
@Composable
private fun PreviewQuantitySelector() {
    QuantitySelector()
}