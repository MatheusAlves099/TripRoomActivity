package br.senai.sp.jandira.activelogintriproom.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TopShape() {
    Surface(
        modifier = Modifier
            .width(120.dp)
            .height(40.dp),
        shape = RoundedCornerShape(bottomStart = 16.dp),
        color = Color(207, 6, 240, 255)
    ) {

    }
}

@Preview
@Composable
fun TopShapePreview() {
    TopShape()
}

@Composable
fun BottomShape() {
    Surface(
        modifier = Modifier
            .width(120.dp)
            .height(40.dp),
        shape = RoundedCornerShape(topEnd = 16.dp),
        color = Color(207, 6, 240, 255)
    ) {

    }
}

@Preview
@Composable
fun BottomShapePreview() {
    BottomShape()
}