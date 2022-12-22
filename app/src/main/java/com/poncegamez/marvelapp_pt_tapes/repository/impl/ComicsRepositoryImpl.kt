package com.poncegamez.marvelapp_pt_tapes.repository.impl

import com.poncegamez.marvelapp_pt_tapes.api.ComicsApi
import com.poncegamez.marvelapp_pt_tapes.mappers.ComicMapper
import com.poncegamez.marvelapp_pt_tapes.model.Comic
import com.poncegamez.marvelapp_pt_tapes.repository.ComicsRepository

class ComicsRepositoryImpl(private val comicsApi: ComicsApi) : ComicsRepository {
    override suspend fun getComics(): List<Comic> {
        val response = comicsApi.getAllComics().data.results
        return response.map { ComicMapper.map(it) }
    }
}