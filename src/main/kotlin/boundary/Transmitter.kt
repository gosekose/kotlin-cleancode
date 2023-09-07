package boundary
interface Transmitter {
    fun transmit(frequency: Double, stream: String): String
}