package com.mehmet.wmsapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.mehmet.wmsapp.R

class ReportFragment : Fragment() {

    private lateinit var spinnerReportType: Spinner
    private lateinit var etStartDate: EditText
    private lateinit var etEndDate: EditText
    private lateinit var btnGenerateReport: Button
    private lateinit var tvReportResult: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_report, container, false)

        spinnerReportType = view.findViewById(R.id.spinnerReportType)
        etStartDate = view.findViewById(R.id.etStartDate)
        etEndDate = view.findViewById(R.id.etEndDate)
        btnGenerateReport = view.findViewById(R.id.btnGenerateReport)
        tvReportResult = view.findViewById(R.id.tvReportResult)

        // Spinner için rapor türleri
        val reportTypes = arrayOf("Stok Raporu", "Sipariş Raporu", "Raf Doluluk Raporu", "Gönderi Raporu")
        spinnerReportType.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, reportTypes)

        btnGenerateReport.setOnClickListener {
            val reportInfo = """
                Rapor Türü: ${spinnerReportType.selectedItem}
                Başlangıç Tarihi: ${etStartDate.text}
                Bitiş Tarihi: ${etEndDate.text}
                
                Rapor oluşturuluyor...
            """.trimIndent()
            tvReportResult.text = reportInfo
            Toast.makeText(requireContext(), "Rapor oluşturuldu", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}
