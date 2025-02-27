package com.example.basestatecodelab.ui.home.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.basestatecodelab.R
import com.example.basestatecodelab.data.ToolModel
import com.example.basestatecodelab.data.ToolStatus

@Composable
fun ItemTool(
    modifier: Modifier,
    tool: ToolModel,
    event: @Composable () -> Unit,
    navigation: (ToolModel) -> Unit
) {
    Column(
        modifier = modifier
            .padding(6.dp)
    ) {
        Box(
            modifier = Modifier.wrapContentSize()
                .align(Alignment.CenterHorizontally)
        ){
            Surface(
                modifier = Modifier.shadow(elevation = 4.dp, shape = RoundedCornerShape(10.dp))
                    .size(56.dp)
                    .background(color = Color.White, shape = RoundedCornerShape(10.dp))

            ) {
                Icon(
                    imageVector = Icons.Default.Create,
                    contentDescription = null,
                    modifier = modifier
                        .padding(16.dp)
                )
            }
            Box(
                modifier = modifier.align(Alignment.TopEnd)
                    .align(Alignment.TopEnd)
                    .offset(x = 8.dp, y = (-6).dp)
            ){
                event()
            }
        }
        Spacer(modifier.height(4.dp))
        Text(
            text = tool.title,
            fontSize = 10.sp,
            fontWeight = FontWeight(400),
            modifier = modifier.padding(top = 4.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun ItemSoonStatusTool(){
    Text(
        text = "SOON",
        fontSize = 8.sp,
        color = Color.White,
        modifier = Modifier
            .background(
                color = colorResource(R.color.home_tool_coming_soon_color),
                shape = RoundedCornerShape(dimensionResource(id = R.dimen._8dp),)
            )
            .padding(
                horizontal = dimensionResource(id = R.dimen._6dp),
                vertical = dimensionResource(id = R.dimen._4dp)
            )
    )
}


@Composable
fun ItemHotStatusTool(){
    Text(
        text = "HOT",
        fontSize = 8.sp,
        color = Color.White,
        modifier = Modifier
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        colorResource(id = R.color.home_tool_hot_gradient_start),
                        colorResource(id = R.color.home_tool_hot_gradient_end)
                    ),
                    start = Offset.Zero,
                    end = Offset.Infinite
                ),
                shape = RoundedCornerShape(
                    topStart = dimensionResource(id = R.dimen._8dp),
                    bottomEnd = dimensionResource(id = R.dimen._8dp)
                )
            )
            .padding(
                horizontal = dimensionResource(id = R.dimen._6dp),
                vertical = dimensionResource(id = R.dimen._4dp)
            )
    )
}