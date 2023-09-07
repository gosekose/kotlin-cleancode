package boundary
class AnalogTransmitter(
    private val analogTransmitterPort: AnalogTransmitterPort,
) : Transmitter {
    override fun transmit(frequency: Double, stream: String): String {
        return analogTransmitterPort.transmit(frequency, stream)
    }
}