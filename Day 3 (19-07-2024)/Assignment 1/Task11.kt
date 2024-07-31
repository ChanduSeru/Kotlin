data class Transaction(val id: Int, val amount: Double, val description: String)
fun handleTransactions(transactions: Collection<Transaction>?) {
    transactions?.forEach { transaction ->
        println("Transaction ID: ${transaction.id}")
        println("Amount: ${transaction.amount}")
        println("Description: ${transaction.description}")
        println()
    } ?: println("Unsupported collection type or empty collection")
}
fun main() {
    // Example usage with list
    val transactionList = listOf(
        Transaction(1, 100.0, "Grocery"),
        Transaction(2, 50.0, "Fuel"),
        Transaction(3, 200.0, "Shopping")
    )
    handleTransactions(transactionList)

    // Example usage with set
    val transactionSet = setOf(
        Transaction(1, 100.0, "Grocery"),
        Transaction(2, 50.0, "Fuel"),
        Transaction(3, 200.0, "Shopping")
    )
    handleTransactions(transactionSet)

    // Example usage with map
    val transactionMap = mapOf(
        1 to Transaction(1, 100.0, "Grocery"),
        2 to Transaction(2, 50.0, "Fuel"),
        3 to Transaction(3, 200.0, "Shopping")
    )
    handleTransactions(transactionMap.values) // Use .values to pass the collection of transactions
}

