package com.joako.ort_app.data

data class Transactions(
    val bank_account_transactions: List<BankAccountTransaction>,
    val credit_card_transactions: List<CreditCardTransaction>
)