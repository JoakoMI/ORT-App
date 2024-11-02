package com.joako.ort_app.data

data class Wallet(
    val balance: Double,
    val bank_account: BankAccount,
    val transactions: Transactions,
    val user_id: String
)