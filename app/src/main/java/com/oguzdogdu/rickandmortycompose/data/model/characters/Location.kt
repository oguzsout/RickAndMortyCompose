package com.oguzdogdu.rickandmortycompose.data.model.characters

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Location(
    val name: String,
    val url: String
):Parcelable