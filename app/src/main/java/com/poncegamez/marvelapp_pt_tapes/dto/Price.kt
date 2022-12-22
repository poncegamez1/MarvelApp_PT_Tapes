package com.poncegamez.marvelapp_pt_tapes.dto


import com.google.gson.annotations.SerializedName

data class Price(
    @SerializedName("price")
    val price: Double,
    @SerializedName("type")
    val type: String
)