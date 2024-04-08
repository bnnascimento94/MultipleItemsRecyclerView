package com.vullpes.projectmanager.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vullpes.projectmanager.R

class ArchiveAdapter(private val archives:List<String>): RecyclerView.Adapter<ArchiveAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_archive,parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return archives.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = archives[position]
        holder.archive.text = item


    }

    class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
        val archive: TextView = itemView.findViewById(R.id.titleTxt)
    }
}