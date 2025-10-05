package com.mehmet.wmsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.mehmet.wmsapp.data.DataManager
import com.mehmet.wmsapp.ui.OrderFragment
import com.mehmet.wmsapp.ui.OrderListFragment
import com.mehmet.wmsapp.ui.ProductFragment
import com.mehmet.wmsapp.ui.ProductListFragment

class MainActivity : AppCompatActivity() {

    private var currentSection: String = "products"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Örnek verileri başlat
        DataManager.initializeSampleData()

        // Varsayılan olarak ProductFragment'i göster
        if (savedInstanceState == null) {
            loadFragment(ProductFragment())
        }

        // Tab Layout ayarla
        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                when (tab.position) {
                    0 -> {
                        // Ekle sekmesi
                        if (currentSection == "products") {
                            loadFragment(ProductFragment())
                        } else {
                            loadFragment(OrderFragment())
                        }
                    }
                    1 -> {
                        // Liste sekmesi
                        if (currentSection == "products") {
                            loadFragment(ProductListFragment())
                        } else {
                            loadFragment(OrderListFragment())
                        }
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

        // Bottom Navigation ayarla
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_products -> {
                    currentSection = "products"
                    tabLayout.getTabAt(0)?.select()
                    loadFragment(ProductFragment())
                    true
                }
                R.id.nav_orders -> {
                    currentSection = "orders"
                    tabLayout.getTabAt(0)?.select()
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
