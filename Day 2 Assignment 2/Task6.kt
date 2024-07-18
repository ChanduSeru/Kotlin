//Interface
interface Display {
    fun showEventDetails(event: Event2)
}

// Define an Event data class
data class Event2(val name: String, val date: String, val location: String)

class EventManager2 : Display {
    override fun showEventDetails(event: Event2) {
        println("Event Name: ${event.name}")
        println("Date: ${event.date}")
        println("Location: ${event.location}")
    }
}

fun main() {
   
    val eventManager = EventManager2()

    val event = Event2("New Mobile Launch", "10-11-2024", "Virtual")

    eventManager.showEventDetails(event)
}