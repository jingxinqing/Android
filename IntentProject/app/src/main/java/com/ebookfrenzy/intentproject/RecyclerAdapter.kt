package com.ebookfrenzy.intentproject

import android.content.Intent
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.intentproject.R
import kotlin.random.Random
import com.google.android.material.snackbar.Snackbar


class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        val intent: Intent? = null

        init {
            itemImage = itemView.findViewById(R.id.itemImage)
            itemTitle = itemView.findViewById(R.id.itemTitle)
            itemDetail = itemView.findViewById(R.id.itemDetail)

            //pass position

            itemView.setOnClickListener { v : View ->
                val intent = Intent(v.context, ZoomActivity::class.java)
                val position = getAdapterPosition()
                intent.putExtra("position", position)
                v.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    var d = IntentData()
    //val num: Int = d.titles.size
    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {

        viewHolder.itemTitle.text = d.titles[MainViewModel.arr[i][0]]

        viewHolder.itemDetail.text = d.details[MainViewModel.arr[i][1]]
        viewHolder.itemImage.setImageResource(d.images[MainViewModel.arr[i][2]])


    }

    override fun getItemCount(): Int {
        return d.titles.size
    }
}