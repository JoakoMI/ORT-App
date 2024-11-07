package com.joako.ort_app.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joako.ort_app.data.firestore.Transaction
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun MovimientoItem(transaction: Transaction) {
    val originalFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val targetFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
    val formattedDate = transaction.date?.let {
        originalFormat.parse(it)?.let { date -> targetFormat.format(date) }
    } ?: "N/A"

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
    ) {
        Column (Modifier.weight(1f)){
            Text(text = "$formattedDate   ", fontSize = 14.sp, color = Color(0xFF2A1846))
        }
        Column(Modifier.weight(2f)) {
            transaction.description?.let {
                Text(
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Start,
                    text = it,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF2A1846)
                )
            }
            Text(
                textAlign = TextAlign.Start,
                text = ("ID de trx: " + transaction.transaction_id) ?: "N/A"
            )
        }
        Column(Modifier.weight(1f), horizontalAlignment = Alignment.End) {
            Text(
                text = if (transaction.type == "credit") "+ $${transaction.amount ?: "N/A"}" else "- $${transaction.amount ?: "N/A"}",
                color = if (transaction.type == "credit") Color(0xFF00C853) else Color(0xFFF96440),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun MovimientoItemPrev() {
    MovimientoItem(
        Transaction(
            transaction_id = "123456",
            amount = "1000",
            date = "2021-10-10",
            description = "Pago de factura",
            type = "debit"
        )
    )
}
