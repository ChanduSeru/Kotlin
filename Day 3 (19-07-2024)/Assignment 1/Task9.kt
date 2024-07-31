// Define the Exportable interface
interface Exportable {
    fun exportToCSV(): String
}

// Example class implementing Exportable interface
class TransactionData : Exportable {
    // Example transaction data properties
    private val transactions = listOf(
        Transaction("2024-07-26 ", " John Doe   ", 100.0),
        Transaction("2024-07-27", " Jane Smith  ", 150.0)
    )

    // Implementation of the exportToCSV method
    override fun exportToCSV(): String {
        val csvContent = StringBuilder()
        csvContent.append("Date  ","       Name  "," Amount\n") // CSV header

        for (transaction in transactions) {
            csvContent.append("${transaction.date},${transaction.name},${transaction.amount}\n")
        }

        return csvContent.toString()
    }

    // Example inner class representing a transaction
    data class Transaction(val date: String, val name: String, val amount: Double)
}

// Main function to demonstrate usage
fun main() {
    val transactionData = TransactionData()
    val csvData = transactionData.exportToCSV()
    println(csvData)
}
