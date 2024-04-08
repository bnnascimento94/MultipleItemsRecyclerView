package com.vullpes.projectmanager.adapter

import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vullpes.projectmanager.R
import com.vullpes.projectmanager.domain.OngoingDomain

class OngoingAdapter(private val items: List<OngoingDomain>): RecyclerView.Adapter<OngoingAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_ongoing,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.title.text = item.title
        holder.data.text = item.data
        holder.progressBarPercent.text = "${item.progressPercent}%"

        holder.progressBar.setProgress(item.progressPercent,true)

        val drawableResourceId = holder.itemView.context.resources.getIdentifier(
            item.picPath,"drawable",holder.itemView.context.packageName
        )

        Glide.with(holder.itemView.context).load(drawableResourceId).into(holder.pic)

        with(holder){
            if(position ==0){
                layout.setBackgroundResource(R.drawable.dark_bg)
                setTextColors(R.color.white)
            }else{
                layout.setBackgroundResource(R.drawable.light_purple_background)
                setTextColors(R.color.dark_purple)
            }
        }

    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.titleTxt)
        val data: TextView = itemView.findViewById(R.id.dateTxt)
        val progressBarPercent: TextView = itemView.findViewById(R.id.percentTxt)
        val progressTxt: TextView = itemView.findViewById(R.id.progressTxt)
        val progressBar: ProgressBar = itemView.findViewById(R.id.progressBar)
        val pic: ImageView = itemView.findViewById(R.id.pic)
        val layout: ConstraintLayout = itemView.findViewById(R.id.layout)

        fun setTextColors(colorRes: Int){
            title.setTextColor(itemView.context.getColor(colorRes))
            data.setTextColor(itemView.context.getColor(colorRes))
            progressTxt.setTextColor(itemView.context.getColor(colorRes))
            progressBarPercent.setTextColor(itemView.context.getColor(colorRes))
            pic.setColorFilter(ContextCompat.getColor(itemView.context, colorRes), PorterDuff.Mode.SRC_IN)
            progressBar.progressTintList = ColorStateList.valueOf(ContextCompat.getColor(itemView.context, colorRes))
        }


    }
}