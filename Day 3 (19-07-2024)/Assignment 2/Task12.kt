class DataManager<T> {
    private val data: MutableList<T> = mutableListOf()

    // add data
    fun add(item: T) {
        data.add(item)
    }

    // retrieve all data
    fun getAll(): List<T> {
        return data.toList()
    }
}

data class Attendee(val name: String, val id: String)
data class Event(val name: String, val location: String)

fun main() {
    val attendeeManager = DataManager<Attendee>()
    val eventManager = DataManager<Event>()

    // Add attendees
    attendeeManager.add(Attendee("Chand", "chand@gmail.com"))
    attendeeManager.add(Attendee("Lunar", "lunar@gmail.com"))

    // Add events
    eventManager.add(Event("Conference", "Hyderabad"))
    eventManager.add(Event("Workshop", "Bangolore"))

    // Retrieve and print all attendees
    val allAttendees = attendeeManager.getAll()
    println("All attendees:")
    allAttendees.forEach { println("${it.name} - ${it.id}") }

    // Retrieve and print all events
    val allEvents = eventManager.getAll()
    println("\nAll events:")
    allEvents.forEach { println("${it.name} - ${it.location}") }
}
