package com.ysp.explorewonogiri.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.ysp.explorewonogiri.DetailDataActivity
import com.ysp.explorewonogiri.R
import com.ysp.explorewonogiri.model.Wisata

class AdapterWisata(val listWisata: ArrayList<Wisata>) : RecyclerView.Adapter<AdapterWisata.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: android.view.View? =
            LayoutInflater.from(parent.context).inflate(R.layout.item_listdata, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val wisata = listWisata[position]

        Picasso.get()
            .load(wisata.photo)
            .into(holder.imgPhoto)
        holder.tvName.text = wisata.nama
        holder.tvAlamat.text = wisata.alamat

        val mContext = holder.itemView.context

        holder.itemView.setOnClickListener {
            val moveDetail = Intent(mContext, DetailDataActivity::class.java)
            moveDetail.putExtra(DetailDataActivity.EKSTRA_NAMA, wisata.nama)
            moveDetail.putExtra(DetailDataActivity.EKSTRA_DETAIL, wisata.detail)
            moveDetail.putExtra(DetailDataActivity.EKSTRA_ALAMAT, wisata.alamat)
            moveDetail.putExtra(DetailDataActivity.EKSTRA_MAPS, wisata.maps)
            moveDetail.putExtra(DetailDataActivity.EKSTRA_IMG, wisata.photo)
            mContext.startActivity(moveDetail)
        }
    }

    override fun getItemCount(): Int {
        return listWisata.size
    }

    inner class ListViewHolder(itemView: android.view.View?) : RecyclerView.ViewHolder(itemView!!) {
        var tvName = itemView!!.findViewById<TextView>(R.id.tv_item_name)
        var tvAlamat = itemView!!.findViewById<TextView>(R.id.tv_alamat)
        var imgPhoto = itemView!!.findViewById<ImageView>(R.id.img_item_photo2)
    }
}