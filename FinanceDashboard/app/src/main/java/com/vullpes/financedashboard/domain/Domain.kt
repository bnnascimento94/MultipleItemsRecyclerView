package com.vullpes.financedashboard.domain

data class Domain(
    val name:String,
    val symbol:String,
    val price:Double,
    val changePercent:Double,
    val lineData: ArrayList<Int>,
    val propertyAmount:Double,
    val propertySize: Double
)