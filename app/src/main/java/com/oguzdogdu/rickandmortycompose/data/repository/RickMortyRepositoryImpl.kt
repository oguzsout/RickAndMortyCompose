package com.oguzdogdu.rickandmortycompose.data.repository

import com.oguzdogdu.rickandmortycompose.data.model.RickMortyDto
import com.oguzdogdu.rickandmortycompose.data.remote.service.RickAndMortyService
import com.oguzdogdu.rickandmortycompose.domain.repository.RickMortyRepository
import javax.inject.Inject

class RickMortyRepositoryImpl @Inject constructor(private val service: RickAndMortyService) :
    RickMortyRepository {
    override suspend fun getCharacterList(): RickMortyDto {
        return service.getCharacterList()
    }
}