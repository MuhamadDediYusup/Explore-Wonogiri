package com.ysp.explorewonogiri

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class Profile_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        var img = findViewById<CircleImageView>(R.id.my_photo)
        Picasso.get()
            .load("https://avatars.githubusercontent.com/u/36018809?v=4")
            .into(img)

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
}