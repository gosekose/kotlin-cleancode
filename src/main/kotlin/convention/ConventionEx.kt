package convention

import kotlin.math.sqrt

/* 지역 변수는 가깝게 설정하기 */
class JunitTestEx {
    private val tests = mutableListOf<TestEx>()

    fun countTestCase(): Int {
        var count = 0
        for (test in tests) {
            count += test.countTests()
        }
        return count
    }

}

data class TestEx(
    val name: String,
) {
    private val tests = mutableListOf<String>()

    fun addTest(test: String) {
        tests.add(test)
    }

    fun countTests() = tests.count()
}

/* 인스턴스 변수는 맨 처음 정의 */
class KoTestEx {
    private val tests = mutableListOf<TestEx>()
}

/* 종속 함수는 가깝게 배치 */
class ReporterConfig {
    private val properties = mutableListOf<String>()

    fun addProperty(property: String) {
        validateProperty(property)
        properties.add(property)
    }

    private fun validateProperty(property: String) {
        require(property.isNotEmpty()) { "property should not empty" }
    }
}

/* 개념적 유사성 */
object Assert {

    private const val DEFAULT_EXCEPTION_MESSAGE = "Exception"
    fun assertTrue(message: String, condition: Boolean) {
        if (!condition) fail(message)
    }

    fun assertTrue(condition: Boolean) {
        assertTrue(DEFAULT_EXCEPTION_MESSAGE, condition)
    }

    fun assertFalse(message: String, condition: Boolean) {
        assertTrue(message, !condition)
    }

    fun assertFalse(condition: Boolean) {
        assertFalse(DEFAULT_EXCEPTION_MESSAGE, condition)
    }

    private fun fail(message: String): Nothing {
        throw IllegalArgumentException(message)
    }
}

/* 연산사 우선순위에 따라 공백을 적절하게 처리*/
object Quadratic {
    fun root(a: Double, b: Double, c: Double): Double {
        val determinant = determinant(a, b, c)
        return (-b + sqrt(determinant)) / (2 * a)
    }

    private fun determinant(a: Double, b: Double, c: Double): Double {
        return b * b - 4 * a * c
    }
}