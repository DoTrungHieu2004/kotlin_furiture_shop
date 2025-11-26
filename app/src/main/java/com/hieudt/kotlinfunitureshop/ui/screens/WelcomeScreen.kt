package com.hieudt.kotlinfunitureshop.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hieudt.kotlinfunitureshop.R
import com.hieudt.kotlinfunitureshop.ui.fonts.GelasioFamily
import com.hieudt.kotlinfunitureshop.ui.fonts.NunitoSansFamily
import com.hieudt.kotlinfunitureshop.ui.theme.DarkCharcoal
import com.hieudt.kotlinfunitureshop.ui.theme.GraniteGray
import com.hieudt.kotlinfunitureshop.ui.theme.Gray
import com.hieudt.kotlinfunitureshop.ui.theme.KotlinFunitureShopTheme
import com.hieudt.kotlinfunitureshop.ui.theme.RaisinBlack

@Composable
fun WelcomeScreen(onGettingStarted: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        // Ảnh nền toàn màn hình (background)
        Image(
            painter = painterResource(id = R.drawable.background_img),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Nội dung chính chồng lên ảnh nền
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Spacer(modifier = Modifier.height(48.dp))
            Text(
                text = "MAKE YOUR",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = GelasioFamily,
                color = GraniteGray
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "HOME BEAUTIFUL",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = GelasioFamily,
                color = DarkCharcoal
            )
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = stringResource(R.string.shop_description),
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = NunitoSansFamily,
                color = Gray,
                modifier = Modifier.padding(start = 24.dp)
            )
            Spacer(modifier = Modifier.height(64.dp))
            ElevatedButton(
                border = BorderStroke(
                    width = 2.dp,
                    color = RaisinBlack
                ),
                shape = RoundedCornerShape(4.dp),
                colors = ButtonDefaults.elevatedButtonColors(
                    containerColor = RaisinBlack,
                    contentColor = Color.White
                ),
                modifier = Modifier.align(Alignment.CenterHorizontally),
                onClick = onGettingStarted,
            ) {
                Text(
                    text = "Get started",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = GelasioFamily
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewWelcomeScreen() {
    KotlinFunitureShopTheme {
        WelcomeScreen(onGettingStarted = {})
    }
}