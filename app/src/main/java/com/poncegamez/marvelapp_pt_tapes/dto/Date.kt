package com.poncegamez.marvelapp_pt_tapes.dto


import com.google.gson.annotations.SerializedName

data class Date(
    @SerializedName("date")
    val date: String,
    @SerializedName("type")
    val type: String
)