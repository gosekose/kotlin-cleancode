package function

open class Employee {
    open fun isPayDay(): Boolean = true

    open fun calculatePay() = Money()

    open fun deliverPay(pay: Money) = println("deliver pay")
}

class CommissionedEmployee : Employee()

class HourlyEmployee : Employee()

class SalariedEmployee : Employee()

class Money

enum class EmployeeType {
    COMMISSIONED, HOURLY, SALARIED
}

interface EmployeeFactory {
    fun makeEmployee(employeeType: EmployeeType): Employee
}

class EmployeeFactoryImpl : EmployeeFactory {
    override fun makeEmployee(employeeType: EmployeeType): Employee {
        return when (employeeType) {
            EmployeeType.COMMISSIONED -> CommissionedEmployee()
            EmployeeType.HOURLY -> HourlyEmployee()
            EmployeeType.SALARIED -> SalariedEmployee()
        }
    }
}