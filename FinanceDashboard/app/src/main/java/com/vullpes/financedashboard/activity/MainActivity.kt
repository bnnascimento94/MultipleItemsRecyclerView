package com.vullpes.financedashboard.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.vullpes.financedashboard.adapter.CriptoAdapter
import com.vullpes.financedashboard.adapter.StockAdapter
import com.vullpes.financedashboard.databinding.ActivityMainBinding
import com.vullpes.financedashboard.domain.Domain

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val lineData: ArrayList<Int> = ArrayList()
    val lineData2: ArrayList<Int> = ArrayList()
    val lineData3: ArrayList<Int> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setData()

        recyclerViewCrypto()
        recyclerViewStock()
    }

    private fun recyclerViewCrypto() {
        binding.crypoView.layoutManager =  LinearLayoutManager(this, LinearLayoutManager.VERTICAL ,false)

        val domainArrayList: ArrayList<Domain> = ArrayList()
        domainArrayList.add(Domain("bitcoin", "BTX", 1234.12,2.13,lineData,1234.12,0.1234))
        domainArrayList.add(Domain("etherium", "ETH", 1234.12,-1.13,lineData2,6545.65,0.12345))
        domainArrayList.add(Domain("trox", "ROX", 6543.21,0.73,lineData3,31234.12,0.02154))


        binding.crypoView.adapter = CriptoAdapter(domainArrayList)

    }


    private fun recyclerViewStock() {
        binding.stockView.layoutManager =  LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL ,false)

        val domainArrayList: ArrayList<Domain> = ArrayList()
        domainArrayList.add(Domain("NASDAQ100", "BTX", 1234.12,2.13,lineData,1234.12,0.1234))
        domainArrayList.add(Domain("S&P 500", "ETH", 1234.12,-1.13,lineData2,6545.65,0.12345))
        domainArrayList.add(Domain("Dow Jones", "ROX", 6543.21,0.73,lineData3,31234.12,0.02154))


        binding.stockView.adapter = StockAdapter(domainArrayList)

    }

    private fun setData() {
        lineData.add(1000)
        lineData.add(1100)
        lineData.add(1200)
        lineData.add(1100)

        lineData2.add(2100)
        lineData2.add(2000)
        lineData2.add(1900)
        lineData2.add(2000)

        lineData3.add(900)
        lineData3.add(1100)
        lineData3.add(1200)
        lineData3.add(1150)
    }
}