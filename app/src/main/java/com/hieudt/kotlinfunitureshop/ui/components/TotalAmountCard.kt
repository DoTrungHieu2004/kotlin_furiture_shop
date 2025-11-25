package com.hieudt.kotlinfunitureshop.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hieudt.kotlinfunitureshop.ui.fonts.NunitoSansFamily
import com.hieudt.kotlinfunitureshop.ui.theme.PhilippineGray
import com.hieudt.kotlinfunitureshop.ui.theme.RaisinBlack

@Composable
fun TotalAmountCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(4.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Order:",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = NunitoSansFamily,
                    color = PhilippineGray
                )
                Text(
                    text = "$ 95.00",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = NunitoSansFamily,
                    color = RaisinBlack
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Delivery:",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = NunitoSansFamily,
                    color = PhilippineGray
                )
                Text(
                    text = "$ 5.00",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = NunitoSansFamily,
                    color = RaisinBlack
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Total:",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = NunitoSansFamily,
                    color = PhilippineGray
                )
                Text(
                    text = "$ 100.00",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = NunitoSansFamily,
                    color = RaisinBlack
                )
            }
        }
    }
}

@Preview
@Composable
private fun PreviewTotalAmountCard() {
    TotalAmountCard()
}