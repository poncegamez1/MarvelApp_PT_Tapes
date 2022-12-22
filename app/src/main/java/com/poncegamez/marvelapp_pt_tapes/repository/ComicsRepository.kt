package com.poncegamez.marvelapp_pt_tapes.repository

import com.poncegamez.marvelapp_pt_tapes.model.Comic

interface ComicsRepository {
    suspend fun getComics(): List<Comic>
}