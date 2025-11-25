package com.hieudt.kotlinfunitureshop.ui.screens.fragments

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hieudt.kotlinfunitureshop.R
import com.hieudt.kotlinfunitureshop.sample.SampleProduct
import com.hieudt.kotlinfunitureshop.ui.components.AppToolbar
import com.hieudt.kotlinfunitureshop.ui.components.ProductCard
import com.hieudt.kotlinfunitureshop.ui.components.ToolbarButton

@Composable
fun HomeFragment() {
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
            ProductList(SampleProduct.getSampleProducts())
        }
    }
}

@Composable
private fun ProductList(items: List<SampleProduct>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items.size) { index ->
            ProductCard(
                product = items[index],
                onAddToCartClicked = {}
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewHomeFragment() {
    HomeFragment()
}