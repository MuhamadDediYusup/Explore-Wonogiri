package com.ysp.explorewonogiri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.ysp.explorewonogiri.adapter.AdapterWisata
import com.ysp.explorewonogiri.model.Wisata
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout


class WisataActivity : AppCompatActivity() {

    var db = Firebase.firestore
    private lateinit var rvWisata: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listdata)

        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar()?.setDisplayShowHomeEnabled(true);
        supportActionBar?.setTitle("Explore Wisata")


        rvWisata = findViewById(R.id.rvWisata)
        rvWisata.setHasFixedSize(true)

        db = Firebase.firestore
        getData()

        val swipeContainer = findViewById<SwipeRefreshLayout>(R.id.swipeContainer)
        swipeContainer.setOnRefreshListener {
            rvWisata.clearOnScrollListeners()
            getData()
        }

    }

    private fun getData() {
        db.collection("wisata")
            .get()
            .addOnSuccessListener {
                var listWisata:ArrayList<Wisata> = ArrayList()
                listWisata.clear()

                for (document in it) {
                    listWisata.add((Wisata (
                        document.data.get("nama") as String,
                        document.data.get("alamat") as String,
                        document.data.get("image") as String,
                        document.data.get("detail") as String,
                        document.data.get("maps") as String
                        )))
                }
                var wisataAdapter = AdapterWisata(listWisata)
                rvWisata.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = wisataAdapter
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