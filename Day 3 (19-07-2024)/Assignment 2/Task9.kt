// Interface defining properties and methods common to all events
interface Event {
    var name: String
    var startTime: String
    var duration: Int

    fun displayDetails() {
        println("Event: $name")
        println("Start Time: $startTime")
        println("Duration: $duration minutes")
    }
}

// Interface for scheduling operations
interface Schedulable {
    fun schedule(event: Event)
    fun reschedule(event: Event, newStartTime: String, newDuration: Int)
}

// Implementation of Schedule class that handles scheduling and rescheduling
class Schedule : Schedulable {
    private val events = mutableListOf<Event>()

    override fun schedule(event: Event) {
        events.add(event)
        println("Event '${event.name}' scheduled for ${event.startTime} with duration ${event.duration} minutes.")
    }

    override fun reschedule(event: Event, newStartTime: String, newDuration: Int) {
        event.startTime = newStartTime
        event.duration = newDuration
        println("Event '${event.name}' rescheduled to $newStartTime with duration $newDuration minutes.")
    }
}

// Example of a specific event (Meeting) implementing Event interface
data class Meeting(
    override var name: String,
    override var startTime: String,
    override var duration: Int
) : Event

fun main() {
    val schedule = Schedule()

    // Example usage
    val meeting = Meeting("Team Meeting", "10:00 AM", 60)
    schedule.schedule(meeting)

    // User changes to meeting details
    meeting.name = "Client Presentation"
    meeting.startTime = "2:00 PM"
    meeting.duration = 90

    // Reschedule the meeting
    schedule.reschedule(meeting, meeting.startTime, meeting.duration)
}
