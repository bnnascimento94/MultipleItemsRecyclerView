package com.vullpes.financedashboard.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.majorik.sparklinelibrary.SparkLineLayout
import com.vullpes.financedashboard.R
import com.vullpes.financedashboard.domain.Domain
import java.text.DecimalFormat

class StockAdapter(private val dataList: List<Domain>) : RecyclerView.Adapter<StockAdapter.ViewHolder>() {



    private var formatter:DecimalFormat = DecimalFormat("###,###,###,###.##")



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflate: View = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_stock,parent,false)
        return ViewHolder(inflate)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nameTxt.text = dataList[position].name
        holder.priceTxt.text = "$${formatter.format(dataList[position].price)}"
        holder.changePercentText.text = dataList[position].changePercent.toString() + "%"
        holder.lineChart.setData(dataList[position].lineData)




        if(position == 0){
            holder.mainLayout.setBackgroundResource(R.drawable.purple_bg)
            holder.nameTxt.setTextColor(holder.itemView.context.resources.getColor(R.color.white))
            holder.priceTxt.setTextColor(holder.itemView.context.resources.getColor(R.color.white))
            holder.changePercentText.setTextColor(holder.itemView.context.resources.getColor(R.color.white))
        }

        var pickName = ""
        when(dataList[position].name){
            "NASDAQ100"->{
                pickName = "stock_1"
            }
            "S&P 500"->{
                pickName = "stock_2"
            }
            "Dow Jones"->{
                pickName = "stock_3"
            }
        }

        val drawableResourceId = holder.itemView.context.resources.getIdentifier(
            pickName,"drawable",holder.itemView.context.packageName
        )

        Glide.with(holder.logo.context).load(drawableResourceId).into(holder.logo)


    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTxt: TextView = itemView.findViewById(R.id.cryptoNameTest)
        val priceTxt: TextView = itemView.findViewById(R.id.cryptpPriceTxt)
        val changePercentText: TextView = itemView.findViewById(R.id.changePercentText)
        val logo: ImageView = itemView.findViewById(R.id.logoImg)
        val lineChart: SparkLineLayout = itemView.findViewById(R.id.sparkLine)
        val mainLayout: ConstraintLayout = itemView.findViewById(R.id.mainLayout)

    }

}