data class User(val id: Int, val name: String, val email: String)
fun ListUse() {
    // Create a mutable list to store users
    val usersList = mutableListOf<User>()

    // Adding users
    usersList.add(User(1, "Chandu", "chandu@gmail.com"))
    usersList.add(User(2, "lunar", "lunar@gmail.com"))
    usersList.add(User(3, "yinyang", "yinyang@gmail.com"))

    // Display current users
    println("Current users:")
    
    usersList.forEach { println("${it.id}: ${it.name} ${it.email}") }
    println()

    // Removing a user (example: remove user with id 2)
    val userIdToRemove = 2
    val removedUser = usersList.removeIf { it.id == userIdToRemove }

    if (removedUser) {
        println("User with ID $userIdToRemove removed successfully.")
    } else {
        println("User with ID $userIdToRemove not found.")
    }

    // Display updated users
    println("\nUpdated users:")
    usersList.forEach { println("${it.id}: ${it.name} (${it.email})") }
}
fun SetUse() {
    // Create a mutable set to store users
    val usersSet = mutableSetOf<User>()

    // Adding users
    usersSet.add(User(1, "Alice", "alice@example.com"))
    usersSet.add(User(2, "Bob", "bob@example.com"))
    usersSet.add(User(3, "Charlie", "charlie@example.com"))

    // Display current users
    println("Current users:")
    usersSet.forEach { println("${it.id}: ${it.name} (${it.email})") }
    println()

    // Removing a user (example: remove user with id 2)
    val userIdToRemove = 2
    val removed = usersSet.removeIf { it.id == userIdToRemove }

    if (removed) {
        println("User with ID $userIdToRemove removed successfully.")
    } else {
        println("User with ID $userIdToRemove not found.")
    }

    // Display updated users
    println("\nUpdated users:")
    usersSet.forEach { println("${it.id}: ${it.name} (${it.email})") }
}
fun main(){
    ListUse()
    SetUse()
}
