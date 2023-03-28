package com.oguzdogdu.rickandmortycompose.domain.usecase

import com.oguzdogdu.rickandmortycompose.common.Resource
import com.oguzdogdu.rickandmortycompose.data.mappers.toCharacters
import com.oguzdogdu.rickandmortycompose.domain.model.Character
import com.oguzdogdu.rickandmortycompose.domain.repository.RickMortyRepository
import com.oguzdogdu.rickandmortycompose.navigation.Screens
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(private val repository: RickMortyRepository) {

    operator fun invoke(): Flow<Resource<List<Character>>> = flow {
        try {
            emit(Resource.Loading)
            repository.getCharacterList().results.map { it.toCharacters() }.let {
                emit(Resource.Success(it))
            }
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage.orEmpty()))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage.orEmpty()))
        }
    }
}