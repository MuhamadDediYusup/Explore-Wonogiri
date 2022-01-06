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
import com.ysp.explorewonogiri.model.Hotel

class AdapterHotel (val listHotel: ArrayList<Hotel>) : RecyclerView.Adapter<AdapterHotel.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: android.view.View? = LayoutInflater.from(parent.context).inflate(R.layout.item_listdata, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val hotel = listHotel[position]

        Picasso.get()
            .load(hotel.photo)
            .into(holder.imgPhoto)
        holder.tvName.text = hotel.nama
        holder.tvAlamat.text = hotel.alamat

        val mContext = holder.itemView.context

        holder.itemView.setOnClickListener {
            val moveDetail = Intent(mContext, DetailDataActivity::class.java)
            moveDetail.putExtra(DetailDataActivity.EKSTRA_NAMA, hotel.nama)
            moveDetail.putExtra(DetailDataActivity.EKSTRA_ALAMAT, hotel.alamat)
            moveDetail.putExtra(DetailDataActivity.EKSTRA_IMG, hotel.photo)
            mContext.startActivity(moveDetail)
        }

    }

    override fun getItemCount(): Int {
        return listHotel.size
    }

    inner class ListViewHolder(itemView: android.view.View?) : RecyclerView.ViewHolder(itemView!!) {
        var tvName = itemView!!.findViewById<TextView>(R.id.tv_item_name)
        var tvAlamat = itemView!!.findViewById<TextView>(R.id.tv_alamat)
        var imgPhoto = itemView!!.findViewById<ImageView>(R.id.img_item_photo)
    }
}