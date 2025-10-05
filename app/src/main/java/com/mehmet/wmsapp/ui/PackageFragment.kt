package com.mehmet.wmsapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.mehmet.wmsapp.R
import com.mehmet.wmsapp.data.Package

class PackageFragment : Fragment() {

    private lateinit var etPackageId: EditText
    private lateinit var etOrderId: EditText
    private lateinit var spinnerPackageType: Spinner
    private lateinit var etWeight: EditText
    private lateinit var etDimensions: EditText
    private lateinit var etTrackingNumber: EditText
    private lateinit var btnCreatePackage: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_package, container, false)

        etPackageId = view.findViewById(R.id.etPackageId)
        etOrderId = view.findViewById(R.id.etOrderId)
        spinnerPackageType = view.findViewById(R.id.spinnerPackageType)
        etWeight = view.findViewById(R.id.etWeight)
        etDimensions = view.findViewById(R.id.etDimensions)
        etTrackingNumber = view.findViewById(R.id.etTrackingNumber)
        btnCreatePackage = view.findViewById(R.id.btnCreatePackage)

        // Spinner için örnek paket türleri
        val packageOptions = arrayOf("Küçük", "Orta", "Büyük")
        spinnerPackageType.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, packageOptions)

        btnCreatePackage.setOnClickListener {
            val pkg = Package(
                packageId = etPackageId.text.toString(),
                orderId = etOrderId.text.toString(),
                packageType = spinnerPackageType.selectedItem.toString(),
                weight = etWeight.text.toString().toDoubleOrNull() ?: 0.0,
                dimensions = etDimensions.text.toString(),
                status = "Created",
                trackingNumber = etTrackingNumber.text.toString()
            )
            Toast.makeText(requireContext(), "Paket oluşturuldu:\n$pkg", Toast.LENGTH_LONG).show()
        }

        return view
    }
}
