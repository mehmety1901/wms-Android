package com.mehmet.wmsapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mehmet.wmsapp.R
import com.mehmet.wmsapp.data.Order

class OrderAdapter(private var orders: List<Order>) : 
    RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {

    inner class OrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvOrderId: TextView = itemView.findViewById(R.id.tvOrderId)
        private val tvCustomer: TextView = itemView.findViewById(R.id.tvCustomer)
        private val tvDate: TextView = itemView.findViewById(R.id.tvDate)
        private val tvStatus: TextView = itemView.findViewById(R.id.tvStatus)
        private val tvItemCount: TextView = itemView.findViewById(R.id.tvItemCount)

        fun bind(order: Order) {
            tvOrderId.text = "Sipariş: ${order.orderId}"
            tvCustomer.text = order.customerName
            tvDate.text = order.orderDate
            tvStatus.text = "Durum: ${order.status}${if (order.isReturn) " (İade)" else ""}"
            tvItemCount.text = "Ürün Sayısı: ${order.items.size}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_order, parent, false)
        return OrderViewHolder(view)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        holder.bind(orders[position])
    }

    override fun getItemCount() = orders.size

    fun updateOrders(newOrders: List<Order>) {
        orders = newOrders
        notifyDataSetChanged()
    }
}
