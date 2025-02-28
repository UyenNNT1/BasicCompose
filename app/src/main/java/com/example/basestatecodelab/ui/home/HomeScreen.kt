package com.example.basestatecodelab.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.basestatecodelab.data.ToolModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel,
    navigationToToolDetail: (ToolModel) -> Unit
) {
    val scrollSate = rememberScrollState()
    val banners by viewModel.banners.collectAsState(initial = emptyList())
    val tools by viewModel.tool.collectAsState(initial = emptyList())
    val dataItems by viewModel.categories.collectAsState(initial = emptyList())
    Column(
        modifier
            .fillMaxSize()
            .verticalScroll(scrollSate)
    ) {
        BannerSlider(banners = banners)
        Spacer(modifier.height(32.dp))
        ListItemTool(tools = tools, navigationToDetail = { navigationToToolDetail(it) })
        Spacer(modifier.height(16.dp))
        ListDataItem(listItem = dataItems)
    }
}

