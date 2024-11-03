package com.joako.ort_app.screens.signIn

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joako.ort_app.data.retrofit.NetworkResponse
import com.joako.ort_app.data.retrofit.RetroFitInstance
import com.joako.ort_app.data.retrofit.SignInModel
import kotlinx.coroutines.launch

class SignInScreenViewModel : ViewModel() {

    companion object {
        val viewModel: SignInScreenViewModel by lazy {
            SignInScreenViewModel()
        }
    }

    fun logMessage(tag: String, message: String) {
        Log.d(tag, message)
    }

    private val signInApi = RetroFitInstance.api

    private val _signInResult = mutableStateOf<NetworkResponse<SignInModel>?>(null)
    val signInResult: NetworkResponse<SignInModel>? get() = _signInResult.value

    fun getData(username: String, password: String) {
        viewModelScope.launch {
            try {
                logMessage("SignInScreen", "Attempting to sign in with username: $username")
                val response =
                    signInApi.signIn(mapOf("username" to username, "password" to password))
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        _signInResult.value = NetworkResponse.Success(responseBody)
                        logMessage("SignInScreen", "Sign in successful: ${responseBody.token}")
                    } else {
                        _signInResult.value = NetworkResponse.Error("Response body is null")
                        logMessage("SignInScreen", "Sign in failed: Response body is null")
                    }
                } else {
                    _signInResult.value = NetworkResponse.Error("Sign In failed")
                    logMessage("SignInScreen", "Sign in failed: ${response.errorBody()?.string()}")
                }
            } catch (e: Exception) {
                _signInResult.value = NetworkResponse.Error(e.message ?: "An error occurred")
                logMessage("SignInScreen", "Sign in error: ${e.message}")
            }
        }
    }

    fun clearSignInResult() {
        _signInResult.value = null
    }
}