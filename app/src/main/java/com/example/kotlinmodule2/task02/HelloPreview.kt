package com.example.kotlinmodule2.task02

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlinmodule2.task01.Hello
import com.example.kotlinmodule2.ui.theme.KotlinModule2Theme

@Preview(
    name = "portrait",
    showSystemUi = true,
    device = "spec:parent=pixel_5,orientation=portrait"
)
@Preview(
    name = "landscape",
    showSystemUi = true,
    device = "spec:parent=pixel_5,orientation=landscape"
)
@Composable
fun HelloPreview() {
    KotlinModule2Theme {
        Hello(
            name = "Android",
            modifier = Modifier.padding(top = 48.dp, start = 16.dp)
        )
    }
}

@Preview(
    name = "round",
    showSystemUi = true,
    showBackground = true,
    backgroundColor = 0xFFFFFF00,
    device = "spec:width=200dp,height=200dp,dpi=320,isRound=true"
)
@Composable
fun HelloRoundPreview() {
    KotlinModule2Theme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Yellow),
            contentAlignment = Alignment.Center
        ) {
            Hello(name = "Android")
        }
    }
}
