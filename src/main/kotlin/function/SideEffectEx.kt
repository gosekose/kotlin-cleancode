package function

class UserValidatorV1 {
    fun checkPassword(userName: String, password: String): Boolean {
        val phase = UserGateway.findByName(userName)?.let {
            val codedPhase = it.encryptedPassword
            Cryptographer.verifyPassword(codedPhase, password)
        }

        /* 문제가 되는 소스 */
        if (phase == VerificationResult.VALID) {
            Session.initialize()
            return true
        }

        return false
    }
}

class UserValidatorV2 {
    fun checkPassword(userName: String, password: String): Boolean {
        val phase = UserGateway.findByName(userName)?.let {
            val encryptedPassword = it.encryptedPassword
            Cryptographer.verifyPassword(encryptedPassword, password)
        }

        /* 단일 책임 원칙 */
        return phase == VerificationResult.VALID
    }
}

object Session {
    fun initialize() {
        println("session setup")
    }
}

object Cryptographer {
    fun verifyPassword(encryptedPassword: String, password: String): VerificationResult {
        return if (encryptedPassword == encrypt(password)) VerificationResult.VALID else VerificationResult.INVALID
    }

    fun encrypt(password: String) = password
}

enum class VerificationResult {
    VALID, INVALID
}

class User(
    val userName: String,
    var password: String,
) {

    var encryptedPassword: String = Cryptographer.encrypt(password)
        private set

    fun changePasswordAndEncryptedPassword(newPassword: String) {
        password = newPassword
        encryptedPassword = Cryptographer.encrypt(password)
    }
}

object UserGateway {

    private val userMap = mutableMapOf<String, User>()
    fun findByName(userName: String): User? {
        return userMap[userName]
    }
}

