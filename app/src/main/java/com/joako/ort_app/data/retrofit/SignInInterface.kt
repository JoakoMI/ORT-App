package com.joako.ort_app.data.retrofit

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface SignInInterface {
    @POST("/auth/login")
    suspend fun signIn(@Body credentials: Map<String, String>): Response<SignInModel>

    @GET("/")
    suspend fun getUser(): Response<SignInModel>
}