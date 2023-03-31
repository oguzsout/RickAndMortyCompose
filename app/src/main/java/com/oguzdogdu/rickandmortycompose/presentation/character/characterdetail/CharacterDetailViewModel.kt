package com.oguzdogdu.rickandmortycompose.presentation.character.characterdetail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oguzdogdu.rickandmortycompose.common.Constants
import com.oguzdogdu.rickandmortycompose.common.Resource
import com.oguzdogdu.rickandmortycompose.domain.usecase.GetCharacterByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(private val useCase: GetCharacterByIdUseCase,savedStateHandle: SavedStateHandle) : ViewModel() {
    private val _state = mutableStateOf(CharacterDetailState())
    val state: State<CharacterDetailState> get() = _state
    private var characterId: Int? = savedStateHandle["id"]

    init {
        savedStateHandle.getLiveData<Int>(Constants.CHARACTER_ID.toString()).observeForever { id ->
            characterId = id
        }
         getCharacterById()
    }

    private fun getCharacterById() {
                useCase(characterId).onEach{ result ->
                    when (result) {
                        Resource.Loading -> _state.value = CharacterDetailState(isLoading = true)
                        is Resource.Success -> {
                            result.data.let { data ->
                                _state.value = (CharacterDetailState(character = data))
                            }
                        }
                        is Resource.Error -> _state.value = CharacterDetailState(error = result.errorMessage)
                    }
                }.launchIn(viewModelScope)
        }

    }