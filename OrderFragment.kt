import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment

class OrderFragment : Fragment() {

    private lateinit var etOrderId: EditText
    private lateinit var etCustomerName: EditText
    private lateinit var etOrderDate: EditText
    private lateinit var spinnerStatus: Spinner
    private lateinit var etNotes: EditText
    private lateinit var cbIsReturn: CheckBox
    private lateinit var btnCreateOrder: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_order, container, false)

        // XML bileşenlerini bağla
        etOrderId = view.findViewById(R.id.etOrderId)
        etCustomerName = view.findViewById(R.id.etCustomerName)
        etOrderDate = view.findViewById(R.id.etOrderDate)
        spinnerStatus = view.findViewById(R.id.spinnerStatus)
        etNotes = view.findViewById(R.id.etNotes)
        cbIsReturn = view.findViewById(R.id.cbIsReturn)
        btnCreateOrder = view.findViewById(R.id.btnCreateOrder)

        // Spinner için örnek durumlar
        val statusOptions = arrayOf("Pending", "Packed", "Shipped")
        spinnerStatus.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, statusOptions)

        btnCreateOrder.setOnClickListener {
            val order = Order(
                orderId = etOrderId.text.toString(),
                customerName = etCustomerName.text.toString(),
                orderDate = etOrderDate.text.toString(),
                status = spinnerStatus.selectedItem.toString(),
                items = listOf(), // Ürünler daha sonra eklenecek
                isReturn = cbIsReturn.isChecked,
                notes = etNotes.text.toString()
            )
            Toast.makeText(requireContext(), "Sipariş oluşturuldu:\n$order", Toast.LENGTH_LONG).show()
        }

        return view
    }
}
