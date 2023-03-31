package com.oguzdogdu.rickandmortycompose.domain.usecase

import com.oguzdogdu.rickandmortycompose.common.Resource
import com.oguzdogdu.rickandmortycompose.data.model.detail.toCharacter
import com.oguzdogdu.rickandmortycompose.domain.model.CharacterDetails
import com.oguzdogdu.rickandmortycompose.domain.repository.RickMortyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCharacterByIdUseCase @Inject constructor(private val repository: RickMortyRepository) {
    operator fun invoke(id: Int?): Flow<Resource<CharacterDetails>> = flow {
        try {
            emit(Resource.Loading)
            repository.getCharacterById(id).toCharacter().let { data ->
                emit(Resource.Success(data))
            }
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage.orEmpty()))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage.orEmpty()))
        }
    }
}