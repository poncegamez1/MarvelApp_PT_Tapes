package com.poncegamez.marvelapp_pt_tapes.dto


import com.google.gson.annotations.SerializedName

data class Characters(
    @SerializedName("available")
    val available: Int,
    @SerializedName("collectionURI")
    val collectionURI: String,
    @SerializedName("items")
    val items: List<Item>,
    @SerializedName("returned")
    val returned: Int
)