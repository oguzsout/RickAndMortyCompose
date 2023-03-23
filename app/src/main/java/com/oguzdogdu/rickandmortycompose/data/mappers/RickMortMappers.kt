package com.oguzdogdu.rickandmortycompose.data.mappers

import com.oguzdogdu.rickandmortycompose.data.model.Result
import com.oguzdogdu.rickandmortycompose.domain.model.Characters

fun Result.toCharacters() = Characters(
    id = id,
    image = image,
    name = name,
    origin = origin,
    species = species,
    status = status,
    type = type,
    url = url
)