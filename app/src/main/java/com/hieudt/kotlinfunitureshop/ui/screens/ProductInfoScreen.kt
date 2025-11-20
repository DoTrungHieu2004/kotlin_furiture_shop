package com.hieudt.kotlinfunitureshop.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hieudt.kotlinfunitureshop.R
import com.hieudt.kotlinfunitureshop.ui.components.QuantitySelector
import com.hieudt.kotlinfunitureshop.ui.fonts.GelasioFamily
import com.hieudt.kotlinfunitureshop.ui.fonts.NunitoSansFamily
import com.hieudt.kotlinfunitureshop.ui.theme.AntiFlashWhite
import com.hieudt.kotlinfunitureshop.ui.theme.DarkCharcoal
import com.hieudt.kotlinfunitureshop.ui.theme.GraniteGray
import com.hieudt.kotlinfunitureshop.ui.theme.Gray
import com.hieudt.kotlinfunitureshop.ui.theme.Maize
import com.hieudt.kotlinfunitureshop.ui.theme.RaisinBlack

@Composable
fun ProductInfoScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        ProductHeader()
        ProductInfo()
    }
}

// Header
@Composable
fun ProductHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(420.dp)
            .clip(
                RoundedCornerShape(
                    bottomStart = 32.dp,
                    bottomEnd = 32.dp
                )
            )
    ) {
        // Ảnh sản phẩm
        Image(
            painter = painterResource(R.drawable.product_example),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Nút quay lại
        IconButton(
            onClick = {},
            modifier = Modifier
                .padding(16.dp)
                .size(40.dp)
                .background(Color.White.copy(alpha = 0.9f), shape = RoundedCornerShape(6.dp))
                .align(Alignment.TopStart),
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_back),
                contentDescription = "Back"
            )
        }
    }
}

// Thông tin sản phẩm
@Composable
fun ProductInfo() {
    Column(
        modifier = Modifier.padding(24.dp)
    ) {
        // Tên sản phẩm
        Text(
            text = "Minimal Stand",
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = GelasioFamily,
            color = DarkCharcoal
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Giá + số lượng
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "$ 50",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = NunitoSansFamily,
                color = DarkCharcoal
            )

            QuantitySelector()
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Đánh giá
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_star),
                contentDescription = null,
                tint = Maize
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = "4.5",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = NunitoSansFamily,
                color = DarkCharcoal
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = "(50 reviews)",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = NunitoSansFamily,
                color = Gray
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Mô tả sản phẩm
        Text(
            text = stringResource(R.string.lorem_ipsum),
            fontSize = 16.sp,
            fontWeight = FontWeight.Light,
            fontFamily = NunitoSansFamily,
            color = GraniteGray,
            maxLines = 6
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Nhóm nút bookmark và đặt hàng
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .background(
                        color = AntiFlashWhite,
                        shape = RoundedCornerShape(8.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_bookmark_outline),
                    contentDescription = null
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Button(
                onClick = {},
                modifier = Modifier
                    .height(60.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(4.dp)),
                colors = ButtonDefaults.buttonColors(
                    containerColor = RaisinBlack,
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "Add to cart",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = NunitoSansFamily
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewProductInfoScreen() {
    ProductInfoScreen()
}