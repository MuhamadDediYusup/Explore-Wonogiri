package com.ysp.explorewonogiri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.ysp.explorewonogiri.adapter.AdapterKuliner
import com.ysp.explorewonogiri.adapter.AdapterWisata
import com.ysp.explorewonogiri.model.Kuliner

class KulinerActivity : AppCompatActivity() {

    var db = Firebase.firestore
    private lateinit var rvWisata: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listdata)

        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar()?.setDisplayShowHomeEnabled(true);
        supportActionBar?.setTitle("Explore Kuliner")

//        var btn_back = findViewById<ImageView>(R.id.btn_arrowBack)
//        var appbar_title = findViewById<TextView>(R.id.appbar_title)
//        appbar_title.setText("Explore Kuliner")
//
//        btn_back.setOnClickListener { startActivity(Intent(this, MainActivity::class.java)) }

        rvWisata = findViewById(R.id.rvWisata)
        rvWisata.setHasFixedSize(true)

        db = Firebase.firestore
        getData()


    }

    private fun getData() {
        db.collection("kuliner")
            .get()
            .addOnSuccessListener {
                var listKuliner:ArrayList<Kuliner> = ArrayList()
                listKuliner.clear()

                for (document in it) {
                    listKuliner.add((Kuliner (
                        document.data.get("nama") as String,
                        document.data.get("detail") as String,
                        document.data.get("image") as String
                    )))
                }
                var kulinerAdapter = AdapterKuliner(listKuliner)
                rvWisata.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = kulinerAdapter
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