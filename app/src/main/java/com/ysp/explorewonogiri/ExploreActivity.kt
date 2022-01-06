package com.ysp.explorewonogiri

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.ysp.explorewonogiri.adapter.AdapterExplore
import com.ysp.explorewonogiri.model.Explore

class ExploreActivity : AppCompatActivity() {

    var db = Firebase.firestore
    private lateinit var rvExplore: RecyclerView

    @SuppressLint("WrongViewCast", "ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explore)

        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar()?.setDisplayShowHomeEnabled(true);
        supportActionBar?.setTitle("Explore")

        rvExplore = findViewById(R.id.rv_explore)
        rvExplore.setHasFixedSize(true)

        db = Firebase.firestore
        getData()

    }

    private fun getData() {
        db.collection("explore_wisata")
            .get()
            .addOnSuccessListener {
                var listExplore:ArrayList<Explore> = ArrayList()
                listExplore.clear()

                for (document in it) {
                    listExplore.add((Explore (
                        document.data.get("nama") as String,
                        document.data.get("image") as String,
                        document.data.get("alamat") as String,
                        document.data.get("maps") as String
                    )))
                }
                var exploreAdapter = AdapterExplore(listExplore = listExplore)
                rvExplore.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = exploreAdapter
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