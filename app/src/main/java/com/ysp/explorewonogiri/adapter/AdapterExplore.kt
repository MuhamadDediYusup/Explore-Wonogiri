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
import com.ysp.explorewonogiri.model.Explore

class AdapterExplore(val listExplore: ArrayList<Explore>) : RecyclerView.Adapter<AdapterExplore.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: android.view.View? = LayoutInflater.from(parent.context).inflate(R.layout.item_explore, parent, false)
        return ListViewHolder(view)

    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val explore = listExplore[position]

        Picasso.get()
            .load(explore.photo)
            .into(holder.imgPhoto)
        holder.tvName.text = explore.nama
        holder.tvAlamat.text = explore.alamat

        val mContext = holder.itemView.context

        holder.itemView.setOnClickListener {
            val moveDetail = Intent(mContext, DetailDataActivity::class.java)
            moveDetail.putExtra(DetailDataActivity.EKSTRA_NAMA, explore.nama)
            moveDetail.putExtra(DetailDataActivity.EKSTRA_ALAMAT, explore.alamat)
            moveDetail.putExtra(DetailDataActivity.EKSTRA_MAPS, explore.maps)
            moveDetail.putExtra(DetailDataActivity.EKSTRA_IMG, explore.photo)
            mContext.startActivity(moveDetail)
        }
    }

    override fun getItemCount(): Int {
        return listExplore.size
    }

    inner class ListViewHolder(itemView: android.view.View?) : RecyclerView.ViewHolder(itemView!!) {
        var tvName = itemView!!.findViewById<TextView>(R.id.place_name)
        var imgPhoto = itemView!!.findViewById<ImageView>(R.id.img_explore)
        var tvAlamat = itemView!!.findViewById<TextView>(R.id.place_address)
    }
}