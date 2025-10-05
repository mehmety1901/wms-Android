package com.mehmet.wmsapp.utils

object Constants {
    // API Base URL - Replace with your actual API endpoint
    const val BASE_URL = "https://api.example.com/wms/"
    
    // Package Types
    const val PACKAGE_SMALL = "Küçük"
    const val PACKAGE_MEDIUM = "Orta"
    const val PACKAGE_LARGE = "Büyük"
    
    // Order Status
    const val STATUS_PENDING = "Pending"
    const val STATUS_PACKED = "Packed"
    const val STATUS_SHIPPED = "Shipped"
    const val STATUS_DELIVERED = "Delivered"
    
    // Shared Preferences Keys
    const val PREF_NAME = "WMSAppPreferences"
    const val PREF_USER_ID = "user_id"
    const val PREF_USER_NAME = "user_name"
}
