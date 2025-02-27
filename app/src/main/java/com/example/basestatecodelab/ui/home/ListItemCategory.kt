package com.example.basestatecodelab.ui.home

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.basestatecodelab.R
import com.example.basestatecodelab.data.CategoryModel
import com.example.basestatecodelab.data.DataItem
import com.example.basestatecodelab.ui.home.widgets.ItemCategory

@Composable
fun ListDataItem(listItem: List<DataItem>) {
    Column{
        listItem.forEach { dataItem ->
            ListItemCategory(modifier = Modifier, dataItem) { }
        }
    }
}

@Composable
fun ListItemCategory(
    modifier: Modifier = Modifier,
    dataItem: DataItem,
    navigationToDetail: (CategoryModel) -> Unit
) {
    val scrollState = rememberScrollState()
    Column {
        Text(
            text = dataItem.title,
            color = colorResource(R.color.text_title_category),
            fontSize = 18.sp,
            fontWeight = FontWeight(400),
            fontFamily = FontFamily.Serif
        )
        Spacer(modifier.height(16.dp))
       Row(
            modifier = modifier
                .fillMaxWidth()
                .horizontalScroll(scrollState),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            dataItem.categories.forEach { category ->
                ItemCategory(modifier, category) {
                    navigationToDetail(category)
                }
            }
        }
    }
}


@Preview
@Composable
private fun ListDataItemPreview() {
    val homeViewModel : HomeViewModel = viewModel()
    Surface(
        color = MaterialTheme.colorScheme.surface
    ) {
        ListDataItem(homeViewModel.getDataItem())
    }
}