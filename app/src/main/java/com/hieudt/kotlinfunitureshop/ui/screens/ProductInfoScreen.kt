package com.hieudt.kotlinfunitureshop.ui.screens

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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.hieudt.kotlinfunitureshop.R
import com.hieudt.kotlinfunitureshop.api.APIClient
import com.hieudt.kotlinfunitureshop.data.models.Product
import com.hieudt.kotlinfunitureshop.ui.components.QuantitySelector
import com.hieudt.kotlinfunitureshop.ui.fonts.GelasioFamily
import com.hieudt.kotlinfunitureshop.ui.fonts.NunitoSansFamily
import com.hieudt.kotlinfunitureshop.ui.theme.AntiFlashWhite
import com.hieudt.kotlinfunitureshop.ui.theme.DarkCharcoal
import com.hieudt.kotlinfunitureshop.ui.theme.GraniteGray
import com.hieudt.kotlinfunitureshop.ui.theme.Gray
import com.hieudt.kotlinfunitureshop.ui.theme.Maize
import com.hieudt.kotlinfunitureshop.ui.theme.RaisinBlack
import com.hieudt.kotlinfunitureshop.viewmodel.providers.provideProductDetailViewModel

@Composable
fun ProductInfoScreen(productId: String, navController: NavHostController) {
    val vm = provideProductDetailViewModel()
    val product = vm.product
    val isLoading = vm.isLoading
    val error = vm.error

    LaunchedEffect(productId) {
        vm.loadProductDetail(productId)
    }

    when {
        isLoading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        error != null -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Error: $error",
                    color = Color.Red
                )
            }
        }

        product != null -> {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                ProductHeader(
                    product = product,
                    onBack = {
                        navController.popBackStack()
                    }
                )
                ProductInfo(product = product)
            }
        }
    }
}

// Header
@Composable
fun ProductHeader(product: Product, onBack: () -> Unit) {
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
        AsyncImage(
            model = "${APIClient.BASE_URL}uploads/products/${product.image}",
            contentDescription = product.name,
            modifier = Modifier
                .fillMaxWidth()
                .height(360.dp)
                .clip(RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp)),
            contentScale = ContentScale.Crop
        )

        // Nút quay lại
        IconButton(
            onClick = { onBack() },
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
fun ProductInfo(product: Product) {
    Column(
        modifier = Modifier.padding(24.dp)
    ) {
        // Tên sản phẩm
        Text(
            text = product.name,
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
                text = "$${product.price}",
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
            text = product.description,
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
    ProductInfoScreen(
        productId = "",
        navController = rememberNavController()
    )
}