package com.slavenski.game.futurecar.ui.field

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FieldDraw(
    modifier: Modifier = Modifier,
    filter: PointerEventType? = null
) {
    var carPointsPath by remember {
        mutableStateOf(listOf<Offset>())
    }
    Canvas(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .pointerInput(filter) {
                detectDragGestures(
                    onDragStart = {
                        val newPath = carPointsPath.toMutableList()
                        newPath.add(it)
                        carPointsPath = newPath.toList()
                    },
                    onDrag = { change, _ ->
                        val newPath = carPointsPath.toMutableList()
                        newPath.add(change.position)
                        carPointsPath = newPath.toList()
                    },
                    onDragEnd = {
                        val newList = carPointsPath.toMutableList()
                        newList.clear()
                        carPointsPath = newList
                    }
                )
            }
    ) {
        drawPoints(
            points = carPointsPath,
            strokeWidth = 1.dp.toPx(),
            pointMode = PointMode.Lines,
            color = Color.Black
        )
    }
}

@Preview
@Composable
fun TestFieldDraw() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        FieldDraw()
    }
}