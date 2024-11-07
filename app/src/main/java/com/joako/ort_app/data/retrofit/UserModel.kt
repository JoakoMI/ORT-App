package com.joako.ort_app.data.retrofit

data class UserModel(
    val id: Int,
    val email: String,
    val username: String,
    val name: Name,
    val phone: String,
    val address: Address
)

data class Name(
    val firstname: String,
    val lastname: String
)

data class Address(
    val geolocation: Geolocation,
    val city: String,
    val street: String,
    val number: Int,
    val zipcode: String
)

data class Geolocation(
    val lat: String,
    val long: String
)