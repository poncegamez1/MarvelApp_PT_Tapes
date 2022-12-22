package com.poncegamez.marvelapp_pt_tapes.model

import java.io.Serializable

data class Comic(
    val id: Int,
    val title: String,
    val description: String?,
    val thumbnailPath: String,
    val thumbnailExt: String
) : Serializable
