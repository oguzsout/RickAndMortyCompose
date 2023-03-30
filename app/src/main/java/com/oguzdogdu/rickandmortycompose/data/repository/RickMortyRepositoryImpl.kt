package com.oguzdogdu.rickandmortycompose.data.repository

import com.oguzdogdu.rickandmortycompose.data.model.characters.RickMortyResponse
import com.oguzdogdu.rickandmortycompose.data.model.detail.RickMortDetail
import com.oguzdogdu.rickandmortycompose.data.remote.service.RickAndMortyService
import com.oguzdogdu.rickandmortycompose.domain.repository.RickMortyRepository
import javax.inject.Inject

class RickMortyRepositoryImpl @Inject constructor(private val service: RickAndMortyService) :
    RickMortyRepository {
    override suspend fun getCharacterList(): RickMortyResponse {
        return service.getCharacterList()
    }

    override suspend fun getCharacterById(id: Int?): RickMortDetail {
        return service.getCharacterById(id)
    }
}