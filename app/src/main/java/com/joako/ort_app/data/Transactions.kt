package com.joako.ort_app.data

data class Transactions(
    val BankAccountransactionList: List<BankAccountTransaction>? = null,
    val CreditCardtransactionList: List<CreditCardTransaction>? = null
)

//data class Transaction(
//    val id: String = "",s
//    val amount: Double = 0.0
//)