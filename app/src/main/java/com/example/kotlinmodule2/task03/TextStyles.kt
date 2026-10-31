package com.example.kotlinmodule2.task03

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.kotlinmodule2.R

@Preview(showBackground = true)
@Composable
fun GreenItalicTextPreview() {
    Text(
        text = stringResource(R.string.compose_description),
        modifier = Modifier.fillMaxWidth(),
        color = Color.Green,
        fontSize = 16.sp,
        fontStyle = FontStyle.Italic,
        textAlign = TextAlign.Center
    )
}

@Preview(showBackground = true)
@Composable
fun SingleLineTextPreview() {
    Text(
        text = stringResource(R.string.compose_description),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}

@Preview(showBackground = true)
@Composable
fun IndentedTextPreview() {
    Text(
        text = stringResource(R.string.compose_description),
        modifier = Modifier.background(Color.Green),
        color = Color.Black,
        fontSize = 24.sp,
        textDecoration = TextDecoration.Underline,
        style = TextStyle(textIndent = TextIndent(firstLine = 48.sp))
    )
}
