package com.example.basestatecodelab.ui.home.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.basestatecodelab.R
import com.example.basestatecodelab.data.CategoryModel

@Composable
fun ItemCategory(
    modifier: Modifier,
    item: CategoryModel,
    navigationToDetail: (CategoryModel) -> Unit
) {
    Surface(
        modifier = Modifier
            .size(width = 160.dp, height = 240.dp)
            .border(
                1.dp,
                colorResource(R.color.home_item_category_border),
                RoundedCornerShape(10.dp)
            )
            .clickable { navigationToDetail(item) },
        shape = RoundedCornerShape(10.dp),
        color = MaterialTheme.colorScheme.surface,
        shadowElevation = 4.dp,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(
                modifier = Modifier.size(width = 160.dp, height = 200.dp),
                shape = RoundedCornerShape(10.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.img_category),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }
            Box(
                modifier = modifier.fillMaxSize()
            ){
                Text(
                    modifier = modifier.align(Alignment.Center),
                    text = item.title,
                    fontSize = 10.sp,
                    fontWeight = FontWeight(400),
                    fontFamily = FontFamily.Serif
                )
            }
        }
    }
}

@Preview
@Composable
private fun ItemCategoryPreview() {
    val item = CategoryModel("", "Alida")
    ItemCategory(modifier = Modifier, item) { }
}