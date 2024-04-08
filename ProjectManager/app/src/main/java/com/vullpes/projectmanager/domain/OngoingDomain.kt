package com.vullpes.projectmanager.domain

data class OngoingDomain(
    var title: String,
    var data: String,
    var progressPercent: Int,
    val picPath: String
)
