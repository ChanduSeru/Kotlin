data class Event(val name: String, val time: String)

typealias NotificationHandler = (Event) -> Unit

class EventManager {
    private val subscribers = mutableSetOf<NotificationHandler>()

    fun subscribe(handler: NotificationHandler) {
        subscribers.add(handler)
    }

    fun unsubscribe(handler: NotificationHandler) {
        subscribers.remove(handler)
    }

    fun notify(event: Event) {
        subscribers.forEach { handler ->
            handler(event)
        }
    }
}


fun main() {
    val eventManager = EventManager()
    val subscriber1: NotificationHandler = { event ->
        println("Notification for event '${event.name}' at ${event.time}")
    }

    val subscriber2: NotificationHandler = { event ->
      
        println("Custom notification for event '${event.name}'")
    }

    eventManager.subscribe(subscriber1)
    eventManager.subscribe(subscriber2)

    val event = Event("Meeting", "10:00 AM")
    eventManager.notify(event)

    eventManager.unsubscribe(subscriber1)
    
    val anotherEvent = Event("Presentation", "2:00 PM")
    eventManager.notify(anotherEvent)
}

