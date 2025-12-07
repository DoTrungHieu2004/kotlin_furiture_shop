package com.hieudt.kotlinfunitureshop.ui.components

import androidx.compose.foundation.clickable
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
import coil.compose.AsyncImage
import com.hieudt.kotlinfunitureshop.R
import com.hieudt.kotlinfunitureshop.api.APIClient
import com.hieudt.kotlinfunitureshop.data.models.Category
import com.hieudt.kotlinfunitureshop.data.models.Product
import com.hieudt.kotlinfunitureshop.ui.fonts.NunitoSansFamily
import com.hieudt.kotlinfunitureshop.ui.theme.DarkCharcoal
import com.hieudt.kotlinfunitureshop.ui.theme.GraniteGray

@Composable
fun ProductCard(
    product: Product,
    onAddToCartClicked: () -> Unit,
    onClickToInfo: () -> Unit
) {
    val formattedPrice = String.format("%.2f", product.price)
    val displayPrice = "$ $formattedPrice"

    Card(
        modifier = Modifier
            .width(180.dp)
            .padding(8.dp)
            .clickable { onClickToInfo() },
        shape = RoundedCornerShape(12.dp)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                AsyncImage(
                    model = "${APIClient.BASE_URL}uploads/products/${product.image}",
                    contentDescription = product.name,
                    modifier = Modifier
                        .height(140.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp)),
                    contentScale = ContentScale.Crop
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
        product = Product(
            _id = "A101",
            name = "Miminal Stand",
            description = "It's just a minimal stand. Nothing special.",
            price = 12.00,
            discount = 0.00,
            image = "https://picsum.photos/200/300",
            categoryId = Category(
                _id = "1234",
                name = "Table",
                slug = "table"
            ),
            stock = 12
        ),
        onAddToCartClicked = {},
        onClickToInfo = {}
    )
}