package com.ysp.explorewonogiri

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.ysp.explorewonogiri.adapter.AdapterWisata
import com.ysp.explorewonogiri.model.Wisata

class HotelActivity : AppCompatActivity() {

    var db = Firebase.firestore
    private lateinit var rvWisata: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listdata)

        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar()?.setDisplayShowHomeEnabled(true);
        supportActionBar?.setTitle("Explore Penginapan")

        rvWisata = findViewById(R.id.rvWisata)
        rvWisata.setHasFixedSize(true)

        db = Firebase.firestore
        getData()

    }

    private fun getData() {
        db.collection("hotel")
            .get()
            .addOnSuccessListener {
                var listWisata:ArrayList<Wisata> = ArrayList()
                listWisata.clear()

                for (document in it) {
                    listWisata.add((Wisata (
                        document.data.get("nama") as String,
                        document.data.get("alamat") as String,
                        document.data.get("image") as String,
                    )))
                }
                var wisataAdapter = AdapterWisata(listWisata)
                rvWisata.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = wisataAdapter
                }
            }
            .addOnFailureListener {
                Log.v("Haduhhhhh", "Gagal Mengamil Data nih")
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