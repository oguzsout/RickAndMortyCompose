package com.oguzdogdu.rickandmortycompose.presentation.characters

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.oguzdogdu.rickandmortycompose.R
import com.oguzdogdu.rickandmortycompose.domain.model.Characters

@Composable
fun CharacterItem(characters: Characters) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .background(Color.White)
            .padding(8.dp), shape = RoundedCornerShape(8.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            ConstraintLayout {
                val (image, text) = createRefs()
                AsyncImage(
                    alignment = Alignment.CenterStart,
                    model = ImageRequest.Builder(context)
                        .data(characters.image)
                        .crossfade(true)
                        .build(),
                    contentDescription = stringResource(R.string.app_name),
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .constrainAs(image) {
                            top.linkTo(parent.top)
                        }
                        .fillMaxSize()
                )
                Text(
                    text = characters.name,
                    color = Color.Black,
                    maxLines = 1,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .constrainAs(text) {
                            top.linkTo(image.bottom, margin = 16.dp)
                        }
                        .fillMaxSize()
                        .padding(start = 16.dp, end = 16.dp, bottom = 16.dp))
            }
        }
    }
}
