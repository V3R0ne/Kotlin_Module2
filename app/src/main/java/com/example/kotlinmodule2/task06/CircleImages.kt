package com.example.kotlinmodule2.task06

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlinmodule2.R

@Composable
fun CircleTopEnd(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(width = 240.dp, height = 120.dp)
            .background(Color.Black),
        contentAlignment = Alignment.TopEnd
    ) {
        Image(
            painter = painterResource(R.drawable.circle),
            contentDescription = "Круг"
        )
    }
}

@Composable
fun CircleCenterPurple(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(width = 240.dp, height = 120.dp)
            .background(Color.Blue),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.circle),
            contentDescription = "Круг",
            modifier = Modifier.fillMaxSize(),
            colorFilter = ColorFilter.tint(Color(0xFF9C27B0))
        )
    }
}

@Preview
@Composable
fun CircleTopEndPreview() {
    CircleTopEnd()
}

@Preview
@Composable
fun CircleCenterPurplePreview() {
    CircleCenterPurple()
}
