package com.poncegamez.marvelapp_pt_tapes.mappers

import com.poncegamez.marvelapp_pt_tapes.model.Comic

object ComicMapper {
    fun map(result: com.poncegamez.marvelapp_pt_tapes.dto.Result): Comic {
        return Comic(
            id = result.id,
            title = result.title,
            description = result.description,
            thumbnailPath = result.thumbnail.path,
            thumbnailExt = result.thumbnail.extension
        )
    }
}