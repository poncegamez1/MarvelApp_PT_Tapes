package com.poncegamez.marvelapp_pt_tapes.dto


import com.google.gson.annotations.SerializedName

data class CollectedIssue(
    @SerializedName("name")
    val name: String,
    @SerializedName("resourceURI")
    val resourceURI: String
)