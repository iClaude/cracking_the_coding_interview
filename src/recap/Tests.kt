package recap

import kotlin.math.sqrt

data class Point(val xPosition: Double, val yPosition: Double)  // 1

typealias Position = Point  // 2

typealias inRange = (Position) -> Boolean

fun circle(radius: Double): inRange {
    return { position ->
        sqrt(position.xPosition * position.xPosition + position.yPosition * position.yPosition) < radius
    }
}

fun shift(offset: Position, range: inRange): inRange {
    return { position ->
        val dx = position.xPosition - offset.xPosition
        val dy = position.yPosition - offset.yPosition
        range(Position(dx, dy))
    }
}

fun main() {
    println(circle(50.0)(Point(1.5, 70.0)))
    println(shift(Position(10.0, 10.0), circle(10.0)))
}