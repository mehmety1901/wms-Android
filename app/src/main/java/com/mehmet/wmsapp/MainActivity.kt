package com.mehmet.wmsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mehmet.wmsapp.ui.OrderFragment
import com.mehmet.wmsapp.ui.ProductFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Varsayılan olarak ProductFragment'i göster
        if (savedInstanceState == null) {
            loadFragment(ProductFragment())
        }

        // Bottom Navigation ayarla
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_products -> {
                    loadFragment(ProductFragment())
                    true
                }
                R.id.nav_orders -> {
                    loadFragment(OrderFragment())
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
