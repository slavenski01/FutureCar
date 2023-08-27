package com.slavenski.game.futurecar.ui.car

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.dp
import com.slavenski.game.futurecar.ui.theme.PlayerCarCircle

fun DrawScope.drawPlayerCar(
    xCurrent: Float,
    yCurrent: Float
) {
    val sizeCar = Size(25.dp.toPx(), 25.dp.toPx())
    val sizePilotCar = Size(12.dp.toPx(), 13.dp.toPx())
    val topLeft = Offset(xCurrent - sizeCar.width / 2, yCurrent - sizeCar.height / 2)
    val topLeftPilot = topLeft.copy(topLeft.x + 6.dp.toPx(), topLeft.y + 6.dp.toPx())
    val radiusWheel = 15f

    val centerTopLeftWheel = Offset(
        xCurrent - radiusWheel - sizeCar.width / 2,
        yCurrent - sizeCar.height / 2
    )
    val centerTopRightWheel = Offset(
        (xCurrent + sizeCar.width) + radiusWheel - sizeCar.width / 2,
        yCurrent - sizeCar.height / 2
    )
    val centerBottomRightWheel = Offset(
        (xCurrent + sizeCar.width / 2) + radiusWheel,
        (yCurrent + sizeCar.height / 2) + radiusWheel
    )
    val centerBottomLeftWheel = Offset(
        xCurrent - radiusWheel - sizeCar.width / 2,
        (yCurrent + sizeCar.height / 2) + radiusWheel
    )


    drawCircle(
        color = PlayerCarCircle,
        radius = radiusWheel,
        center = centerTopLeftWheel
    )
    drawCircle(
        color = PlayerCarCircle,
        radius = radiusWheel,
        center = centerTopRightWheel
    )
    drawCircle(
        color = PlayerCarCircle,
        radius = radiusWheel,
        center = centerBottomRightWheel
    )
    drawCircle(
        color = PlayerCarCircle,
        radius = radiusWheel,
        center = centerBottomLeftWheel
    )
    drawRect(
        color = Color.Blue,
        topLeft = topLeft,
        size = sizeCar
    )
    drawRect(
        color = Color.Red,
        topLeft = topLeftPilot,
        size = sizePilotCar
    )
}