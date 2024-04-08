package com.vullpes.financedashboard.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.majorik.sparklinelibrary.SparkLineLayout
import com.vullpes.financedashboard.R
import com.vullpes.financedashboard.domain.Domain
import java.text.DecimalFormat

class CriptoAdapter(private val dataList: List<Domain>) : RecyclerView.Adapter<CriptoAdapter.ViewHolder>() {



    private var formatter:DecimalFormat = DecimalFormat("###,###,###,###.##")



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflate: View = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_crypto,parent,false)
        return ViewHolder(inflate)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nameTxt.text = dataList[position].name
        holder.priceTxt.text = "$${formatter.format(dataList[position].price)}"
        holder.changePercentText.text = dataList[position].changePercent.toString() + "%"
        holder.propertySizeTxt.text = dataList[position].propertySize.toString() + dataList[position].symbol
        holder.propertyAmountTxt.text = "$"+dataList[position].propertyAmount
        holder.lineChart.setData(dataList[position].lineData)


        val drawableResourceId = holder.itemView.context.resources.getIdentifier(
            dataList[position].name,"drawable",holder.itemView.context.packageName
        )

        Glide.with(holder.logo.context).load(drawableResourceId).into(holder.logo)

        if(dataList[position].changePercent > 0){
            holder.changePercentText.setTextColor(Color.parseColor("#12c737"))
            holder.lineChart.sparkLineColor = Color.parseColor("#12c737")
        } else if( dataList[position].changePercent < 0 ){
            holder.changePercentText.setTextColor(Color.parseColor("#fc0000"))
            holder.lineChart.sparkLineColor = Color.parseColor("#fc0000")
        } else {
            holder.changePercentText.setTextColor(Color.parseColor("#ffffff"))
            holder.lineChart.sparkLineColor = Color.parseColor("#ffffff")
        }
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTxt: TextView = itemView.findViewById(R.id.cryptoNameTest)
        val priceTxt: TextView = itemView.findViewById(R.id.cryptpPriceTxt)
        val changePercentText: TextView = itemView.findViewById(R.id.changePercentText)
        val propertySizeTxt: TextView = itemView.findViewById(R.id.propertySizeText)
        val propertyAmountTxt: TextView = itemView.findViewById(R.id.propertyAmountTxt)
        val logo: ImageView = itemView.findViewById(R.id.logoImg)
        val lineChart: SparkLineLayout = itemView.findViewById(R.id.sparkLine)

    }

}