data class Event(val name: String, val date: String, val type: String)

fun main() {
    // Sample collection of events
    val events = listOf(
        Event("Birthday Party", "2024-07-28", "Party"),
        Event("Conference", "2024-08-10", "Conference"),
        Event("Meeting", "2024-08-05", "Meeting"),
        Event("Wedding", "2024-07-30", "Party")
    )

    // Filter events by date
    val eventsInJuly = events.filter { it.date.startsWith("2024-07") }
    println("Events in July 2024:")
    eventsInJuly.forEach { println("${it.name} (${it.type}) on ${it.date}") }
    println()

    // Filter events by type
    val partyEvents = events.filter { it.type == "Party" }
    println("Party Events:")
    partyEvents.forEach { println("${it.name} (${it.type}) on ${it.date}") }
}
