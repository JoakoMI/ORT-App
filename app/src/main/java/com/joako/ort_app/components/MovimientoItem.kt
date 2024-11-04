package com.joako.ort_app.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
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
            .height(60.dp)
            .padding(8.dp)
    ) {
        Column {
            Row {
                Text(text = "$formattedDate   ", fontSize = 14.sp, color = Color(0xFF2A1846))
                transaction.description?.let { Text(text = it, fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(0xFF2A1846)) }
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "$ ${transaction.amount ?: "N/A"}",
                    color = if (transaction.type == "credit") Color(0xFF00C853) else if (transaction.type == "debit") Color(0xFFD50000) else TODO(),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Text(text = ("                                       ID de trx: " + transaction.transaction_id) ?: "N/A", fontSize = 10.sp, color = Color.Gray)
}
        }


    }
