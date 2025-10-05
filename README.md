# WMS-Android

Android-based Warehouse Management System (WMS) for inventory and order management.

## Özellikler

### Ürün Yönetimi
- Ürün ekleme ve düzenleme
- SKU bazlı ürün takibi
- Raf kodu ve slot yönetimi
- Paket türü seçimi (Küçük, Orta, Büyük)
- Hediye paket seçeneği

### Sipariş Yönetimi
- Sipariş oluşturma ve takibi
- Sipariş durumu yönetimi (Pending, Packed, Shipped)
- Müşteri bilgileri
- İade yönetimi
- Sipariş notları

## Proje Yapısı

```
wms-Android/
├── app/
│   ├── build.gradle
│   ├── src/
│   │   └── main/
│   │       ├── java/com/mehmet/wmsapp/
│   │       │   ├── MainActivity.kt
│   │       │   ├── data/
│   │       │   │   ├── Product.kt
│   │       │   │   └── Order.kt
│   │       │   └── ui/
│   │       │       ├── ProductFragment.kt
│   │       │       └── OrderFragment.kt
│   │       ├── res/
│   │       │   ├── layout/
│   │       │   │   ├── activity_main.xml
│   │       │   │   ├── fragment_product.xml
│   │       │   │   └── fragment_order.xml
│   │       │   ├── menu/
│   │       │   │   └── bottom_nav_menu.xml
│   │       │   └── values/
│   │       │       ├── strings.xml
│   │       │       ├── colors.xml
│   │       │       └── themes.xml
│   │       └── AndroidManifest.xml
├── build.gradle
└── settings.gradle
```

## Teknolojiler

- **Kotlin** - Ana programlama dili
- **Android SDK** - Minimum SDK 24 (Android 7.0)
- **Material Design** - Modern UI bileşenleri
- **AndroidX** - Güncel Android kütüphaneleri
- **Navigation Component** - Fragment arası geçişler

## Kurulum

1. Android Studio'yu açın
2. "Open an Existing Project" seçeneğini seçin
3. Proje dizinini seçin
4. Gradle senkronizasyonunun tamamlanmasını bekleyin
5. Uygulamayı çalıştırın

## Gereksinimler

- Android Studio Arctic Fox veya üzeri
- JDK 8 veya üzeri
- Android SDK 24 veya üzeri
- Gradle 8.0 veya üzeri

## Kullanım

### Ürün Ekleme
1. Ana ekranda "Ürünler" sekmesine gidin
2. Gerekli alanları doldurun:
   - SKU (Stok Kodu)
   - Ürün Adı
   - Miktar
   - Raf Kodu
   - Raf Slotu
   - Paket Türü
3. İsteğe bağlı olarak "Hediye" seçeneğini işaretleyin
4. "Ürün Ekle" butonuna tıklayın

### Sipariş Oluşturma
1. "Siparişler" sekmesine gidin
2. Sipariş bilgilerini girin:
   - Sipariş ID
   - Müşteri Adı
   - Sipariş Tarihi (YYYY-MM-DD formatında)
   - Sipariş Durumu
   - Notlar (opsiyonel)
3. İade siparişi ise "İade" kutucuğunu işaretleyin
4. "Sipariş Oluştur" butonuna tıklayın

## Geliştirme

### Data Sınıfları

#### Product
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

#### Order
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

## Doğrulama Kuralları

### Ürün Doğrulama
- SKU boş olamaz
- Ürün adı boş olamaz
- Miktar 0'dan büyük olmalıdır
- Raf kodu boş olamaz
- Raf slotu 0'dan büyük olmalıdır

### Sipariş Doğrulama
- Sipariş ID boş olamaz
- Müşteri adı boş olamaz
- Tarih YYYY-MM-DD formatında olmalıdır

## Gelecek Özellikler

- [ ] Firebase entegrasyonu
- [ ] Ürün listesi görüntüleme
- [ ] Sipariş listesi görüntüleme
- [ ] Ürün arama ve filtreleme
- [ ] QR kod okuma
- [ ] Barkod tarama
- [ ] Stok yönetimi
- [ ] Raporlama
- [ ] Kullanıcı yönetimi

## Lisans

MIT License - Detaylar için [LICENSE](LICENSE) dosyasına bakınız.

## Katkıda Bulunanlar

- Mehmet Yıldırım (@mehmety1901)
