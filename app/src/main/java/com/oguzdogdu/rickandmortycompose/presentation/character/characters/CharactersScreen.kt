package com.oguzdogdu.rickandmortycompose.presentation.character.characters

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun CharactersScreen(
    viewModel: CharacterViewModel = hiltViewModel(),
    navigateToCharacterDetail: (Int) -> Unit,
) {
    val state = viewModel.state.value

    Box {
        Column(
            modifier = Modifier
                .padding(top = 8.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(8.dp)
            ) {
                items(state.characters) { character ->
                    CharacterItem(character = character, onItemClick = {
                        navigateToCharacterDetail.invoke(it)
                    })
                }
            }       
        }

        if (state.error.isNotBlank())

        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = Color.Black
            )
        }
    }
}