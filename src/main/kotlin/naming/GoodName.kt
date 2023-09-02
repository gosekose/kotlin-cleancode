package naming

import java.util.*

/* 명확한 네이밍 */
data class Day(
    val elapsedTimeInDays: Int,
    val daysSinceCreation: Int,
    val daysSinceModified: Int,
    val fileAgeInDays: Int,
)

/* 명확한 네이밍 */
class Cell(
    val row: Int,
    val column: Int,
    val flag: Boolean,
) {
    fun isFlagged() = flag
}

fun getFlaggedCells(gameBoard: List<Cell>): List<Cell> {
    val flaggedCells = mutableListOf<Cell>()
    for (cell in gameBoard) {
        if (cell.isFlagged()) flaggedCells.add(cell)
    }

    return flaggedCells
}

/* 발음하기 쉬운 네이밍 */
data class Customer(
    val generationTimeStamp: Date,
    val modificationTimeStamp: Date,
)

/* 팩토리 메서드 활용 */
class Rectangle(
    var width: Int = 15,
    var height: Int = 0,
) {

    companion object {
        fun fromHeight(height: Int): Rectangle {
            return Rectangle(height = height)
        }
    }
}

fun main() {
    val rectangle = Rectangle.fromHeight(10)
}