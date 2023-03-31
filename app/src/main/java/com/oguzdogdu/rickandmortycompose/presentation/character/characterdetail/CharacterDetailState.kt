package com.oguzdogdu.rickandmortycompose.presentation.character.characterdetail

import com.oguzdogdu.rickandmortycompose.domain.model.CharacterDetails

data class CharacterDetailState(
    val isLoading: Boolean = false,
    val character: CharacterDetails? = null,
    val error : String = ""
)