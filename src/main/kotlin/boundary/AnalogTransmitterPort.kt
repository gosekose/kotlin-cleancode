package boundary

interface AnalogTransmitterPort {
    fun transmit(frequency: Double, stream: String): String
}