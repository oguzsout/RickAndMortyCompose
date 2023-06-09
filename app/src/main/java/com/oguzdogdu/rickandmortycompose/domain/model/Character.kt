package com.oguzdogdu.rickandmortycompose.domain.model

import com.oguzdogdu.rickandmortycompose.data.model.characters.Origin

data class Character(
    val id: Int?,
    val image: String?,
    val name: String?,
    val origin: Origin?,
    val species: String?,
    val status: String?,
    val type: String?,
    val url: String?
)
