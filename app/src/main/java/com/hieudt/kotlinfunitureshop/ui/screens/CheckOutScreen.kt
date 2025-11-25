package com.hieudt.kotlinfunitureshop.ui.screens

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import com.hieudt.kotlinfunitureshop.ui.components.AddressCard
import com.hieudt.kotlinfunitureshop.ui.components.AppToolbar
import com.hieudt.kotlinfunitureshop.ui.components.DeliveryMethodCard
import com.hieudt.kotlinfunitureshop.ui.components.PaymentMethodCard
import com.hieudt.kotlinfunitureshop.ui.components.ToolbarButton
import com.hieudt.kotlinfunitureshop.ui.components.TotalAmountCard
import com.hieudt.kotlinfunitureshop.ui.fonts.NunitoSansFamily
import com.hieudt.kotlinfunitureshop.ui.theme.PhilippineGray
import com.hieudt.kotlinfunitureshop.ui.theme.RaisinBlack

@Composable
fun CheckOutScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            AppToolbar(
                title = "Check out",
                leftButton = ToolbarButton(
                    iconRes = R.drawable.ic_back,
                    contentDescription = "Back button",
                    onClick = {}
                )
            )

            Column(
                modifier = Modifier.padding(12.dp)
            ) {
                // Địa chỉ giao hàng
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Shipping address",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = NunitoSansFamily,
                        color = PhilippineGray
                    )
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_edit_outline),
                            contentDescription = "Edit address",
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
                AddressCard(
                    customer = "Customer name",
                    address = "Address here"
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Phương thức thanh toán
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Payment",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = NunitoSansFamily,
                        color = PhilippineGray
                    )
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_edit_outline),
                            contentDescription = "Edit address",
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
                PaymentMethodCard()

                Spacer(modifier = Modifier.height(8.dp))

                // Phương thức giao hàng
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Delivery method",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = NunitoSansFamily,
                        color = PhilippineGray
                    )
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_edit_outline),
                            contentDescription = "Edit address",
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
                DeliveryMethodCard()

                Spacer(modifier = Modifier.height(24.dp))

                // Tổng tiền
                TotalAmountCard()

                Spacer(modifier = Modifier.height(24.dp))

                // Nút đặt hàng
                ElevatedButton(
                    border = BorderStroke(
                        width = 2.dp,
                        color = RaisinBlack
                    ),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.elevatedButtonColors(
                        containerColor = RaisinBlack,
                        contentColor = Color.White
                    ),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .fillMaxWidth(),
                    onClick = {}
                ) {
                    Text(
                        text = "SUBMIT ORDER",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = NunitoSansFamily
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewCheckOutScreen() {
    CheckOutScreen()
}