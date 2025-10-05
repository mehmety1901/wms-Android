package com.mehmet.wmsapp.data

data class Order(
    val orderId: String,
    val customerName: String,
    val orderDate: String,
    val status: String,
    val items: List<Product>,
    val isReturn: Boolean = false,
    val notes: String? = null
)
