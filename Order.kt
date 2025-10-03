data class Product(
    val sku: String,
    val name: String,
    val quantity: Int,
    val rackCode: String,
    val rackSlot: Int,
    val packageType: String,
    val isGift: Boolean
)

data class Order(
    val orderId: String,
    val customerName: String,
    val orderDate: String,
    val status: String,
    val items: List<Product>,
    val isReturn: Boolean = false,
    val notes: String? = null
)

fun main() {
    val item1 = Product("PRD001", "Bluetooth Kulaklık", 5, "RACK5", 10, "Orta", false)
    val item2 = Product("PRD002", "Powerbank", 3, "RACK2", 4, "Küçük", true)

    val order = Order(
        orderId = "ORD123",
        customerName = "Mehmet Yıldırım",
        orderDate = "2025-10-03",
        status = "Pending",
        items = listOf(item1, item2),
        isReturn = false,
        notes = "Kargo hızlı olsun"
    )

    println(order)
}

