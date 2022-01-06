package com.ysp.explorewonogiri

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.ysp.explorewonogiri.adapter.AdapterArtikel
import com.ysp.explorewonogiri.model.Artikel
import com.ysp.explorewonogiri.model.Wisata

class ArtikelActivity : AppCompatActivity() {

    var db = Firebase.firestore
    private lateinit var rvArtikel: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artikel)

        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar()?.setDisplayShowHomeEnabled(true);
        supportActionBar?.setTitle("Artikel")


        rvArtikel = findViewById(R.id.rvArtikel)
        rvArtikel.setHasFixedSize(true)

        db = Firebase.firestore
        getData()

    }

    private fun getData() {
        db.collection("artikel")
            .get()
            .addOnSuccessListener {
                var listartikel:ArrayList<Artikel> = ArrayList()
                listartikel.clear()

                for (document in it) {
                    listartikel.add((Artikel (
                        document.data.get("judul") as String,
                        document.data.get("image") as String,
                        document.data.get("content") as String
                    )))
                }
                var artikelActivity = AdapterArtikel(listartikel)
                rvArtikel.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = artikelActivity
                }
            }
            .addOnFailureListener {
                Log.v("Bang Ganteng", "Gagal Mengamil Data")
            }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}