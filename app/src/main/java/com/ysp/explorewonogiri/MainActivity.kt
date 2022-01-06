package com.ysp.explorewonogiri

import android.app.Activity
import android.content.ClipData
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.sax.StartElementListener
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ysp.explorewonogiri.model.Explore

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //set Transparent Statusbar
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true)
        }
        if (Build.VERSION.SDK_INT >= 19) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            }
        }
        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false)
            window.statusBarColor = Color.TRANSPARENT
        }

        var btn_wisata = findViewById<Button>(R.id.btn_wisata)
        btn_wisata.setOnClickListener {
            startActivity(Intent(this, WisataActivity::class.java))
        }

        var btn_kuliner = findViewById<Button>(R.id.btn_kuliner)
        btn_kuliner.setOnClickListener { startActivity(Intent(this, KulinerActivity::class.java)) }

        var btn_hotel = findViewById<Button>(R.id.btn_hotel)
        btn_hotel.setOnClickListener { startActivity(Intent(this, HotelActivity::class.java)) }

        var btn_explore = findViewById<Button>(R.id.btn_eksplore)
        btn_explore.setOnClickListener { startActivity(Intent(this, ExploreActivity::class.java)) }

        var btn_explore_top = findViewById<Button>(R.id.btn_explore_top)
        btn_explore_top.setOnClickListener { startActivity(Intent(this, ExploreActivity::class.java)) }

        val btn_artikel = findViewById<TextView>(R.id.btn_artikel)
        btn_artikel.setOnClickListener { startActivity(Intent(this, ArtikelActivity::class.java)) }

//        //navbar
//        val itemId = findViewById<BottomNavigationItemView>(R.id.nb_home)
//        itemId.setOnClickListener { startActivity(Intent(this, MainActivity::class.java)) }
//
//        val nb_explore = findViewById<BottomNavigationItemView>(R.id.nb_explore)
//        nb_explore.setOnClickListener { startActivity(Intent(this, ExploreActivity::class.java)) }
//
//        val nb_artikel = findViewById<BottomNavigationItemView>(R.id.nb_artikel)
//        nb_artikel.setOnClickListener { startActivity(Intent(this, ArtikelActivity::class.java)) }
//
//        val nb_profil = findViewById<BottomNavigationItemView>(R.id.nb_profil)
//        nb_profil.setOnClickListener { startActivity(Intent(this, Profile_Activity::class.java)) }
        var bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemReselectedListener { item ->
            when(item.itemId) {
                R.id.nb_home -> {
                    startActivity(Intent(this, MainActivity::class.java))
                }
                R.id.nb_artikel -> {
                    startActivity(Intent(this, ArtikelActivity::class.java))
                }
                R.id.nb_explore -> {
                    startActivity(Intent(this, ExploreActivity::class.java))
                }
                R.id.nb_profil -> {
                    startActivity(Intent(this, Profile_Activity::class.java))
                }
            }
        }

    }

    companion object {
        fun setWindowFlag(activity: Activity, bits: Int, on: Boolean) {
            val window = activity.window
            val layoutParams = window.attributes
            if (on) {
                layoutParams.flags = layoutParams.flags or bits
            } else {
                layoutParams.flags = layoutParams.flags and bits.inv()
            }
            window.attributes = layoutParams
        }
    }

}