open class Transaction3(
    val desc: String,
    val amount: Double,
    val date: String
) {
    open fun display() {
        println("Description: $desc")
        println("Amount: $amount")
        println("Date: $date")
    }
}
class Income(
	desc: String,
    amount: Double,
    date: String,
    val source: String
): Transaction3(desc, amount, date){
    override fun display(){
        super.display()
        println("Source: $source")
    }
}
class Expense(
    desc: String,
    amount: Double,
    date: String,
    val category: String
) : Transaction3(desc, amount, date) {
    override fun display() {
        super.display()
        println("Category: $category")
    }
}

fun main() {
    val income = Income("Salary", 20000.0, "05-07-2024", "JOB")
    val expense = Expense("Movie", 500.0, "07-07-2024", "Entertainment")
    
    println("Income Details:")
    income.display()

    println("\nExpense Details:")
    expense.display()
}


