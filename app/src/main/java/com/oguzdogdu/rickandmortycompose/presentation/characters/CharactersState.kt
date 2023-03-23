package com.oguzdogdu.rickandmortycompose.presentation.characters

import com.oguzdogdu.rickandmortycompose.domain.model.Characters

data class CharactersState(
    val isLoading: Boolean = false,
    val characters: List<Characters> = emptyList(),
    val error : String = ""
)