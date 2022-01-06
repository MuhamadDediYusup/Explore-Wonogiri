package com.ysp.explorewonogiri

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class DetailDataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val actionBar = supportActionBar
        actionBar!!.title = "Detail"
        actionBar.setDisplayHomeAsUpEnabled(true)

        val setNama: TextView = findViewById(R.id.tv_nama_detail)
        val setDetail: TextView = findViewById(R.id.tv_desc_detail)
        val setAlamat: TextView = findViewById(R.id.tv_alamat_detail)
        val setImg: ImageView = findViewById(R.id.iv_img_detail)

        val aNama = intent.getStringExtra(EKSTRA_NAMA)
        val aDetail = intent.getStringExtra(EKSTRA_DETAIL)
        val aAlamat = intent.getStringExtra(EKSTRA_ALAMAT)
        val aImg = intent.getStringExtra(EKSTRA_IMG)
        val aMaps = intent.getStringExtra(EKSTRA_MAPS)
        val aStatus = intent.getStringExtra(EKSTRA_STATUS)

        val btn_maps = findViewById<Button>(R.id.btn_maps)
        btn_maps.setOnClickListener {
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(aMaps)
            )
            startActivity(intent)
        }

        setNama.text = aNama
        Picasso.get()
            .load(aImg)
            .into(setImg)
        setDetail.text = aDetail
        setAlamat.text = aAlamat
    }

    companion object {
        const val EKSTRA_NAMA = "ekstra_title"
        const val EKSTRA_DETAIL = "ekstra_write"
        const val EKSTRA_ALAMAT = "ekstra_desc"
        const val EKSTRA_IMG = "ekstra_img"
        const val EKSTRA_MAPS = "ekstra_maps"
        const val EKSTRA_STATUS = "ekstra_status"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}