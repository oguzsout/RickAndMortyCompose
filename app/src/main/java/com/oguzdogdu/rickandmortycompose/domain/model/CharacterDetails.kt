package com.oguzdogdu.rickandmortycompose.domain.model

import com.oguzdogdu.rickandmortycompose.data.model.detail.Origin

data class CharacterDetails(
    val id: Int? = null,
    val image: String? = null,
    val name: String? = null,
    val origin: Origin? = null,
    val species: String? = null,
    val status: String? = null,
    val type: String? = null,
    val url: String? = null
)
