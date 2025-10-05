# WMS Android - Mimari Dokümantasyon

## Proje Mimarisi

### Genel Bakış

WMS Android uygulaması, basit ve temiz bir mimari ile organize edilmiştir. Uygulama 3 ana katmandan oluşur:

```
┌─────────────────────────────────────┐
│         Presentation Layer          │
│     (UI - Fragments & Activities)   │
└─────────────────────────────────────┘
                 ↓
┌─────────────────────────────────────┐
│         Business Logic Layer        │
│        (DataManager - Singleton)    │
└─────────────────────────────────────┘
                 ↓
┌─────────────────────────────────────┐
│           Data Layer                │
│      (Data Classes - Models)        │
└─────────────────────────────────────┘
```

## Katmanlar

### 1. Presentation Layer (UI Katmanı)

#### MainActivity
- Ana aktivite, fragment container'ı yönetir
- Bottom navigation ve tab layout'u kontrol eder
- Fragment geçişlerini yönetir

#### Fragments

**ProductFragment**
- Ürün ekleme formu
- Input validasyonu
- DataManager ile entegrasyon

**ProductListFragment**
- Ürünleri RecyclerView ile gösterir
- ProductAdapter kullanır

**OrderFragment**
- Sipariş oluşturma formu
- Input validasyonu
- Tarih formatı kontrolü

**OrderListFragment**
- Siparişleri RecyclerView ile gösterir
- OrderAdapter kullanır

#### Adapters

**ProductAdapter**
- Product listesini RecyclerView'e bağlar
- ViewHolder pattern kullanır

**OrderAdapter**
- Order listesini RecyclerView'e bağlar
- ViewHolder pattern kullanır

### 2. Business Logic Layer (İş Mantığı Katmanı)

**DataManager (Singleton)**
- Tüm ürün ve sipariş verilerini yönetir
- In-memory data storage
- CRUD operasyonları sağlar
- Örnek veri başlatma

```kotlin
object DataManager {
    fun addProduct(product: Product)
    fun getProducts(): List<Product>
    fun addOrder(order: Order)
    fun getOrders(): List<Order>
    fun initializeSampleData()
}
```

### 3. Data Layer (Veri Katmanı)

**Product (Data Class)**
```kotlin
data class Product(
    val sku: String,
    val name: String,
    val quantity: Int,
    val rackCode: String,
    val rackSlot: Int,
    val packageType: String,
    val isGift: Boolean
)
```

**Order (Data Class)**
```kotlin
data class Order(
    val orderId: String,
    val customerName: String,
    val orderDate: String,
    val status: String,
    val items: List<Product>,
    val isReturn: Boolean = false,
    val notes: String? = null
)
```

## Veri Akışı

### Ürün Ekleme Akışı
```
User Input → ProductFragment → Validation → DataManager.addProduct() → In-Memory List
```

### Ürün Listeleme Akışı
```
ProductListFragment → DataManager.getProducts() → ProductAdapter → RecyclerView → Display
```

### Sipariş Oluşturma Akışı
```
User Input → OrderFragment → Validation → DataManager.addOrder() → In-Memory List
```

### Sipariş Listeleme Akışı
```
OrderListFragment → DataManager.getOrders() → OrderAdapter → RecyclerView → Display
```

## Navigasyon Yapısı

```
MainActivity
├── Bottom Navigation
│   ├── Products (nav_products)
│   └── Orders (nav_orders)
└── Tab Layout
    ├── Add (Ekle) Tab
    │   ├── ProductFragment (when Products selected)
    │   └── OrderFragment (when Orders selected)
    └── List (Liste) Tab
        ├── ProductListFragment (when Products selected)
        └── OrderListFragment (when Orders selected)
```

## Paket Yapısı

```
com.mehmet.wmsapp
├── MainActivity.kt
├── data/
│   ├── Product.kt
│   ├── Order.kt
│   └── DataManager.kt
└── ui/
    ├── ProductFragment.kt
    ├── ProductListFragment.kt
    ├── ProductAdapter.kt
    ├── OrderFragment.kt
    ├── OrderListFragment.kt
    └── OrderAdapter.kt
```

## Layout Yapısı

```
res/
├── layout/
│   ├── activity_main.xml (TabLayout + BottomNavigation)
│   ├── fragment_product.xml (Add Product Form)
│   ├── fragment_product_list.xml (Product RecyclerView)
│   ├── fragment_order.xml (Add Order Form)
│   ├── fragment_order_list.xml (Order RecyclerView)
│   ├── item_product.xml (Product Card)
│   └── item_order.xml (Order Card)
├── menu/
│   └── bottom_nav_menu.xml
└── values/
    ├── strings.xml
    ├── colors.xml
    └── themes.xml
```

## Validation Kuralları

### ProductFragment Validasyonu
- SKU: Required, non-empty
- Name: Required, non-empty
- Quantity: Required, > 0, numeric
- RackCode: Required, non-empty
- RackSlot: Required, > 0, numeric

### OrderFragment Validasyonu
- OrderId: Required, non-empty
- CustomerName: Required, non-empty
- OrderDate: Required, format YYYY-MM-DD

## Gelecek Geliştirmeler

### Kısa Vadeli
1. **Persistent Storage**
   - Room Database entegrasyonu
   - SharedPreferences kullanımı

2. **Search & Filter**
   - Ürün arama
   - Sipariş filtreleme (durum, tarih)

3. **Edit & Delete**
   - Ürün düzenleme
   - Sipariş güncelleme

### Orta Vadeli
1. **Firebase Integration**
   - Realtime Database
   - Authentication
   - Cloud Storage

2. **Advanced Features**
   - Barcode scanning
   - QR code generation
   - Export to PDF/Excel

3. **Offline Support**
   - Offline-first architecture
   - Sync when online

### Uzun Vadeli
1. **Multi-user Support**
   - User roles (admin, warehouse worker)
   - Permissions

2. **Analytics**
   - Stock reports
   - Order statistics
   - Dashboard

3. **Integration**
   - External API integration
   - ERP system connection

## Teknoloji Stack

- **Language**: Kotlin
- **UI**: Material Design Components
- **Architecture**: Simple MVC (Model-View-Controller)
- **Data Storage**: In-Memory (for now)
- **Build System**: Gradle
- **Min SDK**: 24 (Android 7.0)
- **Target SDK**: 34 (Android 14)

## Bağımlılıklar

```gradle
// AndroidX
androidx.core:core-ktx:1.12.0
androidx.appcompat:appcompat:1.6.1
androidx.fragment:fragment-ktx:1.6.2

// Material Design
com.google.android.material:material:1.11.0

// Layout
androidx.constraintlayout:constraintlayout:2.1.4

// Navigation (optional for future)
androidx.navigation:navigation-fragment-ktx:2.7.6
androidx.navigation:navigation-ui-ktx:2.7.6
```
