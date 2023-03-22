package com.oguzdogdu.rickandmortycompose.data.remote.service

import com.oguzdogdu.rickandmortycompose.common.Constants.PAGE_ITEM_LIMIT
import com.oguzdogdu.rickandmortycompose.data.model.RickMortyDto
import retrofit2.http.GET
import retrofit2.http.Query

interface RickAndMortyService {

    @GET(CHARACTER)
    suspend fun getCharacterList(@Query("page") page: Int = PAGE_ITEM_LIMIT): RickMortyDto

    companion object {
        const val CHARACTER = "character"
    }
}