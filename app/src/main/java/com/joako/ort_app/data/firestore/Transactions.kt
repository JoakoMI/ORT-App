package com.joako.ort_app.data.firestore

data class Transactions(
    val credit_card_transactions: List<Transaction> = emptyList(),
    val bank_account_transactions: List<Transaction> = emptyList()
)
