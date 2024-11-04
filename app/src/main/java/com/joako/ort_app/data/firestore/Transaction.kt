package com.joako.ort_app.data.firestore

data class Transaction(
    val transaction_id: String? = null,
    val date: String? = null,
    val description: String? = null,
    val amount: String? = null,
    val currency: String? = null,
    val type: String? = null
)