package com.joako.ort_app.data.firestore

data class BankAccount(
    val bank_name: String? = null,
    val account_type: String? = null,
    val alias: String? = null,
    val cvu: String? = null,
    val currency: String? = null
)