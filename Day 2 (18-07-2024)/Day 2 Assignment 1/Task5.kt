data class Transaction1(val id: Int, var description: String, var amount: Double)

class TransactionList {
    private val transactions = mutableListOf<Transaction1>()

    fun addTransaction(id: Int, description: String, amount: Double) {
        val newTransaction = Transaction1(id, description, amount)
        transactions.add(newTransaction)
    }

    fun deleteTransaction(id: Int) {
        val transaction = transactions.find { it.id == id }
        transaction?.let { transactions.remove(it) }
    }

    fun editTransaction(id: Int, newDescription: String, newAmount: Double) {
        val transaction = transactions.find { it.id == id }
        transaction?.apply {
            description = newDescription
            amount = newAmount
        }
    }
    
    fun printTransactions() {
        transactions.forEach {
            println("Transaction ID: ${it.id}, Description: ${it.description}, Amount: ${it.amount}")
        }
    }
}


fun main() {
    val transactionList = TransactionList()

    transactionList.addTransaction(1, "Milk", 39.0)
    transactionList.addTransaction(2, "Gas", 300.0)
    transactionList.addTransaction(3, "Dinner", 480.0)

    println("All Transactions:")
    transactionList.printTransactions()


    transactionList.editTransaction(2, "Fuel", 35.0)

    println("\nTransactions after editing:")
    transactionList.printTransactions()

    transactionList.deleteTransaction(1)

    println("\nTransactions after deletion:")
    transactionList.printTransactions()
}
