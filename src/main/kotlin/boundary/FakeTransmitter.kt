package boundary
class FakeTransmitter : Transmitter {
    override fun transmit(frequency: Double, stream: String): String {
        return "hello"
    }
}