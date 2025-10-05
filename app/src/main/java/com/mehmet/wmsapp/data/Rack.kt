package com.mehmet.wmsapp.data

data class Rack(
    val rackCode: String,
    val location: String,
    val capacity: Int,
    val currentOccupancy: Int,
    val slots: List<RackSlot> = emptyList()
)

data class RackSlot(
    val slotNumber: Int,
    val isEmpty: Boolean,
    val product: Product? = null
)
