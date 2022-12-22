package com.poncegamez.marvelapp_pt_tapes.api

import com.poncegamez.marvelapp_pt_tapes.dto.GeneralResponse
import com.poncegamez.marvelapp_pt_tapes.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface ComicsApi {

    @GET("/v1/public/comics")
    suspend fun getAllComics(
        @Query("apikey") apikey: String = Constants.PUBLIC_API_KEY,
        @Query("ts") ts: String = Constants.timeStamp,
        @Query("hash") hash: String = Constants.getHash()
    ): GeneralResponse
}

