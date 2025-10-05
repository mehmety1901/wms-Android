package com.mehmet.wmsapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mehmet.wmsapp.R
import com.mehmet.wmsapp.data.Product

class ProductAdapter(private var products: List<Product>) : 
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvSku: TextView = itemView.findViewById(R.id.tvSku)
        private val tvName: TextView = itemView.findViewById(R.id.tvName)
        private val tvQuantity: TextView = itemView.findViewById(R.id.tvQuantity)
        private val tvRack: TextView = itemView.findViewById(R.id.tvRack)
        private val tvPackage: TextView = itemView.findViewById(R.id.tvPackage)

        fun bind(product: Product) {
            tvSku.text = "SKU: ${product.sku}"
            tvName.text = product.name
            tvQuantity.text = "Miktar: ${product.quantity}"
            tvRack.text = "Raf: ${product.rackCode}-${product.rackSlot}"
            tvPackage.text = "${product.packageType}${if (product.isGift) " (Hediye)" else ""}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(products[position])
    }

    override fun getItemCount() = products.size

    fun updateProducts(newProducts: List<Product>) {
        products = newProducts
        notifyDataSetChanged()
    }
}
