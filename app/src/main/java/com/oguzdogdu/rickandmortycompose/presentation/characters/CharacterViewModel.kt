package com.oguzdogdu.rickandmortycompose.presentation.characters

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oguzdogdu.rickandmortycompose.common.Resource
import com.oguzdogdu.rickandmortycompose.domain.usecase.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(private val useCase: GetCharactersUseCase):ViewModel() {
    private val _state = mutableStateOf(CharactersState())
    val state: State<CharactersState> = _state

    init {
        getCharacters()
    }

    private fun getCharacters() {
        useCase().onEach { result ->
            when (result) {
                Resource.Loading -> _state.value = CharactersState(isLoading = true)
                is Resource.Success -> {
                    result.data.let {
                        _state.value = CharactersState(characters = it)
                    }
                }
                is Resource.Error -> _state.value = CharactersState(error = result.errorMessage)
            }
        }.launchIn(viewModelScope)
    }
}