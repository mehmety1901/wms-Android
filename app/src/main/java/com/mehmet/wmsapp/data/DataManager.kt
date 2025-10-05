package com.mehmet.wmsapp.data

object DataManager {
    private val products = mutableListOf<Product>()
    private val orders = mutableListOf<Order>()

    fun addProduct(product: Product) {
        products.add(product)
    }

    fun getProducts(): List<Product> {
        return products.toList()
    }

    fun addOrder(order: Order) {
        orders.add(order)
    }

    fun getOrders(): List<Order> {
        return orders.toList()
    }

    fun clearAll() {
        products.clear()
        orders.clear()
    }

    // Başlangıç örnek verileri
    fun initializeSampleData() {
        if (products.isEmpty()) {
            addProduct(Product("PRD001", "Bluetooth Kulaklık", 5, "RACK5", 10, "Orta", false))
            addProduct(Product("PRD002", "Powerbank", 3, "RACK2", 4, "Küçük", true))
            addProduct(Product("PRD003", "USB Kablo", 15, "RACK1", 8, "Küçük", false))
        }

        if (orders.isEmpty()) {
            val item1 = Product("PRD001", "Bluetooth Kulaklık", 2, "RACK5", 10, "Orta", false)
            val item2 = Product("PRD002", "Powerbank", 1, "RACK2", 4, "Küçük", true)
            
            addOrder(Order(
                orderId = "ORD001",
                customerName = "Ahmet Yılmaz",
                orderDate = "2025-01-15",
                status = "Pending",
                items = listOf(item1, item2),
                isReturn = false,
                notes = "Hızlı kargo isteniyor"
            ))

            addOrder(Order(
                orderId = "ORD002",
                customerName = "Ayşe Demir",
                orderDate = "2025-01-14",
                status = "Packed",
                items = listOf(item1),
                isReturn = false,
                notes = null
            ))
        }
    }
}
