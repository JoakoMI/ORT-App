package com.joako.ort_app.data

data class BankAccount(
    val account_type: String,
    val alias: String,
    val bank_name: String,
    val currency: String,
    val cvu: String
)