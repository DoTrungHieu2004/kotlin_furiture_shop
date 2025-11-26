package com.hieudt.kotlinfunitureshop.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hieudt.kotlinfunitureshop.R
import com.hieudt.kotlinfunitureshop.ui.fonts.MerriweatherFamily
import com.hieudt.kotlinfunitureshop.ui.fonts.NunitoSansFamily
import com.hieudt.kotlinfunitureshop.ui.theme.DarkCharcoal
import com.hieudt.kotlinfunitureshop.ui.theme.Gray
import com.hieudt.kotlinfunitureshop.ui.theme.GrayX11
import com.hieudt.kotlinfunitureshop.ui.theme.PhilippineGray
import com.hieudt.kotlinfunitureshop.ui.theme.RaisinBlack

@Composable
fun RegisterScreen(onRegisterSuccess: () -> Unit) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPass by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Spacer(
                modifier = Modifier
                    .weight(1f)
                    .height(1.dp)
                    .background(color = GrayX11)
            )
            Box(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .size(64.dp)
                    .clip(CircleShape)
                    .background(color = Color.White),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.app_icon),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Spacer(
                modifier = Modifier
                    .weight(1f)
                    .height(1.dp)
                    .background(color = GrayX11)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "WELCOME",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = MerriweatherFamily,
            color = DarkCharcoal
        )

        Spacer(modifier = Modifier.height(60.dp))

        // Form đăng ký
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = {
                Text(
                    text = "Name",
                    fontWeight = FontWeight.Normal,
                    fontFamily = NunitoSansFamily,
                    color = PhilippineGray
                )
            },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = {
                Text(
                    text = "Email",
                    fontWeight = FontWeight.Normal,
                    fontFamily = NunitoSansFamily,
                    color = PhilippineGray
                )
            },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = {
                Text(
                    text = "Password",
                    fontWeight = FontWeight.Normal,
                    fontFamily = NunitoSansFamily,
                    color = PhilippineGray
                )
            },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = if (passwordVisible) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            trailingIcon = {
                val image = if (passwordVisible) {
                    R.drawable.ic_visibility
                } else {
                    R.drawable.ic_visibility_off
                }

                val description = if (passwordVisible) "Hide password" else "Show password"

                IconButton(
                    onClick = { passwordVisible = !passwordVisible }
                ) {
                    Icon(
                        painter = painterResource(id = image),
                        contentDescription = description
                    )
                }
            }
        )
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(
            value = confirmPass,
            onValueChange = { confirmPass = it },
            label = {
                Text(
                    text = "Confirm password",
                    fontWeight = FontWeight.Normal,
                    fontFamily = NunitoSansFamily,
                    color = PhilippineGray
                )
            },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = if (passwordVisible) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            trailingIcon = {
                val image = if (passwordVisible) {
                    R.drawable.ic_visibility
                } else {
                    R.drawable.ic_visibility_off
                }

                val description = if (passwordVisible) "Hide password" else "Show password"

                IconButton(
                    onClick = { passwordVisible = !passwordVisible }
                ) {
                    Icon(
                        painter = painterResource(id = image),
                        contentDescription = description
                    )
                }
            }
        )
        Spacer(modifier = Modifier.height(24.dp))
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
            onClick = {},
        ) {
            Text(
                text = "SIGN UP",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = NunitoSansFamily
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Already have an account?",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = NunitoSansFamily,
                color = Gray,
            )
            TextButton(
                onClick = {}
            ) {
                Text(
                    text = "SIGN IN",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = NunitoSansFamily,
                    color = DarkCharcoal
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewRegisterScreen() {
    RegisterScreen(onRegisterSuccess = {})
}