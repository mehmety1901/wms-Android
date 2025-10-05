package com.mehmet.wmsapp.network

import com.mehmet.wmsapp.data.*
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    
    @GET("products")
    fun getProducts(): Call<List<Product>>
    
    @POST("products")
    fun addProduct(@Body product: Product): Call<Product>
    
    @GET("orders")
    fun getOrders(): Call<List<Order>>
    
    @POST("orders")
    fun createOrder(@Body order: Order): Call<Order>
    
    @GET("racks")
    fun getRacks(): Call<List<Rack>>
    
    @POST("racks")
    fun addRack(@Body rack: Rack): Call<Rack>
    
    @GET("packages")
    fun getPackages(): Call<List<Package>>
    
    @POST("packages")
    fun createPackage(@Body pkg: Package): Call<Package>
}
