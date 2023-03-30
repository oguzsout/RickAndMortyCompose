package com.oguzdogdu.rickandmortycompose.data.model.detail

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RickMortDetail(
    val created: String?,
    val episode: List<String>?,
    val gender: String?,
    val id: Int?,
    val image: String?,
    val location: Location?,
    val name: String?,
    val origin: Origin?,
    val species: String?,
    val status: String?,
    val type: String?,
    val url: String?
):Parcelable
    fun RickMortDetail.toCharacter() = com.oguzdogdu.rickandmortycompose.domain.model.CharacterDetails(
        id = id,
        image = image,
        name = name,
        origin = origin,
        species = species,
        status = status,
        type = type,
        url = url
    )
