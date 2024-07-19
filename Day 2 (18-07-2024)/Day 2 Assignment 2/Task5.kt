data class Event1(
    val name: String,
    val date: String,
    val amount: Double
)

class EventManager1 {
    private val events: MutableSet<Event1> = mutableSetOf()

    // add an event
    fun addEvent(name: String, date: String, amount: Double) {
        val event = Event1(name, date, amount)
        events.add(event)
        println("Event '$name' added.")
    }

    // remove an event
    fun removeEvent(name: String) {
        val eventToRemove = events.find { it.name == name }
        if (eventToRemove != null) {
            events.remove(eventToRemove)
            println("Event '$name' removed.")
        } else {
            println("Event '$name' not found.")
        }
    }

    // display all events
    fun displayEvents() {
        println("Current Events:")
        events.forEach { println("${it.name} | Date: ${it.date} | Amount: ${it.amount}") }
    }
}

fun main() {
    val eventManager = EventManager1()

    // Adding events
    eventManager.addEvent("Birthday Party", "23-07-2024", 1000.0)
    eventManager.addEvent("Conference", "27-07-2024", 11200.0)
    eventManager.addEvent("Wedding", "02-08-2024", 50000.0)

  
    eventManager.displayEvents()

    eventManager.removeEvent("Conference")

    eventManager.displayEvents()

    eventManager.removeEvent("Conference")
}