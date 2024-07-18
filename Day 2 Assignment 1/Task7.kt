import java.time.LocalDate

data class Transaction2(val id: Int, val description: String, val amount: Double, val date: LocalDate)

class User2(private val username: String, private val password: String) {
    private var isLogIn: Boolean = false
    private val transactions = mutableListOf<Transaction2>()

    // To login the user
    fun login(inputPassword: String): Boolean {
        if (inputPassword == password) {
            isLogIn = true
            return true
        }
        return false
    }

    //To add a transaction
    fun addTransaction(id: Int, description: String, amount: Double, date: LocalDate) {
        if (isLogIn) {
            transactions.add(Transaction2(id, description, amount, date))
            println("Transaction added successfully.")
        } else {
            println("Please login to add transactions.")
        }
    }

    // To filter transactions by date using a lambda
    fun filterTransactionsByDate(predicate: (Transaction2) -> Boolean): List<Transaction2> {
        return transactions.filter(predicate)
    }

    // To sort transactions by amount using a lambda
    fun sortTransactionsByAmount(comparator: Comparator<Transaction2>): List<Transaction2> {
        return transactions.sortedWith(comparator)
    }

    // To display summary of transactions
    fun displayTransactionSummary(transactions: List<Transaction2>) {
        if (isLogIn) {
            println("Transaction Summary for User: $username")
            transactions.forEach { transaction ->
                println("ID: ${transaction.id}, Description: ${transaction.description}, Amount: ${transaction.amount}, Date: ${transaction.date}")
            }
        } else {
            println("Please login to display transaction summary.")
        }
    }
}


fun main() {
    val user = User2("Chand", "Chan143")

    
    val isLoggedInNow = user.login("Chan143")
    println("Login successful: $isLoggedInNow")

    // Adding transactions
    user.addTransaction(1, "Milk", 39.0, LocalDate.of(2023, 6, 14))
    user.addTransaction(2, "Gas", 1000.0, LocalDate.of(2023, 11, 16))
    user.addTransaction(3, "Dinner", 580.0, LocalDate.of(2023, 11, 20))

   
    val filteredByDate = user.filterTransactionsByDate { it.date.isAfter(LocalDate.of(2023, 11, 15)) }
    println("\nTransactions filtered by date (after Nov 15, 2023):")
    user.displayTransactionSummary(filteredByDate)

    val sortedByAmount = user.sortTransactionsByAmount(compareByDescending { it.amount })
    println("\nTransactions sorted by amount (descending order):")
    user.displayTransactionSummary(sortedByAmount)
}
