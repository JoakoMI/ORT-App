package com.joako.ort_app.data.firestore

data class Wallet(
    val user_id: String? = null,
    val balance: String? = null,
    val bank_account: BankAccount? = null,
    val transactions: Transactions? = null
)