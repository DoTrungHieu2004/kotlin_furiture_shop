package com.hieudt.kotlinfunitureshop.ui.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.hieudt.kotlinfunitureshop.R
import com.hieudt.kotlinfunitureshop.ui.fonts.MerriweatherFamily
import com.hieudt.kotlinfunitureshop.ui.theme.DarkCharcoal
import com.hieudt.kotlinfunitureshop.ui.theme.RaisinBlack

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppToolbar(
    title: String,
    leftButton: ToolbarButton? = null,
    rightButton: ToolbarButton? = null,
    backgroundColor: Color = Color.White,
    contentColor: Color = DarkCharcoal,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                color = contentColor,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = MerriweatherFamily
            )
        },
        navigationIcon = {
            leftButton?.let {
                IconButton(onClick = it.onClick) {
                    Icon(
                        painter = painterResource(id = it.iconRes),
                        contentDescription = it.contentDescription,
                        tint = RaisinBlack
                    )
                }
            }
        },
        actions = {
            rightButton?.let {
                IconButton(onClick = it.onClick) {
                    Icon(
                        painter = painterResource(id = it.iconRes),
                        contentDescription = it.contentDescription,
                        tint = RaisinBlack
                    )
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = backgroundColor,
            titleContentColor = contentColor,
            actionIconContentColor = contentColor,
            navigationIconContentColor = contentColor
        ),
        modifier = modifier
    )
}

@Preview
@Composable
private fun PreviewAppToolbar() {
    AppToolbar(
        title = "Toolbar",
        leftButton = ToolbarButton(
            iconRes = R.drawable.ic_search,
            contentDescription = "Search",
            onClick = {}
        ),
        rightButton = ToolbarButton(
            iconRes = R.drawable.ic_shopping_cart_outline,
            contentDescription = "Cart",
            onClick = {}
        )
    )
}