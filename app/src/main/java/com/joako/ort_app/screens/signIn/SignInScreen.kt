package com.joako.ort_app.screens.signIn

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joako.ort_app.R
import com.joako.ort_app.data.retrofit.NetworkResponse
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.joako.ort_app.MainActivityViewModel
import com.joako.ort_app.components.SignInPhrase
import com.joako.ort_app.navigation.MainNavActions
import com.joako.ort_app.navigation.Routes

val goldmanSans = FontFamily(Font(R.font.goldman_sans))


@Composable
fun SignInScreen(
    viewModel: SignInScreenViewModel,
    navigationActions: MainNavActions,
    navController: NavHostController,
    mainViewModel: MainActivityViewModel // Añadir el MainActivityViewModel aquí
) {
    val context = LocalContext.current
    val signInResult = viewModel.signInResult

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var rememberMe by remember { mutableStateOf(false) }
    var passwordVisible by remember { mutableStateOf(false) }


        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF0fd08b))
                .background(Color(0xFF0fd08b)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp))

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "App Logo",
                contentScale = ContentScale.Fit,
            )
            Spacer(modifier = Modifier.height(40.dp))

            SignInPhrase()

            Spacer(modifier = Modifier.height(50.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFF7F7F7), shape = RoundedCornerShape(12.dp))
                    .padding(horizontal = 12.dp, vertical = 24.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFF7F7F7), shape = RoundedCornerShape(16.dp))

                ) {
                    Text(
                        text = stringResource(R.string.signin_account),
                        color = Color(0xFF2A1846),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    TextField(
                        value = username,
                        onValueChange = { username = it },
                        label = { Text(stringResource(R.string.signin_account_label), color = Color(0xFF575372)) },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    TextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text(stringResource(R.string.signin_pass), color = Color(0xFF575372)) },
                        singleLine = true,
                        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        trailingIcon = {
                            val icon =
                                if (passwordVisible) R.drawable.visibility else R.drawable.visibility_off
                            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                                Icon(
                                    painter = painterResource(id = icon),
                                    contentDescription = "Toggle password visibility"
                                )
                            }
                        },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = stringResource(R.string.signin_pass_recover),
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
                        Text(
                            text = stringResource(R.string.signin_pass_remember),
                            fontSize = 14.sp,
                            color = Color(0xFF2A1846)
                        )
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
                                viewModel.clearSignInResult()
                                mainViewModel.setRoute(Routes.INICIO_SCREEN) // Llamar a setRoute aquí
                                navController.navigate(Routes.INICIO_SCREEN) {
                                    popUpTo(Routes.SIGNIN_SCREEN) { inclusive = true }
                                }
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
    }


