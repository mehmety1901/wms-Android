package com.mehmet.wmsapp.data

data class Package(
    val packageId: String,
    val orderId: String,
    val packageType: String,
    val weight: Double,
    val dimensions: String,
    val status: String,
    val trackingNumber: String? = null
)
