package objectanddatastructure

interface VehicleObjectExV1 {
    fun getFuelTankCapacityInGallons(): Double
    fun getGallonsOfGasoline(): Double
}

/* 더 좋은 설계 -> 추상화 */
interface VehicleObjectExV2 {
    fun getPercentFuelRemaining(): Double
}

/* 다형적인 도형 */
class SquareObjectEx(
    val toLeft: PointObjectEx,
    val side: Double,
) : ShapeObjectEx {
    override fun area(): Double {
        return side * side
    }
}

class RectangleObjectEx(
    val toLeft: PointObjectEx,
    val height: Double,
    val width: Double,
) : ShapeObjectEx {
    override fun area(): Double {
        return height * width
    }

}

interface ShapeObjectEx {
    fun area(): Double
}

data class PointObjectEx(
    val x: Double,
    val y: Double,
)