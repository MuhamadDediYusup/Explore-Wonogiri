package com.ysp.explorewonogiri

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class DetailArtikelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_artikel)

        val actionBar = supportActionBar
        actionBar!!.title = "Detail"
        actionBar.setDisplayHomeAsUpEnabled(true)

        val setJudul: TextView = findViewById(R.id.tv_judul_detail_artikel)
        val setContent: TextView = findViewById(R.id.tv_content_artikel)
        val setImg: ImageView = findViewById(R.id.iv_img_artikel)

        val aJudul = intent.getStringExtra(EKSTRA_JUDUL)
        val aContent = intent.getStringExtra(EKSTRA_CONTENT)
        val aImg = intent.getStringExtra(EKSTRA_IMG)

        setJudul.text = aJudul
        Picasso.get()
            .load(aImg)
            .into(setImg)
        setContent.text = aContent
    }

    companion object {
        const val EKSTRA_JUDUL = "ekstra_title"
        const val EKSTRA_CONTENT = "ekstra_content"
        const val EKSTRA_IMG = "ekstra_img"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}