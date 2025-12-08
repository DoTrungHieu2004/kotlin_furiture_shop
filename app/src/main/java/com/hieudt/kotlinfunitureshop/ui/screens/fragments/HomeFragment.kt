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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hieudt.kotlinfunitureshop.R
import com.hieudt.kotlinfunitureshop.ui.components.AppToolbar
import com.hieudt.kotlinfunitureshop.ui.components.CategoryFilterDialog
import com.hieudt.kotlinfunitureshop.ui.components.ProductCard
import com.hieudt.kotlinfunitureshop.ui.components.ToolbarButton
import com.hieudt.kotlinfunitureshop.ui.fonts.NunitoSansFamily
import com.hieudt.kotlinfunitureshop.ui.theme.RaisinBlack
import com.hieudt.kotlinfunitureshop.viewmodel.providers.provideCategoryViewModel
import com.hieudt.kotlinfunitureshop.viewmodel.providers.provideProductViewModel

@Composable
fun HomeFragment(
    onProductClick: (String) -> Unit
) {
    val productVM = provideProductViewModel()
    val categoryVM = provideCategoryViewModel()
    
    val products = productVM.products
    val categories = categoryVM.categories
    val isLoading = productVM.isLoading
    val error = productVM.error

    var showDialog by remember { mutableStateOf(false) }
    var selectedCatName by remember { mutableStateOf("All products") }

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
                onClick = { showDialog = true },
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
                    text = selectedCatName,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = NunitoSansFamily
                )
            }

            // Hiển thị dialog
            if (showDialog) {
                CategoryFilterDialog(
                    categories = categories,
                    onDismiss = { showDialog = false },
                    onCategorySelected = { cat ->
                        showDialog = false

                        if (cat == null) {
                            // Lấy tất cả sản phẩm
                            selectedCatName = "All products"
                            productVM.loadProducts()
                        } else {
                            // Lấy theo danh mục
                            selectedCatName = cat.name
                            productVM.loadProductsByCategory(cat._id)
                        }
                    }
                )
            }

            // Nội dung
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
                            text = error,
                            color = Color.Red
                        )
                    }
                }

                else -> {
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
                                onClickToInfo = { onProductClick(p._id) }
                            )
                        }
                    }
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