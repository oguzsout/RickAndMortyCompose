package com.oguzdogdu.rickandmortycompose.presentation.character.characterdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.oguzdogdu.rickandmortycompose.R
import kotlinx.coroutines.flow.collectLatest

@Composable
fun CharacterDetailScreen(viewModel: CharacterDetailViewModel = hiltViewModel()) {
    val state = viewModel.state.value
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
            AsyncImage(
                alignment = Alignment.CenterStart,
                model = ImageRequest.Builder(context)
                    .data(state.character?.image)
                    .crossfade(true)
                    .build(),
                contentDescription = stringResource(R.string.app_name),
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.fillMaxSize()
            )
        }
    }