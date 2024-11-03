package com.joako.ort_app.data

data class CreditCardTransaction(
    val amount: Double? =null,
    val currency: String? =null,
    val date: String? =null,
    val description: String? =null,
    val transaction_id: String? =null,
    val type: String? =null
)