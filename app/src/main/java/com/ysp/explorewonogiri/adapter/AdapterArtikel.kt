package com.ysp.explorewonogiri.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.ysp.explorewonogiri.DetailArtikelActivity
import com.ysp.explorewonogiri.R
import com.ysp.explorewonogiri.model.Artikel

class AdapterArtikel (val listArtikel: ArrayList<Artikel>) : RecyclerView.Adapter<AdapterArtikel.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: android.view.View? = LayoutInflater.from(parent.context).inflate(R.layout.item_artikel, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val artikel = listArtikel[position]

        Picasso.get()
            .load(artikel.photo)
            .into(holder.ivPhoto)
        holder.tvArtikel.text = artikel.judul_artikel
        holder.tvContent.text = artikel.content

        val mContext = holder.itemView.context

        holder.itemView.setOnClickListener {
            val moveDetail = Intent(mContext, DetailArtikelActivity::class.java)
            moveDetail.putExtra(DetailArtikelActivity.EKSTRA_JUDUL, artikel.judul_artikel)
            moveDetail.putExtra(DetailArtikelActivity.EKSTRA_CONTENT, artikel.content)
            moveDetail.putExtra(DetailArtikelActivity.EKSTRA_IMG, artikel.photo)
            mContext.startActivity(moveDetail)
        }

    }

    override fun getItemCount(): Int {
        return listArtikel.size
    }

    inner class ListViewHolder(itemView: android.view.View?) : RecyclerView.ViewHolder(itemView!!) {
        var tvArtikel = itemView!!.findViewById<TextView>(R.id.tv_judulArtikel)
        var ivPhoto = itemView!!.findViewById<ImageView>(R.id.img_artikel)
        var tvContent = itemView!!.findViewById<TextView>(R.id.tv_content)
    }
}