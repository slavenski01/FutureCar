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
import com.slavenski.game.futurecar.ui.car.drawPlayerCar

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
                        newPath.add(
                            Offset(
                                x = it.x,
                                y = this.size.height - 80.dp.toPx()
                            )
                        )
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
        drawPlayerCar(100f, this.size.height - 100.dp.toPx())
        drawPoints(
            points = carPointsPath,
            strokeWidth = 1.dp.toPx(),
            pointMode = PointMode.Lines,
            color = Color.Black
        )
        drawLine(
            color = Color.Black,
            start = Offset(
                x = 0.dp.toPx(),
                y = this.size.height - 80.dp.toPx()
            ),
            end = Offset(
                x = this.size.width,
                y = this.size.height - 80.dp.toPx()
            )
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