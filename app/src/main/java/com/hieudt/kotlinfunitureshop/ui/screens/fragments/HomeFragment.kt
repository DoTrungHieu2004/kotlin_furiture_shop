package com.hieudt.kotlinfunitureshop.ui.screens.fragments

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hieudt.kotlinfunitureshop.R
import com.hieudt.kotlinfunitureshop.ui.components.AppToolbar
import com.hieudt.kotlinfunitureshop.ui.components.ProductCard
import com.hieudt.kotlinfunitureshop.ui.components.ToolbarButton
import com.hieudt.kotlinfunitureshop.ui.fonts.NunitoSansFamily
import com.hieudt.kotlinfunitureshop.ui.theme.RaisinBlack
import com.hieudt.kotlinfunitureshop.viewmodel.providers.provideProductViewModel

@Composable
fun HomeFragment(
    onProductClick: (String) -> Unit
) {
    val vm = provideProductViewModel()
    val products = vm.products
    val isLoading = vm.isLoading
    val error = vm.error

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            AppToolbar(
                title = "Home",
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

            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                shape = RoundedCornerShape(4.dp),
                colors = ButtonDefaults.elevatedButtonColors(
                    containerColor = RaisinBlack,
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "Filter by category",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = NunitoSansFamily
                )
            }

            if (isLoading) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
                return
            }

            if (error != null) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = error,
                        color = Color.Red
                    )
                }
                return
            }

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(products) { p ->
                    ProductCard(
                        product = p,
                        onAddToCartClicked = {},
                        onClickToInfo = {}
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewHomeFragment() {
    HomeFragment(
        onProductClick = {}
    )
}