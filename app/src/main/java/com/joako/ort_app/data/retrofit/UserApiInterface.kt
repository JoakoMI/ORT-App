package com.joako.ort_app.data.retrofit

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface UserApi {
    @GET("users/{id}")
    suspend fun getUser(@Path("id") id: Int): Response<UserModel>

    @POST("auth/login")
    suspend fun signIn(@Body credentials: Map<String, String>): Response<SignInModel>
}