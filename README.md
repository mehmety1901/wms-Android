# WMS Android - Warehouse Management System

Android-based Warehouse Management System (WMS) for inventory, orders, packaging, and shipment management.

## Features

- **Product Management**: Add, view, and manage products with SKU, quantity, rack location, and package type
- **Rack Management**: Organize warehouse racks with capacity and occupancy tracking
- **Order Management**: Create and track customer orders with status updates
- **Package Management**: Handle package creation with weight, dimensions, and tracking
- **Shipment Management**: Track shipments with carrier information and delivery status
- **Reporting**: Generate various reports for inventory, orders, and shipments

## Project Structure

```
/WMSApp
├── /app
│   ├── /src
│   │   ├── /main
│   │   │   ├── /java/com/mehmet/wmsapp
│   │   │   │   ├── MainActivity.kt
│   │   │   │   ├── /ui
│   │   │   │   │   ├── ProductFragment.kt
│   │   │   │   │   ├── RackFragment.kt
│   │   │   │   │   ├── OrderFragment.kt
│   │   │   │   │   ├── PackageFragment.kt
│   │   │   │   │   ├── ShipmentFragment.kt
│   │   │   │   │   └── ReportFragment.kt
│   │   │   │   ├── /data
│   │   │   │   │   ├── Product.kt
│   │   │   │   │   ├── Order.kt
│   │   │   │   │   ├── Rack.kt
│   │   │   │   │   └── Package.kt
│   │   │   │   ├── /network
│   │   │   │   │   ├── ApiService.kt
│   │   │   │   │   └── RetrofitClient.kt
│   │   │   │   ├── /utils
│   │   │   │   │   └── Constants.kt
│   │   │   ├── /res
│   │   │   │   ├── /layout
│   │   │   │   │   ├── fragment_product.xml
│   │   │   │   │   ├── fragment_order.xml
│   │   │   │   │   ├── fragment_rack.xml
│   │   │   │   │   ├── fragment_package.xml
│   │   │   │   │   ├── fragment_shipment.xml
│   │   │   │   │   ├── fragment_report.xml
│   │   │   │   │   └── activity_main.xml
│   │   │   │   ├── /values
│   │   │   │   │   ├── strings.xml
│   │   │   │   │   └── colors.xml
│   │   │   │   ├── /menu
│   │   │   │   │   └── bottom_navigation_menu.xml
│   │   │   └── AndroidManifest.xml
├── build.gradle
├── settings.gradle
└── README.md
```

## Technologies Used

- **Kotlin**: Primary programming language
- **Android SDK**: Android development framework
- **Retrofit**: REST API client for network requests
- **Material Design**: UI components
- **Fragment Navigation**: Bottom navigation for app sections

## Setup

1. Clone the repository
2. Open the project in Android Studio
3. Sync Gradle files
4. Update the API endpoint in `Constants.kt`
5. Run the application on an Android device or emulator

## Requirements

- Android Studio Arctic Fox or later
- Android SDK 21 or higher
- Gradle 7.4.0

## License

MIT License - see LICENSE file for details
