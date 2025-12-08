package com.hieudt.kotlinfunitureshop.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
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
import androidx.compose.ui.window.Dialog
import com.hieudt.kotlinfunitureshop.R
import com.hieudt.kotlinfunitureshop.data.models.Category
import com.hieudt.kotlinfunitureshop.ui.fonts.NunitoSansFamily

@Composable
fun CategoryFilterDialog(
    categories: List<Category>,
    onDismiss: () -> Unit,
    onCategorySelected: (Category?) -> Unit
) {
    Dialog(onDismissRequest = onDismiss) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Column(
                modifier = Modifier.padding(8.dp)
            ) {
                Text(
                    text = "Filter by category",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = NunitoSansFamily,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                // Tất cả sản phẩm
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onCategorySelected(null) }
                        .padding(vertical = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_all),
                        contentDescription = "All products"
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = "All products",
                        fontSize = 16.sp,
                        fontFamily = NunitoSansFamily
                    )
                }

                Divider(modifier = Modifier.padding(vertical = 4.dp))

                // Tất cả danh mục
                categories.forEach { cat ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onCategorySelected(cat) }
                            .padding(vertical = 12.dp)
                    ) {
                        Text(
                            text = cat.name,
                            fontSize = 16.sp,
                            fontFamily = NunitoSansFamily
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewCategoryFilterDialog() {
    val officialCategories = listOf(
        Category(_id = "1", name = "Chairs", slug = "chairs"),
        Category(_id = "2", name = "Tables", slug = "tables"),
        Category(_id = "3", name = "Armchairs", slug = "Armchairs"),
        Category(_id = "4", name = "Beds", slug = "beds"),
        Category(_id = "5", name = "Lamps", slug = "lamps")
    )

    CategoryFilterDialog(
        categories = officialCategories,
        onDismiss = {},
        onCategorySelected = {}
    )
}