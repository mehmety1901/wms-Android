package com.mehmet.wmsapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mehmet.wmsapp.R
import com.mehmet.wmsapp.data.DataManager

class ProductListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ProductAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_product_list, container, false)

        recyclerView = view.findViewById(R.id.recyclerViewProducts)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        adapter = ProductAdapter(DataManager.getProducts())
        recyclerView.adapter = adapter

        return view
    }

    override fun onResume() {
        super.onResume()
        // Her görüntülendiğinde listeyi güncelle
        adapter.updateProducts(DataManager.getProducts())
    }
}
