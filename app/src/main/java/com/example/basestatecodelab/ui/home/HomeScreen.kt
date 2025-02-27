package com.example.basestatecodelab.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HomeScreen(modifier: Modifier = Modifier, viewModel: HomeViewModel) {
    val scrollSate = rememberScrollState()
    Column(
        modifier
            .fillMaxSize()
            .verticalScroll(scrollSate)
    ) {
        BannerSlider(viewModel.getBanners())
        Spacer(modifier.height(32.dp))
        ListItemTool(modifier, viewModel.getTools())
        Spacer(modifier.height(16.dp))
        ListDataItem(viewModel.getDataItem())
    }
}


/*
@Preview
@Composable
private fun HomeScreenPreview() {
    val viewModel: HomeViewModel = viewModel()
    Surface(
        color = MaterialTheme.colorScheme.surface
    ) {
        HomeScreen(modifier = Modifier, viewModel)
    }
}*/
