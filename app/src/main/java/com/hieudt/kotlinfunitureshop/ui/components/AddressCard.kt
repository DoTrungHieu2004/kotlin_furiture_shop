package com.hieudt.kotlinfunitureshop.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hieudt.kotlinfunitureshop.ui.fonts.NunitoSansFamily
import com.hieudt.kotlinfunitureshop.ui.theme.AntiFlashWhite
import com.hieudt.kotlinfunitureshop.ui.theme.DarkCharcoal
import com.hieudt.kotlinfunitureshop.ui.theme.Gray

@Composable
fun AddressCard(
    customer: String,
    address: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(4.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = customer,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = NunitoSansFamily,
                color = DarkCharcoal
            )
            Divider(
                color = AntiFlashWhite.copy(alpha = 0.5f),
                thickness = 1.dp,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Text(
                text = address,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = NunitoSansFamily,
                color = Gray
            )
        }
    }
}

@Preview
@Composable
private fun PreviewAddressCard() {
    AddressCard(
        customer = "Do Trung Hieu",
        address = "Nguyen Dong Chi Road, Cau Dien District, Tu Liem Ward, Hanoi"
    )
}