package com.oguzdogdu.rickandmortycompose.presentation.character.characters

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun CharactersScreen(
    viewModel: CharacterViewModel = hiltViewModel(),
    navigateToCharacterDetail: (Int) -> Unit,
) {
    val state = viewModel.state.collectAsState()

    Box {
        Column(
            modifier = Modifier
                .padding(top = 8.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(8.dp)
            ) {
                items(state.value.characters) { character ->
                    CharacterItem(character = character, onItemClick = {
                        navigateToCharacterDetail.invoke(it)
                    })
                }
            }       
        }
    }
}