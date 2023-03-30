package com.oguzdogdu.rickandmortycompose.domain.repository

import com.oguzdogdu.rickandmortycompose.data.model.characters.RickMortyResponse
import com.oguzdogdu.rickandmortycompose.data.model.detail.RickMortDetail

interface RickMortyRepository {
    suspend fun getCharacterList() : RickMortyResponse
    suspend fun getCharacterById(id:Int?) : RickMortDetail
}