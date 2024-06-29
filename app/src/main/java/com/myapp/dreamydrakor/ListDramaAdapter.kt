package com.myapp.dreamydrakor

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListDramaAdapter(private val listDrama: ArrayList<Drama>) : RecyclerView.Adapter<ListDramaAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgDrama: ImageView = itemView.findViewById(R.id.drama_image)
        val tvTitle: TextView = itemView.findViewById(R.id.drama_name)
        val tvDescription: TextView = itemView.findViewById(R.id.drama_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_drakor, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listDrama.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (title, description, dramaImage) = listDrama[position]
        holder.imgDrama.setImageResource(dramaImage)
        holder.tvTitle.text = title
        holder.tvDescription.text = description

        holder.itemView.setOnClickListener {
            val intentDrama = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDrama.putExtra("key_drama", listDrama[position])
            holder.itemView.context.startActivity(intentDrama)
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Drama)
    }
}