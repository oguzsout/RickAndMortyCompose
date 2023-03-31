package com.oguzdogdu.rickandmortycompose.presentation.character.characters

import androidx.paging.PagingData
import com.oguzdogdu.rickandmortycompose.domain.model.Character

data class CharactersState(
    val isLoading: Boolean = false,
    val characters: List<Character> = emptyList(),
    val error : String = ""
)