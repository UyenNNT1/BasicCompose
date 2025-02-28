package com.example.basestatecodelab.ui.tool

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.basestatecodelab.data.ToolModel

@Composable
fun ToolDetailScreen(toolModel: ToolModel?, navController: NavController) {
    Column {
        IconButton(onClick = { navController.popBackStack() }){
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )
        }
        toolModel?.let {
            Text(
                text = "Detail Screen",
                color = Color.Black
            )
            Text(
                text = toolModel.title,
                color = Color.Black
            )
            Text(
                text = toolModel.status.status,
                color = Color.Black
            )
        }
    }
}