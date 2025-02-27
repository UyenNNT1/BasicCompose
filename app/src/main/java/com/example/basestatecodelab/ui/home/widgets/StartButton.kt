package com.example.basestatecodelab.ui.home.widgets

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun StartButton(){
    Card {
        Row {
            Icon(
                imageVector = Icons.Default.AddCircle,
                contentDescription = null
            )
            Text(
                text = "Start Editing"
            )
        }
    }

}

@Preview
@Composable
private fun StartButtonPreview() {
    StartButton()
}