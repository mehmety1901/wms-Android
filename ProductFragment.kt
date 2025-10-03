import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment

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
        spinnerPackage.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, packageOptions)

        btnAddProduct.setOnClickListener {
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
        }

        return view
    }
}

