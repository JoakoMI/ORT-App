package com.joako.ort_app.data.firestore

data class BankAccountTransaction(
    val amount: Int? =null,
    val currency: String? =null,
    val date: String? =null,
    val description: String? =null,
    val transaction_id: String? =null,
    val type: String? =null
)