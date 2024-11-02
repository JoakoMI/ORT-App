package com.joako.ort_app.screens

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joako.ort_app.data.NetworkResponse
import com.joako.ort_app.data.RetroFitInstance
import com.joako.ort_app.data.SignInModel
import kotlinx.coroutines.launch

class SignInScreenViewModel : ViewModel() {
    companion object {
        // Check for any static fields or initialization blocks
        val viewModel: SignInScreenViewModel by lazy {
            SignInScreenViewModel()
        }
    }

    fun logMessage(tag: String, message: String) {
        Log.d(tag, message)
    }

    private val signInApi = RetroFitInstance.api
    private val _signInResult = MutableLiveData<NetworkResponse<SignInModel>>()
    val signInResult: LiveData<NetworkResponse<SignInModel>> = _signInResult

    fun getData(username: String, password: String) {
        viewModelScope.launch {
            try {
                logMessage("SignInScreen", "Attempting to sign in with username: $username")
                val response = RetroFitInstance.api.signIn(mapOf("username" to username, "password" to password))
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        _signInResult.postValue(NetworkResponse.Success(responseBody))
                        logMessage("SignInScreen", "Sign in successful: ${responseBody.token}")
                    } else {
                        _signInResult.postValue(NetworkResponse.Error("Response body is null"))
                        logMessage("SignInScreen", "Sign in failed: Response body is null")
                    }
                } else {
                    _signInResult.postValue(NetworkResponse.Error("Sign In failed"))
                    logMessage("SignInScreen", "Sign in failed: ${response.errorBody()?.string()}")
                }
            } catch (e: Exception) {
                _signInResult.postValue(NetworkResponse.Error(e.message ?: "An error occurred"))
                logMessage("SignInScreen", "Sign in error: ${e.message}")
            }
        }
    }
}