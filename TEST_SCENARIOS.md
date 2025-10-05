# WMS Android - Test Senaryoları

## Manuel Test Senaryoları

### 1. Ürün Ekleme Testi

#### Pozitif Test
1. Uygulamayı başlatın
2. "Ürünler" sekmesinde olduğunuzdan emin olun
3. "Ekle" tabına tıklayın
4. Aşağıdaki bilgileri girin:
   - SKU: TEST001
   - Ürün Adı: Test Ürünü
   - Miktar: 10
   - Raf Kodu: RACK1
   - Raf Slotu: 5
   - Paket Türü: Orta
   - Hediye: İşaretlenmiş
5. "Ürün Ekle" butonuna tıklayın
6. **Beklenen Sonuç**: "Ürün eklendi" mesajı görünmeli

#### Negatif Test (Boş Alanlar)
1. "Ekle" tabındayken boş form ile "Ürün Ekle"ye tıklayın
2. **Beklenen Sonuç**: SKU alanında "SKU gereklidir" hatası görünmeli
3. Sadece SKU doldurup tekrar deneyin
4. **Beklenen Sonuç**: "Ürün adı gereklidir" hatası görünmeli

#### Negatif Test (Geçersiz Miktar)
1. Tüm alanları doldurun ama Miktar alanına "-5" veya "abc" girin
2. "Ürün Ekle"ye tıklayın
3. **Beklenen Sonuç**: "Geçerli bir miktar giriniz" hatası görünmeli

### 2. Ürün Listesi Testi

1. Önce en az 2 ürün ekleyin (yukarıdaki test)
2. "Liste" tabına tıklayın
3. **Beklenen Sonuç**: 
   - Eklediğiniz ürünler listede görünmeli
   - Her ürün kartında SKU, isim, miktar, raf ve paket bilgisi görünmeli
   - Örnek veriler de listede olmalı (PRD001, PRD002, PRD003)

### 3. Sipariş Oluşturma Testi

#### Pozitif Test
1. "Siparişler" sekmesine tıklayın
2. "Ekle" tabına tıklayın
3. Aşağıdaki bilgileri girin:
   - Sipariş ID: TEST001
   - Müşteri Adı: Test Müşteri
   - Sipariş Tarihi: 2025-01-20
   - Sipariş Durumu: Pending
   - Notlar: Test notu
   - İade: İşaretsiz
4. "Sipariş Oluştur" butonuna tıklayın
5. **Beklenen Sonuç**: "Sipariş oluşturuldu" mesajı görünmeli

#### Negatif Test (Tarih Formatı)
1. Tüm alanları doldurun ama Tarih alanına "20/01/2025" girin
2. "Sipariş Oluştur"a tıklayın
3. **Beklenen Sonuç**: "Tarih formatı YYYY-MM-DD olmalıdır" hatası görünmeli

### 4. Sipariş Listesi Testi

1. Önce en az 2 sipariş oluşturun (yukarıdaki test)
2. "Liste" tabına tıklayın
3. **Beklenen Sonuç**: 
   - Oluşturduğunuz siparişler listede görünmeli
   - Her sipariş kartında ID, müşteri adı, tarih, durum ve ürün sayısı görünmeli
   - Örnek veriler de listede olmalı (ORD001, ORD002)

### 5. Navigasyon Testi

1. "Ürünler" sekmesinde "Ekle" tabına gidin
2. "Liste" tabına geçin
3. "Siparişler" sekmesine tıklayın
4. **Beklenen Sonuç**: Sipariş ekleme formu görünmeli (Ekle tab otomatik seçili)
5. "Liste" tabına tıklayın
6. **Beklenen Sonuç**: Sipariş listesi görünmeli
7. "Ürünler" sekmesine dönün
8. **Beklenen Sonuç**: Son hangi tab seçiliyse o görünmeli

### 6. Veri Tutarlılığı Testi

1. Ürünler bölümünde yeni bir ürün ekleyin
2. Liste tabına geçin ve ürünü görün
3. Siparişler bölümüne gidin
4. Ürünler bölümüne geri dönün ve Liste tabına gidin
5. **Beklenen Sonuç**: Eklediğiniz ürün hala listede olmalı (veri kaybolmamalı)

### 7. Form Temizleme Testi

1. Ürün ekleme formunu doldurun
2. "Ürün Ekle"ye tıklayın
3. **Beklenen Sonuç**: Tüm form alanları temizlenmiş olmalı
4. Aynı testi sipariş formu için de yapın

## Otomatik Test İpuçları

Gelecekte eklenecek otomatik testler için:

### Unit Testler
- `DataManager` sınıfı için testler:
  - `addProduct()` metodu testi
  - `getProducts()` metodu testi
  - `addOrder()` metodu testi
  - `getOrders()` metodu testi
  - `initializeSampleData()` testi

### UI Testler (Espresso)
- Fragment navigasyon testleri
- Form validasyon testleri
- RecyclerView item görüntüleme testleri
- Tab geçiş testleri

### Integration Testler
- End-to-end ürün ekleme ve listede görme testi
- End-to-end sipariş oluşturma ve listede görme testi

## Test Sonuçları

### Tarih: [Test tarihi]
### Test Eden: [Test edenin adı]

| Test Senaryosu | Durum | Notlar |
|----------------|-------|--------|
| Ürün Ekleme - Pozitif | ☐ | |
| Ürün Ekleme - Boş Alanlar | ☐ | |
| Ürün Ekleme - Geçersiz Miktar | ☐ | |
| Ürün Listesi | ☐ | |
| Sipariş Oluşturma - Pozitif | ☐ | |
| Sipariş Oluşturma - Tarih Formatı | ☐ | |
| Sipariş Listesi | ☐ | |
| Navigasyon | ☐ | |
| Veri Tutarlılığı | ☐ | |
| Form Temizleme | ☐ | |

## Bilinen Sorunlar

(Bulunan sorunlar burada listelenecek)

## Yapılacaklar

- [ ] Otomatik unit testler ekle
- [ ] Espresso UI testleri ekle
- [ ] CI/CD pipeline kur
- [ ] Performance testleri ekle
