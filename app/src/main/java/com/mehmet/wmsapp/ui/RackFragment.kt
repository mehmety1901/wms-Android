package com.mehmet.wmsapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.mehmet.wmsapp.R
import com.mehmet.wmsapp.data.Rack
import com.mehmet.wmsapp.data.RackSlot

class RackFragment : Fragment() {

    private lateinit var etRackCode: EditText
    private lateinit var etLocation: EditText
    private lateinit var etCapacity: EditText
    private lateinit var etCurrentOccupancy: EditText
    private lateinit var btnAddRack: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_rack, container, false)

        etRackCode = view.findViewById(R.id.etRackCode)
        etLocation = view.findViewById(R.id.etLocation)
        etCapacity = view.findViewById(R.id.etCapacity)
        etCurrentOccupancy = view.findViewById(R.id.etCurrentOccupancy)
        btnAddRack = view.findViewById(R.id.btnAddRack)

        btnAddRack.setOnClickListener {
            val rack = Rack(
                rackCode = etRackCode.text.toString(),
                location = etLocation.text.toString(),
                capacity = etCapacity.text.toString().toIntOrNull() ?: 0,
                currentOccupancy = etCurrentOccupancy.text.toString().toIntOrNull() ?: 0,
                slots = emptyList()
            )
            Toast.makeText(requireContext(), "Raf eklendi:\n$rack", Toast.LENGTH_LONG).show()
        }

        return view
    }
}
