package com.hieudt.kotlinfunitureshop.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hieudt.kotlinfunitureshop.R
import com.hieudt.kotlinfunitureshop.ui.fonts.NunitoSansFamily
import com.hieudt.kotlinfunitureshop.ui.theme.DarkCharcoal
import com.hieudt.kotlinfunitureshop.ui.theme.RaisinBlack

@Composable
fun DeliveryMethodCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(4.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.dhl),
                contentDescription = "Mastercard",
                modifier = Modifier.size(width = 64.dp, height = 32.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "Fast (2-3 days)",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = NunitoSansFamily,
                color = DarkCharcoal
            )
        }
    }
}

@Preview
@Composable
private fun PreviewDeliveryMethodCard() {
    DeliveryMethodCard()
}