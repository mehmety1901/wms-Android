package com.mehmet.wmsapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.mehmet.wmsapp.R
import com.mehmet.wmsapp.data.Product

class ProductFragment : Fragment() {

    private lateinit var etSku: EditText
    private lateinit var etName: EditText
    private lateinit var etQuantity: EditText
    private lateinit var etRackCode: EditText
    private lateinit var etRackSlot: EditText
    private lateinit var spinnerPackage: Spinner
    private lateinit var cbGift: CheckBox
    private lateinit var btnAddProduct: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_product, container, false)

        // XML bileşenlerini bağla
        etSku = view.findViewById(R.id.etSku)
        etName = view.findViewById(R.id.etName)
        etQuantity = view.findViewById(R.id.etQuantity)
        etRackCode = view.findViewById(R.id.etRackCode)
        etRackSlot = view.findViewById(R.id.etRackSlot)
        spinnerPackage = view.findViewById(R.id.spinnerPackage)
        cbGift = view.findViewById(R.id.cbGift)
        btnAddProduct = view.findViewById(R.id.btnAddProduct)

        // Spinner için örnek paket türleri
        val packageOptions = arrayOf("Küçük", "Orta", "Büyük")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, packageOptions)
        spinnerPackage.adapter = adapter

        btnAddProduct.setOnClickListener {
            // Doğrulama
            if (!validateInputs()) {
                return@setOnClickListener
            }

            val product = Product(
                sku = etSku.text.toString(),
                name = etName.text.toString(),
                quantity = etQuantity.text.toString().toIntOrNull() ?: 0,
                rackCode = etRackCode.text.toString(),
                rackSlot = etRackSlot.text.toString().toIntOrNull() ?: 0,
                packageType = spinnerPackage.selectedItem.toString(),
                isGift = cbGift.isChecked
            )

            Toast.makeText(requireContext(), "Ürün eklendi:\n$product", Toast.LENGTH_LONG).show()

            // Alanları temizle
            clearInputs()

            // TODO: Firebase'e gönderme veya listeye ekleme işlemi burada yapılabilir
        }

        return view
    }

    private fun validateInputs(): Boolean {
        // SKU kontrolü
        if (etSku.text.toString().trim().isEmpty()) {
            etSku.error = "SKU gereklidir"
            return false
        }

        // Ürün adı kontrolü
        if (etName.text.toString().trim().isEmpty()) {
            etName.error = "Ürün adı gereklidir"
            return false
        }

        // Miktar kontrolü
        val quantity = etQuantity.text.toString().toIntOrNull()
        if (quantity == null || quantity <= 0) {
            etQuantity.error = "Geçerli bir miktar giriniz"
            return false
        }

        // Raf kodu kontrolü
        if (etRackCode.text.toString().trim().isEmpty()) {
            etRackCode.error = "Raf kodu gereklidir"
            return false
        }

        // Raf slotu kontrolü
        val rackSlot = etRackSlot.text.toString().toIntOrNull()
        if (rackSlot == null || rackSlot <= 0) {
            etRackSlot.error = "Geçerli bir raf slotu giriniz"
            return false
        }

        return true
    }

    private fun clearInputs() {
        etSku.text?.clear()
        etName.text?.clear()
        etQuantity.text?.clear()
        etRackCode.text?.clear()
        etRackSlot.text?.clear()
        spinnerPackage.setSelection(0)
        cbGift.isChecked = false
    }
}
