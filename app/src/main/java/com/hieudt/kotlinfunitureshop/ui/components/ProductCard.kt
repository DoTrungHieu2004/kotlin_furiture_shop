package com.hieudt.kotlinfunitureshop.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hieudt.kotlinfunitureshop.R
import com.hieudt.kotlinfunitureshop.sample.SampleProduct
import com.hieudt.kotlinfunitureshop.ui.fonts.NunitoSansFamily
import com.hieudt.kotlinfunitureshop.ui.theme.DarkCharcoal
import com.hieudt.kotlinfunitureshop.ui.theme.GraniteGray

@Composable
fun ProductCard(
    product: SampleProduct,
    onAddToCartClicked: () -> Unit
) {
    val formattedPrice = String.format("%.2f", product.price)
    val displayPrice = "$ $formattedPrice"

    Card(
        modifier = Modifier
            .width(180.dp)
            .padding(8.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                Image(
                    painter = painterResource(id = product.image),
                    contentDescription = product.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.matchParentSize()
                )

                Button(
                    onClick = onAddToCartClicked,
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(end = 12.dp, bottom = 12.dp)
                        .size(36.dp)
                        .clip(RoundedCornerShape(2.dp)),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = GraniteGray.copy(alpha = 0.4f),
                        contentColor = Color.White
                    ),
                    contentPadding = PaddingValues(0.dp),
                    elevation = ButtonDefaults.buttonElevation(defaultElevation = 0.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_shopping_bag),
                        contentDescription = "Add to cart"
                    )
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 8.dp)
        ) {
            Text(
                text = product.name,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = NunitoSansFamily,
                color = GraniteGray,
                maxLines = 1
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = displayPrice,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = NunitoSansFamily,
                color = DarkCharcoal
            )
        }
    }
}

@Preview
@Composable
private fun PreviewProductCard() {
    ProductCard(
        product = SampleProduct(
            id = "A101",
            name = "Minimal Stand",
            price = 12.00,
            image = R.drawable.product_example,
            description = "1234567890"
        ),
        onAddToCartClicked = {}
    )
}