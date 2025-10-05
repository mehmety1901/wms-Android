package com.mehmet.wmsapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.mehmet.wmsapp.R

class ShipmentFragment : Fragment() {

    private lateinit var etShipmentId: EditText
    private lateinit var etOrderId: EditText
    private lateinit var etCarrier: EditText
    private lateinit var etTrackingNumber: EditText
    private lateinit var etShipmentDate: EditText
    private lateinit var spinnerShipmentStatus: Spinner
    private lateinit var btnCreateShipment: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_shipment, container, false)

        etShipmentId = view.findViewById(R.id.etShipmentId)
        etOrderId = view.findViewById(R.id.etOrderId)
        etCarrier = view.findViewById(R.id.etCarrier)
        etTrackingNumber = view.findViewById(R.id.etTrackingNumber)
        etShipmentDate = view.findViewById(R.id.etShipmentDate)
        spinnerShipmentStatus = view.findViewById(R.id.spinnerShipmentStatus)
        btnCreateShipment = view.findViewById(R.id.btnCreateShipment)

        // Spinner için gönderi durumları
        val statusOptions = arrayOf("Pending", "In Transit", "Delivered", "Returned")
        spinnerShipmentStatus.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, statusOptions)

        btnCreateShipment.setOnClickListener {
            val shipmentInfo = """
                Gönderi ID: ${etShipmentId.text}
                Sipariş ID: ${etOrderId.text}
                Kargo Şirketi: ${etCarrier.text}
                Takip No: ${etTrackingNumber.text}
                Gönderi Tarihi: ${etShipmentDate.text}
                Durum: ${spinnerShipmentStatus.selectedItem}
            """.trimIndent()
            Toast.makeText(requireContext(), "Gönderi oluşturuldu:\n$shipmentInfo", Toast.LENGTH_LONG).show()
        }

        return view
    }
}
