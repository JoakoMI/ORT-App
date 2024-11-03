package com.joako.ort_app.data

data class Wallet(
    val user_id: String? = null,
    val balance: Double? = null,
    val bank_account: BankAccount? = null,
    val transactions: Transactions? = null
)