data class Expense1(val id: Int, val description: String, val amount: Double)

class User1(private val username: String, private val password: String) {
    private var isLogIn: Boolean = false
    private val expenses = mutableListOf<Expense1>()

    fun login(inputPassword: String): Boolean {
        if (inputPassword == password) {
            isLogIn = true
            return true
        }
        return false
    }

    fun addExpense(id: Int, description: String, amount: Double) {
        if (isLogIn) {
            expenses.add(Expense1(id, description, amount))
            println("Expense added successfully.")
        } else {
            println("Please login to add expenses.")
        }
    }


    fun displayExpenseSummary() {
        if (isLogIn) {
            println("Expense Summary for User: $username")
            expenses.forEach { expense ->
                println("ID: ${expense.id}, Description: ${expense.description}, Amount: ${expense.amount}")
            }
        } else {
            println("Please login to display expense summary.")
        }
    }
}

fun main() {
    val user = User1("Chand", "Chan143")

   
    user.addExpense(1, "Milk", 39.0)


    val isLoggedIn = user.login("Chan")
    println("Login successful: $isLoggedIn")

    val isLoggedInNow = user.login("Chan143")
    println("Login successful: $isLoggedInNow")

    user.addExpense(1, "Milk", 39.0)
    user.addExpense(2, "Gas", 30.0)


    user.displayExpenseSummary()
}