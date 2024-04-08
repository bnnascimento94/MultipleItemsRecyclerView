package com.vullpes.projectmanager.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vullpes.projectmanager.R
import com.vullpes.projectmanager.domain.OngoingDomain
import com.vullpes.projectmanager.domain.TeamDomain

class MyTeamAdapter(private val items: List<TeamDomain>): RecyclerView.Adapter<MyTeamAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_team,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.title.text = item.title
        holder.status.text = item.status



    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.titleTxt)
        val status: TextView = itemView.findViewById(R.id.statusTxt)




    }
}