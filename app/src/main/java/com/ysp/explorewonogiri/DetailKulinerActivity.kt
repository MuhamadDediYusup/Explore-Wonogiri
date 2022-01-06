package com.ysp.explorewonogiri

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class DetailKulinerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_artikel)

        val setNama: TextView = findViewById(R.id.tv_judul_detail_artikel)
        val setDetail: TextView = findViewById(R.id.tv_content_artikel)
        val setImg: ImageView = findViewById(R.id.iv_img_artikel)

        val aNama = intent.getStringExtra(EKSTRA_NAMA)
        val aDetail = intent.getStringExtra(EKSTRA_DETAIL)
        val aImg = intent.getStringExtra(EKSTRA_IMG)

        val actionBar = supportActionBar
        actionBar!!.title = "Detail Kuliner"

        actionBar.setDisplayHomeAsUpEnabled(true)

        setNama.text = aNama
        Picasso.get()
            .load(aImg)
            .into(setImg)
        setDetail.text = aDetail

    }

    companion object {
        const val EKSTRA_NAMA = "ekstra_title"
        const val EKSTRA_DETAIL = "ekstra_write"
        const val EKSTRA_IMG = "ekstra_img"

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}