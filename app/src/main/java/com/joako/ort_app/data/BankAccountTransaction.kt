package com.joako.ort_app.data

data class BankAccountTransaction(
    val amount: Int,
    val currency: String,
    val date: String,
    val description: String,
    val transaction_id: String,
    val type: String
)