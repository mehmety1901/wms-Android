package com.mehmet.wmsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mehmet.wmsapp.ui.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        
        // Load default fragment
        loadFragment(ProductFragment())

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_product -> {
                    loadFragment(ProductFragment())
                    true
                }
                R.id.nav_rack -> {
                    loadFragment(RackFragment())
                    true
                }
                R.id.nav_order -> {
                    loadFragment(OrderFragment())
                    true
                }
                R.id.nav_package -> {
                    loadFragment(PackageFragment())
                    true
                }
                R.id.nav_shipment -> {
                    loadFragment(ShipmentFragment())
                    true
                }
                R.id.nav_report -> {
                    loadFragment(ReportFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
