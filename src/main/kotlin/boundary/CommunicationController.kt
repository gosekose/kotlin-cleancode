package boundary

class CommunicationController(
    private val transmitter: Transmitter,
) {
    fun transmit(transmissionRequest: TransmitterRequest): ResponseEntity<TransmissionResponse> {
        val analogSign = transmitter.transmit(transmissionRequest.frequency, transmissionRequest.stream)

        return ResponseEntity(
            code = ResponseCode.OK,
            data = TransmissionResponse(
                analogSign = analogSign,
            ),
        )
    }
}

data class TransmitterRequest(
    val frequency: Double,
    val stream: String,
)

data class TransmissionResponse(
    val analogSign: String,
)

data class ResponseEntity<T>(
    val code: ResponseCode,
    val data: T,
)

enum class ResponseCode(
    val code: String,
    val status: String,
) {
    OK("200", "ok"),
    BAD_REQUEST("400", "Bad Request"),
}