package com.joako.ort_app.screens.signIn

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joako.ort_app.R
import com.joako.ort_app.data.retrofit.NetworkResponse
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.joako.ort_app.navigation.MainNavActions

val goldmanSans = FontFamily(Font(R.font.goldman_sans))


@Composable
fun SignInScreen(viewModel: SignInScreenViewModel, navigationActions: MainNavActions) {
    val context = LocalContext.current
    val signInResult = viewModel.signInResult

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var rememberMe by remember { mutableStateOf(false) }
    var passwordVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF00C58D))
            .padding(10.dp).background(colorResource(id = R.color.screen_background)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(40.dp))

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "App Logo",
            contentScale = ContentScale.Fit,
        )
        Spacer(modifier = Modifier.height(40.dp))

        Row(
            modifier = Modifier
                .background(Color(0xFFD8D8FF), shape = RoundedCornerShape(50))
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "UNA BILLETERA",
                color = Color(0xFF1E0A3C),
                fontSize = 20.sp,
                fontFamily = goldmanSans
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "😊", fontSize = 20.sp)
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier
                .background(Color(0xFFD8D8FF), shape = RoundedCornerShape(50))
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "🙏 SIMPLE PARA VOS.",
                color = Color(0xFF1E0A3C),
                fontSize = 20.sp,
                fontFamily = goldmanSans
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFF7F7F7), shape = RoundedCornerShape(16.dp))
                .padding(16.dp)
        ) {
            Text(
                text = "Ingresá a tu cuenta:",
                color = Color(0xFF2A1846
            ),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )
            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("DNI o E-mail", color = Color(0xFF575372)) },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Contraseña", color = Color(0xFF575372)) },
                singleLine = true,
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val icon = if (passwordVisible) R.drawable.visibility else R.drawable.visibility_off
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(painter = painterResource(id = icon), contentDescription = "Toggle password visibility")
                    }
                },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Olvidé mi contraseña",
                fontWeight = FontWeight.Bold,
                color = Color(0xFF442E83),

                modifier = Modifier.align(Alignment.End),
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .background(Color.White, shape = CircleShape)
                        .border(2.dp, Color.Gray, shape = CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Checkbox(
                        checked = rememberMe,
                        onCheckedChange = { rememberMe = it },
                        colors = CheckboxDefaults.colors(
                            checkmarkColor = Color.Black,
                            uncheckedColor = Color.Transparent,
                            checkedColor = Color.Transparent
                        )
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Recordar datos de ingreso", fontSize = 14.sp)
            }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { viewModel.getData(username, password) },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF442E83))
        ) {
            Text(text = "Ingresar", color = Color.White, fontSize = 16.sp)
        }

        signInResult?.let { result ->
            when (result) {
                is NetworkResponse.Success -> {
                    Toast.makeText(context, "Sign In Successful", Toast.LENGTH_SHORT).show()
                    viewModel.clearSignInResult()
                }
                is NetworkResponse.Error -> {
                    Toast.makeText(context, result.message, Toast.LENGTH_SHORT).show()
                    viewModel.clearSignInResult()
                }
            }
        }
    }
}
}