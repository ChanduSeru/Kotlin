class Event(private val name: String, private var time: String, private var location: String) {

    fun getName(): String {
        return name
    }
	fun getTime(): String {
        return time
    }

    fun setTime(newTime: String) {
        time = newTime
    }
    fun getLocation(): String {
        return location
    }

    fun setLocation(newLocation: String) {
        location = newLocation
    }
}

fun main() {
    // Creating an instance of Event
    val event = Event("Birthday Party", "11:00 A.M", "123 Main Street")

    // Accessing event data
    println("Event Name: ${event.getName()}")
    println("Event Time: ${event.getTime()}")
    println("Event Location: ${event.getLocation()}")
	println("Modified Data")
    // Modifying event data (example)
    event.setLocation("456 Elm Avenue")
    event.setTime("1:00 P.M")
   	println("Event Name: ${event.getName()}")
    println("Event Time: ${event.getTime()}")
    println("Event Location: ${event.getLocation()}")
}
