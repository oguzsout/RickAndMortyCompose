package com.oguzdogdu.rickandmortycompose.data.mappers

import com.oguzdogdu.rickandmortycompose.data.model.characters.Result
import com.oguzdogdu.rickandmortycompose.domain.model.Character
import com.oguzdogdu.rickandmortycompose.domain.model.CharacterDetails

fun Result.toCharacters() = Character(
    id = id,
    image = image,
    name = name,
    origin = origin,
    species = species,
    status = status,
    type = type,
    url = url
)