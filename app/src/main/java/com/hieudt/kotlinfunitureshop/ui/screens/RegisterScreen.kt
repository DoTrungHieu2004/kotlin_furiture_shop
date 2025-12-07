package com.hieudt.kotlinfunitureshop.ui.screens

import android.util.Patterns
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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
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
import com.hieudt.kotlinfunitureshop.viewmodel.providers.provideAuthViewModel
import com.hieudt.kotlinfunitureshop.viewmodel.state.AuthState

@Composable
fun RegisterScreen(
    onRegisterSuccess: () -> Unit,
    onNavigateLogin: () -> Unit
) {
    val vm = provideAuthViewModel()
    val state by vm.authState.collectAsState()

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPass by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    var nameError by remember { mutableStateOf<String?>(null) }
    var emailError by remember { mutableStateOf<String?>(null) }
    var phoneError by remember { mutableStateOf<String?>(null) }
    var passwordError by remember { mutableStateOf<String?>(null) }
    var confirmPassError by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(key1 = state) {
        if (state is AuthState.Success) {
            onRegisterSuccess()
        }
    }

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

        // TextField tên người dùng
        OutlinedTextField(
            value = name,
            onValueChange = {
                name = it
                nameError = null
            },
            label = {
                Text(
                    text = "Name",
                    fontWeight = FontWeight.Normal,
                    fontFamily = NunitoSansFamily,
                    color = PhilippineGray
                )
            },
            singleLine = true,
            isError = nameError != null,
            modifier = Modifier.fillMaxWidth()
        )
        if (nameError != null) {
            Text(text = nameError!!, color = Color.Red, fontSize = 12.sp)
        }

        Spacer(modifier = Modifier.height(12.dp))

        // TextField email
        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
                emailError = null
            },
            label = {
                Text(
                    text = "Email",
                    fontWeight = FontWeight.Normal,
                    fontFamily = NunitoSansFamily,
                    color = PhilippineGray
                )
            },
            singleLine = true,
            isError = emailError != null,
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        if (emailError != null) {
            Text(text = emailError!!, color = Color.Red, fontSize = 12.sp)
        }

        Spacer(modifier = Modifier.height(12.dp))

        // TextField số điện thoại
        OutlinedTextField(
            value = phone,
            onValueChange = {
                phone = it
                phoneError = null
            },
            label = {
                Text(
                    text = "Phone number",
                    fontWeight = FontWeight.Normal,
                    fontFamily = NunitoSansFamily,
                    color = PhilippineGray
                )
            },
            singleLine = true,
            isError = phoneError != null,
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
        )
        if (phoneError != null) {
            Text(text = phoneError!!, color = Color.Red, fontSize = 12.sp)
        }

        Spacer(modifier = Modifier.height(12.dp))

        // TextField mật khẩu
        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
                passwordError = null
            },
            label = {
                Text(
                    text = "Password",
                    fontWeight = FontWeight.Normal,
                    fontFamily = NunitoSansFamily,
                    color = PhilippineGray
                )
            },
            singleLine = true,
            isError = passwordError != null,
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
        if (passwordError != null) {
            Text(text = passwordError!!, color = Color.Red, fontSize = 12.sp)
        }

        Spacer(modifier = Modifier.height(12.dp))

        // TextField xác nhận mật khẩu
        OutlinedTextField(
            value = confirmPass,
            onValueChange = {
                confirmPass = it
                confirmPassError = null
            },
            label = {
                Text(
                    text = "Confirm password",
                    fontWeight = FontWeight.Normal,
                    fontFamily = NunitoSansFamily,
                    color = PhilippineGray
                )
            },
            singleLine = true,
            isError = confirmPassError != null,
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
        if (confirmPassError != null) {
            Text(text = confirmPassError!!, color = Color.Red, fontSize = 12.sp)
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Button đăng ký
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
            onClick = {
                var hasError = false

                if (name.isEmpty()) {
                    nameError = "Tên người dùng không được để trống"
                    hasError = true
                }

                if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    emailError = "Email bị bỏ trống hoặc sai định dạng"
                    hasError = true
                }

                if (phone.isEmpty() || !phone.matches(Regex("^0[0-9]{9}\$"))) {
                    phoneError = "Số điện thoại bị bỏ trống hoặc sai định dạng"
                    hasError = true
                }

                if (password.isEmpty() || password.length < 6) {
                    passwordError = "Mật khẩu bị bỏ trống hoặc quá ngắn"
                    hasError = true
                }

                if (confirmPass != password) {
                    confirmPassError = "Mật khẩu xác nhận không khớp"
                    hasError = true
                }

                if (!hasError) {
                    vm.register(
                        name = name,
                        email = email,
                        password = password,
                        phone = phone
                    )
                }
            },
        ) {
            Text(
                text = "SIGN UP",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = NunitoSansFamily
            )
        }

        if (state is AuthState.Loading) {
            CircularProgressIndicator()
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
                onClick = { onNavigateLogin() }
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

    if (state is AuthState.Error) {
        Text(
            text = (state as AuthState.Error).message,
            color = Color.Red
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewRegisterScreen() {
    RegisterScreen(
        onRegisterSuccess = {},
        onNavigateLogin = {}
    )
}