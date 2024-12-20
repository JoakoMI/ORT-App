package com.joako.ort_app.components.drawer

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.joako.ort_app.R
import com.joako.ort_app.components.SubmenuItem

@Composable
fun DrawerItemContainer(modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .background(Color.White),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, Color.LightGray),
        colors = CardDefaults.cardColors(containerColor = Color.White)

    ) {
        Column() {
            SubmenuItem(
                modifier = Modifier,
                text = stringResource(R.string.mis_datos)
            )
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 1.dp),
                color = colorResource(id = R.color.gray_500)
            )
            SubmenuItem(
                modifier = Modifier,
                text = stringResource(R.string.mi_cvu)
            )
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 1.dp),
                color = colorResource(id = R.color.gray_500)
            )
            SubmenuItem(
                modifier = Modifier,
                text = stringResource(R.string.config)
            )
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 1.dp),
                color = colorResource(id = R.color.gray_500)
            )
            SubmenuItem(
                modifier = Modifier,
                text = stringResource(R.string.help)
            )
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 1.dp),
                color = colorResource(id = R.color.gray_500)
            )
            SubmenuItem(
                modifier = Modifier,
                text = stringResource(R.string.terms)
            )
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 1.dp),
                color = colorResource(id = R.color.gray_500)
            )
            SubmenuItem(
                modifier = Modifier,
                text = stringResource(R.string.close)
            )
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 1.dp),
                color = colorResource(id = R.color.gray_500)
            )
        }
    }
}