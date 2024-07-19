open class Event4(val name: String, val date: String, val venue: String) {

}

class SpecialEvent(
    name: String,
    date: String,
    venue: String,
    val vipList: MutableList<String> = mutableListOf(),
    val premiumServices: Boolean = true
) : Event4(name, date, venue) {
    fun addGuestToVIPList(guestName: String) {
        vipList.add(guestName)
    }

    fun isPremiumServiceAvailable(): Boolean {
        return premiumServices
    }
}

fun main() {
    // Example usage:
    val specialEvent = SpecialEvent("New App Launch", "11-10-2024", "Grand Hall")
    specialEvent.addGuestToVIPList("Chand")
    specialEvent.addGuestToVIPList("Chan")

    println("Event: ${specialEvent.name}")
    println("Date: ${specialEvent.date}")
    println("Venue: ${specialEvent.venue}")
    println("VIP List: ${specialEvent.vipList}")
    println("Premium Services Available: ${specialEvent.isPremiumServiceAvailable()}")
}