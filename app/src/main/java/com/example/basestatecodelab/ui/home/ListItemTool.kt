package com.example.basestatecodelab.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basestatecodelab.data.ToolModel
import com.example.basestatecodelab.data.ToolStatus
import com.example.basestatecodelab.ui.home.widgets.ItemHotStatusTool
import com.example.basestatecodelab.ui.home.widgets.ItemSoonStatusTool
import com.example.basestatecodelab.ui.home.widgets.ItemTool

@Composable
fun ListItemTool(
    modifier: Modifier,
    tools: List<ToolModel>
) {
    /*LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = modifier.fillMaxWidth()
            .height(188.dp)
    ) {
        items(tools) { tool ->
            val event: @Composable () -> Unit = when (tool.status) {
                ToolStatus.HOT -> {
                    { ItemHotStatusTool() }
                }

                ToolStatus.SOON -> {
                    { ItemSoonStatusTool() }
                }

                else -> {
                    {}
                }
            }
            ItemTool(modifier, tool, event = { event() }) { }
        }
    }*/

    Column(
        modifier = modifier
            .wrapContentHeight()
            .padding(6.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(start = 16.dp, end = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            tools.take(3).forEach { tool ->
                val event: @Composable () -> Unit = when (tool.status) {
                    ToolStatus.HOT -> { { ItemHotStatusTool() } }
                    ToolStatus.SOON -> { { ItemSoonStatusTool() } }
                    else -> { {} }
                }
                ItemTool(modifier, tool, event = { event() }) { }
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            tools.subList(3, 6).forEach { tool ->
                val event: @Composable () -> Unit = when (tool.status) {
                    ToolStatus.HOT -> { { ItemHotStatusTool() } }
                    ToolStatus.SOON -> { { ItemSoonStatusTool() } }
                    else -> { {} }
                }
                ItemTool(modifier, tool, event = { event() }) { }
            }
        }
    }
}

@Preview
@Composable
private fun ListItemToolPreview() {
    Surface(
        color = MaterialTheme.colorScheme.surface
    ) {
        ListItemTool(modifier = Modifier, data)
    }

}

val data = listOf(
    ToolModel("AI Enhance", 1, ToolStatus.HOT),
    ToolModel("AI Beauty", 1, ToolStatus.NONE),
    ToolModel("AI Expand", 1, ToolStatus.NONE),
    ToolModel("Fitting", 1, ToolStatus.NONE),
    ToolModel("AI Enhance", 1, ToolStatus.SOON),
    ToolModel("AI Hair", 1, ToolStatus.NONE)
)