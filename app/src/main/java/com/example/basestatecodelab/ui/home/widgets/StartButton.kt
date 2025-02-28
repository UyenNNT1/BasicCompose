package com.example.basestatecodelab.ui.home.widgets

import android.content.res.Resources
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddBox
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun StartButton(modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .padding(start = 16.dp, end = 16.dp)
            .background(Color.White, RoundedCornerShape(10.dp)),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)

    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .align(Alignment.CenterHorizontally)

        ) {
            val (iconRef, textRef) = createRefs()

            createHorizontalChain(iconRef, textRef, chainStyle = ChainStyle.Packed)

            Icon(
                imageVector = Icons.Default.AddBox,
                contentDescription = null,
                modifier = Modifier
                    .constrainAs(iconRef) {
                        bottom.linkTo(parent.bottom)
                        top.linkTo(parent.top)
                    }
                    .size(24.dp)
            )
            Text(
                text = "Starting Editing",
                modifier = Modifier
                    .padding(start = 16.dp)
                    .constrainAs(textRef) {
                        bottom.linkTo(parent.bottom)
                        top.linkTo(parent.top)
                    },
                color = Color.Black,
                fontSize = 16.sp
            )
        }
    }

}

@Preview
@Composable
private fun StartButtonPreview() {
    val screenWidth = Resources.getSystem().displayMetrics.widthPixels
    val width80 = (screenWidth * 0.8).toInt()
    Button(
        onClick = { },
        modifier = Modifier.width(width80.dp)
    ) {
        Text(text = "Start Editing")
    }
}

val Int.toDp: Dp
    @Composable get() = with(LocalDensity.current) { this@toDp.toDp() }

val Int.toPx: Float
    @Composable get() = with(LocalDensity.current) { this@toPx.toPx }
