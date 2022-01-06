package com.ysp.explorewonogiri.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.ysp.explorewonogiri.DetailDataActivity
import com.ysp.explorewonogiri.DetailKulinerActivity
import com.ysp.explorewonogiri.R
import com.ysp.explorewonogiri.model.Kuliner

class AdapterKuliner (val listKuliner: ArrayList<Kuliner>) : RecyclerView.Adapter<AdapterKuliner.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: android.view.View? = LayoutInflater.from(parent.context).inflate(R.layout.item_listdata, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val kuliner = listKuliner[position]

        Picasso.get()
            .load(kuliner.photo)
            .into(holder.imgPhoto)
        holder.tvName.text = kuliner.nama
        holder.tvDetail.text = kuliner.detail

        val mContext = holder.itemView.context

        holder.itemView.setOnClickListener {
            val moveDetail = Intent(mContext, DetailKulinerActivity::class.java)
            moveDetail.putExtra(DetailKulinerActivity.EKSTRA_NAMA, kuliner.nama)
            moveDetail.putExtra(DetailKulinerActivity.EKSTRA_DETAIL, kuliner.detail)
            moveDetail.putExtra(DetailKulinerActivity.EKSTRA_IMG, kuliner.photo)
            mContext.startActivity(moveDetail)
        }
    }

    override fun getItemCount(): Int {
        return listKuliner.size
    }

    inner class ListViewHolder(itemView: android.view.View?) : RecyclerView.ViewHolder(itemView!!) {
        var tvName = itemView!!.findViewById<TextView>(R.id.tv_item_name)
        var tvDetail = itemView!!.findViewById<TextView>(R.id.tv_alamat)
        var imgPhoto = itemView!!.findViewById<ImageView>(R.id.img_item_photo2)
    }
}