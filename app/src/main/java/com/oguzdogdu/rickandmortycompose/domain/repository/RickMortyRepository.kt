package com.oguzdogdu.rickandmortycompose.domain.repository

import com.oguzdogdu.rickandmortycompose.data.model.RickMortyDto

interface RickMortyRepository {
    suspend fun getCharacterList() : RickMortyDto
}