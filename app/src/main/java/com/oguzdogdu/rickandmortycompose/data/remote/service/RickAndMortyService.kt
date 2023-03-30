package com.oguzdogdu.rickandmortycompose.data.remote.service

import com.oguzdogdu.rickandmortycompose.common.Constants.PAGE_ITEM_LIMIT
import com.oguzdogdu.rickandmortycompose.data.model.characters.RickMortyResponse
import com.oguzdogdu.rickandmortycompose.data.model.detail.RickMortDetail
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyService {

    @GET("character")
    suspend fun getCharacterList(@Query("page") page: Int = PAGE_ITEM_LIMIT): RickMortyResponse

    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") id: Int?): RickMortDetail

    companion object {
        const val CHARACTER = "character"
    }
}